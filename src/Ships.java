import java.util.Random;

public class Ships {
    String type;
    int[][] coords;
    int length;
    boolean sunk = false;

    public Ships(int[][] coords, String type){
        this.type = type;
        if(this.type.equals("Destroyer")){
            this.length = 3;
        }else{
            this.length = 4;
        }
        this.coords = new int[this.length + 1][2];
        for(int i = 0; i < this.coords.length; i++){
            for(int j = 0; j < this.coords[i].length; j++){
                this.coords[i][j] = coords[i][j];
            }
        }
    }

    public int[][] getCoords(){
        return coords.clone();
    }

    public int getLength(){
        return this.length;
    }

    public void makeSunk(){
        System.out.println(type + " has been sunk");
        this.sunk = true;
    }

    public boolean hasbeenSunk(){
        return this.sunk;
    }

}