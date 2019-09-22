package application;

import java.awt.image.BufferedImage;

/**
 * The SpriteSheet class holds a BufferedImage of a sprite sheet and has utility methods to get sprites from it
 * @author jpconver
 *
 */
public class SpriteSheet {

    private BufferedImage sheet;
    private int spriteWidth;
    private int spriteHeight;

    public SpriteSheet(BufferedImage sheet, int spriteWidth, int spriteHeight) {
        this.sheet = sheet;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
    }

    public BufferedImage getSprite(int xStart, int yStart, int xEnd, int yEnd) {
        return sheet.getSubimage(xStart * spriteWidth, yStart * spriteHeight, xEnd * spriteWidth, xEnd * spriteHeight);
    }

}
