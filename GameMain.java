import javax.swing.*;

public class GameMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Berry Catcher");
        GamePanel game = new GamePanel();
        GameController controller = new GameController(game);
        
        frame.addKeyListener(controller);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
