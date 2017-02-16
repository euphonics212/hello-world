// Daniel Gerber
// Project Assignment 5
// This class is used to create Rectangle objects.

//imports Color and Graphics objects
import java.awt.Color;
import java.awt.Graphics;

//create public class MyRect
public class MyRect extends MyBoundedShape
{
	//no argument constructor
	public MyRect()
	{
		super(0, 0, 0, 0, Color.BLACK,false );
	}// end constructor MyRect
	
	//constructor with six arguments for initialising the positions and colour and fill of a Rectangle.
	public MyRect( int x1, int y1, int x2, int y2, Color color, boolean fill )
	{
		super( x1, y1, x2, y2, color, fill );
		
	}//end MyRect constructor
		
	// method for drawing filled or outlined rectangle.
	public void draw( Graphics g )
	{
		g.setColor( getMyColor() );
		  
		//use boolean value to determine if the shape is filled or not.
		if( getFillShape() == false )
			g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		else
			g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
	}//end method drawRect
}//end class
