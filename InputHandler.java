import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {

    private boolean leftPressed = false;
    private boolean rightPressed = false;

    @Override
    public void keyPressed(KeyEvent e)
    //This method is called when a key is pressed. 
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            /*If the key pressed is the left arrow key (VK_LEFT), 
            set leftPressed to true.*/
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            /*If the key pressed is the right arrow key (VK_RIGHT), 
            set rightPressed to true. */
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) //This method is called when a key is released.
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            /* If the key released is the left arrow key (VK_LEFT), 
            set leftPressed to false. */
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            /* If the key released is the right arrow key (VK_RIGHT), 
            set rightPressed to false. */
            rightPressed = false;
        }
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}