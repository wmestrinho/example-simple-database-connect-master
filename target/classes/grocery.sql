CREATE SEQUENCE grocery_item_id_seq
CREATE TABLE helloworld.grocery (

  isle INTEGER,
  price BIGINT,
  name varchar(26),
  category varchar(26),
  id BIGINT PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX grocery_name_uindex ON grocery (name);