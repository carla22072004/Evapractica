package ec.edu.uteq.inventario.mapper;

import ec.edu.uteq.inventario.domain.Producto;
import ec.edu.uteq.inventario.dto.ProductoResponse;

public final class ProductoMapper {

    private ProductoMapper() {
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
