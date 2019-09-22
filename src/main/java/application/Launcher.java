package application;

public class Launcher {

    /**
     * The Launcher class is the main game starter
     */
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        Application.getInstance().init();
        Game game = new Game();
        // Create and start game
        Game game = new Game(60);
        game.start();
    }

}
