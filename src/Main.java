public class Main {

    public static void main(String[] args) {
        UserCoordsInput coordsInput = new UserCoordsInput();

        Board board = new Board();

        ConsoleOutputs outputs = new ConsoleOutputs();

        CoordMaker coordMaker = new CoordMaker();

        Destroyer d1 = new Destroyer(coordMaker.getCoords(3));
        Destroyer d2 = new Destroyer(coordMaker.getCoords(3));

        Battleship b1 = new Battleship(coordMaker.getCoords(4));

        boolean gameOn = true;

        board.addShip(d1.getCoords());
        board.addShip(d2.getCoords());
        board.addShip(b1.getCoords());

        while(gameOn) {

            outputs.output(board.getBoard());

            coordsInput.setInput();
            coordsInput.processInput();

            outputs.output(board.hittingShips(coordsInput.getInput()));

            outputs.output(d1.checkSunk(board.getCoordContents(d1.getCoords())));
            outputs.output(d2.checkSunk(board.getCoordContents(d2.getCoords())));
            outputs.output(b1.checkSunk(board.getCoordContents(b1.getCoords())));

            if(d1.getSunk() && d2.getSunk() && b1.getSunk()){
                outputs.output("All ships have been sunk");
                outputs.output("GAME OVER");
                gameOn = false;
            }
        }
    }
}