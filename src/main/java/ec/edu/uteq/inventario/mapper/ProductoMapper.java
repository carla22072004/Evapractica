package ec.edu.uteq.inventario.mapper;

import ec.edu.uteq.inventario.domain.Producto;
import ec.edu.uteq.inventario.dto.ProductoRequest;
import ec.edu.uteq.inventario.dto.ProductoResponse;

public final class ProductoMapper {

    private ProductoMapper() {
    }

    public static Producto toEntity(ProductoRequest request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre().trim());
        producto.setCategoria(request.getCategoria().trim());
        producto.setStock(request.getStock());
        producto.setPrecio(request.getPrecio());
        producto.setActivo(true);
        return producto;
    }

    public static ProductoResponse toResponse(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getStock(),
                producto.getPrecio(),
                producto.getActivo(),
                producto.getCreadoEn()
        );
    }
}
