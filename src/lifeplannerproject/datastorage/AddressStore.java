package lifeplannerproject.datastorage;

import java.io.Serializable;
import java.util.ArrayList;

import lifeplannerproject.addresses.Address;

// class to save a list of distances.

public class AddressStore implements Serializable {
    
    private ArrayList<Address> allDistances;
    private String filename;
    
    public AddressStore(String filename) {
	allDistances = new ArrayList<Address>();
	this.filename = filename;
    }
    
    public void add(Address newDistance) {
	allDistances.add(newDistance);
    }
    public void remove(Address oldDistance) {
	if (allDistances.contains(oldDistance)) {
	    allDistances.remove(oldDistance);
	} else { 
	    throw new IllegalArgumentException("event is not on list"); 
	}
    }
    public void save() {
	SaveLoad.save(allDistances, filename);
    }
    
    public void load() {
	allDistances = (ArrayList<Address>) SaveLoad.load(filename);
    }
    
    public int size() {
	return allDistances.size();
    }
    public void clearMemory() {
	allDistances = new ArrayList<Address>();
    }
    public Address get(int index) {
	return allDistances.get(index);
    }
    public Address get(String postcode) {
	int noOfItterations = size();
	for (int i = 0; i < noOfItterations; i++) {
	    if (this.get(i).getPostcode().equals(postcode)) {
		return this.get(i);
	    } 
	}
	throw new IllegalArgumentException("postcode not stored");
    }
}
