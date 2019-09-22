package application;

public class Launcher {

    /**
     * The Launcher class is the main game starter
     */
    public static void main(String[] args) {
        // Enable opengl acceleration
        System.setProperty("sun.java2d.opengl", "true");

        // Initilize Singleton
        Application.getInstance().init();

        // Create and start game
        Game game = new Game(60);
        game.start();
    }

}
