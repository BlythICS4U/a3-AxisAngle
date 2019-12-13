package tictactoe;
/**
 * 
 * @author bachle
 */
public class TicTacToe {

    private char[][] board;

    // Constructors
    
    /**
     * the default constructor, which just creates the two-dimensional array and
     * fills each slot with ' ' (a blank space) and initializes the other
     * attributes
     */
    public TicTacToe() {
        board = new char[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    // Accessor Methods
    
    /**
     * returns true if the letter passed in currently has three in a row. That
     * is, isWinner('X') will return true if X has won, and isWinner('O') will
     * return true if O has won
     *
     * @param p
     * @return Boolean that is false or true depending if p is winner
     */
    public boolean isWinner(char p) {
        for (int i = 0; i < 3; i++) {
            //Check horizontal
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
                return true;
            }
            //Check vertical
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
                return true;
            }
        }
        
        //Check diagonal
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
            return true;
        }
        //Check other diagonal
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
            return true;
        }
        return false;
    }

    /**
     * returns true if nine turns have been played and false otherwise
     *
     * @return
     */
    public boolean isFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns true if all nine spaces are filled AND neither X nor O has won
     *
     * @return Boolean 
     */
    public boolean isCat() {
        return (isFull() && !isWinner('X') && !isWinner('O'));
    }

    /**
     * Returns true if the given row and column corresponds to a valid space on
     * the board
     *
     * @param r
     * @param c
     * @return Boolean 
     */
    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns the character representing the piece at the given location.
     * Should return either ' ', 'X', or 'O'.
     *
     * @param r
     * @param c
     * @return Array containing ' ', 'X', or 'O'
     */
    public char playerAt(int r, int c) {
        if (isValid(r, c)) {
            return board[r][c];
        } else {
            return '@';
        }
    }

    /**
     * displays the current board on the screen
     */
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");  
    }
    // Modifiers
    
    /**
     * Allows the given player to place their move at the given row and column.
     * The row and column numbers are 0-based, so valid numbers are 0, 1, or 2
     *
     * @param p
     * @param r
     * @param c
     */
    public void playMove(char p, int r, int c) {
        board[r][c] = p;
    }
}