package project03.model;


/*
* Player.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 22th, 2015
*/
public class Player{
    private String name;
    private int discNumber;
    private boolean isBlack;
    private Board board;
    private Flipping moving;
    
    public Player(String name, boolean isBlack, Board board){
        this.board = board;
        this.name = name;
        this.isBlack = isBlack;
        discNumber = 32;
        moving = new Flipping(board, isBlack);
    }
    
    public void placeDisc(int x, String y)throws CustomException{
        try{
            if(!moving.legalMove(x, Rows.valueOf(y)))
                throw new CustomException("This is not a legal move.");
            if(discNumber == 0)
                throw new CustomException("There are no Discs left");
            board.addDisc(x, Rows.valueOf(y), isBlack);
            moving.flipping(x, Rows.valueOf(y));
            discNumber--;
        }
        catch(CustomException e){
            throw e;
        }
    }
    
    public void removeDisc(int x, String y)throws CustomException{
        try{    
            board.removeDisc(x, Rows.valueOf(y));
            discNumber++;
        }
        catch(CustomException e){
            throw e;
        }
    }
    
    public String getName(){
        return name;
    }
    
    public int getDiscNumber(){
        return discNumber;
    }
    
    public boolean getIsBlack(){
        return isBlack;
    }
    
    public void setBoard(Board theBoard){
        board = theBoard;
    }
    
    public Board getBoard(){
        return board;
    }
    
    public Flipping getMoving(){
        return moving;
    }
    
    public void setDiscNumber(int discNumber){
        this.discNumber = discNumber;
    }
    
    @Override
    public String toString(){
        if(isBlack)
            return name + " is Black and has " + discNumber + " discs left";
        else
            return name + " is White and has " + discNumber + " discs left";
    }
}
