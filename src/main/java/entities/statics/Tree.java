package entities.statics;

import java.awt.Graphics;

import application.Application;
import tiles.Tile;

public class Tree extends StaticEntity {

    public Tree(float x, float y) {
        super(x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Application.getInstance().getAssets().getStaticAssets().get("tree"), (int) (x - Application.getInstance().getCamera().getxOffset()), (int) (y - Application.getInstance().getCamera().getyOffset()), width, height, null);
    }

}
