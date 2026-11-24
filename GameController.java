import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController extends KeyAdapter {
    private final GamePanel gamePanel;
    private static boolean leftPressed = false;
    private static boolean rightPressed = false;
    private static boolean shiftPressed = false;

    public GameController(GamePanel game) {
        this.gamePanel = game;
    }

    @Override 
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shiftPressed = true;
        }
    }

    @Override 
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        }
    }

    public static boolean isLeftPressed() { return leftPressed; }
    public static boolean isRightPressed() { return rightPressed; }
    public static boolean isShiftPressed() { return shiftPressed; }
}
