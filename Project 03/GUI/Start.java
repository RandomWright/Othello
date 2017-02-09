package project03.GUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project03.model.*;

/*
* Start.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: May 2nd, 2015
*/
public class Start {
    
    public Start(){
        boolean customRules;
        String p1 = JOptionPane.showInputDialog(new JFrame(), "What is Player 1's name?", null);
        String p2 = JOptionPane.showInputDialog(new JFrame(), "What is Player 2's name?", null);
        
        int rules = JOptionPane.showConfirmDialog(new JFrame(), "Custom Rules?");
        if(rules == JOptionPane.YES_OPTION)
            customRules = true;
        else
            customRules = false;
        
        Board board = new Board();
        Othello othelloBoard = new Othello(board, new Player(p1, true, board), new Player(p2, false, board), customRules);
        othelloBoard.setVisible(true);
        othelloBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
