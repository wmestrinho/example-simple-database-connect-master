package com.ironyard.data;

/**
 * Created by WagnerMestrinho on 1/31/17.
 CREATE TABLE helloworld.grocery (
        isle INTEGER,
        price BIGINT,
        name CHARACTER VARYING(26),
        category CHARACTER VARYING(26),
        id BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('grocery_id_seq'::regclass)
        );
        CREATE UNIQUE INDEX grocery_name_uindex ON grocery USING BTREE (name);
*/
public class Grocery {

    private String item;
    private int isle;
    private double price;
    private String cat;
    private long id;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getIsle() {
        return isle;
    }

    public void setIsle(int isle) {
        this.isle = isle;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }















}



