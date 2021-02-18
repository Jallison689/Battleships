import java.util.ArrayList;

public interface ShipInterface {
    String checkSunk(ArrayList<String> coordContents);
    int[][] getCoords();
    boolean getSunk();
}