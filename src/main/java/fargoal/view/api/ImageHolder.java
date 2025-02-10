package fargoal.view.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHolder {
    
    private static BufferedImage playerImage;
    private static BufferedImage wallImage;
    private static BufferedImage upStairsImage;
    private static BufferedImage tileImage;
    private static BufferedImage templeImage;

    static {
        try {
            playerImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Player.png" + File.separator));
            wallImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "Wall.png" + File.separator));
            upStairsImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "UpStairs.png" + File.separator));
            tileImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "Tile.png" + File.separator));
            templeImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "tiles" + File.separator
                + "Temple.png" + File.separator));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static BufferedImage player() {
        return playerImage;
    }

    public static BufferedImage wall() {
        return wallImage;
    }

    public static BufferedImage tile() {
        return tileImage;
    }

    public static BufferedImage temple() {
        return templeImage;
    }

    public static BufferedImage upStair() {
        return upStairsImage;
    }
}
