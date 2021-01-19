/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.queens.pkg3153;

import java.util.Random;

/**
 *
 * @author Carrt
 */
public class EightQueens {

    private final static int dimension = 8; //change this for bigger board
    private int[][] board = new int[dimension][dimension]; //base board
    private Random r = new Random();
    private Queen[] queens = new Queen[dimension];

    public EightQueens() {
        //generate 0 on the board
        for (int i = 0; i < dimension; i++) {
            for (int g = 0; g < dimension; g++) {
                board[i][g] = 0;
            }
        }
    }

    public EightQueens(EightQueens dupe) {
        this.board = dupe.board;
        for (int i = 0; i < dimension; i++) {
            int[] pos = dupe.queens[i].getPosition();
            queens[i] = new Queen(pos[0], pos[1]);
        }
    }

    public void GenerateBoard() {
        for (int i = 0; i < dimension; i++) {
            boolean open = true;
            int x, y;
            do {
                x = r.nextInt(dimension);
                y = i;
                open = this.checkPosition(x, y); //false = spot taken
            } while (!open);
            queens[i] = new Queen(x, y);
            placeQueen(queens[i]);
        }
    }

    public void printBoard() {
        System.out.println("Current State");
        this.reDrawBoard();
        for (int i = 0; i < dimension; i++) {
            for (int g = 0; g < dimension; g++) {
                System.out.print(board[i][g] + " ");
            }
            System.out.print("\n");
        }
    }

    private void reDrawBoard() {
        for (int i = 0; i < dimension; i++) {
            for (int g = 0; g < dimension; g++) {
                board[i][g] = 0;
            }
        }
        for (Queen q : queens) {
            int[] pos = q.getPosition();
            board[pos[0]][pos[1]] = 1;
        }
    }

    public boolean checkPosition(int x, int y) {
        if (board[x][y] == 1) {
            return false;
        } else {
            return true;
        }
    }

    public void placeQueen(Queen queen) {
        int[] queenPos = queen.getPosition();
        board[queenPos[0]][queenPos[1]] = 1;
    }

    /*
    I really hope I did this right in terms of what we are supposed to do.
    Basically:
    Every queen is checked to get the current heuristic value
    it first checks the row for other queens, then it checks diagnals
    if at any point a queen is seen in another row/diagnal, this method returns false
    when it returns false, the current herustic value adds 1.
     */
    public boolean checkQueen(int queen) {
        Queen q = queens[queen];
        this.reDrawBoard();
        int[] pos = q.getPosition();

        //check row
        for (int i = 0; i < dimension; i++) {
            //ignore current row
            if (i == pos[1]) {
                continue;
            }
            if (board[pos[0]][i] == 1) {
                return false;
            }
        }

        //check diagnals
        boolean cont;
        int x, y;
        //-,-
        cont = true;
        x = pos[0];
        y = pos[1];
        do {
            x--;
            y--;
            if (x >= dimension || x < 0 || y >= dimension || y < 0) {
                cont = false;
            } else {
                if (board[x][y] == 1) {
                    return false;
                }
            }
        } while (cont);
        //+,-
        cont = true;
        x = pos[0];
        y = pos[1];
        do {
            x++;
            y--;
            if (x >= dimension || x < 0 || y >= dimension || y < 0) {
                cont = false;
            } else {
                if (board[x][y] == 1) {
                    return false;
                }
            }
        } while (cont);
        //+,+
        cont = true;
        x = pos[0];
        y = pos[1];
        do {
            x++;
            y++;
            if (x >= dimension || x < 0 || y >= dimension || y < 0) {
                cont = false;
            } else {
                if (board[x][y] == 1) {
                    return false;
                }
            }
        } while (cont);
        //-,+
        cont = true;
        x = pos[0];
        y = pos[1];
        do {
            x--;
            y++;
            if (x >= dimension || x < 0 || y >= dimension || y < 0) {
                cont = false;
            } else {
                if (board[x][y] == 1) {
                    return false;
                }
            }
        } while (cont);

        return true;
    }

    public void moveQueen(int Queen, int row) {
        queens[Queen].setX(row);
        this.reDrawBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    public Queen getQueen(int queenIndex) {
        return queens[queenIndex];
    }

    public void setQueen(int queenIndex, Queen queen) {
        queens[queenIndex] = queen;
        this.reDrawBoard();
    }

}
