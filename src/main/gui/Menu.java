package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
    JMenu fileTab;
    JMenu editTab;
    JMenu loadFile;
    List<JMenuItem> toLoad;
    JMenuItem newFile;
    JMenuItem saveFile;
    JMenuItem newEvent;
    JMenuItem editEvent;

    public Menu() {
	super();

	fileTab = new JMenu("File");

	newFile = new JMenuItem("New");
	loadFile = new JMenu("Open");
	//TODO: Class to retrieve every save,
	// pop into toLoad list, display,
	// also way of opening file system?
	saveFile = new JMenuItem("Save");

	fileTab.add(newFile);
	fileTab.add(loadFile);
	fileTab.add(saveFile);

	add(fileTab);

	editTab = new JMenu("Edit");
	
	newEvent = new JMenuItem("Add Event");
	editEvent = new JMenuItem("Existing Events");
	
	editTab.add(newEvent);
	editTab.add(editEvent);
	
	add(editTab);
    }
}
