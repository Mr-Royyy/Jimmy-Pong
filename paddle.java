import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Pong paddle
 * @author Jimmy Roy
 * @Version January 23, 2023
 */
public class paddle
{
    static int x;
    static int y;
    static int deltaY; //up/down change
    static int paddlewidth = 25;  //paddle dimensions
    static int paddleheight = 125;//paddle dimensions


    static Rectangle rectangle;

    /**
     *
     * @param startX starting x cord of paddle
     * @param startY starting y value of paddle
     */
    public paddle(int startX, int startY)
    {
        x = startX;
        y = startY;
        rectangle = new Rectangle(x, y, paddlewidth, paddleheight);
        rectangle.setFill(Color.HOTPINK);
    }

    /**
     *
     * @return returns paddle
     */
    public Rectangle getRectangle()
    {
        return rectangle;
    }

}
