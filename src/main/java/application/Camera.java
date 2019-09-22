package application;

import entities.Entity;
import tiles.Tile;

public class Camera {

    private float xOffset, yOffset;

    public Camera(float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > Application.getInstance().getWorld().getWidth() * Tile.TILEWIDTH - getGameWidth()) {
            xOffset = Application.getInstance().getWorld().getWidth() * Tile.TILEWIDTH - getGameWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > Application.getInstance().getWorld().getHeight() * Tile.TILEHEIGHT - getHameHeight()) {
            yOffset = Application.getInstance().getWorld().getHeight() * Tile.TILEHEIGHT - getHameHeight();
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - getGameWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - getHameHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    private int getGameWidth() {
        return Application.getInstance().getDisplay().getWidth();
    }

    private int getHameHeight() {
        return Application.getInstance().getDisplay().getHeight();
    }

}
