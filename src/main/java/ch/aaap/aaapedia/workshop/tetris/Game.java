package ch.aaap.aaapedia.workshop.tetris;

public class Game {

    public State state = State.INITIALIZED;

    public static void main(String[] args) {
        var matrix = new Matrix();

        matrix.newGame();

        matrix.stepGame(Action.DOWN);

        matrix.stepGame(Action.DOWN);

        matrix.stepGame(Action.DOWN);

        matrix.stepGame(Action.DOWN);

        matrix.paint();
    }
}
