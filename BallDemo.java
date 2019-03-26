import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 * 
 * Demonstrates the BoxBall Class
 *
 * @author Matthew Trecozzi
 * @version 3.25.19
 */

public class BallDemo   
{
    private Canvas myCanvas;
    public ArrayList<BoxBall> balls = new ArrayList<>();
    public Point canvasCenter;

    /**
     * Create a BallDemo Object, initializes our main canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Bll Demo", 600, 500);
        
        canvasCenter = new Point((int) myCanvas.getSize().getWidth()/ 2,(int) myCanvas.getSize().getHeight() /2);
        
        // call boxBounce for testing purposes
        //boxBounce();
    }

    /**
     * @ return void
     * @ parame null
     * Simulate two bouncing balls
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
    
    /**
     * Initialize and add a ballObject to our ArrayList Collection
     * @return void
     * @param startX initiailizes the balls starting X Position
     * @param startY initializes the balls starting X position
     * @param diameter sets the balls diameter and size
     * @param color initializes the balls color.
     */
    public void addBall(int startX, int startY, int diameter, Color color) {
        
     balls.add( new BoxBall (startX, startY, diameter, color, myCanvas)); 
        
    }
    
    /**
     * Initializes the scene by creating and distributing ball Objects into the scene space and the balls arrayList for management.
     * @return void
     * @param _totalBalls The total number of ball objects to generate
     * @param boxLength The Length of one side of the square box.
     */
    public void populateScene(int _totalBalls, int boxLength) {
     
        Random rand = new Random();
        
        //int totalBalls = rand.nextInt(26);
        //totalBalls += 5;
        
        for (int i = 0; i < _totalBalls; i++) {
         
            int size = rand.nextInt(21) + 10;
            
            int colorNumber = rand.nextInt(5);
            Color color = new Color (rand.nextInt(246), rand.nextInt(246), rand.nextInt(246));
            
            // switch (colorNumber){      
                // case  0 : 
                // color = Color.RED;
                // break;
                
                // case 1 :
                // color = Color.BLUE;
                // break;
                
                // case 2 :
                // color = Color.CYAN;
                // break;
                
                // case 3 :
                // color = Color.ORANGE;
                // break;
                
                // case 4 :
                // color = Color.PINK;
                // break;
                
                // default:
                // break;
                
            // }
            
            int quadrant = rand.nextInt(4);
            
            int xOffset = rand.nextInt(boxLength / 2) - 30;
            int yOffset = rand.nextInt(boxLength /2) - 30;
            
            
            switch (quadrant){
                
                case 0:
                // spawn in top left quadrant
                xOffset = -xOffset;
                break;
                
                case 1:
                // spawn in top right quadrant
                break;
                
                case 2:
                // spawn in bot right quadrant
                yOffset = -yOffset;
                break;
                
                case 3: 
                // spon in bot left quadrant
                yOffset = -yOffset;
                xOffset = -xOffset;
                break;
                
                default:
                break;
                
                
                
            }
            
            addBall(canvasCenter.x + xOffset, canvasCenter.y + yOffset, size, color);
            
            
        }
        
    }
    
    /** 
     * Simulates  bouncing ball(s) confined within  box
     * @return void
     * @param totalBalls The total Balls to generate and simulate within the scene
     */
    public void boxBounce(int totalBalls) {
        int boxLength = (int) myCanvas.getSize().getHeight() - ((int) myCanvas.getSize().getHeight() / 10);
        int halfLength = boxLength / 2;
        
        // crete  clss for point vlues (2, 3);
        // crete point vlues to check ginst;
        
        // x and y center of the box
        int centerX = canvasCenter.x;
        int centerY = canvasCenter.y;
        
       myCanvas.getSize().getHeight();
       myCanvas.getSize().getWidth();
        
        Point topRight = new Point(centerX + halfLength, centerY -halfLength);
        Point topLeft = new Point(centerX -halfLength,centerY -halfLength);
        Point botRight = new Point(centerX + halfLength, centerY + halfLength);
        Point botLeft = new Point(centerX -halfLength, centerY + halfLength);
        
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
        
        populateScene(totalBalls, boxLength);
        
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
        while(!finished) {     
            myCanvas.wait(50);
            
            // smll dely
            
            // Draw line in update method
            // Erase All Balls in Stream
            balls.stream().forEach(b -> b.erase());
            // Apply movement to each ball in the scene;
            balls.stream().forEach(b -> b.move());
            
            
            
        }
        
    }
    
    /**
     * Draws a line between the position values of two point objects
     * @return void
     * @param a Point a
     * @param b Point b
     */
    public void drawLine(Point a, Point b){
            myCanvas.drawLine(a.x, a.y, b.x, b.y);   
    }
    
    
    /**
     * Initializes the boundingPoints hashMap within a ball object with the given point name and value key map relationship.
     * @return void
     * @param ball The ball object to initialize
     * @param name The name of the boundingPoint
     * @param point The Point Object Value
     */    
    public void putBoundingPoints(BoxBall ball,String name, Point point) {
        ball.boundingPoints.put(name, point);
    }
}
