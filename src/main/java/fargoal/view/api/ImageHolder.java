package fargoal.view.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class that has the objective to memorize in a static way
 * images, to not have to read them at every frame.
 */
public final class ImageHolder {
    private static BufferedImage playerImage;
    private static BufferedImage chestImage;
    private static BufferedImage downstairsImage;
    private static BufferedImage hiddenGoldImage;
    private static BufferedImage sackOfGoldImage;
    private static BufferedImage swordImage;
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

    private static final String ENTITY_FOLDER = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "entity" + File.separator;
    private static final String TILES_FOLDER =  "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "tiles" + File.separator;

    private ImageHolder() { }

    static {
        try {
            playerImage = ImageIO.read(new File(ENTITY_FOLDER + "Player.png" + File.separator));
            chestImage = ImageIO.read(new File(TILES_FOLDER + "Chest.png" + File.separator));
            downstairsImage = ImageIO.read(new File(TILES_FOLDER + "DownStairs.png" + File.separator));
            hiddenGoldImage = ImageIO.read(new File(TILES_FOLDER + "HiddenGold.png" + File.separator));
            sackOfGoldImage = ImageIO.read(new File(TILES_FOLDER + "SackOfGold.png" + File.separator));
            swordImage = ImageIO.read(new File(TILES_FOLDER + "Sword.png" + File.separator));
            assassinImage = ImageIO.read(new File(ENTITY_FOLDER + "Assassin.png" + File.separator));
            barbarianImage = ImageIO.read(new File(ENTITY_FOLDER + "Barbarian.png" + File.separator));
            mageImage = ImageIO.read(new File(ENTITY_FOLDER + "Mage.png" + File.separator));
            monkImage = ImageIO.read(new File(ENTITY_FOLDER + "Monk.png" + File.separator));
            rogueImage = ImageIO.read(new File(ENTITY_FOLDER + "Rogue.png" + File.separator));
            spiderImage = ImageIO.read(new File(ENTITY_FOLDER + "Spider.png" + File.separator));
            warLordImage = ImageIO.read(new File(ENTITY_FOLDER + "WarLord.png" + File.separator));
            wallImage = ImageIO.read(new File(TILES_FOLDER + "Wall.png" + File.separator));
            upStairsImage = ImageIO.read(new File(TILES_FOLDER + "UpStairs.png" + File.separator));
            tileImage = ImageIO.read(new File(TILES_FOLDER + "Tile.png" + File.separator));
            templeImage = ImageIO.read(new File(TILES_FOLDER + "Temple.png" + File.separator));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that returns the image for the player.
     * 
     * @return - the image of the player
     */
    public static BufferedImage player() {
        return playerImage;
    }

    /**
     * Method that returns the image for the chest.
     * 
     * @return - the image of the chest
     */
    public static BufferedImage chest() {
        return chestImage;
    }

    /**
     * Method that returns the image for the downstairs.
     * 
     * @return - the image of the downstairs
     */
    public static BufferedImage downstairs() {
        return downstairsImage;
    }

    /**
     * Method that returns the image for the hiddengold.
     * 
     * @return - the image of the hiddengold
     */
    public static BufferedImage hiddenGold() {
        return hiddenGoldImage;
    }

    /**
     * Method that returns the image for the sack of gold.
     * 
     * @return - the image of the sack of gold
     */
    public static BufferedImage sackOfGold() {
        return sackOfGoldImage;
    }

    /**
     * Method that returns the image for the sword.
     * 
     * @return - the image of the sword
     */
    public static BufferedImage sword() {
        return swordImage;
    }

    /**
     * Method that returns the image for the assassin.
     * 
     * @return - the image of the assassin
     */
    public static BufferedImage assassin() {
        return assassinImage;
    }

    /**
     * Method that returns the image for the barbarian.
     * 
     * @return - the image of the barbarian
     */
    public static BufferedImage barbarian() {
        return barbarianImage;
    }

    /**
     * Method that returns the image for the mage.
     * 
     * @return - the image of the mage
     */
    public static BufferedImage mage() {
        return mageImage;
    }

    /**
     * Method that returns the image for the monk.
     * 
     * @return - the image of the monk
     */
    public static BufferedImage monk() {
        return monkImage;
    }

    /**
     * Method that returns the image for the rogue.
     * 
     * @return - the image of the rogue
     */
    public static BufferedImage rogue() {
        return rogueImage;
    }

    /**
     * Method that returns the image for the spider.
     * 
     * @return - the image of the spider
     */
    public static BufferedImage spider() {
        return spiderImage;
    }

    /**
     * Method that returns the image for the war lord.
     * 
     * @return - the image of the war lord
     */
    public static BufferedImage warlord() {
        return warLordImage;
    }

    /**
     * Method that returns the image for the wall.
     * 
     * @return - the image of the wall
     */
    public static BufferedImage wall() {
        return wallImage;
    }

    /**
     * Method that returns the image for the tile.
     * 
     * @return - the image of the tile
     */
    public static BufferedImage tile() {
        return tileImage;
    }

    /**
     * Method that returns the image for the temple.
     * 
     * @return - the image of the temple
     */
    public static BufferedImage temple() {
        return templeImage;
    }

    /**
     * Method that returns the image for the upstairs.
     * 
     * @return - the image of the upstairs
     */
    public static BufferedImage upStair() {
        return upStairsImage;
    }
}
