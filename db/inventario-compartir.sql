--
-- PostgreSQL database dump
--

\restrict pI0VJYfdusTnvhlP8TpZVNfb1yGNkGF9fD8tG4sb1CNdqeg4ibwTgOUJGOTfjmN

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: productos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.productos (
    id bigint NOT NULL,
    nombre character varying(100) NOT NULL,
    categoria character varying(50) NOT NULL,
    stock integer NOT NULL,
    precio numeric(10,2) NOT NULL,
    activo boolean DEFAULT true NOT NULL,
    creado_en timestamp with time zone DEFAULT now() NOT NULL,
    CONSTRAINT productos_precio_check CHECK ((precio >= 0.01)),
    CONSTRAINT productos_stock_check CHECK ((stock >= 0))
);


--
-- Name: productos_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.productos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: productos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;


--
-- Name: productos id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);


--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.productos VALUES (1, 'Arroz flor', 'Granos', 120, 0.95, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (2, 'Azucar blanca', 'Granos', 80, 1.10, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (3, 'Aceite vegetal', 'Aceites', 45, 2.50, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (4, 'Leche entera', 'Lacteos', 60, 0.85, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (5, 'Pan de yuca', 'Panaderia', 30, 0.50, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (6, 'Platano verde', 'Verduras', 200, 0.25, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (7, 'Tomate rinon', 'Verduras', 90, 0.40, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (8, 'Pollo entero', 'Carnes', 25, 3.80, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (9, 'Queso fresco', 'Lacteos', 40, 2.20, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (10, 'Cafe molido', 'Bebidas', 55, 4.50, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (11, 'Frijol rojo', 'Granos', 70, 1.30, true, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (12, 'Producto inactivo demo', 'Otros', 5, 1.00, false, '2026-07-24 08:10:47.641153-05');
INSERT INTO public.productos VALUES (13, 'Maiz suave', 'Granos', 40, 0.75, false, '2026-07-24 08:29:55.350807-05');


--
-- Name: productos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.productos_id_seq', 13, true);


--
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict pI0VJYfdusTnvhlP8TpZVNfb1yGNkGF9fD8tG4sb1CNdqeg4ibwTgOUJGOTfjmN

