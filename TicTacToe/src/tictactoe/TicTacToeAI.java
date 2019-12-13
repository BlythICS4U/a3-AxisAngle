/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author bachle
 */
public class TicTacToeAI {
    
    /**
     * Returns true if it is the AI's first move and will place it's first move 
     * and false if it has already made a move.
     * @param board
     * @return Boolean true or false depending on whether if it's the AI's first move or not.
     */
    private static boolean AIFirstMove(TicTacToe board) {
        boolean firstMove = true; 

        //Checks if it's the first move.
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board.playerAt(r, c) == 'O') {
                    firstMove = false;
                    break;
                }
            }
        }

        if (firstMove ) {

            //If first move is center it will play in a corner
            if (board.playerAt(1, 1) == 'X') {
                board.playMove('O', 2, 2);
            } 
            //If first move is a corner or edge it will play in the center
            else {
                board.playMove('O', 1, 1);
            }
        } 
        return firstMove;
    }
    
    /**
     * AI goes through all the squares and checks if it can place to win 
     * and if it finds nothing it will return false.
     * 
     * @param board
     * @return Boolean true if winmove is found and false if none is found.
     */
    private static boolean AIWinMove(TicTacToe board)
    {
        //horizontal
        for (int i = 0; i < 3; i++) {
            
            if (board.playerAt(i, 2) == board.playerAt(i, 1) && board.playerAt(i, 2) == 'O') {
                if (board.playerAt(i, 0) == ' ') {
                    board.playMove('O', i, 0);
                    return true;
                }
            }
        
        
            if (board.playerAt(i,0) == board.playerAt(i,1) && board.playerAt(i,0) == 'O') {
                if (board.playerAt(i,2) == ' ') {
                    board.playMove('O', i,2);
                    return true;
                }
            }
        
            if (board.playerAt(i,0) == board.playerAt(i,2) && board.playerAt(i,0) == 'O') {
                if (board.playerAt(i,1) == ' ') {
                    board.playMove('O', i,1);
                    return true;
                }
            }
        
        //vertical
            if (board.playerAt(2,i) == board.playerAt(1,i) && board.playerAt(2,i) == 'O') {
                if (board.playerAt(0,i) == ' ') {
                    board.playMove('O', 0, i);
                    return true;
                }
            }
        
            if (board.playerAt(0,i) == board.playerAt(1,i) && board.playerAt(0,i) == 'O') {
                if (board.playerAt(2,i) == ' ') {
                    board.playMove('O', 2,i);
                    return true;
                }
            }
        
            if (board.playerAt(0,i) == board.playerAt(2,i) && board.playerAt(0,i) == 'O') {
                if (board.playerAt(1,i) == ' ') {
                    board.playMove('O', 1,i);
                    return true;
                }
            }
        }
        
        //diagonal
        if (board.playerAt(0,0) == board.playerAt(1,1) && board.playerAt(0,0) == 'O') {
                if (board.playerAt(2,2) == ' ') {
                    board.playMove('O', 2,2);
                    return true;
                }
            }
        
        if (board.playerAt(2,2) == board.playerAt(1,1) && board.playerAt(2,2) == 'O') {
                if (board.playerAt(0,0) == ' ') {
                    board.playMove('O', 0,0);
                    return true;
                }
            }
        
          if (board.playerAt(0,2) == board.playerAt(1,1) && board.playerAt(0,2) == 'O') {
                if (board.playerAt(2,0) == ' ') {
                    board.playMove('O', 2,0);
                    return true;
                }
            }
        
          if (board.playerAt(2,0) == board.playerAt(1,1) && board.playerAt(2,0) == 'O') {
                if (board.playerAt(0,2) == ' ') {
                    board.playMove('O', 0,2);
                    return true;
                }
            }
          return false;
    }
    
    /**
     * AI checks if the player is about to win and blocks if that's the case
     * @param board
     * @return Boolean true if it made a move to block and false if it did not
     */
    private static boolean AIBlock(TicTacToe board)
    {
         //horizontal 
        for (int i = 0; i < 3; i++) {
            
            if (board.playerAt(i, 2) == board.playerAt(i, 1) && board.playerAt(i, 2) == 'X') {
                if (board.playerAt(i, 0) == ' ') {
                    board.playMove('O', i, 0);
                    return true;
                }
            }
        
            if (board.playerAt(i,0) == board.playerAt(i,1) && board.playerAt(i,0) == 'X') {
                if (board.playerAt(i,2) == ' ') {
                    board.playMove('O', i,2);
                    return true;
                }
            }
        
            if (board.playerAt(i,0) == board.playerAt(i,2) && board.playerAt(i,0) == 'X') {
                if (board.playerAt(i,1) == ' ') {
                    board.playMove('O', i,1);
                    return true;
                }
            }

        //vertical 
            if (board.playerAt(2,i) == board.playerAt(1,i) && board.playerAt(2,i) == 'X') {
                if (board.playerAt(0,i) == ' ') {
                    board.playMove('O', 0, i);
                    return true;
                }
            }

            if (board.playerAt(0,i) == board.playerAt(1,i) && board.playerAt(0,i) == 'X') {
                if (board.playerAt(2,i) == ' ') {
                    board.playMove('O', 2,i);
                    return true;
                }
            }
        
            if (board.playerAt(0,i) == board.playerAt(2,i) && board.playerAt(0,i) == 'X') {
                if (board.playerAt(1,i) == ' ') {
                    board.playMove('O', 1,i);
                    return true;
                }
            }
        }
        
        //diagonal 
        if (board.playerAt(0,0) == board.playerAt(1,1) && board.playerAt(0,0) == 'X') {
                if (board.playerAt(2,2) == ' ') {
                    board.playMove('O', 2,2);
                    return true;
                }
            }
        
        if (board.playerAt(2,2) == board.playerAt(1,1) && board.playerAt(2,2) == 'X') {
                if (board.playerAt(0,0) == ' ') {
                    board.playMove('O', 0,0);
                    return true;
                }
            }
        
          if (board.playerAt(0,2) == board.playerAt(1,1) && board.playerAt(0,2) == 'X') {
                if (board.playerAt(2,0) == ' ') {
                    board.playMove('O', 2,0);
                    return true;
                }
            }
        
          if (board.playerAt(2,0) == board.playerAt(1,1) && board.playerAt(2,0) == 'X') {
                if (board.playerAt(0,2) == ' ') {
                    board.playMove('O', 0,2);
                    return true;
                }
            }     
          
          //Corner 
          if(board.playerAt(0,1) == board.playerAt(1, 0) && board.playerAt(1,0) == 'X')
          {
              if (board.playerAt(0,0) == ' ') {
                    board.playMove('O', 0,0);
                    return true;
                }
          }
         
          if(board.playerAt(0,1) == board.playerAt(1, 2) && board.playerAt(0,1) == 'X')
          {
              if (board.playerAt(0,2) == ' ') {
                    board.playMove('O', 0,2);
                    return true;
                }
          }
          
          if(board.playerAt(1,0) == board.playerAt(2,1) && board.playerAt(1,0) == 'X')
          {
              if (board.playerAt(2,0) == ' ') {
                    board.playMove('O', 2,0);
                    return true;
                }
          }
          
          if(board.playerAt(1,2) == board.playerAt(2,1) && board.playerAt(1,2) == 'X')
          {
              if (board.playerAt(2,2) == ' ') {
                    board.playMove('O', 2,2);
                    return true;
                }
          }  
          return false;
    }
    
    /**
     * Plays a move in the first square it finds
     * @param board 
     */
    private static void AIFindMove(TicTacToe board)
    {
        if(board.playerAt(0,2) == 'X' && board.playerAt(2,0) == 'X' && board.playerAt(1,1) == 'O')
        {
            board.playMove('O', 1,0);
            return;
        }
        
        if(board.playerAt(0,0) == 'X' && board.playerAt(2,1) == 'X' && board.playerAt(1,1) == 'O')
        {
            board.playMove('O',1,0);
            return;
        }
        
        if(board.playerAt(0,2) == 'X' && board.playerAt(2,1) == 'X' && board.playerAt(1,1) =='O')
        {
            board.playMove('O',1,2);
            return;
        }
        
        if(board.playerAt(0,0) == 'X' && board.playerAt(1,1) == 'X')
        {
            board.playMove('O',2,0);
            return;
        }
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c<3; c++)
            {
                if(board.playerAt(r,c) == ' ')
                {
                    board.playMove('O',r,c);
                    return;
                }
            }
        }
    }
    
    /**
     * 
     * @param board 
     */
    public static void AIplayMove(TicTacToe board) {
            boolean isFirstMove =AIFirstMove(board);

            if (!isFirstMove) {
                boolean win = AIWinMove(board);
                if(!win)
                {
                    boolean success = AIBlock(board);
                    if(!success)
                    {
                    AIFindMove(board);
                    }
                }
            }
        }
    }