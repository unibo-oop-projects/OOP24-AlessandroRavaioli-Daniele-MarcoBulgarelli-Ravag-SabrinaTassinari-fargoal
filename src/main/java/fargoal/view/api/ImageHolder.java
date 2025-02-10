package fargoal.view.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHolder {
    
    private static BufferedImage playerImage;
    private static BufferedImage assassinImage;
    private static BufferedImage barbarianImage;
    private static BufferedImage mageImage;
    private static BufferedImage monkImage;
    private static BufferedImage rogueImage;
    private static BufferedImage spiderImage;
    private static BufferedImage warLordImage;
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
            assassinImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Assassin.png" + File.separator));
            barbarianImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Barbarian.png" + File.separator));
            mageImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Mage.png" + File.separator));
            monkImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Monk.png" + File.separator));
            rogueImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Rogue.png" + File.separator));
            spiderImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "Spider.png" + File.separator));
            warLordImage = ImageIO.read(new File("src" + File.separator 
                + "main" + File.separator
                + "resources" + File.separator
                + "entity" + File.separator
                + "WarLord.png" + File.separator));
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

    public static BufferedImage assassin() {
        return assassinImage;
    }

    public static BufferedImage barbarian() {
        return barbarianImage;
    }

    public static BufferedImage mage() {
        return mageImage;
    }

    public static BufferedImage monk() {
        return monkImage;
    }

    public static BufferedImage rogue() {
        return rogueImage;
    }

    public static BufferedImage spider() {
        return spiderImage;
    }

    public static BufferedImage warlord() {
        return warLordImage;
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
