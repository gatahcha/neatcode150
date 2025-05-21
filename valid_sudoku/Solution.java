package valid_sudoku;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        //checking horizontal
        boolean validX = validHorizontal(board);

        //valid per 3x3
        boolean valid3x3 = valid3x3(board);

        //checking vertical
        boolean validY = validVertical(board);

        return validX && validY && valid3x3;
    }

    public boolean validStr(char[] str){
        
        //using hashtable
        boolean[] hashtable = new boolean[9];

        for (char checkChar : str){
            if (checkChar != '.') {
                if (hashtable[checkChar - '1'] == true){
                    return false;
                }
                else {
                    hashtable[checkChar - '1'] = true;
                }
            }
        }
        return true;
    } 

    public boolean validHorizontal(char[][] board){

        //check valid perhorizontal
        for (char[] k : board){
            if (validStr(k) == false) return false;
        }

        return true;
    }

    public char[][] rotateSudoku(char[][] board){
        for (int i = 0 ; i < 9; i++){
            for (int j = i ; j < 9; j++){
                char temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
        return board;
    }

    public boolean validVertical(char[][] board){

        //check valid pervertical
        //rotation
        char[][] rotated = rotateSudoku(board);

        //check valid perhorizontal
        for (char[] k : rotated){
            if (validStr(k) == false) return false;
        }

        return true;
    }

    public boolean valid3x3(char[][] board){

        for (int i=0; i<3; i++){
            for ( int j = 0; j< 3; j++){
                char[] checkStr = new char[9];
                for (int indexX = 0 ; indexX < 3; indexX++){
                    for (int indexY = 0 ; indexY < 3; indexY++){
                        checkStr[3*indexX + indexY] = (board[3*i + indexX][3*j+indexY]);
                    }
                }
                if (validStr(checkStr) == false) return false;
            }
        }
        return true;
    }
}
