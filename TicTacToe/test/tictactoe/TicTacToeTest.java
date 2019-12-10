package tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

    /**
     *Test of isWinner method, of class TicTacToe.
     */
    @Test
    public void testIsWinner() {
        TicTacToe test = new TicTacToe();
        assertEquals(test.isWinner('X'), false);
        assertEquals(test.isWinner('O'), false);

        for (int i = 0; i < 3; i++) {
            test.playMove('X', 0, i);
        }
        assertEquals(test.isWinner('X'), true);
    }

    /**
     *Test of isFull method, of class TicTacToe.
     */
    @Test
    public void testIsFull() {
        TicTacToe test = new TicTacToe();
        assertEquals(test.isFull(), false);
    }

    /**
     *Test of isCat method, of class TicTacToe.
     */
    @Test
    public void testIsCat() {
        TicTacToe test = new TicTacToe();
        test.playMove('X',0,0);
        assertEquals(test.isCat(), false);
        test.playMove('X',0,1);
        test.playMove('X',0,1);
        assertEquals(test.isCat(), false);
    }
    /**
     *Test of isValid method, of class TicTacToe.
     */
    @Test
    public void testIsValid() {
        TicTacToe test = new TicTacToe();
        assertEquals(test.isValid(0, 0), true);
        assertEquals(test.isValid(0, 69), false);
        assertEquals(test.isValid(-69, -420), false);
    }

    /**
     *Test of playerAt method, of class TicTacToe.
     */
    @Test
    public void testPlayerAt() {
        TicTacToe test = new TicTacToe();
        test.playMove('X', 0, 0);
        assertEquals(test.playerAt(0, 0), 'X');
        assertEquals(test.playerAt(0, 1), ' ');
    }

    /**
     *Test of displayBoard method, of class TicTacToe.
     */
    @Test
    public void testDisplayBoard() {
        TicTacToe test = new TicTacToe();
        
    }

    /**
     *Test of playMove method, of class TicTacToe.
     */
    @Test
    public void testPlayMove() {
        TicTacToe test = new TicTacToe();
        test.playMove('X', 0, 0);
        assertEquals(test.playerAt(0, 0), 'X');
    }

}
