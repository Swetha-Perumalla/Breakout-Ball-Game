//import java.awt.*;
import java.util.List;

public class CollisionDetector {

    public void checkCollisions(Ball ball, Paddle paddle, List<Brick> bricks) {
        // Check collision with paddle
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.bounceOffPaddle(paddle);
        }

        // Check collision with bricks
        for (Brick brick : bricks) {
            if (ball.getBounds().intersects(brick.getBounds())) {
                ball.bounceOffBrick(brick);
                bricks.remove(brick);
                break;
            }
        }

        // Check collision with walls
        if (ball.getX() <= 0 || ball.getX() >= 800 - ball.getWidth()) {
            ball.reverseXDirection();
        }
        if (ball.getY() <= 0) {
            ball.reverseYDirection();
        }
    }
}