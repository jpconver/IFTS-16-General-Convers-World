package application;

public class Launcher {

    public static void main(String[] args) {
        Application.getInstance().init();
        Game game = new Game();
        game.start();
    }

}
