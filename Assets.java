import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Assets {
    public static BufferedImage load(String path) {
        URL url = Assets.class.getResource(path);
        if(url == null) {
            System.err.println("Could not find image: " + path);
            return null;
        }
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            System.err.println("Could not read image: " + path);
            return null;
        }
    }
}
