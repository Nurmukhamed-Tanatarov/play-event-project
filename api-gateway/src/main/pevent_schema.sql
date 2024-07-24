--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

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
-- Name: add_to_game_list(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.add_to_game_list() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO game_list (categories_id)
    VALUES (NEW.id);
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.add_to_game_list() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id integer NOT NULL,
    category_type character varying(255),
    category_title character varying(255)
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categories_id_seq OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- Name: contacts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contacts (
    id integer NOT NULL,
    manager_id integer,
    description character varying(255),
    full_address character varying(255),
    phone_number character varying(255),
    email character varying(255)
);


ALTER TABLE public.contacts OWNER TO postgres;

--
-- Name: contacts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contacts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.contacts_id_seq OWNER TO postgres;

--
-- Name: contacts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contacts_id_seq OWNED BY public.contacts.id;


--
-- Name: game; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game (
    id integer NOT NULL,
    game_list_id integer,
    title character varying(255),
    price character varying(255),
    description character varying(255),
    info character varying(255)
);


ALTER TABLE public.game OWNER TO postgres;

--
-- Name: game_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.game_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.game_id_seq OWNER TO postgres;

--
-- Name: game_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.game_id_seq OWNED BY public.game.id;


--
-- Name: game_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_images (
    id integer NOT NULL,
    game_id integer,
    image_url character varying(255),
    image_title character varying(255),
    data bytea,
    upload_time timestamp without time zone,
    type character varying
);


ALTER TABLE public.game_images OWNER TO postgres;

--
-- Name: game_images_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.game_images_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.game_images_id_seq OWNER TO postgres;

--
-- Name: game_images_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.game_images_id_seq OWNED BY public.game_images.id;


--
-- Name: game_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_list (
    id integer NOT NULL,
    categories_id integer
);


ALTER TABLE public.game_list OWNER TO postgres;

--
-- Name: game_list_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.game_list_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.game_list_id_seq OWNER TO postgres;

--
-- Name: game_list_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.game_list_id_seq OWNED BY public.game_list.id;


--
-- Name: game_rent_rules; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_rent_rules (
    id integer NOT NULL,
    game_id integer,
    rent_rules_id integer,
    description character varying(255)
);


ALTER TABLE public.game_rent_rules OWNER TO postgres;

--
-- Name: game_rent_rules_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.game_rent_rules_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.game_rent_rules_id_seq OWNER TO postgres;

--
-- Name: game_rent_rules_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.game_rent_rules_id_seq OWNED BY public.game_rent_rules.id;


--
-- Name: manager_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manager_images (
    id integer NOT NULL,
    image_url character varying(255),
    title character varying(255),
    manager_id integer,
    data bytea,
    upload_time timestamp without time zone,
    type character varying
);


ALTER TABLE public.manager_images OWNER TO postgres;

--
-- Name: manager_images_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.manager_images_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.manager_images_id_seq OWNER TO postgres;

--
-- Name: manager_images_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.manager_images_id_seq OWNED BY public.manager_images.id;


--
-- Name: managers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.managers (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    patronymic character varying(255)
);


ALTER TABLE public.managers OWNER TO postgres;

--
-- Name: managers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.managers ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.managers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: rent_rules; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rent_rules (
    id integer NOT NULL,
    description character varying(255)
);


ALTER TABLE public.rent_rules OWNER TO postgres;

--
-- Name: rent_rules_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rent_rules_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rent_rules_id_seq OWNER TO postgres;

--
-- Name: rent_rules_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rent_rules_id_seq OWNED BY public.rent_rules.id;


--
-- Name: translations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.translations (
    id integer NOT NULL,
    entity_id integer,
    entity_type character varying(255),
    language_code character varying(255),
    translated_text character varying(255)
);


ALTER TABLE public.translations OWNER TO postgres;

--
-- Name: translations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.translations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.translations_id_seq OWNER TO postgres;

--
-- Name: translations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.translations_id_seq OWNED BY public.translations.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying,
    password character varying,
    name character varying NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: contacts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacts ALTER COLUMN id SET DEFAULT nextval('public.contacts_id_seq'::regclass);


--
-- Name: game id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game ALTER COLUMN id SET DEFAULT nextval('public.game_id_seq'::regclass);


--
-- Name: game_images id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_images ALTER COLUMN id SET DEFAULT nextval('public.game_images_id_seq'::regclass);


--
-- Name: game_list id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_list ALTER COLUMN id SET DEFAULT nextval('public.game_list_id_seq'::regclass);


--
-- Name: game_rent_rules id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_rent_rules ALTER COLUMN id SET DEFAULT nextval('public.game_rent_rules_id_seq'::regclass);


--
-- Name: manager_images id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager_images ALTER COLUMN id SET DEFAULT nextval('public.manager_images_id_seq'::regclass);


--
-- Name: rent_rules id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rent_rules ALTER COLUMN id SET DEFAULT nextval('public.rent_rules_id_seq'::regclass);


--
-- Name: translations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.translations ALTER COLUMN id SET DEFAULT nextval('public.translations_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: contacts contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_pkey PRIMARY KEY (id);


--
-- Name: game_images game_images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_images
    ADD CONSTRAINT game_images_pkey PRIMARY KEY (id);


--
-- Name: game_list game_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_list
    ADD CONSTRAINT game_list_pkey PRIMARY KEY (id);


--
-- Name: game game_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_pkey PRIMARY KEY (id);


--
-- Name: game_rent_rules game_rent_rules_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_rent_rules
    ADD CONSTRAINT game_rent_rules_pkey PRIMARY KEY (id);


--
-- Name: manager_images manager_images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager_images
    ADD CONSTRAINT manager_images_pkey PRIMARY KEY (id);


--
-- Name: managers managers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managers
    ADD CONSTRAINT managers_pkey PRIMARY KEY (id);


--
-- Name: rent_rules rent_rules_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rent_rules
    ADD CONSTRAINT rent_rules_pkey PRIMARY KEY (id);


--
-- Name: translations translations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.translations
    ADD CONSTRAINT translations_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: categories after_category_insert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER after_category_insert AFTER INSERT ON public.categories FOR EACH ROW EXECUTE FUNCTION public.add_to_game_list();


--
-- Name: contacts contacts_manager_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_manager_id_fkey FOREIGN KEY (manager_id) REFERENCES public.managers(id);


--
-- Name: manager_images fk_manager; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager_images
    ADD CONSTRAINT fk_manager FOREIGN KEY (manager_id) REFERENCES public.managers(id);


--
-- Name: game game_game_list_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_game_list_id_fkey FOREIGN KEY (game_list_id) REFERENCES public.game_list(id);


--
-- Name: game_images game_images_game_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_images
    ADD CONSTRAINT game_images_game_id_fkey FOREIGN KEY (game_id) REFERENCES public.game(id);


--
-- Name: game_list game_list_categories_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_list
    ADD CONSTRAINT game_list_categories_id_fkey FOREIGN KEY (categories_id) REFERENCES public.categories(id);


--
-- Name: game_rent_rules game_rent_rules_game_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_rent_rules
    ADD CONSTRAINT game_rent_rules_game_id_fkey FOREIGN KEY (game_id) REFERENCES public.game(id);


--
-- Name: game_rent_rules game_rent_rules_rent_rules_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_rent_rules
    ADD CONSTRAINT game_rent_rules_rent_rules_id_fkey FOREIGN KEY (rent_rules_id) REFERENCES public.rent_rules(id);


--
-- PostgreSQL database dump complete
--

