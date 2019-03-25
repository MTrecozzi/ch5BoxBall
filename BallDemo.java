import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    /** Simulates a bouncing ball confined within a box
     */
    public void boxBounce() {
        int boxLength = 100;
        int halfLength = boxLength / 2;
        
        // create a class for point values (2, 3);
        // create point values to check against;
        
        int center = 200; // Position of the center of the box
        int centerX = center;
        int centerY = center;
        
       myCanvas.getSize().getHeight();
       myCanvas.getSize().getWidth();
        
        Point topRight = new Point(center + halfLength, center -halfLength);
        Point topLeft = new Point(center -halfLength,center -halfLength);
        Point botRight = new Point(center + halfLength, center - halfLength);
        Point botLeft = new Point(center -halfLength, center + halfLength);
        
        int boundRight = botRight.x;
        int boundLeft = botLeft.x;
        int boundTop = topLeft.y;
        int boundBot = botLeft.y;
        
        myCanvas.setVisible(true);
        
        

        // draw the left Box;
        myCanvas.drawLine(topLeft.x, topLeft.y,
        botLeft.x, botLeft.y);
        // draw the top Box;
        myCanvas.drawLine(topLeft.x, topLeft.y,
        topRight.x, topRight.y);
        // draw the right box;
        myCanvas.drawLine(center + halfLength, center - halfLength,
        center + halfLength, center + halfLength);
        // draw bottom box
        myCanvas.drawLine(center - halfLength, center + halfLength,
        center + halfLength, center + halfLength);
        // crate and show the balls
        BoxBall ball = new BoxBall(centerX, centerY, 16, Color.BLUE, myCanvas, 100, 100);
        ball.draw();
        BoxBall ball2 = new BoxBall(centerX, centerY, 20, Color.RED, myCanvas, 100, 100);
        ball2.draw();
        
        int timer = 0;

        // make them bounce
        boolean finished =  false;
        while(!finished && timer < 1000) {
            timer++;
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
            
            
            
        }
        
    }
}
