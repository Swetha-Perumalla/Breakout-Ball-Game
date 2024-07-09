import java.awt.*;

public class Paddle {
    private int x, y;
    private final int width = 100;
    private final int height = 20;
    private final int speed = 15;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveRight() {
        x += speed;
        if (x > 800 - width) {
            x = 800 - width;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}