/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.queens.pkg3153;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Carrt
 */
public class Queens3153 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EightQueens game = new EightQueens();
        HillClimbing hillClimb = new HillClimbing(8);
        int currentHeuristic, totalResets = 0, totalMoves = 0, lowerH;

        //Place queens on board
        game.GenerateBoard();

        //print initial state
        System.out.println("Initial Game Board");
        game.printBoard();

        //check initial state
        currentHeuristic = hillClimb.CalculateHueristic(game);
        System.out.println("Initial h:" + currentHeuristic);

        //run hillclimb algorithm
        boolean cont = true;
        if (currentHeuristic == 0) {
            cont = false;
        }
        while (cont) {
            lowerH = 0;
            totalMoves++;

            //try moving queens around
            ArrayList<Node> nodes = hillClimb.moveQueens(game);
            Node lowestH = null;

            //find lowest heuristic
            for (Node n : nodes) {
                int h = n.getH();
                if (h == 0) {
                    cont = false;
                }
                if (h < currentHeuristic) {
                    lowerH++;
                    if (lowestH == null) {
                        lowestH = n;
                    } else if (lowestH.getH() > h) {
                        lowestH = n;
                    }
                }
            }

            if (lowerH == 0) { //reset
                totalResets++;
                //reset board
                game = new EightQueens();
                game.GenerateBoard();
                //print information
                System.out.println("\nCurrent h: " + currentHeuristic);
                game.printBoard();
                System.out.println("Neighbors found with lower h: " + lowerH);
                System.out.println("RESTART");;
                currentHeuristic = hillClimb.CalculateHueristic(game);
            } else { //update board;
                game.setQueen(lowestH.getQueenIndex(), lowestH.getQueen());
                currentHeuristic = lowestH.getH();
                //print board
                System.out.println("\nCurrent h: " + lowestH.getH());
                game.printBoard();
                //if game ended, say so
                if (currentHeuristic == 0) {
                    System.out.println("Solution Found!");
                    System.out.println("State Changes: " + totalMoves);
                    System.out.println("Restarts: " + totalResets);
                } else { //otherwise show neighbors
                    System.out.println("Neighbors found with lower h: " + lowerH);
                }

            }
        }
    }

}
