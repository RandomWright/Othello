package project03.model;


/*
* Board.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 22th, 2015
*/
public class Board{
    private Square[][] board;
    
    public Board(){
        board = new Square[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Square();
            }
        }
        
        board[3][3] = new Square(new Disc(true));
        board[3][4] = new Square(new Disc(false));
        board[4][3] = new Square(new Disc(false));
        board[4][4] = new Square(new Disc(true));
    }
    
    public Square[][] getSquareBoard(){
        return board;
    }
    
    public Square getSquare(int x, Rows y){
        return board[x][y.ordinal()];
    }
    
    public Square getSquare(int x, int y){
        return board[x][y];
    }
    
    public void addDisc(int x, Rows y, boolean isBlack)throws CustomException{
        try{
            board[x][y.ordinal()].addDisc(isBlack);
        }
        catch(CustomException disc){
            throw disc;
        }
    }
    
    public void removeDisc(int x, Rows y)throws CustomException{
        try{
            board[x][y.ordinal()].removeDisc();
        }
        catch(CustomException disc){
            throw disc;
        }
    }
    
    public int getRowLength(){
        return board[0].length;
    }
    
    private String rowToString( Square[] row ) {
        String message = "";
        for(int i = 0; i < row.length; i++) {
            message = message + "| " + row[i].toString() + " |";
        }
        return message;
    }
    
    public String wins(){
        if(counter(true) > counter(false))
            return "Black Wins!!!";
        else if(counter(true) < counter(false))
            return "White Wins!!!";
        else
            return "Tie";
    }
    
    public int counter(boolean isBlack){
        int add = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].isEmpty())
                    add = add;
                else if(board[i][j].getDisc().getIsBlack() == isBlack)
                    add++;
            }
        }
        return add;
    }
    
    @Override
    public String toString(){
        String message = "";
        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board.length; j++) {
                message += "| " + board[j][i] + " |";
            }
            message += "\n";
        }
        return message;
    }
}
