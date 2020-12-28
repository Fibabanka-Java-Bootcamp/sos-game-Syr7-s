package org.kodluyoruz;

import org.kodluyoruz.Concrete.SosGame;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("----------------------------Welcome To SoS Game----------------------------");
        SosGame sosGame=new SosGame();
        int dimension=sosGame.setDimension();
        if (dimension==-1){
            System.out.println("Exception handled.");
        }else{
            sosGame.sosGameMatrixDimension(dimension);
            sosGame.sosGameBoard();
            sosGame.decideToTheStartGame();
            sosGame.decideToTheCharacter();
            sosGame.scoreBoard();
            sosGame.startGame();
        }
    }
}
