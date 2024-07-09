import java.awt.*;

public class Brick {
    private int x, y;
    private final int width = 80;
    private final int height = 30;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}