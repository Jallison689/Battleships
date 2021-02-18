import java.util.ArrayList;
import java.util.Random;

public class CoordMaker {

    ArrayList<String> coordHolder;

    public CoordMaker(){
        this.coordHolder = new ArrayList<>();
    }

    public int[][] getCoords(int size){

        int[][] coords = new int[size + 1][2];

        boolean uniqueCoords = false;
        boolean shipPlaced = false;

        Random random = new Random();

        int temp;

        while(!uniqueCoords) {
            for (int j = 0; j < coords[0].length; j++) {
                temp = random.nextInt(10);
                if (!(temp - size < 0 || temp + size > 10)) {
                    coords[0][j] = temp;
                }
            }
            if (!(this.coordHolder.contains(Integer.toString(coords[0][0]) + coords[0][1]))) {
                uniqueCoords = true;
                this.coordHolder.add(Integer.toString(coords[0][0]) + coords[0][1]);
            }
        }
        while(!shipPlaced) {
            switch (random.nextInt(4)) {
                case 0:
                    if (coords[0][0] - size > 0) {
                        for (int j = 1; j < size + 1; j++) {
                            coords[j][0] = coords[0][0] - j;
                            coords[j][1] = coords[0][1];
                            if(!(this.coordHolder.contains(Integer.toString(coords[j][0]) + coords[j][1]))){
                                shipPlaced = true;
                                this.coordHolder.add(Integer.toString(coords[j][0]) + coords[j][1]);
                            }else{
                                shipPlaced = false;
                                break;
                            }
                        }

                    }
                    break;
                case 1:
                    if (coords[0][1] + size < 10) {
                        for (int j = 1; j < size + 1; j++) {
                            coords[j][0] = coords[0][0];
                            coords[j][1] = coords[0][1] + j;
                            if(!(this.coordHolder.contains(Integer.toString(coords[j][0]) + coords[j][1]))){
                                shipPlaced = true;
                                this.coordHolder.add(Integer.toString(coords[j][0]) + coords[j][1]);
                            }else{
                                shipPlaced = false;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    if (coords[0][0] + size < 10) {
                        for (int j = 1; j < size + 1; j++) {
                            coords[j][0] = coords[0][0] + j;
                            coords[j][1] = coords[0][1];
                            if(!(this.coordHolder.contains(Integer.toString(coords[j][0]) + coords[j][1]))){
                                shipPlaced = true;
                                this.coordHolder.add(Integer.toString(coords[j][0]) + coords[j][1]);
                            }else{
                                shipPlaced = false;
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (coords[0][1] - size > 0) {
                        for (int j = 1; j < size + 1; j++) {
                            coords[j][0] = coords[0][0];
                            coords[j][1] = coords[0][1] - j;
                            if(!(this.coordHolder.contains(Integer.toString(coords[j][0]) + coords[j][1]))){
                                shipPlaced = true;
                                this.coordHolder.add(Integer.toString(coords[j][0]) + coords[j][1]);
                            }else{
                                shipPlaced = false;
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return coords.clone();
    }
}