package com.ironyard.services;

import com.ironyard.data.Pet;
import org.junit.After;
import org.junit.Assert;
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
    //
    // @After
    public void truncateBefore(){
        System.out.println("truncateBefore");
        DbService ds = new DbService();
        ds.truncate("helloworld.pets");
    }

    @Test
    public void getAllPetsFromDatabase() throws Exception {
        // TODO .. First insert stuff
        PetService ps = new PetService();

        ps.save(new Pet("test1", 7, "skipper", "brown", "mouse");
        ps.save(new Pet("test2", 7, "skipper", "brown", "mouse");
        ps.save(new Pet("test3", 7, "skipper", "brown", "mouse");
        List<Pet> found= ps.getAllPetsFromDatabase();
        assertEquals("Found unexpected number of rows.", 2, found.size());
    }

    @Test
    public void getPetByIdFromDatabase() throws Exception {
        //Create Pet with know Name
        PetService ps = new PetService();
        Pet saveMe = ps.save(new Pet("test1", 7, "skipper", "brown", "mouse"));

        //fetch pet by name
        Pet foundByNamePet = ps.getPetByName("test1");
        long fetchMeAgainBYThisId = savedMe.getId();

        //now get pet by id and ensure
        ps = new PetService();
        Pet found = ps.getPetById();
        Assert.assertEquals("incorrect id",1, found.getPetById(""));
    }

    @Test
    public void getPetByNameFromDatabase() throws Exception {
        // TODO .. Fist insert stuff
        PetService ps = new PetService();
        Pet saveMe = new Pet("pepper", 7, "skipper", "brown", "horse");
        Pet found = ps.getPetByName("pepper");
        assertEquals("Name 404",saveMe.getName(), found.getName());
        assertEquals("getColor 404",saveMe.getColor(), found.getColor());
        assertEquals("getType 404",saveMe.getType(), found.getType());
        assertEquals("getAge 404",saveMe.getAge(), found.getAge());
        assertEquals("getOwner 404",saveMe.getOwner(), found.getOwner());


        //PetService ps = new PetService();


        assertNotNull(found);
       // assertEquals("incorrect id",3, found.getId());
        assertEquals("Name 404","pepper", found.getName());
    }

    @Test
    public void saveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        PetService ps = new PetService();
        Pet saveMe = new Pet("test",7,"skipper","brown","mouse");
        //
        ps.save(saveMe);

        // fetch by name
        Pet found = ps.getPetByName("test");
        assertEquals("Name 404",saveMe.getName(), found.getName());
        assertEquals("getColor 404",saveMe.getColor(), found.getColor());
        assertEquals("getType 404",saveMe.getType(), found.getType());
        assertEquals("getAge 404",saveMe.getAge(), found.getAge());
        assertEquals("getOwner 404",saveMe.getOwner(), found.getOwner());

    }
}