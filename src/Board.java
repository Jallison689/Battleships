import java.util.Random;

public class Board {
    String[][] map = new String[10][10];

    public Board(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = " ";
            }
        }
    }

    public void hittingShips(int[] coords){
        if(map[coords[0]][coords[1]].equals("S")){
            map[coords[0]][coords[1]] = "O";
            System.out.println("Hit");
        }else{
            map[coords[0]][coords[1]] = "X";
            System.out.println("Miss");
        }
    }

    public void show(){
        int count = 1;

        System.out.println("   A B C D E F G H I J");

        for (String[] each:map){
            if(count != 10){
                System.out.print(count + " ");
            }else{
                System.out.print(count);
            }
            for (String stringEach:each) {
                System.out.print("|");
                /*if(stringEach.equals("S")){
                    System.out.print(" ");
                }else{*/
                System.out.print(stringEach);
                //}
            }
            count++;
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public void addShips(Ships ship){
        int[][] CoordsHolder;
        CoordsHolder = ship.getCoords();
        for (int[] each : CoordsHolder) {
            map[each[0]][each[1]] = "S";
        }

    }

    public void isSunk(Ships ship){
        int[][] CoordsHolder = ship.getCoords();
        int length = ship.getLength() + 1;
        for (int[] each : CoordsHolder) {
            if(!(map[each[0]][each[1]].equals("S"))){
                length--;
            }
        }
        if(length == 0){
            ship.makeSunk();
        }
    }
}