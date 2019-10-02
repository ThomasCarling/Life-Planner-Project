package oldmain.addresses;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Class that contains an ArrayList of postcodes,
 * as well as the distance to each of those postcodes
 * from the initial postcode.
 * 
 * @author Tom Carling
 *
 */
public class Address implements Serializable {
    
    private static final long serialVersionUID = 6504836435156942866L;
    private ArrayList<String[]> distanceTo;
    private String postcode;
    
    /**
     * Constructs a new @ArrayList.
     *
     * @param  postcode  the initial postcode
     * @throws IllegalArgumentException if the postcode is invalid
     *         
     */
    public Address(String postcode) {
	if (PostcodeChecker.check(postcode)) {
	this.postcode = PostcodeChecker.fix(postcode);
	} else {
	    throw new IllegalArgumentException("invalid postcode");
	}
	this.distanceTo = new ArrayList<String[]>();
	String[] toSelf = {postcode, "0"};
	distanceTo.add(toSelf);
    }
    
    public void addDistance(int timeInMinutes, String toThisPostcode) {
	String[] addThis = {toThisPostcode, "" + timeInMinutes};
	distanceTo.add(addThis);
    }
    
    public int getDistance(String toThisPostcode) {
	for (int i = 0; i < distanceTo.size(); i++) {
	    if (distanceTo.get(i)[0] == toThisPostcode) {
		return Integer.parseInt(distanceTo.get(i)[1]);
	    }
	}
	throw new IllegalArgumentException("No stored distance from " 
	+ this.postcode + " to " + toThisPostcode);
    }
    
    public String getPostcode() {
	return postcode;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((distanceTo == null) ? 0 : distanceTo.hashCode());
	result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Address other = (Address) obj;
	if (distanceTo == null) {
	    if (other.distanceTo != null)
		return false;
	} else if (!distanceTo.equals(other.distanceTo))
	    return false;
	if (postcode == null) {
	    if (other.postcode != null)
		return false;
	} else if (!postcode.equals(other.postcode))
	    return false;
	return true;
    }
}
