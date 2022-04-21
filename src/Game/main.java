package Game;

public class main {

    public static void main(String[] args) throws InterruptedException {
        GameView view = new GameView();
        view.setup();
        view.explainRules();
        view.play();
    }

}
