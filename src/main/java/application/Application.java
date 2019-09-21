package application;

import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Rock;
import entities.statics.Tree;

public class Application {

    private Display display;
    private Player player;
    private EntityManager entityManager;
    private World world;
    private Camera camera;
    private KeyManager keyManager;
    private Assets assets;
    private static final Application instance = new Application();

    private Application() {

    }
    
    public void init() {
        loadAssets();
        this.display = new Display("ConversWorld", 1024, 768);
        this.player = new Player(100, 100);
        this.entityManager = new EntityManager(player);
        entityManager.addEntity(new Tree(132, 250));
        entityManager.addEntity(new Rock(132, 450));
        entityManager.addEntity(new Rock(350, 300));
        entityManager.addEntity(new Rock(400, 345));
        entityManager.addEntity(new Tree(625, 325));
        this.world = new World("res/worlds/world2.txt");
        this.camera = new Camera(0, 0);
        this.keyManager = new KeyManager();
        this.display.getFrame().addKeyListener(keyManager);
    }

    private void loadAssets() {
        this.assets = new Assets();
        assets.addSheet("main", "/textures/sheet.png", 32, 32);
        assets.addStaticAsset("wood", "main", 1, 1, 1, 1);
        assets.addStaticAsset("dirt", "main", 1, 0, 1, 1);
        assets.addStaticAsset("grass", "main", 2, 0, 1, 1);
        assets.addStaticAsset("stone", "main", 3, 0, 1, 1);
        assets.addStaticAsset("tree", "main", 0, 0, 1, 2);
        assets.addStaticAsset("rock", "main", 0, 2, 1, 1);
        assets.addAnimatedAsset("playerUp", "main", 6, 0, 1, 1);
        assets.addAnimatedAsset("playerUp", "main", 7, 0, 1, 1);
        assets.addAnimatedAsset("playerDown", "main", 4, 0, 1, 1);
        assets.addAnimatedAsset("playerDown", "main", 5, 0, 1, 1);
        assets.addAnimatedAsset("playerLeft", "main", 6, 1, 1, 1);
        assets.addAnimatedAsset("playerLeft", "main", 7, 1, 1, 1);
        assets.addAnimatedAsset("playerRight", "main", 4, 1, 1, 1);
        assets.addAnimatedAsset("playerRight", "main", 5, 1, 1, 1);
    }

    public static Application getInstance() {
        return instance;
    }

    public Display getDisplay() {
        return display;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public Camera getCamera() {
        return camera;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Assets getAssets() {
        return assets;
    }

}