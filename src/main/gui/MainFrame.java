package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    
    public MainFrame(String title) {
	super(title);
	setLayout(new BorderLayout());
	setJMenuBar(new Menu());
	
    }
    
    public static void main(String[] args) {
	SwingUtilities.invokeLater( () -> {
	    JFrame frame = new MainFrame("Life Planner");
	    frame.setSize(500, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	});
    }

}
