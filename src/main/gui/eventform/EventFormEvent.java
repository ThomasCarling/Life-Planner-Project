package gui.eventform;

import java.util.EventObject;

public class EventFormEvent extends EventObject {
    
    private static final long serialVersionUID = 3379581543618809992L;
    private String name;
    private String length;
    private String location;

    public EventFormEvent(Object source, String name, String length, String location) {
	super(source);
	this.name = name;
	this.length = length;
	this.location = location;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
