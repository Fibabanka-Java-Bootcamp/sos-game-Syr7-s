package org.kodluyoruz.Concrete;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SosGame implements org.kodluyoruz.Abstract.SosGame {
    private Random random = new Random();
    private Scanner reader = new Scanner(System.in);
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

    @Override
    public void sosGameMatrixDimension(int dimension) {
        sosGameMatrix = new String[dimension][dimension];
    }

    @Override
    public void sosGameBoard() {
        System.out.println("--------------------------------------------");
        System.out.println("------------------SOS Panel-----------------");
        int i = 0;
        for (int j = 0; j < dimension; j++) {
            if (i == 0) {
                System.out.print("   " + (j + 1) + "  ");
            }
        }
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

    @Override
    public void decideToTheCharacter() {
        boolean takeCharacter = random.nextBoolean();
        decideToTheCharacter(takeCharacter);
    }

    private void decideToTheCharacter(boolean takeCharacter) {
        if (takeCharacter) {
            playerEnterCharacter = LETTER_S;
            computerEnterCharacter = LETTER_O;
            System.out.println("--------------------------------------------");
            System.out.println("Player will start with " + playerEnterCharacter + "  letter to the game.\n" +
                    "Computer will start with " + computerEnterCharacter + " letter to the game.");
        } else {
            playerEnterCharacter = LETTER_O;
            computerEnterCharacter = LETTER_S;
            System.out.println("--------------------------------------------");
            System.out.println("Player will start with " + playerEnterCharacter + "  letter to the game.\n" +
                    "Computer will start with " + computerEnterCharacter + " letter to the game.");
        }
        System.out.println("--------------------------------------------");
    }

    @Override
    public void playerEnterIndexValues() throws InputMismatchException {
        while (true) {
            System.out.print("Enter indexX value : ");
            playerIndexX = reader.nextInt();
            System.out.print("Enter indexY value : ");
            playerIndexY = reader.nextInt();
            boolean result = enterIndexXandIndexYvalues(playerIndexX, playerIndexY);
            if (result) {
                return;
            }
        }
    }

    @Override
    public void computerEnterIndexValues() {
        computerIndexX = random.nextInt(dimension);
        computerIndexY = random.nextInt(dimension);

        System.out.println("Computer IndexX value: " + computerIndexX + "\nComputer IndexY value : " + computerIndexY);
    }

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
                        System.out.println("Run Time exceptİon was occurred.");
                    }

                    break;
                default:
                    System.out.println("Invalid character input.");
                    break;
            }
        }
    }

    private void numberOfMatrixElementsControl() {
        if (numberOfMatrixElements <= 0) {
            System.out.println("There are no characters left to enter the panel, the game ends.");
            whoIsTheGameWin();
            System.exit(0);
        }
    }

    private void gameStart() {
        if (playerOrder) {
            playerContinueGame();
        } else {
            computerContinueGame();
        }
    }

    private void playerContinueGame() {
        numberOfMatrixElements--;
        while (true) {
            playerEnterIndexValues();
            indexState = isMatrixIndexNull(playerIndexX, playerIndexY);
            if (indexState) {
                break;
            }
        }

        characterEnterToThePanel(playerIndexX, playerIndexY, playerEnterCharacter);
        sosGameBoard();
        scoreBoard();
        numberOfMatrixElementsControl();

    }

    private void computerContinueGame() {
        numberOfMatrixElements--;
        while (true) {
            computerEnterIndexValues();
            indexState = isMatrixIndexNull(computerIndexX, computerIndexY);
            if (indexState)
                break;
        }
        characterEnterToThePanel(computerIndexX, computerIndexY, computerEnterCharacter);
        sosGameBoard();
        scoreBoard();
        numberOfMatrixElementsControl();
    }

    private boolean isMatrixIndexNull(int indexX, int indexY) {
        if (sosGameMatrix[indexX][indexY] == null) {
            return true;
        } else if (sosGameMatrix[indexX][indexY] == "S") {
            System.out.println("Please,Re-enter Index values.");
            return false;
        } else {
            System.out.println("Please,Re-enter Index values.");
            return false;
        }
    }

    @Override
    public void characterEnterToThePanel(int indexX, int indexY, String character) {
        sosGameMatrix[indexX][indexY] = character;
        if (sosGameMatrix[indexX][indexY] == "S" && playerEnterCharacter.equals("S") && playerOrder) {
            playerOrderAndSletterControl(indexX, indexY);
            score = 0;
        } else if (sosGameMatrix[indexX][indexY] == "S" && computerEnterCharacter.equals("S") && computerOrder) {
            computerOrderAndSletterControl(indexX, indexY);
            score = 0;
        } else if (sosGameMatrix[indexX][indexY] == "O" && playerEnterCharacter.equals("O") && playerOrder) {
            playerOrderOletterControl(indexX, indexY);
            score = 0;
        } else if (sosGameMatrix[indexX][indexY] == "O" && computerEnterCharacter.equals("O") && computerOrder) {
            computerOrderAndOletterControl(indexX, indexY);
            score = 0;
        }
    }

    private void playerOrderAndSletterControl(int indexX, int indexY) {
        sosCount = characterScontrol(indexX, indexY);
        if (sosCount > 0) {
            System.out.println("Player won " + sosCount + " point\nThus, the Player won another game.");
            playerScore += score;
        } else if (sosCount == 0) {
            playerOrder = false;
            computerOrder = true;
        }
    }

    private void computerOrderAndSletterControl(int indexX, int indexY) {
        sosCount = characterScontrol(indexX, indexY);
        if (sosCount > 0) {
            System.out.println("Computer won " + sosCount + " point.\nThus, the Computer won another game.");
            computerScore += score;
        } else if (sosCount == 0) {
            computerOrder = false;
            playerOrder = true;
        }
    }

    private void playerOrderOletterControl(int indexX, int indexY) {
        sosCount = characterOcontrol(indexX, indexY);
        if (sosCount > 0 && sosCount <= 2) {
            System.out.println("Player won 1 point\nThus, the Player won another game.");
            playerScore++;
        } else if (sosCount > 2) {
            System.out.println("Player won " + (sosCount - 2) + " point.\nThus, the Player won another game.");
            playerScore += 2;
        } else if (sosCount == 0) {
            playerOrder = false;
            computerOrder = true;
        }
    }

    private void computerOrderAndOletterControl(int indexX, int indexY) {
        sosCount = characterOcontrol(indexX, indexY);
        if (sosCount > 0 && sosCount <= 2) {
            System.out.println("Computer won 1 point\nThus, the Computer won another game.");
            computerScore++;
        } else if (sosCount > 2) {
            System.out.println("Computer won " + (sosCount - 2) + " point\nThus, the Computer won another game.");
            computerScore += 2;
        } else if (sosCount == 0) {
            playerOrder = true;
            computerOrder = false;
        }
    }

    @Override
    public int characterScontrol(int indexX, int indexY) {
        String selectedValueOne = sosGameMatrix[indexX][indexY];
        System.out.println("Selected Value : " + selectedValueOne);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (selectedValueOne == "S") {
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

    @Override
    public int characterOcontrol(int indexX, int indexY) {
        String selectedValueOne = sosGameMatrix[indexX][indexY];
        System.out.println("Selected Value : " + selectedValueOne);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (selectedValueOne == "O") {
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

    @Override
    public void whoIsTheGameWin() {
        if (playerScore > computerScore) {
            System.out.println("--------------------------------------------");
            System.out.println("Player won the game!");
            System.out.println("--------------------------------------------");
            scoreBoard();
            System.out.println("--------------------------------------------");
            System.out.println("----------------------------The Game Over----------------------------------");

        } else if (playerScore < computerScore) {
            System.out.println("--------------------------------------------");
            System.out.println("Computer won the game !");
            System.out.println("--------------------------------------------");
            scoreBoard();
            System.out.println("--------------------------------------------");
            System.out.println("----------------------------The Game Over----------------------------------");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("The game ended in a draw !");
            System.out.println("--------------------------------------------");
            scoreBoard();
            System.out.println("--------------------------------------------");
            System.out.println("----------------------------The Game Over----------------------------------");
        }
    }
}
