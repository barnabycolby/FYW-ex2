package ex2;
import fyw.turtles.*;

public class Ex2RectangleMethods {
    
    /**
     * create turtle in a GUI, and an input frame
     * @param args strings from command line
     */
    public static void main(String[] args) {
        Turtle theTurtle = new Turtle();
        new TurtleGUI(theTurtle);
        //InputFrame theInputFrame = new InputFrame();
        
        /* Write your own code and comments within the area below
         *vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
         */
        
        //Create an array of 5 random rectangles
        Ex2Rectangle[] array = RandomArray(5);
        
        //Draw the rectangles using turtle
        for(int i = 0; i < array.length; i++){
        	array[i].draw(theTurtle);
        }
        
        //Calculate and store bounding box of the rectangles
        Ex2Rectangle boundingBox = BoundingBox(array);
        
        //Check that the call to BoundingBox was successful
        if(boundingBox == null){
        	System.out.print("The array of rectangles was empty!");
        	System.exit(0);
        }
        
        //Draw the bounding box using theTurtle
        boundingBox.draw(theTurtle);
        
        /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         * Write your own code and comments within the area above
         */
        
    }
    
    /* RandomArray returns an array of Ex2Rectangles
     * requires: An integer that defines the number of Ex2Rectangles that should be generated
     * ensures: An array is returned that contains the specified number of Ex2Rectangles with
     * 		random positions and sizes
     */
    //This method must be a static method because it references several objects of the same class
    //and cannot be defined as a non-static method of Ex2Rectangle because we would not be able to
    //call it from main. This is because several new Ex2Rectangle classes are generated inside the
    //RandomArray function. We cannot generate these classes by using a non-static method inside
    //Ex2Rectangle as it's non static property means that it can only perform actions on the current
    //instance of Ex2Rectangle.
    public static Ex2Rectangle[] RandomArray(int numberOfRectangles){
    	//Define an array with the specified length to store the array of Ex2Rectangles
    	Ex2Rectangle[] array = new Ex2Rectangle[numberOfRectangles];
    	
    	//Loop invariant: the variable i is always less than numberOfRectangles
    	for(int i = 0; i < numberOfRectangles; i++){
    		//Generate a new Ex2Rectangle with random position and size (Empty contructor parameters)
    		//and assign it to the next available position in the array
    		array[i] = new Ex2Rectangle();
    	}
    	
    	//Return the array
    	return array;
    }
    
    public static Ex2Rectangle BoundingBox(Ex2Rectangle[] array){
    	//If input array is empty, return null
    	if(array.length == 0){
    		return null;
    	}
    	
    	//Variables to store the size of the bounding box
    	//We initialise them with the size of the first rectangle
    	float left = array[0].getLeft();
    	float top = array[0].getTop();
    	float right = array[0].getRight();
    	float bottom = array [0].getBottom();
    	
    	//Start the count from 1 because we have already looked at one box
    	for(int i = 1; i < array.length; i++){
    		//Check whether the left side is contained by the bounding box
    		if(array[i].getLeft() < left){
    			left = array[i].getLeft();
    		}
    		
    		//Check whether the top side is contained by the bounding box
    		if(array[i].getTop() < top){
    			top = array[i].getTop();
    		}
    		
    		//Check whether the right side is contained by the bounding box
    		if(array[i].getRight() > right){
    			right = array[i].getRight();
    		}
    		
    		//Check whether the bottom side is contained by the bounding box
    		if(array[i].getBottom() > bottom){
    			bottom = array[i].getBottom();
    		}
    	}
    	
    	//Work out the width and height of the bounding box from the
    	//top, left, bottom and right variables
    	float width = right - left;
    	float height = bottom - top;
    	
    	//Create the Ex2Rectangle which stores the bounding box
    	Ex2Rectangle boundingBox = new Ex2Rectangle(left, top, width, height);
    	
    	//Return the bounding box
    	return boundingBox;
    }
    
}
