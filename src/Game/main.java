package Game;

/**
 * main class that runs the entire program.
 *
 * @author Rzez, Marcelo, Uzair, Hannah April 2022
 */

public class main {

    public static void main(String[] args) throws InterruptedException {
        GameView view = new GameView();
        view.setup();
        view.explainRules();
        view.play();
    }

}
