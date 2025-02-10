package fargoal.view.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHolder {
    
    private static BufferedImage playerImage;
    private static BufferedImage chestImage;
    private static BufferedImage downstairsImage;
    private static BufferedImage hiddenGoldImage;
    private static BufferedImage sackOfGoldImage;
    private static BufferedImage swordImage;

    static {
        try {
            playerImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Player.png" + File.separator));
            chestImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "Chest.png" + File.separator));
            downstairsImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "DownStairs.png" + File.separator));
            hiddenGoldImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "HiddenGold.png" + File.separator));
            sackOfGoldImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "SackOfGold.png" + File.separator));
            swordImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "Sword.png" + File.separator));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static BufferedImage player() {
        return playerImage;
    }

    public static BufferedImage chest() {
        return chestImage;
    }

    public static BufferedImage downstairs() {
        return downstairsImage;
    }

    public static BufferedImage hiddenGold() {
        return hiddenGoldImage;
    }

    public static BufferedImage sackOfGold() {
        return sackOfGoldImage;
    }

    public static BufferedImage sword() {
        return swordImage;
    }
}
