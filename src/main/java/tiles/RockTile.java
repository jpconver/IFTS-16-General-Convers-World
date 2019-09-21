package tiles;

import application.Application;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(Application.getInstance().getAssets().getStaticAssets().get("stone"), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
