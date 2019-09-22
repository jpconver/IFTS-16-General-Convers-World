package application;

public class Launcher {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        Application.getInstance().init();
        Game game = new Game();
        game.start();
    }

}
