import java.awt.*;

public class Berry {
    private int x, y, size = 20;

    public Berry(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fall() {
        y += 5; // gravity; the berry falls down the screen
    }

    public void draw(Graphics g) { // draw berry
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public int getY() {
        return y;
    }
}
