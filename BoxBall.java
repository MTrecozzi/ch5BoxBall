import java.awt.*;
import java.awt.geom.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Class BoxBall - A Graphical Ball that is initialized with a velocity, and bounces around within the constraints of its modeled box.
 * 
 * This variation of the Bouncing Ball class models a ball that moves inside a box.
 *
 * 
 * @author Matthew Trecozzi (G00248431);
 * @version 2019.3.25
 */

public class BoxBall
{
    private Ellipse2D.Double circle;  
    private Color color; // Color of the Ball
    private int diameter; // Diameter of the BoxBall Object
    public int radius; // Radius to be used in calculations, 1/2 * diameter
    private int xPosition; // starting xPosition;
    private int yPosition; // startung yPosition

    private Canvas canvas;
    private int ySpeed = 1; // initial yAxis speed
    private int xSpeed = 1; // initial xAxis speed
    
    int moveX; // current xMovementSpeed
    int moveY; // current yMovementSpeed
    
    public Point center; // center position of the boxBall object
    
    public HashMap<String, Point> boundingPoints = new HashMap<>(); // A hashMap between String bounding point Names, and Point Values
    

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the starting horizontal coordinate of the ball
     * @param yPos  the starting vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                         Canvas drawingCanvas)
    {
        
        Random rand = new Random();
        int xSpeed = rand.nextInt(15) - 7;
        int ySpeed = rand.nextInt(15) - 7;
        
        moveX = xSpeed;
        moveY = ySpeed;
        
        xPosition = xPos;
        yPosition = yPos;
        
        
        color = ballColor;
        diameter = ballDiameter;
        
        radius = diameter / 2;
        
        center = new Point (xPosition + radius, yPosition + radius);
        // Diameter check
        
        canvas = drawingCanvas;
        
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        //erase();
        
        int xMax = boundingPoints.get("topRight").x;
        int xMin = boundingPoints.get("topLeft").x;
        int yMax = boundingPoints.get("topRight").y;
        int yMin = boundingPoints.get("botRight").y;
            
        // compute new position   
        // If distance between this and another circle < b1 rad + b2 rad, they are colliding, reverse their directions.
        
        // check if it has hit the a wall and act accordingly
        
        // If Ball's position is too far Right
       if (xPosition + diameter + moveX > xMax){
           moveX = -moveX;
        }
        // If Ball's position is to far down
       if (yPosition + diameter + moveY < yMin){
            moveY = -moveY;    
        }  
        // If ball position is to far right
       if (xPosition + moveX - 1 < xMin) {
            moveX = -moveX;
        }  
        
       if (yPosition - moveY > yMax) {
            moveY = -moveY;
        }
            
            
        yPosition += moveY;
        xPosition += moveX;
        
        center.setPoints(xPosition + radius, yPosition + radius);

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
