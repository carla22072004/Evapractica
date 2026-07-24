# inventario-mercado-zamora

## Datos del estudiante

- **Apellidos y nombres:** Zamora Arias Carla Esthefania
- **Asignatura:** Aplicaciones Web
- **Carrera:** Ingeniería de Software (Rediseño) — UTEQ
- **Nivel:** Quinto
- **Periodo:** Académico Presencial 2026-2027 (PPA)
- **Proyecto:** Sistema de gestión de inventario del Mercado Municipal de Quevedo

## Versiones

- **Java:** 21 LTS
- **Spring Boot:** 3.4.1
- **PostgreSQL:** 16
- **Redis:** 7

## Requisitos previos

- Docker Desktop
- Git

## Arranque (un solo comando)

```bash
git clone https://github.com/<usuario>/inventario-mercado-zamora.git
cd inventario-mercado-zamora
cp .env.example .env
docker compose up -d --build
```

API local: http://localhost:8080/api/v1/productos

## Usuarios semilla y token JWT

| Usuario | Contraseña | Rol         |
|---------|------------|-------------|
| user    | user123    | ROLE_USER   |
| admin   | admin123   | ROLE_ADMIN  |

Obtener el token:

```http
POST http://localhost:8080/api/v1/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```

Usar el token en las peticiones:

```http
Authorization: Bearer <token>
```

- `GET /api/v1/productos` requiere `ROLE_USER` (también válido con `ROLE_ADMIN`)
- `POST /api/v1/productos` y `DELETE /api/v1/productos/{id}` requieren `ROLE_ADMIN`
- Sin token → HTTP 401
- Token válido con rol insuficiente → HTTP 403

## Cómo probar los cinco requisitos

Colección: `docs/requests.http`

1. **Listado paginado**  
   `GET /api/v1/productos?page=0&size=10&sort=nombre,asc` con token USER o ADMIN.  
   Respuesta con `{success, data, message, meta}`.

2. **Creación validada**  
   `POST /api/v1/productos` con token ADMIN y body válido → 201.  
   Body inválido → 400 con errores por campo.

3. **Eliminación lógica**  
   `DELETE /api/v1/productos/{id}` con token ADMIN → soft delete (`activo=false`).  
   Id inexistente → 404.

4. **Cache-aside con Redis**  
   Llamar dos veces al GET: la segunda responde desde Redis (`@Cacheable`).  
   Tras POST o DELETE se invalida la caché (`@CacheEvict`).

5. **Seguridad JWT**  
   GET sin token → 401.  
   POST con token de `ROLE_USER` → 403.

## Compilación del informe LaTeX (criterio P2)

Archivo principal: `docs/informe/informe.tex`  
Bibliografía: `docs/informe/referencias.bib`  
Motor: `pdflatex` · Procesador: `bibtex` · Pasadas: 4

```bash
cd docs/informe
pdflatex informe
bibtex informe
pdflatex informe
pdflatex informe
```
