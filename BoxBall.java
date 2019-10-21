import java.awt.*;
import java.awt.geom.*;
/**
 * Ball bounces inside of box.
 *
 * @author Paul Neumaier
 * @version 2019.10.21
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private int ballMinus = 1;
    private Ellipse2D.Double circle;
    private int diameter;
    private Color color;
    private int xPos;
    private int yPos;
    private final Rectangle box;
    private Canvas canvas;
    private int xSpeed;
    private int ySpeed;
    

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xSpeed, int xPosition, int ySpeed, int yPosition, 
        int ballDiam, Color ballColor, Rectangle rect, Canvas drawingCanvas)
    {
        xPos = xPosition;
        yPos = yPosition;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        diameter = ballDiam;
        canvas = drawingCanvas;
        color = ballColor;
        box = rect;
    }
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPos,yPos,diameter);
    }
    public void erase()
    {
        canvas.eraseCircle(xPos,yPos,diameter);
    }
    public void move()
    {
        erase();
        
        xPos += xSpeed;
        yPos += ySpeed;
        
        if(yPos >= (box.getMaxY() - diameter) && ySpeed > 0)
        {
           yPos = (int)(box.getMaxY() - diameter);
            ySpeed = -ySpeed + ballMinus; 
            if(ySpeed > 0) {
                ySpeed = 0;
            }
        }
        else if(yPos <= (box.getMinY()) && ySpeed < 0) {
            yPos = (int)(box.getMinY()) + 1;
            ySpeed = -ySpeed - ballMinus; 
            if(ySpeed < 0) 
            {
                ySpeed = 0;
            }
        }
        if(xPos >= (box.getMaxX() - diameter) && xSpeed > 0) {
            xPos = (int)(box.getMaxX() - diameter);
            xSpeed = -xSpeed + ballMinus; 
            if(xSpeed > 0)
            {
                xSpeed = 0;
            }
        }
        else if(xPos <= (box.getMinX()) && xSpeed < 0) {
            xPos = (int)(box.getMinX()) + 1;
            xSpeed = -xSpeed - ballMinus;
            if(xSpeed < 0) {
                xSpeed = 0;
            }
        }


        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPos;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPos;
    }

    /**
     * return true if the ball is still moving
     */
    public boolean isMoving() {
        return (xSpeed != 0  || ySpeed != 0);
    }

} 
        
    

