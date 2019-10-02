package test.dataStorage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oldmain.addresses.Address;
import oldmain.datastorage.AddressStore;

public class AddressStoreTest {
    
    Address one;
    Address two;
    Address three;
    AddressStore testStore;

    @Before
    public void setUp() throws Exception {
	one = new Address("ME19 6AJ");
	two = new Address("E8 2JP");
	three = new Address("EC1Y 4SB");
	testStore = new AddressStore("testDistanceStore.ser");
    }

    @After
    public void tearDown() throws Exception {
	one = null;
	two = null;
	three = null;
    }

    @Test
    public void testAddAndRemove() {
	assertEquals(0, testStore.size());
	testStore.add(one);
	assertEquals(1, testStore.size());
	testStore.add(two);
	assertEquals(2, testStore.size());
	testStore.add(three);
	assertEquals(3, testStore.size());
	testStore.remove(one);
	assertEquals(2, testStore.size());
	testStore.remove(two);
	assertEquals(1, testStore.size());
	testStore.remove(three);
	assertEquals(0, testStore.size());
    }

    @Test
    public void testSaveAndLoad() {
	testStore.add(one);
	testStore.save();
	testStore.clearMemory();
	testStore.load();
	assertTrue(testStore.get(0).equals(one));
	testStore.add(two);
	testStore.save();
	testStore.clearMemory();
	testStore.load();
	assertTrue(testStore.get(1).equals(two));
	}

    @Test
    public void testSize() {
	assertEquals(0, testStore.size());
	testStore.add(one);
	assertEquals(1, testStore.size());
	testStore.add(two);
	assertEquals(2, testStore.size());
	testStore.add(three);
	assertEquals(3, testStore.size());
	}

    @Test
    public void testClearMemory() {
    testStore.add(one);
    testStore.add(two);
    testStore.clearMemory();
    assertEquals(0, testStore.size());
    }

    @Test
    public void testGet() {
	testStore.add(one);
	testStore.add(two);
	testStore.add(three);
	assertEquals(one, testStore.get(0));
	assertEquals(two, testStore.get(1));
	assertEquals(three, testStore.get(2));
    }
    
    @Test
    public void testOtherGet() {
	testStore.add(one);
	testStore.add(two);
	testStore.add(three);
	assertEquals(one, testStore.get("ME19 6AJ"));
	assertEquals(two, testStore.get("E8 2JP"));
	assertEquals(three, testStore.get("EC1Y 4SB"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionRemove() {
	testStore.remove(three);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionGet() {
	testStore.get("E8 2JP");
    }

}
