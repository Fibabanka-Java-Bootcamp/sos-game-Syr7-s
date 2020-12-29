package org.kodluyoruz.abstrct;

public interface SosGame {
    String LETTER_S = "S";
    String LETTER_O = "O";

    int setDimension();

    void sosGameMatrixDimension(int dimension);

    void sosGameBoard();

    void decideToTheStartGame();

    void decideToTheCharacter();

    void playerEnterIndexValues();

    void computerEnterIndexValues();

    void scoreBoard();

    void startGame();

    void characterEnterToThePanel(int indexX, int indexY, String character);

    int characterScontrol(int indexX, int indexY);

    int characterOcontrol(int indexX, int indexY);

    void whoIsTheGameWin();
}
