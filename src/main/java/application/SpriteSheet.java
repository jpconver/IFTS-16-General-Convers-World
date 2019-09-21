package application;

import java.awt.image.BufferedImage;

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
