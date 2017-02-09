package project03.tests;
import project03.controller.*;
import project03.model.*;
import project03.GUI.*;
import java.util.Scanner;
import javax.swing.JFrame;

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
public class MasterMindTest1{
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        BoardGUI board = new BoardGUI(new Board(),new JFrame());
        System.out.println("TEST");
        Player test = new Player("P1", true, board.getBoard());
        Player test2 = new Player("P2", false, board.getBoard());
        board.create();
        board.setClicks(new Clicks(test, test2, false));
        String one = input.next();
        board.MyRepaint(board.getBoard());
        try{
            test.placeDisc(2,"D");
            board.repaint();
            
            one = input.next();
            
            test2.placeDisc(4,"C");
            board.repaint();
            
            one = input.next();
            
            test.placeDisc(5,"E");
            board.repaint();
            
            one = input.next();
            
            test2.placeDisc(1,"D");
            board.repaint();
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }
}
