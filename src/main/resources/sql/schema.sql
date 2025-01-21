--
-- PostgreSQL database dump
--

-- Dumped from database version 16.6 (Debian 16.6-1.pgdg120+1)
-- Dumped by pg_dump version 17.1

-- Started on 2025-01-21 18:24:03

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
-- TOC entry 215 (class 1259 OID 21811)
-- Name: address; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.address (
    id bigint NOT NULL,
    address_line1 character varying(255) NOT NULL,
    address_line2 character varying(255),
    city character varying(255) NOT NULL,
    country character varying(255) NOT NULL,
    postal_code character varying(255) NOT NULL,
    state_or_region character varying(255)
);


ALTER TABLE public.address OWNER TO mainuser;

--
-- TOC entry 216 (class 1259 OID 21818)
-- Name: event; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.event (
    status smallint,
    event_start_date timestamp(6) without time zone,
    id bigint NOT NULL,
    sale_end_date timestamp(6) without time zone,
    sale_start_date timestamp(6) without time zone,
    venue_schematic_id bigint,
    CONSTRAINT event_status_check CHECK (((status >= 0) AND (status <= 3)))
);


ALTER TABLE public.event OWNER TO mainuser;

--
-- TOC entry 217 (class 1259 OID 21824)
-- Name: event_facility; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.event_facility (
    address_id bigint,
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.event_facility OWNER TO mainuser;

--
-- TOC entry 218 (class 1259 OID 21831)
-- Name: event_post; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.event_post (
    event_id bigint,
    id bigint NOT NULL,
    description character varying(255),
    location character varying(255),
    thumbnail_url character varying(255),
    title character varying(255)
);


ALTER TABLE public.event_post OWNER TO mainuser;

--
-- TOC entry 219 (class 1259 OID 21838)
-- Name: event_post_performers; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.event_post_performers (
    performers_order integer NOT NULL,
    event_post_id bigint NOT NULL,
    performers_id bigint NOT NULL
);


ALTER TABLE public.event_post_performers OWNER TO mainuser;

--
-- TOC entry 220 (class 1259 OID 21843)
-- Name: event_post_tags; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.event_post_tags (
    tags_order integer NOT NULL,
    event_post_id bigint NOT NULL,
    tags_id bigint NOT NULL
);


ALTER TABLE public.event_post_tags OWNER TO mainuser;

--
-- TOC entry 221 (class 1259 OID 21848)
-- Name: performer; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.performer (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.performer OWNER TO mainuser;

--
-- TOC entry 222 (class 1259 OID 21853)
-- Name: schematic_object; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.schematic_object (
    angle real NOT NULL,
    layer integer NOT NULL,
    show_label boolean,
    x real NOT NULL,
    y real NOT NULL,
    id bigint NOT NULL,
    parent_id bigint,
    schematic_id bigint,
    label character varying(255),
    name character varying(255)
);


ALTER TABLE public.schematic_object OWNER TO mainuser;

--
-- TOC entry 223 (class 1259 OID 21860)
-- Name: seat; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.seat (
    capacity integer NOT NULL,
    type smallint,
    id bigint NOT NULL,
    schematic_object_id bigint,
    venue_section_id bigint NOT NULL,
    label character varying(255) NOT NULL,
    name character varying(255),
    seat_column character varying(255),
    seat_row character varying(255),
    CONSTRAINT seat_type_check CHECK (((type >= 0) AND (type <= 3)))
);


ALTER TABLE public.seat OWNER TO mainuser;

--
-- TOC entry 224 (class 1259 OID 21870)
-- Name: tag; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.tag (
    id bigint NOT NULL,
    value character varying(255)
);


ALTER TABLE public.tag OWNER TO mainuser;

--
-- TOC entry 225 (class 1259 OID 21875)
-- Name: venue; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.venue (
    event_facility_id bigint,
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.venue OWNER TO mainuser;

--
-- TOC entry 226 (class 1259 OID 21880)
-- Name: venue_schematic; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.venue_schematic (
    id bigint NOT NULL,
    venue_id bigint,
    name character varying(255)
);


ALTER TABLE public.venue_schematic OWNER TO mainuser;

--
-- TOC entry 227 (class 1259 OID 21885)
-- Name: venue_section; Type: TABLE; Schema: public; Owner: mainuser
--

CREATE TABLE public.venue_section (
    capacity integer,
    id bigint NOT NULL,
    schematic_object_id bigint,
    label character varying(255) NOT NULL
);


ALTER TABLE public.venue_section OWNER TO mainuser;

--
-- TOC entry 3253 (class 2606 OID 21817)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 3257 (class 2606 OID 21830)
-- Name: event_facility event_facility_address_id_key; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_facility
    ADD CONSTRAINT event_facility_address_id_key UNIQUE (address_id);


--
-- TOC entry 3259 (class 2606 OID 21828)
-- Name: event_facility event_facility_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_facility
    ADD CONSTRAINT event_facility_pkey PRIMARY KEY (id);


--
-- TOC entry 3255 (class 2606 OID 21823)
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- TOC entry 3263 (class 2606 OID 21842)
-- Name: event_post_performers event_post_performers_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post_performers
    ADD CONSTRAINT event_post_performers_pkey PRIMARY KEY (performers_order, event_post_id);


--
-- TOC entry 3261 (class 2606 OID 21837)
-- Name: event_post event_post_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post
    ADD CONSTRAINT event_post_pkey PRIMARY KEY (id);


--
-- TOC entry 3265 (class 2606 OID 21847)
-- Name: event_post_tags event_post_tags_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post_tags
    ADD CONSTRAINT event_post_tags_pkey PRIMARY KEY (tags_order, event_post_id);


--
-- TOC entry 3267 (class 2606 OID 21852)
-- Name: performer performer_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.performer
    ADD CONSTRAINT performer_pkey PRIMARY KEY (id);


--
-- TOC entry 3269 (class 2606 OID 21859)
-- Name: schematic_object schematic_object_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.schematic_object
    ADD CONSTRAINT schematic_object_pkey PRIMARY KEY (id);


--
-- TOC entry 3271 (class 2606 OID 21867)
-- Name: seat seat_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.seat
    ADD CONSTRAINT seat_pkey PRIMARY KEY (id);


--
-- TOC entry 3273 (class 2606 OID 21869)
-- Name: seat seat_schematic_object_id_key; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.seat
    ADD CONSTRAINT seat_schematic_object_id_key UNIQUE (schematic_object_id);


--
-- TOC entry 3275 (class 2606 OID 21874)
-- Name: tag tag_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (id);


--
-- TOC entry 3277 (class 2606 OID 21879)
-- Name: venue venue_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue
    ADD CONSTRAINT venue_pkey PRIMARY KEY (id);


--
-- TOC entry 3279 (class 2606 OID 21884)
-- Name: venue_schematic venue_schematic_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue_schematic
    ADD CONSTRAINT venue_schematic_pkey PRIMARY KEY (id);


--
-- TOC entry 3281 (class 2606 OID 21889)
-- Name: venue_section venue_section_pkey; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue_section
    ADD CONSTRAINT venue_section_pkey PRIMARY KEY (id);


--
-- TOC entry 3283 (class 2606 OID 21891)
-- Name: venue_section venue_section_schematic_object_id_key; Type: CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue_section
    ADD CONSTRAINT venue_section_schematic_object_id_key UNIQUE (schematic_object_id);


--
-- TOC entry 3295 (class 2606 OID 21947)
-- Name: venue fk15kq7sdryy2ikq2jy3xhps1ax; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue
    ADD CONSTRAINT fk15kq7sdryy2ikq2jy3xhps1ax FOREIGN KEY (event_facility_id) REFERENCES public.event_facility(id);


--
-- TOC entry 3286 (class 2606 OID 21902)
-- Name: event_post fk4kqkj2b34n6fuah9xtn4dqv3j; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post
    ADD CONSTRAINT fk4kqkj2b34n6fuah9xtn4dqv3j FOREIGN KEY (event_id) REFERENCES public.event(id);


--
-- TOC entry 3291 (class 2606 OID 21932)
-- Name: schematic_object fk9w47r21ea9y4l1nvu9pjkdamn; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.schematic_object
    ADD CONSTRAINT fk9w47r21ea9y4l1nvu9pjkdamn FOREIGN KEY (schematic_id) REFERENCES public.venue_schematic(id);


--
-- TOC entry 3289 (class 2606 OID 21917)
-- Name: event_post_tags fkdfbiiqgj6w4mbfqe0igl3p5iu; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post_tags
    ADD CONSTRAINT fkdfbiiqgj6w4mbfqe0igl3p5iu FOREIGN KEY (tags_id) REFERENCES public.tag(id);


--
-- TOC entry 3296 (class 2606 OID 21952)
-- Name: venue_schematic fke79oor6cqcxqkr9rhb7b69y4n; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue_schematic
    ADD CONSTRAINT fke79oor6cqcxqkr9rhb7b69y4n FOREIGN KEY (venue_id) REFERENCES public.venue(id);


--
-- TOC entry 3293 (class 2606 OID 21937)
-- Name: seat fkf5kx9kqjs0isj7vuei5g9hfm0; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.seat
    ADD CONSTRAINT fkf5kx9kqjs0isj7vuei5g9hfm0 FOREIGN KEY (schematic_object_id) REFERENCES public.schematic_object(id);


--
-- TOC entry 3287 (class 2606 OID 21907)
-- Name: event_post_performers fkitu641bhnkss27i81mynn8vwo; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post_performers
    ADD CONSTRAINT fkitu641bhnkss27i81mynn8vwo FOREIGN KEY (performers_id) REFERENCES public.performer(id);


--
-- TOC entry 3297 (class 2606 OID 21957)
-- Name: venue_section fkjdl7i8owbub125ono46f3qcv3; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.venue_section
    ADD CONSTRAINT fkjdl7i8owbub125ono46f3qcv3 FOREIGN KEY (schematic_object_id) REFERENCES public.schematic_object(id);


--
-- TOC entry 3285 (class 2606 OID 21897)
-- Name: event_facility fklk0bdxlwkbl5m5xsw6lg7odew; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_facility
    ADD CONSTRAINT fklk0bdxlwkbl5m5xsw6lg7odew FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- TOC entry 3284 (class 2606 OID 21892)
-- Name: event fklp6yt93tccrwnbwh7coqrcu9l; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT fklp6yt93tccrwnbwh7coqrcu9l FOREIGN KEY (venue_schematic_id) REFERENCES public.venue_schematic(id);


--
-- TOC entry 3292 (class 2606 OID 21927)
-- Name: schematic_object fkmh6eu7699vtqnu2h29n0yerge; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.schematic_object
    ADD CONSTRAINT fkmh6eu7699vtqnu2h29n0yerge FOREIGN KEY (parent_id) REFERENCES public.schematic_object(id);


--
-- TOC entry 3294 (class 2606 OID 21942)
-- Name: seat fknhld17g5i22pcavmj76kbxmbp; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.seat
    ADD CONSTRAINT fknhld17g5i22pcavmj76kbxmbp FOREIGN KEY (venue_section_id) REFERENCES public.venue_section(id);


--
-- TOC entry 3290 (class 2606 OID 21922)
-- Name: event_post_tags fkpb8eoi4b4vvck4ybt07urkolh; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post_tags
    ADD CONSTRAINT fkpb8eoi4b4vvck4ybt07urkolh FOREIGN KEY (event_post_id) REFERENCES public.event_post(id);


--
-- TOC entry 3288 (class 2606 OID 21912)
-- Name: event_post_performers fkswx4dlmj280pulxgoq9uhdgsc; Type: FK CONSTRAINT; Schema: public; Owner: mainuser
--

ALTER TABLE ONLY public.event_post_performers
    ADD CONSTRAINT fkswx4dlmj280pulxgoq9uhdgsc FOREIGN KEY (event_post_id) REFERENCES public.event_post(id);


-- Completed on 2025-01-21 18:24:04

--
-- PostgreSQL database dump complete
--

