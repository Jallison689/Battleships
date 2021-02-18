import java.util.ArrayList;

public class Board {
    String[][] map = new String[10][10];

    public Board(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = " ";
            }
        }
    }

    public String hittingShips(int[] coords){
        if(map[coords[0]][coords[1]].equals("S")){
            map[coords[0]][coords[1]] = "O";
            return "Hit";
        }else{
            map[coords[0]][coords[1]] = "X";
            return "Miss";
        }
    }

    public void addShip(int[][] coords){
        for (int[] each : coords) {
            map[each[0]][each[1]] = "S";
        }
    }

    public String[][] getBoard(){
        return this.map.clone();
    }

    public ArrayList<String> getCoordContents(int[][] coords){
        ArrayList<String> coordContents = new ArrayList<>();
        for(int[] each  : coords){
            coordContents.add(map[each[0]][each[1]]);
        }
        return new ArrayList<>(coordContents);
    }
}