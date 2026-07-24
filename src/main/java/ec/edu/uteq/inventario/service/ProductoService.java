package ec.edu.uteq.inventario.service;

import ec.edu.uteq.inventario.domain.Producto;
import ec.edu.uteq.inventario.dto.ApiResponse;
import ec.edu.uteq.inventario.dto.PageMeta;
import ec.edu.uteq.inventario.dto.ProductoRequest;
import ec.edu.uteq.inventario.dto.ProductoResponse;
import ec.edu.uteq.inventario.exception.RecursoNoEncontradoException;
import ec.edu.uteq.inventario.mapper.ProductoMapper;
import ec.edu.uteq.inventario.repository.ProductoRepository;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Cacheable(value = "productos", key = "#pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort")
    @Transactional(readOnly = true)
    public ApiResponse<List<ProductoResponse>> listar(Pageable pageable) {
        Page<Producto> page = productoRepository.findByActivoTrue(pageable);
        List<ProductoResponse> data = page.getContent().stream()
                .map(ProductoMapper::toResponse)
                .toList();

        PageMeta meta = new PageMeta(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );

        return ApiResponse.ok(data, "Listado obtenido correctamente", meta);
    }

    @CacheEvict(value = "productos", allEntries = true)
    @Transactional
    public ApiResponse<ProductoResponse> crear(ProductoRequest request) {
        Producto guardado = productoRepository.save(ProductoMapper.toEntity(request));
        return ApiResponse.ok(ProductoMapper.toResponse(guardado), "Producto creado correctamente");
    }

    @CacheEvict(value = "productos", allEntries = true)
    @Transactional
    public ApiResponse<Void> eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Producto con id " + id + " no encontrado"));

        producto.setActivo(false);
        productoRepository.save(producto);
        return ApiResponse.ok(null, "Producto eliminado logicamente");
    }
}
