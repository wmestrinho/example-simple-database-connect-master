package com.ironyard.services;

import com.ironyard.data.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jasonskipper on 1/30/17.
 */
public class PetServiceTest {

    @Before
    @After
    public void truncateBefore() {
        System.out.println("truncateBefore");
        DbService ds = new DbService();
        ds.truncate("helloworld.pets");
    }

    @Test
    public void getAllPetsFromDatabase() throws Exception {
        // TODO .. First insert stuff
        this.saveToDatabase();
        System.out.println("getAllPetsFromDatabase");
        PetService ps = new PetService();
        List<Pet> found = ps.getAllPetsFromDatabase();

        assertEquals("Found unexpected number of rows.", 1, found.size());
    }


    @Test
    public void getPetByIdFromDatabase() throws Exception {
        // TODO .. First insert stuff
        System.out.println("saveToDatabase");
        PetService ps = new PetService();
        Pet saveMe = new Pet("test", 7, "skipper", "brown", "mouse");
        //
        ps.save(saveMe);

        System.out.println("getPetByIdFromDatabase");
        Pet found = ps.getPetById(saveMe.getId());
        assertEquals("incorrect id", "test", found.getName());

    }

    @Test
    public void getPetByNameFromDatabase() throws Exception {
        // TODO .. Fist insert stuff
        this.saveToDatabase();
        System.out.println("getPetByNameFromDatabase");
        PetService ps = new PetService();
        Pet found = ps.getPetByName("test");
        assertNotNull(found);
        assertEquals("incorrect id", "test", found.getName());
    }


    @Test
    public void saveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        PetService ps = new PetService();
        Pet saveMe = new Pet("test", 7, "skipper", "brown", "mouse");
        //
        ps.save(saveMe);

        // fetch by name
        Pet found = ps.getPetByName("test");
        assertEquals("Name 404", saveMe.getName(), found.getName());
        assertEquals("getColor 404", saveMe.getColor(), found.getColor());
        assertEquals("getType 404", saveMe.getType(), found.getType());
        assertEquals("getAge 404", saveMe.getAge(), found.getAge());
        assertEquals("getOwner 404", saveMe.getOwner(), found.getOwner());

    }
}