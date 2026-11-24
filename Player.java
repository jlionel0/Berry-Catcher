import java.awt.*;

public class Player {
    private int x, y, width, height;
    private final int baseSpeed = 10;
    private int speed = baseSpeed;
    private boolean dashing = false;


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 20;
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
        g.setColor(dashing ? Color.GREEN : Color.BLUE); // change color when dashing
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
