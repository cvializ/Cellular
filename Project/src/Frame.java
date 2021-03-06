import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Frame for the entrie program including the grid and the buttons
 */
class Frame extends JFrame{
	private Panel panel; //holds the actual grid
	private int screenSize;
	private int cellWidth;
	private int numCells;
	private String[] notes = {"-", "C ", "C#", "D ", "D#", "E ", "F ", "F#", "G ", "G#", "A ", "A#", "B "};
	private String[] octaves = {"-", "4", "5", "6"};
	private String[] colors = {"-", "Red", "Blue", "Green", "Yellow", "Orange", "Magenta"};
	
	private GridBagConstraints gbc;
	
	private JButton startStop = new JButton("Start/Stop");
	private JButton clear = new JButton("Clear  ");
	private JButton generate = new JButton("Generate");
	private JCheckBox birth = new JCheckBox("Birth", false);
	
	private JLabel note = new JLabel("Note:");
	private JLabel octave = new JLabel("Octave:");
	private JLabel color = new JLabel("Color:");
	private JButton insert = new JButton("Insert");
	private JButton delete = new JButton("Delete");
	private JComboBox<String> noteSelect = new JComboBox<String>(notes);
	private JComboBox<String> octaveSelect = new JComboBox<String>(octaves);
	private JComboBox<String> colorSelect = new JComboBox<String>(colors);
	
	public Frame(int newNumCells) {
		cellWidth = 50;
		numCells = newNumCells;
		screenSize = cellWidth*numCells;
		
		controlSetup(); //Set action commands for buttons
		
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		panel = new Panel(screenSize, numCells);
		JPanel filler = new JPanel();
		filler.setPreferredSize(new Dimension(cellWidth,cellWidth));
		JPanel filler2 = new JPanel();
		filler2.setPreferredSize(new Dimension(cellWidth,cellWidth));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 9;
		gbc.gridheight = 9;
		add(panel, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 9;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		add(filler, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(startStop, gbc);
		
		gbc.gridx = 10;
		gbc.gridy = 2;
		add(clear, gbc);
		
		gbc.gridx = 11;
		gbc.gridy = 2;
		add(generate, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.CENTER;
		add(birth, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		add(filler, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(note, gbc);
		
		gbc.gridx = 10;
		gbc.gridy = 6;
		add(octave, gbc);
		
		gbc.gridx = 11;
		gbc.gridy = 6;
		add(color, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 7;
		add(noteSelect, gbc);
		
		gbc.gridx = 10;
		gbc.gridy = 7;
		add(octaveSelect, gbc);
		
		gbc.gridx = 11;
		gbc.gridy = 7;
		add(colorSelect, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 8;
		add(insert, gbc);
		
		gbc.gridx = 10;
		gbc.gridy = 8;
		add(delete, gbc);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cellular");
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void controlSetup() {
		
		insert.setActionCommand("insert");
		delete.setActionCommand("delete");
		startStop.setActionCommand("startStop");
		clear.setActionCommand("clear");
		generate.setActionCommand("generate");
		birth.setActionCommand("birth");
	}
	
	public Panel getPanel() {
		return panel;
	}
	
	public String getNote(){
		return (String) noteSelect.getSelectedItem();
	}
	
	public String getOctave() {
		return (String) octaveSelect.getSelectedItem();
	}
	
	public Color getColor() {
		switch ((String) colorSelect.getSelectedItem()) {
			case "Red": return Color.RED;
			case "Blue": return Color.BLUE;
			case "Green": return Color.GREEN;
			case "Yellow": return Color.YELLOW;
			case "Orange": return Color.ORANGE;
			case "Magenta": return Color.MAGENTA;
			default: return null;
		}
	}
	
	/*
	 * Hides buttons if the grid is not paused
	 */
	public void changeVisible(boolean val) {
		insert.setVisible(val);
		delete.setVisible(val);
		noteSelect.setVisible(val);
		octaveSelect.setVisible(val);
		colorSelect.setVisible(val);
		note.setVisible(val);
		color.setVisible(val);
		octave.setVisible(val);
	}
	
	public void addListener(ActionListener listener) {
		startStop.addActionListener(listener);
		clear.addActionListener(listener);
		generate.addActionListener(listener);
		insert.addActionListener(listener);
		delete.addActionListener(listener);
		birth.addActionListener(listener);
	}
}
