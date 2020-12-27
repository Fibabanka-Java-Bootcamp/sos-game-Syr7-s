package org.kodluyoruz.Abstract;

public interface SosGame {
    String LETTER_S = "S";
    String LETTER_O = "O";

    int setDimension();

    void sosGameMatrixDimension();

    void sosGameBoard();

    void decideToTheStartGame();

    void decideToTheCharacter();

    void playerEnterIndexValues();

    void computerEnterIndexValues();

    void scoreBoard();

    void startGame();

    void characterEnterToThePanel(int indexX, int indexY, String character, boolean order);

    int characterScontrol(int indexX, int indexY, boolean order);

    int characterOcontrol(int indexX, int indexY, boolean order);

    void whoIsTheGameWin();
}
