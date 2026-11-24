import java.awt.*;
import java.awt.image.BufferedImage;

public class Berry {
    private int y;
    private final int x;
    private final int size = 32;
    private final boolean special; // indicates if the berry is special (purple)

    private static final BufferedImage RED_IMG = Assets.load("/assets/apple.png");
    private static final BufferedImage PURPLE_IMG = Assets.load("/assets/blueberry.png");

    public Berry(int x, int y, boolean special) {
        this.x = x;
        this.y = y;
        this.special = special;
    }

    public boolean isSpecial() { return special; }

    public void fall() {
        y += 5; // gravity; the berry falls down the screen
    }

    public void draw(Graphics g) {
        BufferedImage img = special ? PURPLE_IMG : RED_IMG;
        if(img != null) {
            g.drawImage(img, x, y, size, size, null);
        } else {
            g.setColor(special ? Color.MAGENTA : Color.RED);
            g.fillOval(x, y, size, size);
        }
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public int getY() {
        return y;
    }
}
