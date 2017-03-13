package com.ironyard.services;

import com.ironyard.data.GroceryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WagnerMestrinho on 1/31/17.
 */
public class GroceryItemService {

    public GroceryItem getItemById(long id){
        GroceryItem found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.grocery where id= "+id);

            while (rs.next()) {
                found = getItem(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public GroceryItem save(GroceryItem itemToSave){
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO helloworld.grocery " +
                            "(name, isle, price, category) " +
                            "VALUES (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            // set values
            ps.setString(1,itemToSave.getName());
            ps.setInt(2,itemToSave.getIsle());
            ps.setDouble(3,itemToSave.getPrice());
            ps.setInt(4,itemToSave.getCategory());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                itemToSave.setId(rs.getLong("id"));
            }

        }catch(Throwable t){
            t.printStackTrace();
        }
        return itemToSave;
    }

    public GroceryItem getItemByName(String Name){
        GroceryItem found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM helloworld.grocery where name= ?");
            ps.setString(1,Name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                found = getItem(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public List<GroceryItem> getAllItemsFromDatabase(){
        List<GroceryItem> foundItems = new ArrayList<GroceryItem>();
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.grocery");

            while (rs.next()) {
                foundItems.add(getItem(rs));
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return foundItems;
    }

    private GroceryItem getItem(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        double price = rs.getDouble("price");
        int category = rs.getInt("category");
        int isle = rs.getInt("isle");
        long id = rs.getLong("id");
        return new GroceryItem(id, name, isle, price,category);
    }

}

