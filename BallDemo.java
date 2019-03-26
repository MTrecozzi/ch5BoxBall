import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
    public ArrayList<BoxBall> balls = new ArrayList<>();

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
    
    
    public void addBall(int startX, int startY, int diameter, Color color) {
        
     balls.add( new BoxBall (startX, startY, diameter, color, myCanvas)); 
        
    }
    
    public void populateScene() {
     
        Random rand = new Random();
        
        int totalBalls = rand.nextInt(26);
        totalBalls += 5;
        
        for (int i = 0; i < totalBalls; i++) {
         
            int size = rand.nextInt(10) + 10;
            
            int colorNumber = rand.nextInt(5);
            Color color = Color.RED;
            
            switch (colorNumber){      
                case  0 : 
                color = Color.RED;
                break;
                
                case 1 :
                color = Color.BLUE;
                break;
                
                case 2 :
                color = Color.CYAN;
                break;
                
                case 3 :
                color = Color.ORANGE;
                break;
                
                case 4 :
                color = Color.PINK;
                break;
                
                default:
                break;
                
            }
            
            addBall(200, 200, size, color);
            
            
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
        // create and show the balls
        
        populateScene();
        
        // BoxBall ball = new BoxBall(centerX, centerY, 16, Color.BLUE, myCanvas);
        // ball.draw();
   
        // balls.add(ball);

        
        balls.stream()
        .forEach(b -> 
        {
            putBoundingPoints(b, "topRight", topRight);
            putBoundingPoints(b, "topLeft", topLeft);
            putBoundingPoints(b, "botLeft", botLeft);
            putBoundingPoints(b, "botRight", botRight);
        }
        );        
   
        
        int timer = 0;

        // mke them bounce
        boolean finished =  false;
        while(!finished && timer < 1000) {
            timer++;
            myCanvas.wait(50);
            
            // smll dely
            
            // Draw line in update method
            // Erase All Balls in Stream
            balls.stream().forEach(b -> b.erase());
            // Apply movement to each ball in the scene;
            balls.stream().forEach(b -> b.move());
            
            
            
        }
        
    }
    
    public void drawLine(Point a, Point b){
            myCanvas.drawLine(a.x, a.y, b.x, b.y);   
    }
        
    public void putBoundingPoints(BoxBall ball,String name, Point point) {
        ball.boundingPoints.put(name, point);
    }
}
