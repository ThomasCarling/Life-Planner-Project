package gui.eventform;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * A JPanel that allows the input of a new Event.
 * 
 * @author Thomas
 *
 */
public class EventFormPanel extends JPanel{
    
    private static final long serialVersionUID = 6036286048012599252L;
    private JLabel nameLabel;
    private JLabel lengthLabel;
    private JLabel locationLabel;
    private JTextField nameField;
    private JTextField lengthField;
    private JTextField locationField;
    private JButton enterButton;
    private EventFormListener listener;
    
    public EventFormPanel() {
	Dimension dim = getPreferredSize();
	dim.width = 250;
	setPreferredSize(dim);
	setLayout(new GridBagLayout());
	
	nameLabel = new JLabel("Event name :  ");
	lengthLabel = new JLabel("Length (in minutes) :  ");
	locationLabel = new JLabel("Location (postcode) :  ");
	nameField = new JTextField(10);
	lengthField = new JTextField(10);
	locationField = new JTextField(10);
	enterButton = new JButton("Enter");
	
	enterButton.addActionListener(al -> {
	    String name = nameField.getText();
	    String length = lengthField.getText();
	    String location = locationField.getText();
	    
	    EventFormEvent event = new EventFormEvent(this, name, length, location);
	    
	    if (listener != null) {
		listener.EventFormEventOccurred(event);
	    }
	    
	});
	
	Border innerBorder = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Add new event");
	Border outerBorder = BorderFactory.createEtchedBorder();
	setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.fill = GridBagConstraints.NONE;
	
	//////first row//////
	gbc.anchor = GridBagConstraints.LINE_END;
	gbc.weightx = 1;
	gbc.weighty = 1;
	gbc.gridx = 0;
	gbc.gridy = 0;
	add(nameLabel, gbc);
	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.weightx = 1;
	gbc.weighty = 1;
	gbc.gridx = 1;
	gbc.gridy = 0;
	add(nameField, gbc);
	
	//////second row//////
	gbc.anchor = GridBagConstraints.LINE_END;
	gbc.weightx = 1;
	gbc.weighty = 1;
	gbc.gridx = 0;
	gbc.gridy = 1;
	add(lengthLabel, gbc);
	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.weightx = 1;
	gbc.weighty = 1;
	gbc.gridx = 1;
	gbc.gridy = 1;
	add(lengthField, gbc);
	
	//////third row//////
	gbc.anchor = GridBagConstraints.LINE_END;
	gbc.weightx = 1;
	gbc.weighty = 1;
	gbc.gridx = 0;
	gbc.gridy = 2;
	add(locationLabel, gbc);
	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.weightx = 1;
	gbc.weighty = 1;
	gbc.gridx = 1;
	gbc.gridy = 2;
	add(locationField, gbc);
	
	//////last row//////
	gbc.anchor = GridBagConstraints.FIRST_LINE_START;
	gbc.weightx = 1;
	gbc.weighty = 30;
	gbc.gridx = 1;
	gbc.gridy = 3;
	gbc.insets = new Insets(5, 0, 0, 0);
	add(enterButton, gbc);
    }
    
    public void SetEventFormListener(EventFormListener listener) {
	this.listener = listener;
    }
}
