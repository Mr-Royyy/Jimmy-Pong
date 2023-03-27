import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * Pong paddle
 * @author Jimmy Roy
 * @Version January 23, 2023
 */
public class paddleOPP
{
    static int x;
    static int y;
    static int deltaY; //up/down change
    static int paddleoppwidth = 25; //paddle dimensions
    static int paddleoppheight = 125;//paddle dimensions

    static Rectangle rectangle1;

    /**
     *
     * @param startX starting x cord value
     * @param startY starting x cord value
     */
    public paddleOPP(int startX, int startY)
    {
        x = startX;
        y = startY;
        rectangle1 = new Rectangle(x, y, paddleoppwidth, paddleoppheight );
        rectangle1.setFill(Color.AQUA);
    }

    /**
     *
     * @return paddle
     */
    public Rectangle getRectangle()
    {
        return rectangle1;
    }

}
