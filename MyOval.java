// Daniel Gerber
// Project Assignment 5
// This class is used to create Oval objects.

//imports Color and Graphics objects
import java.awt.Color;
import java.awt.Graphics;

//create public class MyOval
public class MyOval extends MyBoundedShape
{
	//no argument constructor
	public MyOval()
	{
		super(0, 0, 0, 0, Color.BLACK,false );
	}// end constructor MyOval
	
	//constructor with six arguments for initialising the positions, colour, and fill of an Oval.
	public MyOval( int x1, int y1, int x2, int y2, Color color, boolean fill )
	{
		super( x1, y1, x2, y2, color, fill );
		
	}//end MyOval constructor
	
	// method for drawing a filled or outlined oval.
	public void draw( Graphics g )
	{
		g.setColor( getMyColor() );
      
		//use boolean value to determine if the shape is filled or not.
		if( getFillShape() == false )
			g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		else
			g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );

	}//end method drawOval
   
}//end class