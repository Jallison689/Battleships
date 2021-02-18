public class ConsoleOutputs implements Outputs {
    public ConsoleOutputs(){}

    public void output(String outputToConsole){
        if(outputToConsole != null){
            System.out.println(outputToConsole);
        }
    }

    public void output(String[][] boardToOutput){
        int count = 1;

        System.out.println("   A B C D E F G H I J");

        for (String[] each:boardToOutput){
            if(count != 10){
                System.out.print(count + " ");
            }else{
                System.out.print(count);
            }
            for (String stringEach:each) {
                System.out.print("|");
                if(stringEach.equals("S")){
                    System.out.print(" ");
                }else{
                    System.out.print(stringEach);
                }
            }
            count++;
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }
}
