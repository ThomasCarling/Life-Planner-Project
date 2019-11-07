package algorithms;

import java.util.HashMap;

public class MockNode implements Node{
    HashMap<String, Integer> timeTo;
    String postcode;
    
    public MockNode(String postcode) {
	this.postcode = postcode;
	timeTo = new HashMap<>();
    }
    @Override
    public int getTimeTo(Node toHere) {
	return timeTo.get(toHere.getStartPostcode());
    }

    @Override
    public String getEndPostcode() {
	return postcode;
    }

    @Override
    public String getStartPostcode() {
	return postcode;
    }
 
    public void setTimeTo(Node toHere, int time) {
	timeTo.put(toHere.getStartPostcode(), time);
    }

}
