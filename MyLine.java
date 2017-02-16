// Daniel Gerber
// Project Assignment 5
// This class is used to create Line objects.

//import the color and graphics
import java.awt.Color;
import java.awt.Graphics;

//declares class MyLine
public class MyLine extends MyShape
{
	//no argument constructor
	public MyLine()
	{
		super(0, 0, 0, 0, Color.BLACK );
	}// end constructor MyLine
	
	// constructor with five arguments for initialising the positions and colour of a line.
	public MyLine( int x1, int y1, int x2, int y2, Color color )
	{
		super( x1, y1, x2, y2, color);
	}//end MyLine constructor
	
	// method for drawing a line.
	public void draw( Graphics g )
	{
		g.setColor( getMyColor() );
		g.drawLine( getX1(), getY1(), getX2(), getY2() );

	}//end method drawLine

	
} // end class MyLine

