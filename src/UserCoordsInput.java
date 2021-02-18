import java.util.Scanner;
import static java.lang.Character.getNumericValue;

public class UserCoordsInput implements UserInput{
    int[] processedUserCoords;
    String rawUserCoords;

    public UserCoordsInput(){
        processedUserCoords = new int[2];
    }

    public void setInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the square you want to check : ");
        rawUserCoords = input.nextLine().toUpperCase();
    }

    public void processInput(){
        char[] temp = {'A','B','C','D','E','F','G','H','I','J'};
        for(int i = 0;i < temp.length;i++){
            if(temp[i] == rawUserCoords.charAt(0)){
                processedUserCoords[1] = i;
                break;
            }
        }
        try {
            if(rawUserCoords.length() == 2){
                processedUserCoords[0] = getNumericValue(rawUserCoords.charAt(1)) - 1;
            }else{
                processedUserCoords[0] = getNumericValue(rawUserCoords.charAt(1) + rawUserCoords.charAt(2)) - 1;
            }
        } catch (Exception e) {}
    }

    public int[] getInput(){
        return processedUserCoords.clone();
    }
}