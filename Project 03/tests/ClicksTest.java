package project03.tests;
import project03.model.*;
import project03.controller.Clicks;

/*
* ClicksTest.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: May 1st, 2015
*/
public class ClicksTest{
    
    public static void main(String[] args){
        Board board = new Board();
        Clicks clicks = new Clicks(new Player("One", true, board), new Player("Two", false, board), false);
    }
}
