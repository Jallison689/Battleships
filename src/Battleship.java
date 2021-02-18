import java.util.ArrayList;

public class Battleship implements ShipInterface {
    int[][] coords;
    int length;
    boolean sunk = false;

    public Battleship(int[][] coords){
        this.length = 5;
        this.coords = new int[this.length][2];
        for(int i = 0; i < this.coords.length; i++){
            for(int j = 0; j < this.coords[i].length; j++){
                this.coords[i][j] = coords[i][j];
            }
        }
    }

    public int[][] getCoords(){
        return this.coords.clone();
    }

    public boolean getSunk(){
        return this.sunk;
    }

    public String checkSunk(ArrayList<String> coordContents){
        int length = this.length;
        for (String each : coordContents) {
            if(!each.equals("S")){
                length -= 1;
            }
            if(length == 0) {
                if (!this.sunk) {
                    this.sunk = true;
                    this.length = length;
                    return "Battleship Has Been Sunk";
                }
                break;
            }
        }
        return null;
    }
}