# Inventario Mercado Municipal de Quevedo

**Estudiante:** Zamora Arias Carla Esthefania  
**Asignatura:** Aplicaciones Web — Ingeniería de Software (UTEQ)  
**Proyecto:** `inventario-mercado-zamora`  
**Stack:** Java 21 LTS · Spring Boot 3.4.1 · PostgreSQL · Redis (Parte 3)

## Partes del desarrollo

| Parte | Estado | Contenido |
|-------|--------|-----------|
| 1 | Lista | Base + entidad Producto + GET paginado |
| 2 | Lista | POST con validación y 400 |
| 3 | Lista | DELETE soft + cache Redis |
| 4 | Pendiente | JWT + entrega (informe LaTeX, requests) |

## Ejecutar en IntelliJ IDEA (recomendado)

### 1. Requisitos
- IntelliJ IDEA
- JDK **21** (File → Project Structure → SDK)
- PostgreSQL local (ya detectado: servicio `postgresql-x64-18`)

### 2. Crear la base de datos
En pgAdmin o en la terminal de PostgreSQL:

```sql
CREATE DATABASE inventario;
```

### 3. Credenciales
Edita `src/main/resources/application.yml` si tu usuario/clave no son `postgres` / `postgres`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/inventario
    username: postgres
    password: TU_CLAVE
```

### 4. Abrir y correr
1. File → Open → carpeta `c:\carla`
2. Espera a que IntelliJ indexe y descargue Maven
3. Abre `InventarioMercadoZamoraApplication`
4. Run ▶

API: http://localhost:8080/api/v1/productos

### 5. Probar GET (Parte 1)

```http
GET http://localhost:8080/api/v1/productos?page=0&size=10&sort=nombre,asc
```

También está en `docs/requests.http` (plugin HTTP Client de IntelliJ).

## Nota Redis (Parte 3)

Redis para Windows ya quedó instalado como servicio (`Redis` en servicios de Windows), puerto **6379**.
La app usa cache-aside: `@Cacheable` en el listado y `@CacheEvict` al crear/eliminar.
