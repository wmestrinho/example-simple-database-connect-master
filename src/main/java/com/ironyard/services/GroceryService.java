package com.ironyard.services;

import com.ironyard.data.Grocery;
import com.ironyard.data.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WagnerMestrinho on 1/31/17.
 */
public class GroceryService {

    public GroceryService getItemById(){
        Pet found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.grocery where pet_id= ");

            while (rs.next()) {

                found = getGrocery(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public Grocery save(GroceryItem aGroceryToSave){



        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO helloworld.grocery " +
                            "(isle, price, name, category) " +
                            "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            // set values
            ps.setString(1,aPetToSave.getName());
            ps.setString(2,aPetToSave.getType());
            ps.setdouble(3,aPetToSave.getAge());
            ps.setString(4,aPetToSave.getOwner());
            ps.setString(5,aPetToSave.getColor());
            ps.execute();

            //populate id
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                aPetToSave.getId()generatedKeys.getLong("pet_id");
            }

        }catch(Throwable t){
            t.printStackTrace();
        }
    }

    /**
     * Get Pet By the name given from database
     * @param aPetName
     * @return
     */
    public Grocery getGroceryByName(String aPetName){
        Pet found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM helloworld.pets where pet_name= ?");
            ps.setString(1,aPetName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                found = getPet(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public List<Pet> getAllPetsFromDatabase(){
        List<Pet> foundPets = new ArrayList<Pet>();
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.pets");

            while (rs.next()) {
                foundPets.add(getPet(rs));
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return foundPets;
    }

    private GroceryItem getGroceryItem (ResultSet rs) throws SQLException {
        String name = rs.getString("pet_name");
        String type = rs.getString("pet_type");
        String ownName = rs.getString("pet_own_name");
        String color = rs.getString("pet_color");
        int age = rs.getInt("pet_age");
        long id = rs.getLong("pet_id");
        return new GroceryItem(name, age, ownName, color, type, id);
    }
}

}
