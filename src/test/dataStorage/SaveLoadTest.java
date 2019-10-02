package dataStorage;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStorage.SaveLoad;

public class SaveLoadTest {
    String testSaveLoad;

    @Before
    public void setUp() throws Exception {
	testSaveLoad = "This is a test";
    }

    @After
    public void tearDown() throws Exception {
	testSaveLoad = null;
    }

    @Test
    public void testSaveAndLoad() {
	SaveLoad.save(testSaveLoad, "test.ser");
	assertEquals("This is a test", SaveLoad.load("test.ser"));
    }
}
