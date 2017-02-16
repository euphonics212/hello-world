// Daniel Gerber
// Project Assignment 5
/* Class DrawFrame extends JFrame, and is used to provide an area on which Components
   can be placed. It contains several event listeners  associated with buttons,
   combo boxes and a check box*/

import java.awt.FlowLayout;// used to specify the order of the display of components
import java.awt.BorderLayout; // specifies how components are arranged
import java.awt.Color;//Color Object for selecting shape color
import java.awt.event.ItemListener;//import for event handling on a JComboBox
import java.awt.event.ItemEvent;//import for event handling on a JComboBox
import java.awt.event.ActionListener;//import for event handling on a JCheckBox
import java.awt.event.ActionEvent;//import for event handling on a JCheckBox

import javax.swing.JScrollPane;//Scrolling for JComboBox
import javax.swing.JPanel;//JPanel imported for grouping components for BorderLayout
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.JButton;// used for creating buttons in a window
import javax.swing.JComboBox;// used to create a drop down list 
import javax.swing.JCheckBox;// used to creat a check box

//declares class DrawFrame that extends the class JFrame
public class DrawFrame extends JFrame
{
	//declare the JButtons
	private JButton undoButton;
	private JButton clearButton;
	
	//declare the JComboBox for selecting the color
	private JComboBox selectColorBox;
	//An array of Strings to represent the selectable colors
	private final String[] colorNames = {
			"Red", "Yellow", "Blue", "Green", "Black", "White", "Gray",
			"Dark Gray", "Light Gray", "Magenta", "Orange", "Pink", "Cyan" };
	//array of Color constants 
	private final Color[] colors = {
			Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.BLACK,
			Color.WHITE, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.CYAN};
	
	//declare the JCheckBox for selecting the shape type
	private JComboBox selectShapeBox;	
	private final String[] shapeName = {"Line", "Rectangle", "Oval"};//used with combobox for naming shapes
	private final int[] shapeTypeNum = { 1, 2, 3};// constants for selecting which shape types
	
	//declare the JCheckBox for selecting wether a shape is filled
	private JCheckBox fillCheckBox;
	
	private JPanel northPanel = new JPanel();//JPanel Object to place buttons, combo boxes and check boxes 
	private JPanel southPanel = new JPanel();//JPanel object to place a JLabel
	
	//declare and initialize a JLable for the DrawPanel constructor
	private JLabel mousePosLabel = new JLabel();
	
	//creat a DrawPanel object for drawing shapes with JLabel mousePosLabel as an argument
	private DrawPanel drawPanel = new DrawPanel( mousePosLabel );
	
	
	
	// Constructor for DrawFrame
	public DrawFrame()
	{
		super( "Paint Program" );//set frame name
		
		add(drawPanel, BorderLayout.CENTER );//add drawPanel
		add(northPanel, BorderLayout.NORTH );//add components panel
		add(southPanel, BorderLayout.SOUTH);//add statusLabel's panel
		southPanel.add(mousePosLabel);//add JLabel mousePosLabel to the southPanel JPanel
		
		undoButton = new JButton( "Undo" );//initialize JButton
		//add an Action Listener for JButton Undo
		undoButton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					if (event.getActionCommand().equals("Undo")) 
						drawPanel.clearLastShape();
				}//end method actionPerformed
			}//end anonymous
		);//end call to addActionListener
		northPanel.add( undoButton );//add button to northPanel
		
		clearButton = new JButton( "Clear" );//initialize JButton
		//add an Action Listener for JButton Clear
		clearButton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					if (event.getActionCommand().equals("Clear")) 
						drawPanel.clearDrawing();
				}//end method actionPerformed
			}//end anonymous class
		);//end call to addActionListener
		northPanel.add( clearButton );//add button to northPanel
		
		selectColorBox = new JComboBox( colorNames );//set color names to be selectable in the JComboBox
		selectColorBox.setMaximumRowCount( 5 );//maximum visible selection
		//add an item Listener for the selectColorBox
		selectColorBox.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged( ItemEvent event )
				{
					if( event.getStateChange() == ItemEvent.SELECTED )
						drawPanel.setCurrentColor( colors[selectColorBox.getSelectedIndex()] );
				}//end method itemStateChanged
			}// end anonymous class
		);//end call to addItemListener
		northPanel.add( new JScrollPane (selectColorBox) );//add selectColorBox JComboBox to the northPanel
		
		selectShapeBox = new JComboBox( shapeName );//set shape names to be selectable in the JComboBox
		//add an item Listener for the selectShapeBox
		selectShapeBox.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged( ItemEvent event )
				{
					if( event.getStateChange() == ItemEvent.SELECTED )	
						drawPanel.setShapeType( shapeTypeNum[selectShapeBox.getSelectedIndex()] );		
				}//end method itemStateChanged
			}// end anonymous class
		);//end call to addItemListener
		northPanel.add( selectShapeBox);
		
		fillCheckBox = new JCheckBox( "Filled" );//create a new JCheckBox object fillCheckBox
		CheckboxHandler handler = new CheckboxHandler();//create CheckBoxHandler
		fillCheckBox.addItemListener( handler );//add the handler to the listener
		northPanel.add( fillCheckBox );// add fillCheckBox to the northPanel

	} // end DrawFrame constructor
	
	//nest class CheckBoxHandler for fillCheckBox events
	public class CheckboxHandler implements ItemListener
	{
		public void itemStateChanged( ItemEvent event )
		{
			if( fillCheckBox.isSelected() )
				drawPanel.setFilledShape( true ); 
			else if( !fillCheckBox.isSelected() )
				drawPanel.setFilledShape( false );
				
			
		}//end method itemStateChanged
	}//end class CheckBoxHandler
	
} // end class DrawFrame