import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    private final Timer timer;
    private final Player player;
    private final ArrayList<Berry> berries;
    private int score = 0;

    private static final int GAME_LENGTH = 30_000; // 30 seconds
    private final long startTime;
    private int timeLeft = 30; // for display purposes
    private boolean gameOver = false;

    private final BufferedImage background = Assets.load("/assets/gamebackground.png");

    public GamePanel() {
        setPreferredSize(new Dimension(500, 550));
        player = new Player(200, 470);
        berries = new ArrayList<>();
        startTime = System.currentTimeMillis();
        timer = new Timer(16, this); // 16ms or ~60 fps
        timer.start();
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        if(background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        }
        player.draw(g);

        for(Berry berry : berries) { // draws multiple berries
            berry.draw(g);
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Time left: " + timeLeft + "s", getWidth() - 100, 20);

        if(gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over! Final Score: " + score, getWidth() / 2 - 70, getHeight() / 2);
        }
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        timeLeft = (int)((GAME_LENGTH - elapsedTime) / 1000);

        if(elapsedTime >= GAME_LENGTH) { // stop game after 30 seconds
            gameOver = true;
            timer.stop();
            repaint();
            return;
        }

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
    
