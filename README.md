# Inventario Mercado Municipal de Quevedo

**Estudiante:** Zamora Arias Carla Esthefania  
**Asignatura:** Aplicaciones Web — Ingeniería de Software (UTEQ)  
**Proyecto:** inventario-mercado-zamora  

Java 21 · Spring Boot 3.4.1 · PostgreSQL · Redis · JWT

## Requisitos

- JDK 21
- PostgreSQL
- Redis (puerto 6379)
- IntelliJ IDEA

## Base de datos

```sql
CREATE DATABASE inventario;
```

Ejecutar `db/schema.sql` y `db/seed.sql` en la base `inventario`.

Ajustar clave en `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    username: postgres
    password: TU_CLAVE
```

## Ejecutar

Abrir el proyecto en IntelliJ y correr `InventarioMercadoZamoraApplication`.

API: http://localhost:8080

## Usuarios

| Usuario | Clave    | Rol         |
|---------|----------|-------------|
| user    | user123  | ROLE_USER   |
| admin   | admin123 | ROLE_ADMIN  |

Login:

```http
POST http://localhost:8080/api/v1/auth/login
Content-Type: application/json

{ "username": "admin", "password": "admin123" }
```

Header:

```http
Authorization: Bearer <token>
```

- GET `/api/v1/productos` → ROLE_USER o ROLE_ADMIN
- POST / DELETE → ROLE_ADMIN
- Sin token → 401
- Rol insuficiente → 403

Pruebas: `docs/requests.http`

## Informe LaTeX

```bash
cd docs/informe
pdflatex informe
bibtex informe
pdflatex informe
pdflatex informe
```

## Docker (opcional)

```bash
cp .env.example .env
docker compose up -d --build
```
