import java.awt.*;

public class Ball {
    private int x, y;// Ball's current position
    private int vx, vy;// Ball's velocity in the x and y directions
    private final int size = 20;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.vx = 2;
        this.vy = 2;
    }

    public void move() {
        x += vx;
        y += vy;
    }

    public void bounceOffPaddle(Paddle paddle) {
        vy = -vy;
    }

    public void bounceOffBrick(Brick brick) {
        vy = -vy;
    }

    public void reverseXDirection() {
        vx = -vx;
    }

    public void reverseYDirection() {
        vy = -vy;
    }

    public boolean isOutOfBounds() {
        //it returns true; otherwise, it returns false.
        return y > 600;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, size, size);
    }

    public Rectangle getBounds() {
        //returns a Rectangle that represents the bounding box of the ball. 
        //This is useful for collision detection.
        return new Rectangle(x, y, size, size);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return size;
    }

    public int getHeight() {
        return size;
    }
}