package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * JFrame for my project, also currently contains main 
 * method to run the project.
 */
public class MainFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private Menu menu;
    private EventForm eventForm;
    
    public MainFrame(String title) {
	super(title);
	
	setLayout(new BorderLayout());
	
	menu = new Menu();
	eventForm = new EventForm();
	
	setJMenuBar(menu);
	add(eventForm, BorderLayout.WEST);
	
	
	setSize(500, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);	
    }
    
    public static void main(String[] args) {
	SwingUtilities.invokeLater( () -> {
	    new MainFrame("Life Planner");
	});
    }

}
