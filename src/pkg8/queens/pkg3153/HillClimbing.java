/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.queens.pkg3153;

import java.util.ArrayList;

/**
 *
 * @author Carrt
 */
public class HillClimbing {

    private int size;

    public HillClimbing(int dimension) {
        this.size = dimension;
    }

    public int CalculateHueristic(EightQueens board) {
        int hueristicValue = 0;
        for (int i = 0; i < size; i++) {
            if (!board.checkQueen(i)) { //true = queen is valid
                hueristicValue++;
            }
        }
        return hueristicValue;
    }

    public ArrayList<Node> moveQueens(EightQueens board) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        //loop through all queens
        for (int i = 0; i < size; i++) {
            //loop through different rows
            for (int g = 0; g < size; g++) {
                EightQueens temp = new EightQueens(board);
                temp.moveQueen(i, g);
                int Heuristic = this.CalculateHueristic(temp);
                nodes.add(new Node(Heuristic, i, temp.getQueen(i)));
            }
        }

        return nodes;
    }
}
