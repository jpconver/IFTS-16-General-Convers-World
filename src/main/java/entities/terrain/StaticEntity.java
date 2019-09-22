package entities.terrain;

import entities.Entity;

/**
 * The Static entity represents entities that cannot move
 *
 * @author jpconver
 *
 */
public abstract class StaticEntity extends Entity {

    public StaticEntity(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

}
