package ec.edu.uteq.inventario.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ProductoResponse {

    private Long id;
    private String nombre;
    private String categoria;
    private Integer stock;
    private BigDecimal precio;
    private Boolean activo;
    private OffsetDateTime creadoEn;

    public ProductoResponse() {
    }

    public ProductoResponse(Long id, String nombre, String categoria, Integer stock,
                            BigDecimal precio, Boolean activo, OffsetDateTime creadoEn) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.activo = activo;
        this.creadoEn = creadoEn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public OffsetDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(OffsetDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}
