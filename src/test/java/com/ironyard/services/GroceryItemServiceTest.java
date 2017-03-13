package com.ironyard.services;

import com.ironyard.data.GroceryItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by WagnerMestrinho on 1/31/17.
 */
public class GroceryItemServiceTest {
    @Before
    public void truncateBefore(){
        System.out.println("truncateBefore");
        DbService ds = new DbService();
        ds.truncate("helloworld.grocery");
    }
    @Test
    public void getItemById() throws Exception{
        System.out.println("saveToDatabase");
        GroceryItemService gs = new GroceryItemService();
        GroceryItem saveMe = new GroceryItem(1, "apple", 2, 1.99, 8);
        //
        gs.save(saveMe);

        System.out.println("getPetByIdFromDatabase");
        GroceryItem found = gs.getItemById(saveMe.getId());
        assertEquals("incorrect id", "apple", found.getName());

    }

    @Test
    public void getAllItemsFromDatabase() throws Exception {
        // TODO .. First insert stuff
        this.saveToDatabase();
        System.out.println("getAllItemsFromDatabase");
        GroceryItemService gs = new GroceryItemService();
        List<GroceryItem> found = gs.getAllItemsFromDatabase();

        assertEquals("Found unexpected number of rows.",1, found.size());
    }

    @Test
    public void saveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        GroceryItemService gs = new GroceryItemService();
        GroceryItem saveMe = new GroceryItem("Potato",7,5.4,3);
        //
        GroceryItem saved = gs.save(saveMe);

        // fetch by name
        GroceryItem found = gs.getItemByName("Potato");
        assertEquals("Name 404",saveMe.getName(), found.getName());
        assertEquals("getColor 404",saveMe.getIsle(), found.getIsle());
        assertEquals("getType 404",saveMe.getPrice(), found.getPrice(), .002);
        assertEquals("getAge 404",saveMe.getCategory(), found.getCategory());
    }
}
