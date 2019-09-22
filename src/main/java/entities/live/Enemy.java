package entities.live;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import application.Animation;
import application.Application;

public class Enemy extends Creature {
    
    private Animation animDown, animUp, animLeft, animRight;

    public Enemy(float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height = 19;
        animDown = new Animation(500, Application.getInstance().getAssets().getAnimatedAssets().get("enemyDown").toArray(new BufferedImage[0]));
        animUp = new Animation(500, Application.getInstance().getAssets().getAnimatedAssets().get("enemyUp").toArray(new BufferedImage[0]));
        animLeft = new Animation(500, Application.getInstance().getAssets().getAnimatedAssets().get("enemyLeft").toArray(new BufferedImage[0]));
        animRight = new Animation(500, Application.getInstance().getAssets().getAnimatedAssets().get("enemyRight").toArray(new BufferedImage[0]));
    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        followPlayer();
        move();
    }
    
    private void followPlayer() {
        float playerXPosition = Application.getInstance().getPlayer().getX();
        float playerYPosition = Application.getInstance().getPlayer().getY();
        
        if (playerXPosition == this.getX()) {
            xMove = 0;
        } else if (playerXPosition < this.getX()) {
            xMove = -speed;
        } else {
            xMove = speed;
        }
        
        if (playerYPosition == this.getY()) {
            yMove = 0;
        } else if (playerYPosition < this.getY()) {
            yMove = -speed;
        } else {
            yMove = speed;
        }
        
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - Application.getInstance().getCamera().getxOffset()), (int) (y - Application.getInstance().getCamera().getyOffset()), width, height, null);
        
    }

    @Override
    public void die() {
        // TODO Auto-generated method stub
        
    }
    
    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else {
            return animDown.getCurrentFrame();
        }
    }

}
