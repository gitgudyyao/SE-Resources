package my.edu.utar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ApplicationMainGUI extends JFrame {
	
	private JPanel buttonJPanel;
	private JPanel originalRecordsPanel;
	private JPanel selectedRecordsPanel;
	
	private JButton readButton, writeButton, filterButton, sortButton;
	private JTextArea originalRecords, selectedRecords; 

	private StudentRecordApplication sra;
	private FileUtilities fu;
	private SortUtilities su;

	public void initializeApplication() {
		fu = new FileUtilities();
		su = new SortUtilities();
		sra = new StudentRecordApplication(fu,su);
	}
	
	public ApplicationMainGUI() {
		
		super ("Student Record Application");
		initializeApplication();
		
		ButtonHandler buttonHandler = new ButtonHandler();
		Font buttonFont = new Font("Courier", Font.BOLD,18);

		readButton = new JButton("Read original records from file");
		writeButton = new JButton("Write selected records to file");
		filterButton = new JButton("Filter to create selected records");
		sortButton = new JButton("Sort to create selected records");
		
		readButton.setFont(buttonFont);
		writeButton.setFont(buttonFont);
		filterButton.setFont(buttonFont);
		sortButton.setFont(buttonFont);
		
		readButton.addActionListener(buttonHandler);
		writeButton.addActionListener(buttonHandler);
		filterButton.addActionListener(buttonHandler);
		sortButton.addActionListener(buttonHandler);
		
		buttonJPanel = new JPanel();
		buttonJPanel.setLayout(new GridLayout(4,1,10,10));
		buttonJPanel.add(readButton);
		buttonJPanel.add(writeButton);
		buttonJPanel.add(filterButton);
		buttonJPanel.add(sortButton);
		
		TitledBorder buttonPanelBorder = new TitledBorder("Click to select any one of the following options");
		Font borderFont = new Font("SanSerif", Font.BOLD,14);
		buttonPanelBorder.setTitleColor(Color.MAGENTA);
		buttonPanelBorder.setTitleFont(borderFont);
		buttonPanelBorder.setTitleJustification(TitledBorder.CENTER);
		buttonJPanel.setBorder(buttonPanelBorder);
		
		setLayout(new BorderLayout(10,10));
		add( buttonJPanel, BorderLayout.CENTER ); // add panel to JFrame
		
		TitledBorder originalPanelBorder = new TitledBorder("Original records");
		originalPanelBorder.setTitleColor(Color.MAGENTA);
		originalPanelBorder.setTitleFont(borderFont);
		originalPanelBorder.setTitleJustification(TitledBorder.CENTER);

		originalRecordsPanel = new JPanel();
		originalRecordsPanel.setLayout(new FlowLayout());
		originalRecordsPanel.setBorder(originalPanelBorder);

		TitledBorder selectedPanelBorder = new TitledBorder("Selected records");
		selectedPanelBorder.setTitleColor(Color.MAGENTA);
		selectedPanelBorder.setTitleFont(borderFont);
		selectedPanelBorder.setTitleJustification(TitledBorder.CENTER);
		
		selectedRecordsPanel = new JPanel();
		selectedRecordsPanel.setLayout(new FlowLayout());
		selectedRecordsPanel.setBorder(selectedPanelBorder);

		Box box1 = Box.createHorizontalBox(); // create box
		Box box2 = Box.createHorizontalBox(); // create box
		
		Font textBoxFont = new Font("Serif", Font.PLAIN,14);

		originalRecords = new JTextArea( "EMPTY", 10, 45);
		selectedRecords = new JTextArea( "EMPTY", 10, 45);
		
		originalRecords.setFont(textBoxFont);
		selectedRecords.setFont(textBoxFont);
		originalRecords.setEditable(false);
		selectedRecords.setEditable(false);
		
		originalRecords.setForeground(Color.BLACK);
		originalRecords.setBackground(Color.LIGHT_GRAY);
		selectedRecords.setForeground(Color.BLUE);
		selectedRecords.setBackground(Color.LIGHT_GRAY);
		
	    box1.add( new JScrollPane(originalRecords)); 
	    box2.add( new JScrollPane(selectedRecords)); 

	    originalRecordsPanel.add(box1);
	    selectedRecordsPanel.add(box2);
	    	    
	    add (originalRecordsPanel, BorderLayout.NORTH);
	    add (selectedRecordsPanel, BorderLayout.SOUTH);
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == readButton) {
				
				String fileName = JOptionPane.showInputDialog("Enter file name to read from : ");
				if (fileName == null)
					return;
				
				try {
					sra.initializeRecordsFromFile(fileName);
					String recordString = sra.getOriginalRecordsAsString();
					originalRecords.setText(recordString);
				}
				catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), "File read error", 
							JOptionPane.ERROR_MESSAGE);					
				}				
			}
			else if (e.getSource() == writeButton) {		
				
				String fileName = JOptionPane.showInputDialog("Enter file name to write to : ");
				if (fileName == null)
					return;						
				
				try {
					sra.writeSelectedRecordsToFile(fileName);

				}
				catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), "File write error", 
							JOptionPane.ERROR_MESSAGE);
				}				
			}
			else if (e.getSource() == filterButton) {
				String filterString = JOptionPane.showInputDialog("Enter string to filter on : ");
				if (filterString == null)
					return;
				try {
					sra.performFilterOperation(filterString);
					String recordString = sra.getSelectedRecordsAsString();
					selectedRecords.setText(recordString);
				}
				catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(),  
							"Error in filter operation", 
							JOptionPane.ERROR_MESSAGE);
				}				
			}
			else if (e.getSource() == sortButton) {
				String sortItem = JOptionPane.showInputDialog("Enter item to sort on : ");
				if (sortItem == null)
					return;				
				try {
					sra.performSortOperation(sortItem);
					String recordString = sra.getSelectedRecordsAsString();
					selectedRecords.setText(recordString);					
				}
				catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage(), 
							"Error in sort operation", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public static void main( String[] args )
	{ 
		ApplicationMainGUI appGui = new ApplicationMainGUI(); 
		appGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		appGui.setSize( 700, 700); // set frame size
		appGui.setVisible( true ); // display frame
	}
}
