--
-- PostgreSQL database dump
--

-- Dumped from database version 12.5
-- Dumped by pg_dump version 12.5

-- Started on 2021-01-11 18:27:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16542)
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16980)
-- Name: location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    created_by character varying(255),
    created_date timestamp without time zone,
    modified_by character varying(255),
    modified_date timestamp without time zone,
    city character varying(255),
    country character varying(255)
);


ALTER TABLE public.location OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16988)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    created_by character varying(255),
    created_date timestamp without time zone,
    modified_by character varying(255),
    modified_date timestamp without time zone,
    category character varying(255),
    inventory character varying(255),
    item integer
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16996)
-- Name: sales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sales (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    created_by character varying(255),
    created_date timestamp without time zone,
    modified_by character varying(255),
    modified_date timestamp without time zone,
    dollars integer,
    location_id uuid,
    product_id uuid,
    time_id uuid
);


ALTER TABLE public.sales OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17004)
-- Name: time; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."time" (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    created_by character varying(255),
    created_date timestamp without time zone,
    modified_by character varying(255),
    modified_date timestamp without time zone,
    month integer,
    quater integer,
    year integer
);


ALTER TABLE public."time" OWNER TO postgres;

--
-- TOC entry 2853 (class 0 OID 16980)
-- Dependencies: 203
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location (id, created_by, created_date, modified_by, modified_date, city, country) FROM stdin;
\.


--
-- TOC entry 2854 (class 0 OID 16988)
-- Dependencies: 204
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, created_by, created_date, modified_by, modified_date, category, inventory, item) FROM stdin;
138736df-d047-4b77-98d0-c8004b53cf27	\N	\N	\N	\N	Dien tu Gia dung	Con hang	5
\.


--
-- TOC entry 2855 (class 0 OID 16996)
-- Dependencies: 205
-- Data for Name: sales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sales (id, created_by, created_date, modified_by, modified_date, dollars, location_id, product_id, time_id) FROM stdin;
\.


--
-- TOC entry 2856 (class 0 OID 17004)
-- Dependencies: 206
-- Data for Name: time; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."time" (id, created_by, created_date, modified_by, modified_date, month, quater, year) FROM stdin;
\.


--
-- TOC entry 2717 (class 2606 OID 16987)
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- TOC entry 2719 (class 2606 OID 16995)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 2721 (class 2606 OID 17003)
-- Name: sales sales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 17011)
-- Name: time time_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."time"
    ADD CONSTRAINT time_pkey PRIMARY KEY (id);


--
-- TOC entry 2724 (class 2606 OID 17012)
-- Name: sales fk6powssogv8avjoi1j5b0jnfrr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT fk6powssogv8avjoi1j5b0jnfrr FOREIGN KEY (location_id) REFERENCES public.location(id);


--
-- TOC entry 2725 (class 2606 OID 17017)
-- Name: sales fkfcs4mjmgry6xchs16dv03eclp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT fkfcs4mjmgry6xchs16dv03eclp FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 2726 (class 2606 OID 17022)
-- Name: sales fkjw6j9grvip4r5hj7q3l98g5r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT fkjw6j9grvip4r5hj7q3l98g5r FOREIGN KEY (time_id) REFERENCES public."time"(id);


-- Completed on 2021-01-11 18:27:16

--
-- PostgreSQL database dump complete
--

