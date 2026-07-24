@echo off
REM Restaura la BD inventario en PostgreSQL local
REM Uso: inventario-restaurar.bat
REM Requiere: psql en PATH o PostgreSQL 18 instalado

set PGPASSWORD=1234
set PSQL="C:\Program Files\PostgreSQL\18\bin\psql.exe"

echo Creando base inventario (si no existe)...
%PSQL% -U postgres -h 127.0.0.1 -d postgres -c "CREATE DATABASE inventario;" 2>nul

echo Restaurando tablas y datos...
%PSQL% -U postgres -h 127.0.0.1 -d inventario -f "%~dp0inventario-para-companero.sql"

echo Listo.
pause
