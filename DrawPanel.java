// Daniel Gerber
// Project Assignment 5
/* Class DrawPanel extends JPanel, and is used to provide an area on which to draw
   on. DrawPanel is also used to provide reference variables for storing and creating MyShape 
   objects, Color objects, and primitive variables used to manipulate this data.*/
import java.lang.ArrayIndexOutOfBoundsException;
   
//import color and graphics classes  
import java.awt.Color;
import java.awt.Graphics;

//import event classes 
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

import java.awt.BorderLayout; // specifies how components are arranged
import javax.swing.JPanel;// Area to draw on
import javax.swing.JLabel;// label used to display the mouse position

public class DrawPanel extends JPanel
{
	//Declare constants to differentiate between shape objetcs 
	private final static int LINES = 1;
	private final static int RECT = 2;
	private final static int OVAL = 3;
	
	private MyShape[] shapes;//stores all the shapes the user will draw
	private MyShape currentShape;//represents the current shape the user is drawing
	private int shapeCount;//used to increment and decremnt the number of shapes in shapes array
	private int shapeType;//determines the shape to be drawn
	private Color currentColor;//represents the current color being used
	private boolean filledShape;//determine if a filled shape should be drawn
	private JLabel statusLabel;//displays the coordinates of the mouse position on the JPanel 
	
	//constructor DrawPanel with JLabel parameter
	public DrawPanel(JLabel label )
	{
		
		statusLabel = label;// initialize JLabel
		this.add( statusLabel, BorderLayout.SOUTH );//adds JLabel statusLabel
		
		//initialize variables
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = 1; 
		currentColor = Color.BLACK;
		currentShape = null;
		
		//set background of JPanel
		setBackground( Color.WHITE );//set panel background to white
		
		//create a new MouseHandler object
		MouseHandler handler = new MouseHandler();
		
		//add handler to DrawPanel's MouseListener 
		this.addMouseListener(handler);
		//add handler to DrawPanel's MouseMotionListener
		this.addMouseMotionListener(handler);
		
	}//end DrawPanel constructor 

	//create nested class MouseHandler, extend MouseAdapter and implement MouseMotionListener
	//class is used to handle mouse events.
	public class MouseHandler extends MouseAdapter implements MouseMotionListener
	{
		//method used to get X and Y posiont on JPanel and set it JLabel statusLabel
		public void mouseMoved( MouseEvent event )
		{
			statusLabel.setText( String.format( "[%d, %d]", event.getX(), event.getY() ) );
		}//end method mouseMoved
		
		//method used to set shape type, position of the shape on the J Panel
		public void mousePressed(MouseEvent event)
		{
			//call method createShapes with getShapeType() as argument 
			createShapes( getShapeType() );//determines the shape type.
			
			//set shapes X - Y position relative to the mouses X -Y position
			currentShape.setX1(event.getX());
			currentShape.setY1(event.getY());
		}//end mousePressed
		
		//enable shape to be seen while dragging the mouse
		public void mouseDragged( MouseEvent event)
		{
			//set shapes height and width relative to the mouses X -Y position while dragging the mouse
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			
			//call to paintComponent's method
			repaint();
			
			// enable status label to be updated while dragging the wouse
			statusLabel.setText( String.format( "[%d, %d]", event.getX(), event.getY() ) );
		}//end method mouse
		
		//method to set height and width of a shape and store it in shapes array 
		public void mouseReleased(MouseEvent event)
		{
			try
			{
				//set shapes height and width relative to the mouses X -Y value
				currentShape.setX2(event.getX());
				currentShape.setY2(event.getY());
				
				//add current shape to shapes array at the index specified by shapeCounts value 			
				shapes[shapeCount] = currentShape;
				shapeCount++;
				
				//resets current shape so it can be used to store the next shapes values
				currentShape = null;
				
				repaint();//call to paintComponent's method
			}
			
			catch(ArrayIndexOutOfBoundsException exception)
			{
				System.out.println( "The maximum number of shape objects has been reached"+
					" \nshapes array is initialized with 100 indices, no more shapes can be added\n");
				
			}
		}//end method mouseReleased
		
	};
	
	// method to determine what shape is to be processed
	private void createShapes(int shapeChoice)
	{
		
			//use shapeChoice variable to determine which shape to draw
			switch ( shapeChoice )
			{
				//MyLine Object assigned to currentShape if shapeChoice is of value 1
				case LINES: 
					currentShape = new MyLine( 0,0,0,0,getCurrentColor() );
					break;
				
				//MyLine Object assigned to currentShape if shapeChoice is of value 1
				case RECT: 
					currentShape = new MyRect(  0,0,0,0,getCurrentColor(), getFilledShape() );
					break;
				
				//MyLine Object assigned to currentShape if shapeChoice is of value 1
				case OVAL: 
					currentShape = new MyOval( 0,0,0,0,getCurrentColor(), getFilledShape() );
					break;
			}//end switch
		
	}//end method createShapes
	
	//method to set the current color
	public void setCurrentColor( Color color )
	{
		currentColor = color;
	}//end method setCurrentColor
	
	//method to get current color
	public Color getCurrentColor()
	{
		return currentColor;
	}//end getCurrentColor
	
	//method to set shapeType
	public void setShapeType( int typeOfShape )
	{
		shapeType = typeOfShape;
	}//end method setShapeType
	
	//method returns shapeType in the constrainted range of values
	public int getShapeType()
	{
		return (shapeType > 0 && shapeType <= 3 ? shapeType : 1 );
	}//end method getShapeType
	
	//method to set wether or not a shape is filled
	public void setFilledShape( boolean filled )
	{
		filledShape = filled;
	}//end method setFilledShape
	
	//method to return the value of filledShape
	public boolean getFilledShape()
	{
		return filledShape;
	}//end method getFilledShape
	
	//method uses shapeCount ands sets it to 0 to delete all shapes on the JPanel
	public void clearDrawing()
	{
		shapeCount =0;
		repaint();
	}//end method clearDrawing
	
	//method to undo the last shape ceated by decrementing shapeCount
	public void clearLastShape()
	{
		shapeCount--;
		
		if( shapeCount < 0 )
			shapeCount = 0;
		repaint();
	}//end method clearLastShape
	
	//draw the individual shapes
	public void paintComponent( Graphics g )
	{	
		super.paintComponent( g ); 	
		
		//displays the shapes in shapes array
		for ( int i = 0; i < shapeCount; i++ )
			shapes[i].draw( g );
		
		
		//displays the cuurent shape being drawn if currentShape is  not null
		if( currentShape != null && shapeCount < 100 )
		{
			currentShape.draw(g);
		}
	
	}//end method paintComponent
	
	
}