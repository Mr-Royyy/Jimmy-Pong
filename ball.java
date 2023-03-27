import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * Pong 'ball'
 * @author Jimmy Roy
 * @Version January 23, 2023
 */
public class ball
{
    static int x;
    static int y;
    static int deltaX = 8;
    static int deltaY = 15;
    Rectangle rectangle;

    /**
     *
     * @param startX Ball x cord updates
     * @param startY ball y cord updates
     */
    public ball(int startX, int startY)
    {
        x = startX;
        y = startY;
        rectangle = new Rectangle (x,y,25,25); //ball size
        rectangle.setFill(Color.NAVAJOWHITE);
    }

    /**
     * Ball movement code
     */
    public void move()
    {
        x +=deltaX;
        y +=deltaY;
        rectangle.setX(x);
        rectangle.setY(y);

        if(y + 25 >= main1.MAX_HEIGHT || y <= 0)
        {
           deltaY *= -1;
        }

    }

    /**
     *
     * @return the paddle
     */
    public Rectangle getRectangle()
    {
        return rectangle;
    }

}
