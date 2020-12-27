package org.kodluyoruz.Concrete;

public class SosGame implements org.kodluyoruz.Abstract.SosGame {
    //Arrays
    private String[][] sosGameMatrix;
    //String values
    private String playerEnterCharacter;
    private String computerEnterCharacter;
    //int values
    private int dimension;
    private int playerIndexX;
    private int playerIndexY;
    private int computerIndexX;
    private int computerIndexY;
    private int numberOfMatrixElements;
    private int sosCount = 0;
    private int score;
    private int playerScore;
    private int computerScore;
    //boolean values
    private boolean playerOrder;
    private boolean computerOrder;
    private boolean indexState;
    @Override
    public int setDimension() {
        return 0;
    }

    @Override
    public void sosGameMatrixDimension() {

    }

    @Override
    public void sosGameBoard() {

    }

    @Override
    public void decideToTheStartGame() {

    }

    @Override
    public void decideToTheCharacter() {

    }

    @Override
    public void playerEnterIndexValues() {

    }

    @Override
    public void computerEnterIndexValues() {

    }

    @Override
    public void scoreBoard() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void characterEnterToThePanel(int indexX, int indexY, String character, boolean order) {

    }

    @Override
    public int characterScontrol(int indexX, int indexY, boolean order) {
        return 0;
    }

    @Override
    public int characterOcontrol(int indexX, int indexY, boolean order) {
        return 0;
    }

    @Override
    public void whoIsTheGameWin() {

    }
}
