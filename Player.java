import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private int x, y, width, height;
    private final int baseSpeed = 10;
    private int speed = baseSpeed;
    private boolean dashing = false;

    private static final BufferedImage IMG = Assets.load("/assets/bucket.png");
    private static final BufferedImage DASH_IMG = Assets.load("/assets/dashing.png");


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 48;
        this.height = 48;
    }

    public void moveLeft() {
        x = Math.max(0, Math.min(x, 500 - width));
        x -= speed;
    }

    public void moveRight() {
        x = Math.max(0, Math.min(x, 500 - width));
        x += speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void setDashing(boolean dashing) {
        this.dashing = dashing;
        speed = dashing ? baseSpeed * 2 : baseSpeed; // double speed when dashing (holding shift)
    }

    public void draw(Graphics g) { // draw player character
        BufferedImage img = dashing ? DASH_IMG : IMG;
        if(img != null) {
            g.drawImage(img, x, y, width, height, null);
        } else {
            g.setColor(dashing ? Color.GREEN : Color.BLUE); // green if dashing otherwise blue
            g.fillRect(x, y, width, height);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
