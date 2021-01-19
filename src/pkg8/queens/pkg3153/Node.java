/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.queens.pkg3153;

/**
 *
 * @author Carrt
 */
public class Node {

    private int h;
    private int queenIndex;
    private Queen queen;

    public Node(int h, int queenIndex, Queen queen) {
        this.h = h;
        this.queenIndex = queenIndex;
        this.queen = queen;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getQueenIndex() {
        return queenIndex;
    }

    public void setQueenIndex(int queenIndex) {
        this.queenIndex = queenIndex;
    }

    public Queen getQueen() {
        return queen;
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
    }
    
    
}
