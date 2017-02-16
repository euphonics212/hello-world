// Daniel Gerber
// Project Assignment 5
// This class is used to create Oval and Rect objects and extend MyShape 
// to determine if said shapes are filled or not.

//imports Color and Graphics objects
import java.awt.Color;
import java.awt.Graphics;

//create public class MyBoundedShape and extend MyShape
public abstract class MyBoundedShape extends MyShape
{
	private boolean fillShape;// boolean value for filling or not filling the shape
	
	public MyBoundedShape( )
	{
		super(0, 0, 0, 0, Color.BLACK);
		
	}//end MyBoundedShape constructor
	
	//constructor with five arguments for initialising the positions and colour of a bound shape
	public MyBoundedShape( int x1, int y1, int x2, int y2, Color color,boolean fill )
	{
		super( x1, y1, x2, y2, color );
		
		setFillShape(fill);
	}//end MyBoundedShape constructor
	
	//method to set filled shape using a boolean value
	public void setFillShape( boolean fill )
	{
		fillShape = fill;
	}//end setFillShape method
   
	//method for returning a boolean value for filling or drawing a bound shape
	public boolean getFillShape()
	{
		return fillShape;
	}//end  method getFillShape
}//end class MyBoundedShape