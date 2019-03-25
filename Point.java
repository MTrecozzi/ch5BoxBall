
/**
 * Write a description of class Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point
{
    // instance variables - replace the example below with your own
    public int x;
    public int y;

    /**
     * Constructor for objects of class Point
     */
    public Point(int _x, int _y)
    {
        // initialise instance variables
        x = _x;
        y = _y;
    }
    
    public void setPoints(int x, int y) {
     
        this.x = x;
        this.y = y;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
