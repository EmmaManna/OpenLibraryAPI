package ehu.isad.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public static Properties lortuEzarpenak()  {
        Properties properties = null;

        try (InputStream in = Utils.class.getResourceAsStream("/setup.properties")) {
            properties = new Properties();
            properties.load(in);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public Image lortuIrudia(String irudia){
        InputStream is = getClass().getResourceAsStream("/images/"+irudia+".png");
        BufferedImage reader = null;
        try {
            reader = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = SwingFXUtils.toFXImage(reader,null);
        return image;
    }
}
