package tiles;

import application.Application;

public class DirtTile extends Tile {

    public DirtTile(int id) {
        super(Application.getInstance().getAssets().getStaticAssets().get("dirt"), id);
    }

}
