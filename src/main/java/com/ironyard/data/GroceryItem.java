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
public class GroceryItem {

    private long id;
    private String name;
    private int isle;
    private double price;
    private int category;

    public GroceryItem() {
    }

    public GroceryItem(long id, String name, int isle, double price, int category) {
        this.id = id;
        this.name = name;
        this.isle = isle;
        this.price = price;
        this.category = category;
    }

    public GroceryItem(String name, int isle, double price, int category) {
        this.name = name;
        this.isle = isle;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsle() {
        return isle;
    }

    public void setIsle(int isle) {
        this.isle = isle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}



