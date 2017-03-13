CREATE SEQUENCE grocery_id_seq;

CREATE TABLE helloworld.grocery
(
  id bigint NOT NULL DEFAULT nextval('grocery_id_seq'::regclass),
  name character varying(26) COLLATE pg_catalog."default",
  isle integer,
  price double precision,
  category integer,
  CONSTRAINT items_pkey PRIMARY KEY (item_id)
)
