import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("Testing if a hit registers as hit")
    void testsHit() {
        int[][] testCoordsToHit = {{1,2}};
        int[] testCoordsToCheck = {1,2};
        board.addShip(testCoordsToHit);
        assertEquals("Hit", board.hittingShips(testCoordsToCheck));
    }

    @Test
    @DisplayName("Testing if a miss registers as miss")
    void testsMiss() {
        int[][] testCoordsToMiss = {{1,2}};
        int[] testCoordsToCheck = {1,4};
        board.addShip(testCoordsToMiss);
        assertEquals("Miss", board.hittingShips(testCoordsToCheck));
    }

    @Test
    @DisplayName("Testing if a ship can be placed at coordinates")
    void testaddShip() {
        int[][] testCoords = {{1,2}};
        board.addShip(testCoords);
        assertEquals("S", board.getCoordContents(testCoords).get(0));
    }

    @Test
    @DisplayName("Testing if specific coordinate contents can be retrieved")
    void testgetCoordContents() {
        int[][] testCoords = {{1,8}};
        board.addShip(testCoords);
        assertEquals("S", board.getCoordContents(testCoords).get(0));
    }
}