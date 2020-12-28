package org.kodluyoruz.Concrete;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SosGame implements org.kodluyoruz.Abstract.SosGame {
    Random random = new Random();
    Scanner reader = new Scanner(System.in);
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
    private int sosCount;
    private int score;
    private int playerScore;
    private int computerScore;
    //boolean values
    private boolean playerOrder;
    private boolean computerOrder;
    private boolean indexState;

    /*
     * Getter and Setter methods
     * */
    public String[][] getSosGameMatrix() {
        return sosGameMatrix;
    }

    private void setSosGameMatrix(String[][] sosGameMatrix) {
        this.sosGameMatrix = sosGameMatrix;
    }

    public String getPlayerEnterCharacter() {
        return playerEnterCharacter;
    }

    private void setPlayerEnterCharacter(String playerEnterCharacter) {
        this.playerEnterCharacter = playerEnterCharacter;
    }

    public String getComputerEnterCharacter() {
        return computerEnterCharacter;
    }

    private void setComputerEnterCharacter(String computerEnterCharacter) {
        this.computerEnterCharacter = computerEnterCharacter;
    }

    public int getDimension() {
        return dimension;
    }

    private void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getPlayerIndexX() {
        return playerIndexX;
    }

    private void setPlayerIndexX(int playerIndexX) {
        this.playerIndexX = playerIndexX;
    }

    public int getPlayerIndexY() {
        return playerIndexY;
    }

    private void setPlayerIndexY(int playerIndexY) {
        this.playerIndexY = playerIndexY;
    }

    public int getComputerIndexX() {
        return computerIndexX;
    }

    private void setComputerIndexX(int computerIndexX) {
        this.computerIndexX = computerIndexX;
    }

    public int getComputerIndexY() {
        return computerIndexY;
    }

    private void setComputerIndexY(int computerIndexY) {
        this.computerIndexY = computerIndexY;
    }

    public int getNumberOfMatrixElements() {
        return numberOfMatrixElements;
    }

    private void setNumberOfMatrixElements(int numberOfMatrixElements) {
        this.numberOfMatrixElements = numberOfMatrixElements;
    }

    public int getSosCount() {
        return sosCount;
    }

    private void setSosCount(int sosCount) {
        this.sosCount = sosCount;
    }

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    private void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public boolean isPlayerOrder() {
        return playerOrder;
    }

    private void setPlayerOrder(boolean playerOrder) {
        this.playerOrder = playerOrder;
    }

    public boolean isComputerOrder() {
        return computerOrder;
    }

    private void setComputerOrder(boolean computerOrder) {
        this.computerOrder = computerOrder;
    }

    public boolean isIndexState() {
        return indexState;
    }

    private void setIndexState(boolean indexState) {
        this.indexState = indexState;
    }


    /*
     * Between 3 and 7 take value from console by user.
     * The number  is  checked between 3 and 7 values.
     * If Character or String values enter from console, The program ends.
     * */
    @Override
    public int setDimension() {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.print("Please,Enter number between 3 and 7 : ");
            try {
                dimension = reader.nextInt();
                System.out.println("--------------------------------------------");
                if (dimension < 3 || dimension > 7)
                    System.out.println("Please try again.");
                else
                    return dimension;
            } catch (InputMismatchException exception) {
                System.out.println("You must Number values.\nPlease, game start again.");
                return -1;
            } catch (RuntimeException exception) {
                System.out.println("Runtime exception was occurred.\n" + exception.getMessage());
                return -1;
            }
        }

    }
    /*
     * After setDimension method, Sos Game panel set dimension with dimension value.
     * And this step, it do  in the sosGameMatrixDimension method.
     * */

    @Override
    public void sosGameMatrixDimension(int dimension) {
        sosGameMatrix = new String[dimension][dimension];
    }

    /*
     * Sos Panel is drawn with the sosGameBoard method.
     * */
    @Override
    public void sosGameBoard() {
        System.out.println("--------------------------------------------");
        System.out.println("------------------SOS Panel-----------------");
        int i = 0;
        for (int j = 0; j < dimension; j++)
            System.out.print("   " + (j + 1) + "  ");
        System.out.println();
        for (String[] values : sosGameMatrix) {
            System.out.print(i + 1 + " ");
            for (String value : values) {
                System.out.print("| " + value + " | ");
            }
            i++;
            System.out.println();
        }
        System.out.println("--------------------------------------------");
    }

    /*
     * Who will start playing the  game?
     * The answer, in this method.
     * */
    @Override
    public void decideToTheStartGame() {
        boolean start = random.nextBoolean();
        if (start) {
            playerOrder = true;
            System.out.println("--------------------------------------------");
            System.out.println("Player start to the game.");
        } else {
            System.out.println("--------------------------------------------");
            computerOrder = true;
            System.out.println("Computer start to the game.");
        }
        System.out.println("--------------------------------------------");
    }

    /*
     * Which player which character will take.
     * The characters are given random to the players.
     * This processes is did in this method.
     * */
    @Override
    public void decideToTheCharacter() {
        boolean takeCharacter = random.nextBoolean();
        decideToTheCharacter(takeCharacter);
    }

    private void decideToTheCharacter(boolean takeCharacter) {
        if (takeCharacter) {
            playerEnterCharacter = LETTER_S;
            computerEnterCharacter = LETTER_O;
        } else {
            playerEnterCharacter = LETTER_O;
            computerEnterCharacter = LETTER_S;
        }
        System.out.println("--------------------------------------------");
        System.out.println("Player will start with " + playerEnterCharacter + "  letter to the game.\n" +
                "Computer will start with " + computerEnterCharacter + " letter to the game.");
        System.out.println("--------------------------------------------");
    }

    /*
     * IndexX and IndexY values are taken for player from playerEnterIndexValues method.
     * */
    @Override
    public void playerEnterIndexValues() throws InputMismatchException {
        while (true) {
            System.out.print("Enter indexX value (between 0 and " + (dimension - 1) + "): ");
            playerIndexX = reader.nextInt();
            System.out.print("Enter indexY value (between 0 and " + (dimension - 1) + "): ");
            playerIndexY = reader.nextInt();
            boolean result = enterIndexXandIndexYvalues(playerIndexX, playerIndexY);
            if (result) {
                return;
            }
        }
    }

    /*
     * IndexX and IndexY values are given random to the Computer.
     * */
    @Override
    public void computerEnterIndexValues() {
        computerIndexX = random.nextInt(dimension);
        computerIndexY = random.nextInt(dimension);

        System.out.println("Computer IndexX value: " + computerIndexX + "\nComputer IndexY value : " + computerIndexY);
    }

    /*
     * IndexX and IndexY values are checked.
     * I mean, Are the values between 3 and 7.
     * */
    private boolean enterIndexXandIndexYvalues(int indexX, int indexY) {
        if (indexX < 0 || indexX >= dimension) {
            if (indexY < 0 || indexY >= dimension) {
                System.out.println("Re-enter indexX and indexY values");
                return false;
            } else {
                System.out.println("Re-enter indexY values");
                return false;
            }
        } else {
            if (indexY < 0 || indexY >= dimension) {
                System.out.println("Re-enter indexX values");
                return false;
            } else {
                return true;
            }
        }
    }

    /*
     * Score Board is shown to the Players with the scoreBoard method.
     *  */
    @Override
    public void scoreBoard() {
        System.out.println("--------------------------------------------");
        System.out.println("*****************Score Board***************\n" +
                "*******************************************\n" +
                "*Players:" + "*****************" + "*Score***********\n" +
                "*******************************************\n" +
                "*" + "Player: \t" + "****************| " + playerScore + " |**********\n" +
                "*" + "Computer: \t" + "****************| " + computerScore + " |**********\n" +
                "*******************************************");
        System.out.println("--------------------------------------------");
    }

    /*
     * The game is started with startGame method.
     * If player press to the N letter, Game start method is run.
     * */
    @Override
    public void startGame() {
        numberOfMatrixElements = dimension * dimension;
        while (true) {
            System.out.print("Y letter (Yes) write for finish the game.If you want to continue to the game, you should write N letter.(No)\n" +
                    "if is not left null field on the game board, you should write C (Control) letter. : ");
            String decision = reader.next();
            System.out.println();
            switch (decision) {
                case "Y":
                    System.out.println("The Game has been exited.");
                    return;
                case "C":
                    numberOfMatrixElementsControl();
                    break;
                case "N":
                    try {
                        gameStart();
                    } catch (InputMismatchException exception) {
                        System.out.println("Invalid value input.");
                        System.out.println();
                        numberOfMatrixElements++;
                    } catch (RuntimeException exception) {
                        System.out.println("Runtime exception was occurred.");
                    }
                    break;
                default:
                    System.out.println("Invalid character input.");
                    break;
            }
        }
    }

    /*
     * Free space control is done.
     * */
    private void numberOfMatrixElementsControl() {
        if (numberOfMatrixElements <= 0) {
            System.out.println("There are no characters left to enter the panel, the game ends.");
            whoIsTheGameWin();
            System.exit(0);
        }
    }

    /*
     * The game is started with gameStart method.
     * */
    private void gameStart() {
        if (playerOrder) {
            playerContinueGame();
        } else {
            computerContinueGame();
        }
    }

    /*
     * if playerOrder value true, playerContinueGame method is run.
     * */
    private void playerContinueGame() {
        numberOfMatrixElements--;
        do {
            playerEnterIndexValues();
            indexState = isMatrixIndexNull(playerIndexX, playerIndexY);
        } while (!indexState);

        characterEnterToThePanel(playerIndexX, playerIndexY, playerEnterCharacter);
        sosGameBoard();
        scoreBoard();
        numberOfMatrixElementsControl();

    }

    /*
     * if playerOrder value false, comuputerContinueGame method is run.
     * */
    private void computerContinueGame() {
        numberOfMatrixElements--;
        do {
            computerEnterIndexValues();
            indexState = isMatrixIndexNull(computerIndexX, computerIndexY);
        } while (!indexState);
        characterEnterToThePanel(computerIndexX, computerIndexY, computerEnterCharacter);
        sosGameBoard();
        scoreBoard();
        numberOfMatrixElementsControl();
    }

    /*
     * When Player or Computer enter the value,
     * I mean if previously  entered the value to the field.
     * Player or Computer should re-enter index values.
     * */
    private boolean isMatrixIndexNull(int indexX, int indexY) {
        if (sosGameMatrix[indexX][indexY] == null) {
            return true;
        } else if (sosGameMatrix[indexX][indexY].equals("S")) {
            System.out.println("Please,Re-enter Index values.");
            return false;
        } else {
            System.out.println("Please,Re-enter Index values.");
            return false;
        }
    }

    /*
     * The characters are entered to the SosGame Panel.
     * SOS is checked. if Player or Computer  do SOS,
     * Player or Computer are  earn point by the number of SOS
     * */
    @Override
    public void characterEnterToThePanel(int indexX, int indexY, String character) {
        sosGameMatrix[indexX][indexY] = character;
        if (sosGameMatrix[indexX][indexY].equals("S") && playerEnterCharacter.equals("S") && playerOrder) {
            playerOrderAndSletterControl(indexX, indexY);
            score = 0;
        } else if (sosGameMatrix[indexX][indexY].equals("S") && computerEnterCharacter.equals("S") && computerOrder) {
            computerOrderAndSletterControl(indexX, indexY);
            score = 0;
        } else if (sosGameMatrix[indexX][indexY].equals("O") && playerEnterCharacter.equals("O") && playerOrder) {
            playerOrderOletterControl(indexX, indexY);
            score = 0;
        } else if (sosGameMatrix[indexX][indexY].equals("O") && computerEnterCharacter.equals("O") && computerOrder) {
            computerOrderAndOletterControl(indexX, indexY);
            score = 0;
        }
    }

    /*
     * if playerOrder true and playerCharacter S, Below method is run
     * */
    private void playerOrderAndSletterControl(int indexX, int indexY) {
        sosCount = characterScontrol(indexX, indexY);
        if (sosCount > 0) {
            System.out.println("Player won " + sosCount + " point\nThus, the Player won one more game.");
            playerScore += score;
        } else if (sosCount == 0) {
            playerOrder = false;
            computerOrder = true;
        }
    }

    /*
     *  if computerOrder true and computerCharacter S, Below method is run
     * */
    private void computerOrderAndSletterControl(int indexX, int indexY) {
        sosCount = characterScontrol(indexX, indexY);
        if (sosCount > 0) {
            System.out.println("Computer won " + sosCount + " point.\nThus, The Computer won one more game.");
            computerScore += score;
        } else if (sosCount == 0) {
            computerOrder = false;
            playerOrder = true;
        }
    }

    /*
     *  if playerOrder true and playerCharacter O, Below method is run
     * */
    private void playerOrderOletterControl(int indexX, int indexY) {
        sosCount = characterOcontrol(indexX, indexY);
        if (sosCount > 0 && sosCount <= 2) {
            System.out.println("Player won 1 point\nThus, The Player won one more game.");
            playerScore++;
        } else if (sosCount > 2) {
            System.out.println("Player won " + (sosCount - 2) + " point.\nThus, The Player won one more game.");
            playerScore += 2;
        } else if (sosCount == 0) {
            playerOrder = false;
            computerOrder = true;
        }
    }

    /*
     *  if computerOrder true and computerCharacter O, Below method is run
     * */
    private void computerOrderAndOletterControl(int indexX, int indexY) {
        sosCount = characterOcontrol(indexX, indexY);
        if (sosCount > 0 && sosCount <= 2) {
            System.out.println("Computer won 1 point\nThus, The Computer won one more game.");
            computerScore++;
        } else if (sosCount > 2) {
            System.out.println("Computer won " + (sosCount - 2) + " point\nThus, The Computer won one more game.");
            computerScore += 2;
        } else if (sosCount == 0) {
            playerOrder = true;
            computerOrder = false;
        }
    }

    /*
     * SOS control with the letter S.
     * */
    @Override
    public int characterScontrol(int indexX, int indexY) {

        System.out.println("Selected Value : " + sosGameMatrix[indexX][indexY]);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (sosGameMatrix[indexX][indexY].equals("S")) {
                    if (indexX + 2 * i >= 0 && indexX + 2 * i < dimension && indexY + 2 * j >= 0 && indexY + 2 * j < dimension) {
                        if (sosGameMatrix[indexX + i][indexY + j] == "O" && sosGameMatrix[indexX + 2 * i][indexY + 2 * j] == "S") {
                            score++;
                        }
                    }
                }
            }
        }
        return score;

    }

    /*
     * SOS control with the letter O.
     *   */
    @Override
    public int characterOcontrol(int indexX, int indexY) {
        System.out.println("Selected Value : " + sosGameMatrix[indexX][indexY]);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (sosGameMatrix[indexX][indexY].equals("O")) {
                    if ((indexX + i >= 0 && indexX + i < dimension && indexY + j >= 0 && indexY + j < dimension)
                            && (indexX - i >= 0 && indexX - i < dimension && indexY - j >= 0 && indexY - j < dimension)) {
                        if (sosGameMatrix[indexX + i][indexY + j] == "S" && sosGameMatrix[indexX - i][indexY - j] == "S") {
                            score++;
                        }
                    }
                }
            }
        }
        return score;
    }

    /*
     * Player Score and Computer Score are compared.
     * */
    @Override
    public void whoIsTheGameWin() {
        System.out.println("--------------------------------------------");
        if (playerScore > computerScore) {
            System.out.println("Player won the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer won the game !");
        } else {
            System.out.println("The game ended in a draw !");
        }
        System.out.println("--------------------------------------------");
        scoreBoard();
        System.out.println("--------------------------------------------");
        System.out.println("----------------------------The Game Over----------------------------------");
    }
}
