// Daniel Gerber
// Project Assignment 5
// Class TestDraw to test Drawing App

import javax.swing.JFrame;
import javax.swing.JLabel;

//create class testDraw
public class TestDraw
{
	//Main method 
	public static void main( String args[] )
	{
		DrawFrame drawFrame = new DrawFrame(); // create drawFrame
		drawFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );//closes application on clicking red x box
		drawFrame.setSize( 550, 360 ); // set frame size
		drawFrame.setVisible( true ); // display frame
	
	} // end main
} // end class TestDraw
