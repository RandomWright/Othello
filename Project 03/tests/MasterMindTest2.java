package project03.tests;
import project03.controller.*;
import project03.model.*;
import project03.GUI.*;
import javax.swing.*;

/*
* MasterMindTest2.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: May 1st, 2015
*/
public class MasterMindTest2{
    public static void main(String[] args){
        System.out.println("TEST");
        
        Board theBoard = new Board();
        
        Player test = new Player("P1", true, theBoard);
        Player test2 = new Player("P2", false, theBoard);
        
        BoardGUI board = new BoardGUI(theBoard, new JFrame());
        board.create();
        board.setClicks(new Clicks(test, test2, false));
        
        
        board.MyRepaint(theBoard);
        
    }
}
