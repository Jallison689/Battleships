import java.util.Scanner;

import static java.lang.Character.getNumericValue;

public class Main {

    public static void main(String[] args) {
        Board shipBoard = new Board();
        CoordMaker coordMaker = new CoordMaker();

        Ships d1 = new Ships(coordMaker.getCoords(3), "Destroyer");
        Ships d2 = new Ships(coordMaker.getCoords(3), "Destroyer");
        Ships b1 = new Ships(coordMaker.getCoords(4), "Battleship");
        gameRun(shipBoard, d1, d2, b1);
    }

    public static void gameRun(Board shipBoard, Ships d1, Ships d2, Ships b1){


        boolean gameOn = true;

        int[] userCoords = new int[2];

        Scanner input = new Scanner(System.in);

        shipBoard.addShips(d1);
        shipBoard.addShips(d2);
        shipBoard.addShips(b1);

        shipBoard.show();

        while(gameOn) {
            System.out.println("Please enter the square you want to check : ");
            String coords = input.nextLine().toUpperCase();
            userCoords[1] = handleLetters(coords.charAt(0));
            try {
                if(coords.length() == 2){
                    userCoords[0] = getNumericValue(coords.charAt(1)) - 1;
                }else{
                    userCoords[0] = getNumericValue(coords.charAt(1) + coords.charAt(2)) - 1;
                }
            } catch (Exception e) {}

            shipBoard.hittingShips(userCoords.clone());
            if (!d1.hasbeenSunk()) {
                shipBoard.isSunk(d1);
            }
            if (!d2.hasbeenSunk()) {
                shipBoard.isSunk(d2);
            }
            if (!b1.hasbeenSunk()) {
                shipBoard.isSunk(b1);
            }

            shipBoard.show();
            if(d1.hasbeenSunk() && d2.hasbeenSunk() && b1.hasbeenSunk()){
                System.out.println("All ships have been sunk");
                System.out.println("GAME OVER");
                gameOn = false;
            }
        }
    }

    public static int handleLetters(char charToConvert) {
        char[] temp = {'A','B','C','D','E','F','G','H','I','J'};
        int itsHere = 0;
        for(int i = 0;i < temp.length;i++){
            if(temp[i] == charToConvert){
                itsHere = i;
                break;
            }
        }
        return itsHere;
    }
}