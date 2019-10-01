package lifeplannerproject.addresses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {
    Address one;

    @Before
    public void setUp() throws Exception {
	one = new Address("E8 2JP");
    }

    @After
    public void tearDown() throws Exception {
	one = null;
    }

    @Test
    public void testAddAndGetDistance() {
	one.addDistance(7, "N1 3PB");
	assertEquals(7, one.getDistance("N1 3PB"));
    }

}
