package ec.edu.uteq.inventario.service;

import ec.edu.uteq.inventario.domain.Producto;
import ec.edu.uteq.inventario.dto.ApiResponse;
import ec.edu.uteq.inventario.dto.PageMeta;
import ec.edu.uteq.inventario.dto.ProductoRequest;
import ec.edu.uteq.inventario.dto.ProductoResponse;
import ec.edu.uteq.inventario.mapper.ProductoMapper;
import ec.edu.uteq.inventario.repository.ProductoRepository;
import java.util.List;
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

    @Transactional
    public ApiResponse<ProductoResponse> crear(ProductoRequest request) {
        Producto guardado = productoRepository.save(ProductoMapper.toEntity(request));
        return ApiResponse.ok(ProductoMapper.toResponse(guardado), "Producto creado correctamente");
    }
}
