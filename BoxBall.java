import java.awt.*;
import java.awt.geom.*;
import java.util.HashMap;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 * 
 * This variation of the Bouncing Ball class models a ball that moves inside a box.
 *
 * 
 * @author Matthew Trecozzi (G00248431);
 * @version 2019.3.25
 */

public class BoxBall
{


    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;

    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int xSpeed = 1;
    
    int moveX;
    int moveY;
    
    public HashMap<String, Point> boundingPoints = new HashMap<>();
    

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                         Canvas drawingCanvas, int boxLength)
    {
        
        moveX = xSpeed;
        moveY = ySpeed;
        
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
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
        erase();
            
        
        
        
        
        // compute new position
        
        

        // check if it has hit the a wall and act accordingly
       if (xPosition + diameter + 1 > boundingPoints.get("topRight").x){
           moveX = -moveX;
        }
         if (yPosition + diameter + 1 < boundingPoints.get("botRight").y){
            moveY = -moveY;    
        }  if (xPosition - 1 < boundingPoints.get("topLeft").x) {
            moveX = -moveX;
        }  if (yPosition -1 > boundingPoints.get("topRight").y)
            moveY = -moveY;
            
        yPosition += moveY;
        xPosition += moveX;

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
