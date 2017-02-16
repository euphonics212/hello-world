// Daniel Gerber
// Project Assignment 5
// This Super Class is used to create Shape objects.

//imports Color and Graphics objects
import java.awt.Color;
import java.awt.Graphics;

//create public class Shape
public abstract class MyShape
{
	private int x1; //first x coordinate
	private int y1; //first y coordinate
	private int x2; //second x coordinate
	private int y2; //Second y coordinate
	private Color myColor; // color of this shape
	
	
	//no argument constructor to set instance variables to a default value
	public MyShape( )
	{
		this(0, 0, 0, 0, Color.BLACK );
	}
	
	//constructor with five arguments for initialising the positions and colour of a shape
	public MyShape( int x1, int y1, int x2, int y2, Color color )
	{
		//methods for valitdating and setting x and y variables
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
	  
		//set the color using setColor method
		setMyColor(color);
	  
	  
	}//end MyShape constructor

	//method for validating that the shape coordinates are within rage
	public int validateCoordinate(int coOrd)
	{
		return (coOrd >= 0 ? coOrd : 0 );
	}//end method validateCoordinate
	
	//set method to set and validate x1
	public void setX1(int x)
	{
		x1 = validateCoordinate(x);
	}//end method setX1
	
	//method to get x1's value
	public int getX1()
	{
		return x1;
	}//end method getX1
	
	//set method to set and validate y1
	public void setY1(int y)
	{
		y1 = validateCoordinate(y);
	}//end method setY1
	
	//method to get y1's value
	public int getY1()
	{
		return y1;
	}//end method getY1
	
	//set method to set and validate x2
	public void setX2(int x)
	{
		x2 = validateCoordinate(x);
	}//end method setX2
	
	//method to get x2's value
	public int getX2()
	{
		return x2;
	}//end method getX2
	
	//set method to set and validate y2
	public void setY2(int y)
	{
		y2 = validateCoordinate(y);
	}//end method setY2
	
	//method to get y2's value
	public int getY2()
	{
		return y2;
	}//end method getY2
	
	//method to set color
	public void setMyColor( Color color )
	{
		myColor = color;
	}//end method setColor
	
	//method to get color
	public Color getMyColor()
	{
		return myColor;
	}//end method getColor
	
	//determine the smaller value to assign tho upper x and y
	private int getSmallerValue( int val1, int val2)
	{
		return( val1 > val2 ? val2 : val1 );
	}// end getSmallerValue
	
	//method to calculate the upperleft corner of the shape
	public int getUpperLeftX()
	{
		return getSmallerValue(x1, x2);
	}//end method getUpperLeftX

	//method to calculate the upperleft corner of the shape
	public int getUpperLeftY()
	{
		return getSmallerValue(y1, y2);
	}//end method getUpperLeftY

	//method to calculate the width of the shape
	public int getWidth()
	{
		int width;
		width = x1 - x2;

		return Math.abs(width); //returns the absolute value of the difference of two values.
	}//end method getWidth

	//method to calculate the height of the shape
	public int getHeight()
	{
		int height;
		height = y1 - y2;

		return Math.abs(height);//returns the absolute value of the difference of two values.
	}//end method getHeight
	
	 public abstract void draw( Graphics g );
	
   
}//end class Shape