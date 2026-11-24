import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    private final Timer timer;
    private final Player player;
    private final ArrayList<Berry> berries;
    private int score = 0;

    public GamePanel() {
        player = new Player(200, 450);
        berries = new ArrayList<>();
        timer = new Timer(16, this); // 16ms or ~60 fps
        timer.start();
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);

        for(Berry berry : berries) { // draws multiple berries
            berry.draw(g);
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(Math.random() < 0.05) {
            berries.add(new Berry((int)(Math.random() * getWidth()), 0, false)); // 5% chance for berry spawn each frame
        }
        if(Math.random() < 0.01) {
            berries.add(new Berry((int)(Math.random() * getWidth()), 0, true)); // 1% chance for a special berry spawn each frame
        }

        for(int i = 0; i < berries.size(); i++) {
            Berry berry = berries.get(i);
            berry.fall();

            if(berry.getBounds().intersects(player.getBounds())) { // collision check
                score += berry.isSpecial() ? 10 : 1; // special berries give 10 points
                berries.remove(i);
                i--;
            } else if(berry.getY() > getHeight()) {
                berries.remove(i); // remove missed berry and decrease score
                if(score != 0) {
                    score--;
                }
            }
        }

        player.setDashing(GameController.isShiftPressed()); 
        if(GameController.isLeftPressed()) { player.moveLeft(); }
        if(GameController.isRightPressed()) { player.moveRight(); }
        

        repaint();
    }

    public Player getPlayer() { return player; }
} 
    
