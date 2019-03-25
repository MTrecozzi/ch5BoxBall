import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Brnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Crete  BllDemo object. Cretes  fresh cnvs nd mkes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Bll Demo", 600, 500);
        
        // call boxBounce for testing purposes
        boxBounce();
    }

    /**
     * Simulte two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // drw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crte nd show the blls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // mke them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // smll dely
            ball.move();
            ball2.move();
            // stop once bll hs trvelled  certin distnce on x xis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    /** Simultes  bouncing ball confined within  box
     */
    public void boxBounce() {
        int boxLength = 100;
        int halfLength = boxLength / 2;
        
        // crete  clss for point vlues (2, 3);
        // crete point vlues to check ginst;
        
        int center = 200; // Position of the center of the box
        int centerX = center;
        int centerY = center;
        
       myCanvas.getSize().getHeight();
       myCanvas.getSize().getWidth();
        
        Point topRight = new Point(center + halfLength, center -halfLength);
        Point topLeft = new Point(center -halfLength,center -halfLength);
        Point botRight = new Point(center + halfLength, center + halfLength);
        Point botLeft = new Point(center -halfLength, center + halfLength);
        
        int boundRight = botRight.x;
        int boundLeft = botLeft.x;
        int boundTop = topLeft.y;
        int boundBot = botLeft.y;
        
        myCanvas.setVisible(true);
        
        // public void drawBox;
        // draw the left Box;
        drawLine(topLeft, botLeft);
        // draw the top Box;
        drawLine(topLeft, topRight);
        // draw the right box;
        drawLine(topRight, botRight); 
        // draw bottom box
        drawLine(botLeft, botRight); 
        // create nd show the blls
        BoxBall ball = new BoxBall(centerX, centerY, 16, Color.BLUE, myCanvas, boxLength);
        ball.draw();
        
        putBoundingPoints(ball, "topRight", topRight);
        putBoundingPoints(ball, "topLeft", topLeft);
        putBoundingPoints(ball, "botLeft", botLeft);
        putBoundingPoints(ball, "botRight", botRight);
        
        BoxBall ball2 = new BoxBall(centerX, centerY, 16, Color.RED, myCanvas, boxLength);
        ball.draw();
        
        putBoundingPoints(ball2, "topRight", topRight);
        putBoundingPoints(ball2, "topLeft", topLeft);
        putBoundingPoints(ball2, "botLeft", botLeft);
        putBoundingPoints(ball2, "botRight", botRight);
        
        
   
        
        int timer = 0;

        // mke them bounce
        boolean finished =  false;
        while(!finished && timer < 1000) {
            timer++;
            myCanvas.wait(50);
            
            // smll dely
            
            // Draw line in update method
            
            ball.move();
            ball2.move();
            
            // stop once bll hs trvelled  certin distnce on x xis
            if(ball.getXPosition() >= 550) {
                finished = true;
            }
            
            
            
        }
        
    }
    
    public void drawLine(Point a, Point b){
            myCanvas.drawLine(a.x, a.y, b.x, b.y);   
    }
        
    public void putBoundingPoints(BoxBall ball,String name, Point point) {
        ball.boundingPoints.put(name, point);
    }
}
