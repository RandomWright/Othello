package project03.controller;
import project03.model.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
* Clicks.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 26th, 2015
*/
public class Clicks{
    private Player one;
    private Player two;
    private boolean isBlacksTurn;
    private boolean customRules;

    public Clicks(Player one, Player two, boolean customRules){
        this.one = one;
        this.two = two;
        this.customRules = customRules;
        isBlacksTurn = true;
    }
    
    public Board getBoard(){
        return one.getBoard();
    }
    
    public boolean isBlacksTurn(){
        return isBlacksTurn;
    }
    
    public void getIsBlacksTurn(boolean isBlacksTurn){
        this.isBlacksTurn = isBlacksTurn;
    }
    
    private String yToString(int Y){
        String yString = "A";
        switch(Y){
            case 0: yString = "H";
            break;
            case 1: yString = "G";
            break;
            case 2: yString = "F";
            break;
            case 3: yString = "E";
            break;
            case 4: yString = "D";
            break;
            case 5: yString = "C";
            break;
            case 6: yString = "B";
            break;
            case 7: yString = "A";
            break;
        }
        return yString;
    }

    public void clickSquare(int x, int y){
        if(customRules && !one.getBoard().getSquare(x,y).isEmpty()){
            try{
                if(isBlacksTurn){
                    one.removeDisc( x , yToString(y));
                }
                else
                    two.removeDisc(  x , yToString(y));
                isBlacksTurn = !isBlacksTurn;
            }
            catch(CustomException e){
                 JOptionPane.showMessageDialog(new JFrame(),"Exception: " + e.toString());
            }
        }
        else{
            try{
                if(isBlacksTurn){
                    one.placeDisc( x , yToString(y));
                }
                else
                    two.placeDisc(  x , yToString(y));
                isBlacksTurn = !isBlacksTurn;
            }
            catch(CustomException e){
                 JOptionPane.showMessageDialog(new JFrame(),"Exception: " + e.toString());
            }
        
        }
    }
}
