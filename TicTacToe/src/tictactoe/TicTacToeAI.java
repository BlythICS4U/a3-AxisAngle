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
    //Rule 1: if O has 2 cells in a row or occupied block it (defense)
    //Rule 2:Find any cell which allows the opponent create  2  rows with 2 cells (defense) 
    //Rule3: Find a  move so that you can create  at most 2 rows 
    //Rule 4:Priotize center cell if possible
    //Rule 5: Pick a corner cell if center is occupied
    public static void AIPlayMove(TicTacToe board) {
        //first move
        if (board.playerAt(0, 0) == 'X' || board.playerAt(0, 2) == 'X' || board.playerAt(2, 0) == 'X' || board.playerAt(2, 2) == 'X') {
            board.playMove('O', 1, 1);
        }
        if (board.playerAt(1, 1) == 'X') {
            board.playMove('O', 0, 1);
        } else {
            board.playMove('O', 1, 1);
        }
        }
    }

