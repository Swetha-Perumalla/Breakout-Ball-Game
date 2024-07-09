import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreakoutGame extends JPanel implements Runnable, KeyListener {

    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;
    private int score;
    private int lives;
    private boolean running;

    private Thread gameThread;

    public BreakoutGame() {
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        addKeyListener(this);

        initialize();
    }

    public void initialize() {
        ball = new Ball(400, 300);
        paddle = new Paddle(375, 550);
        bricks = new ArrayList<>();

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                bricks.add(new Brick(80 * col + 35, 50 * row + 50));
            }
        }

        score = 0;
        lives = 3;
        running = true;

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final int FPS = 60;
        final long targetTime = 1000 / FPS;

        while (running) {
            long startTime = System.nanoTime();

            update();
            repaint();

            long elapsed = System.nanoTime() - startTime;
            long waitTime = targetTime - elapsed / 1000000;

            if (waitTime > 0) {
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update() {
        ball.move();
        checkCollisions();

        if (ball.isOutOfBounds()) {
            lives--;
            if (lives <= 0) {
                running = false;
            } else {
                resetBallAndPaddle();
            }
        }
    }

    public void checkCollisions() {
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.bounceOffPaddle(paddle);
        }

        Iterator<Brick> iterator = bricks.iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            if (ball.getBounds().intersects(brick.getBounds())) {
                ball.bounceOffBrick(brick);
                iterator.remove();
                score += 10;
            }
        }

        if (ball.getX() <= 0 || ball.getX() >= getWidth() - ball.getWidth()) {
            ball.reverseXDirection();
        }
        if (ball.getY() <= 0) {
            ball.reverseYDirection();
        }
    }

    public void resetBallAndPaddle() {
        ball.setPosition(395, 530);
        paddle.setPosition(375, 550);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.draw(g);
        paddle.draw(g);
        for (Brick brick : bricks) {
            brick.draw(g);
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 30, 30);
        g.drawString("Lives: " + lives, getWidth() - 60, 30);

        if (!running) {
            g.drawString("Game Over", 350, 300);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Ball Game");
        BreakoutGame game = new BreakoutGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}