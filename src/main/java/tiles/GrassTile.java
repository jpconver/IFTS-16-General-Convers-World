package tiles;

import application.Application;

public class GrassTile extends Tile {

    public GrassTile(int id) {
        super(Application.getInstance().getAssets().getStaticAssets().get("grass"), id);
    }

}
