package tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 
 * @author bachle
 */
public class TicTacToeTest {

    /**
     * Test of isWinner method, of class TicTacToe.
     */
    @Test
    public void testIsWinner() {
        //Horizontal
        TicTacToe test1 = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            test1.playMove('X', 0, i);
        }
        assertEquals(test1.isWinner('X'), true);

        //Vertical
        TicTacToe test2 = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            test2.playMove('X', i, 0);
        }
        assertEquals(test2.isWinner('X'), true);

        //Diagonal
        TicTacToe test3 = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            test3.playMove('O', i, i);
        }
        assertEquals(test3.isWinner('O'), true);

        //Empty
        TicTacToe test4 = new TicTacToe();
        assertEquals(test4.isWinner('X'), false);
    }

    /**
     * Test of isFull method, of class TicTacToe.
     */
    @Test
    public void testIsFull() {
        //Empty
        TicTacToe test1 = new TicTacToe();
        assertEquals(test1.isFull(), false);

        //Full
        TicTacToe test2 = new TicTacToe();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                test2.playMove('O', r, c);
            }
        }
        assertEquals(test2.isFull(), true);

        //Partially full
        TicTacToe test3 = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            test3.playMove('X', 0, i);
        }
        assertEquals(test3.isFull(), false);
    }

    /**
     *Test of isCat method, of class TicTacToe.
     */
    @Test
    public void testIsCat() {
        //Win but not full
        TicTacToe test1 = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            test1.playMove('X', 0, i);
        }
        assertFalse(test1.isCat());

        //Full but no win
        TicTacToe test2 = new TicTacToe();
        for (int i = 0; i < 2; i++) {
            test2.playMove('O', i, 0);
            test2.playMove('X', i, 1);
            test2.playMove('O', i, 2);
        }
        test2.playMove('X', 2, 0);
        test2.playMove('O', 2, 1);
        test2.playMove('X', 2, 2);
        assertTrue(test2.isCat());

        //Full and there is a winner
        TicTacToe test3 = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            test3.playMove('O', i, 0);
            test3.playMove('X', i, 1);
            test3.playMove('O', i, 2);
        }
        assertFalse(test3.isCat());
    }

    /**
     *Test of isValid method, of class TicTacToe.
     */
    @Test
    public void testIsValid() {
        //Invalid move
        TicTacToe test1 = new TicTacToe();
        assertFalse(test1.isValid(69, 420));

        //Valid move
        assertTrue(test1.isValid(1, 1));
    }

    /**
     *Test of playerAt method, of class TicTacToe.
     */
    @Test
    public void testPlayerAt() {
        TicTacToe test1 = new TicTacToe();
        assertEquals(test1.playerAt(0, 0), ' ');
    }

    /**
     *Test of displayBoard method, of class TicTacToe.
     */
    @Test
    public void testDisplayBoard() {
    }

    /**
     * Test of playMove method, of class TicTacToe.
     */
    @Test
    public void testPlayMove() {
        TicTacToe test1 = new TicTacToe();
        test1.playMove('X', 0, 0);
        assertEquals(test1.playerAt(0, 0), 'X');
    }
}