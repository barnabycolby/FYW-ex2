package ex2;

//Imports the turtle class
import fyw.turtles.*;

public class Ex2Rectangle {
	//Defines distance of the left side of the rectangle to the right of the origin
	private float left;
	//Defines distance of the top side of the rectangle from the top of the origin
	private float top;
	//Defines width of rectangle
	private float width;
	//Defines height of rectangle
	private float height;
	
	/* Getter for left
	 * requires: nothing
	 * ensures: returns the value of left
	 */
	public float getLeft(){
		return this.left;
	}
	/* Setter for left
	 * requires: new value of left
	 * ensures: that the value of left is set to the new value
	 */
	public void setLeft(float newLeft){
		this.left = newLeft;
	}
	
	/* Getter for top
	 * requires: nothing
	 * ensures: returns the value of top
	 */
	public float getTop(){
		return this.top;
	}
	/* Setter for top
	 * requires: new value of top
	 * ensures: that the value of top is set to the new value
	 */
	public void setTop(float newTop){
		this.top = newTop;
	}
	
	/* Getter for width
	 * requires: nothing
	 * ensures: that the value of width is returned
	 */
	public float getWidth(){
		return this.width;
	}
	/* Setter for width
	 * requires: new value of width
	 * ensures: that the value of width is set to the new value
	 */
	public void setWidth(float newWidth){
		this.width = newWidth;
	}
	
	/* Getter for height
	 * requires: nothing
	 * ensures: that the value of height is returned
	 */
	public float getHeight(){
		return this.height;
	}
	/* Setter for height
	 * requires: new value of height
	 * ensures: that the value of height is set to the new value
	 */
	public void setHeight(float newHeight){
		this.height = newHeight;
	}
	
	/* Getter for the distance of the right side from the origin
	 * requires: nothing
	 * ensures: that the distance of the right side from the origin is returned
	 */
	public float getRight(){
		return (this.left + width);
	}
	/* Setter for the distance of the right side from the origin
	 * requires: new value for right
	 * ensures: that the distance of the right side from the origin is set to the new value
	 * 		the value of left is kept the same
	 */
	public void setRight(float newRight){
		this.width = newRight - this.left;
	}
	
	/* Getter for the distance of the bottom side from the origin
	 * requires: nothing
	 * ensures: the distance of the bottom side from the origin is returned
	 */
	public float getBottom(){
		return (this.top + height);
	}
	/* Setter for the distance of the bottom side from the origin
	 * requires: new value of the distance to the bottom side from the origin
	 * ensures: the distance of the bottom side from the origin is set to the new value
	 * 		top stays the same
	 */
	public void setBottom(float newBottom){
		this.height = newBottom - this.top;
	}
	
	/* Constructor
	 * requires: new values of left, top, width, and height
	 * ensures: the values of left, top, width and height are set to the new values provided for each of them
	 */
	public Ex2Rectangle(float newLeft, float newTop, float newWidth, float newHeight){
		//Uses the already defined methods to set the variables so that future
		//modifications to the way we access/use the variables are easier to implement
		this.setLeft(newLeft);
		this.setTop(newTop);
		this.setWidth(newWidth);
		this.setHeight(newHeight);
	}
	
	/* Constructor
	 * requires: nothing
	 * ensures: that the information for a new Rectangle with random position and size is generated
	 */
	public Ex2Rectangle(){
		//Allows easy modification of the "Sensible" range of size and position
		int range = 100;
		
		this.setLeft((float)(Math.random() * range));
		this.setTop((float)(Math.random() * range));
		this.setWidth((float)(Math.random() * range));
		this.setHeight((float)(Math.random() * range));
	}
	
	/* Draws the rectangle
	 * requires: a handle to a turtle
	 * ensures: that the rectangle defined by the internal fields is drawn by the turtle
	 */
	public void draw(Turtle theTurtle){
		//Allows the turtle to move into position without drawing
		theTurtle.penUp();
		//Move turtle to position of top left corner of rectangle
		theTurtle.turn(90);
		theTurtle.move(this.left);
		theTurtle.turn(90);
		theTurtle.move(this.top);
		//Put the pen down to allow the rectangle to be drawn
		theTurtle.penDown();
		//Draw left side
		theTurtle.move(this.height);
		//Draw bottom side
		theTurtle.turn(270);
		theTurtle.move(this.width);
		//Draw right side
		theTurtle.turn(270);
		theTurtle.move(this.height);
		//Draw top side
		theTurtle.turn(270);
		theTurtle.move(this.width);
		//Pen up so that the Turtle can return to original position
		theTurtle.penUp();
		//Return theTurtle to the original position and orientation
		theTurtle.move(this.left);
		theTurtle.turn(90);
		theTurtle.move(this.top);
	}
	
}
