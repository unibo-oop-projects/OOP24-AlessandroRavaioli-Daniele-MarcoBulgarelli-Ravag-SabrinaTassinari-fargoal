package fargoal.view.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHolder {
    
    private static BufferedImage playerImage;

    static {
        try {
            playerImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Player.png" + File.separator));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static BufferedImage player() {
        return playerImage;
    }
}
