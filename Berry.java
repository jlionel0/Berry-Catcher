import java.awt.*;

public class Berry {
    private int y;
    private final int x;
    private final int size = 20;
    private final boolean special; // indicates if the berry is special (purple)

    public Berry(int x, int y, boolean special) {
        this.x = x;
        this.y = y;
        this.special = special;
    }

    public boolean isSpecial() { return special; }

    public void fall() {
        y += 5; // gravity; the berry falls down the screen
    }

    public void draw(Graphics g) { // draw berry
        g.setColor(special ? Color.MAGENTA : Color.RED); // special berries are purple, regular berries stay red
        g.fillOval(x, y, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public int getY() {
        return y;
    }
}
