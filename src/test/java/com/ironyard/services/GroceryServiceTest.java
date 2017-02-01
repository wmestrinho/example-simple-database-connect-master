package com.ironyard.services;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by WagnerMestrinho on 1/31/17.
 */
public class GroceryServiceTest {
    @Before
    public void truncateBefore(){

        DbService ds = new DbService();
        ds.truncate("helloworld.grocery");
    }

    @Test
    public void testFindAllGroceryItems() {
        GroceryService gs = new GroceryService();

        GroceryItem tmp = new GroceryItem

    }

      @Test
              public void testSave(){
            GroceryService gs = new GroceryService();
            //save items
          GroceryItem tmp =new GroceryItem



    }



}
