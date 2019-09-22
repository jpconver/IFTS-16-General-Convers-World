package application;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Utils;

/**
 * The Assets class provides BufferedImage sprites of a sprite sheet
 *
 * @author jpconver
 *
 */
public class Assets {

    private Map<String, SpriteSheet> sheets;
    private Map<String, List<BufferedImage>> animatedAssets;
    private Map<String, BufferedImage> staticAssets;

    public Assets() {
        this.sheets = new HashMap<String, SpriteSheet>();
        this.animatedAssets = new HashMap<String, List<BufferedImage>>();
        this.staticAssets = new HashMap<String, BufferedImage>();
    }

    public void addSheet(String key, String filePath, int spriteWidth, int spriteHeight) {
        this.sheets.put(key, new SpriteSheet(Utils.loadImage(filePath), spriteWidth, spriteHeight));
    }

    public void defineStaticAsset(String key, String sheetKey, int xStart, int yStart, int xEnd, int yEnd) {
        this.staticAssets.put(key, sheets.get(sheetKey).getSprite(xStart, yStart, xEnd, yEnd));
    }

    public void defineAnimatedAsset(String key, String sheetKey, int xStart, int yStart, int xEnd, int yEnd) {
        if (!animatedAssets.containsKey(key)) {
            this.animatedAssets.put(key, new ArrayList<BufferedImage>());
        }
        this.animatedAssets.get(key).add(sheets.get(sheetKey).getSprite(xStart, yStart, xEnd, yEnd));
    }

    public Map<String, List<BufferedImage>> getAnimatedAssets() {
        return animatedAssets;
    }

    public Map<String, BufferedImage> getStaticAssets() {
        return staticAssets;
    }

}
