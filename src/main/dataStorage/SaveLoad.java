package dataStorage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad {
    
    protected static void save(Object toSave, String filename) {
	try {
	    FileOutputStream file = new FileOutputStream(filename);
	    ObjectOutputStream out = new ObjectOutputStream(file);
	    
	    out.writeObject(toSave);
	    
	    out.close();
	    file.close();
	    
	    System.out.println("Successfully Serialised.");
	} catch (IOException e) {
	    System.out.println("not Serialised");
	    e.printStackTrace();
	}
    }
    protected static Object load(String filename) {
	Object toLoad = null;
	try {
	    FileInputStream file = new FileInputStream(filename);
	    ObjectInputStream in = new ObjectInputStream(file);
	    
	    toLoad = (Object)in.readObject();
	    
	    in.close();
	    file.close();
	    
	    System.out.println("Object has been deserialised ");
	    	    
	} catch (IOException e) {
	    System.out.println("IOException is caught");
	    e.printStackTrace();
	} catch (ClassNotFoundException ex) {
	    System.out.println("ClassNotFoundException is caught");
	    ex.printStackTrace();
	}
	return toLoad;
    }
}
