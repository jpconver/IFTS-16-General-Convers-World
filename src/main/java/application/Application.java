package application;

import entities.live.Enemy;
import entities.live.Player;
import entities.terrain.Rock;
import entities.terrain.Tree;
import tiles.DirtTile;
import tiles.GrassTile;
import tiles.RockTile;
import tiles.Tiles;

/**
 * Application Singleton class
 *
 * @author jpconver
 *
 */
public class Application {

    private Display display;
    private Player player;
    private EntityManager entityManager;
    private World world;
    private Camera camera;
    private KeyManager keyManager;
    private Assets assets;
    private Tiles tiles;
    private static final Application instance = new Application();

    private Application() {

    }

    public void init() {
        loadAssets();
        loadTiles();
        this.display = new Display("ConversWorld", 800, 600);
        this.player = new Player(100, 100);
        this.entityManager = new EntityManager(player);
        this.world = new World("res/worlds/world1.txt");
        this.camera = new Camera(0, 0);
        this.keyManager = new KeyManager();
        this.display.getFrame().addKeyListener(keyManager);
        addStaticObjects();
        addEnemies();
    }

    private void addStaticObjects() {
        entityManager.addEntity(new Tree(132, 250));
        entityManager.addEntity(new Rock(132, 450));
        entityManager.addEntity(new Rock(350, 300));
        entityManager.addEntity(new Rock(400, 345));
        entityManager.addEntity(new Tree(625, 325));
    }

    private void addEnemies() {
        Enemy enemy1 = new Enemy(150, 150);
        enemy1.setSpeed(0.5f);
        Enemy enemy2 = new Enemy(400, 400);
        enemy2.setSpeed(0.8f);
        entityManager.addEntity(enemy1);
        entityManager.addEntity(enemy2);
    }

    private void loadAssets() {
        this.assets = new Assets();
        assets.addSheet("main", "/textures/sheet.png", 32, 32);
        assets.defineStaticAsset("wood", "main", 1, 1, 1, 1);
        assets.defineStaticAsset("dirt", "main", 1, 0, 1, 1);
        assets.defineStaticAsset("grass", "main", 2, 0, 1, 1);
        assets.defineStaticAsset("stone", "main", 3, 0, 1, 1);
        assets.defineStaticAsset("tree", "main", 0, 0, 1, 2);
        assets.defineStaticAsset("rock", "main", 0, 2, 1, 1);
        assets.defineAnimatedAsset("playerUp", "main", 6, 0, 1, 1);
        assets.defineAnimatedAsset("playerUp", "main", 7, 0, 1, 1);
        assets.defineAnimatedAsset("playerDown", "main", 4, 0, 1, 1);
        assets.defineAnimatedAsset("playerDown", "main", 5, 0, 1, 1);
        assets.defineAnimatedAsset("playerLeft", "main", 6, 1, 1, 1);
        assets.defineAnimatedAsset("playerLeft", "main", 7, 1, 1, 1);
        assets.defineAnimatedAsset("playerRight", "main", 4, 1, 1, 1);
        assets.defineAnimatedAsset("playerRight", "main", 5, 1, 1, 1);
        assets.defineAnimatedAsset("enemyUp", "main", 6, 2, 1, 2);
        assets.defineAnimatedAsset("enemyUp", "main", 7, 2, 1, 3);
        assets.defineAnimatedAsset("enemyDown", "main", 4, 2, 1, 3);
        assets.defineAnimatedAsset("enemyDown", "main", 5, 2, 1, 3);
        assets.defineAnimatedAsset("enemyLeft", "main", 6, 3, 1, 3);
        assets.defineAnimatedAsset("enemyLeft", "main", 7, 3, 1, 3);
        assets.defineAnimatedAsset("enemyRight", "main", 4, 3, 1, 3);
        assets.defineAnimatedAsset("enemyRight", "main", 5, 3, 1, 3);
    }

    private void loadTiles() {
        this.tiles = new Tiles();
        this.tiles.addTile(new GrassTile(0));
        this.tiles.addTile(new DirtTile(1));
        this.tiles.addTile(new RockTile(2));
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

    public Tiles getTiles() {
        return tiles;
    }

}