CREATE SEQUENCE grocery_id_seq
CREATE TABLE helloworld.grocery (
  isle INTEGER,
  price BIGINT,
  name CHARACTER VARYING(26),
  category CHARACTER VARYING(26),
  id BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('grocery_id_seq'::regclass)
);
CREATE UNIQUE INDEX grocery_name_uindex ON grocery USING BTREE (name);