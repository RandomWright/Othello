package project03.model;


/*
* Flipping.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 22th, 2015
*/
public class Flipping{
    private static Board board;
    private boolean isBlack;
    
    public Flipping(Board board, boolean isBlack){
        this.board = board;
        this.isBlack = isBlack;
    }
    
    public boolean anyLegalMoves(){
        if(colorLegalMoves(true))
            return true;
        else if(colorLegalMoves(false))
            return true;
        else
            return false;
    }
    
    public boolean colorLegalMoves(boolean isBlack){
        Square[][] theBoard = board.getSquareBoard();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(legalMove(i,Rows.values()[j])){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean legalMove(int x, Rows y){
        if(right(x,y) || left(x,y) || up(x,y) || down(x,y))
            return true;
        else if(upRight(x,y) || upLeft(x,y) || downRight(x,y) || downLeft(x,y))
            return true;
        else
            return false;
    }
    
    public void flipping(int x, Rows y)throws CustomException{
        if(legalMove(x,y)){
            int a;// = x;
            int b;// = y.ordinal();
            if(right(x,y)){
                a = x + 1;
                b = y.ordinal();
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    a += 1;
                }
            }
            if(left(x,y)){
                a = x - 1;
                b = y.ordinal();
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    a -= 1;
                }
            }
            if(up(x,y)){
                a = x;
                b = y.ordinal() + 1;
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    b += 1;
                }
            }
            if(down(x,y)){
                a = x;
                b = y.ordinal() - 1;
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    b -= 1;
                }
            }
            if(upRight(x,y)){
                a = x + 1;
                b = y.ordinal() + 1;
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    a += 1;
                    b += 1;
                }
            }
            if(upLeft(x,y)){
                a = x - 1;
                b = y.ordinal() + 1;
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    a -= 1;
                    b += 1;
                }
            }
            if(downRight(x,y)){
                a = x + 1;
                b = y.ordinal() - 1;
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    a += 1;
                    b -= 1;
                }
            }
            if(downLeft(x,y)){
                a = x - 1;
                b = y.ordinal() - 1;
                while(board.getSquare(a,b).getDisc().getIsBlack() != isBlack){
                    board.getSquare(a,b).getDisc().flip();
                    a -= 1;
                    b -= 1;
                }
            }
        }
        else
            throw new CustomException("This movie is not legal");
    }
    
    public boolean right(int x, Rows y){
        if(x + 1 > 7 || board.getSquare(x + 1, y.ordinal()).isEmpty())
            return false;
        else if(board.getSquare(x + 1, y.ordinal()).getDisc().getIsBlack() == isBlack)
            return false;
        else{
            for(int i = x + 2; i < board.getRowLength(); i++){
                if(board.getSquare(i, y).isEmpty())
                    return false;
                else if(board.getSquare(i, y).getDisc().getIsBlack() == isBlack)
                    return true;
            }
            return false;
        }
    }
    
    public boolean left(int x, Rows y){
        if(x - 1 < 0 || board.getSquare(x - 1, y.ordinal()).isEmpty() || board.getSquare(x - 1, y.ordinal()).getDisc().getIsBlack() == isBlack)
                return false;
        else{
            for(int i = x - 2; i >= 0; i--){
                if(board.getSquare(i, y).isEmpty())
                    return false;
                else if(board.getSquare(i, y).getDisc().getIsBlack() == isBlack)
                    return true;
            }
            return false;
        }
    }
    
    public boolean up(int x, Rows y){
        if(y.ordinal() + 1 > 7 || board.getSquare(x, y.ordinal() + 1).isEmpty())
            return false;
        else if(board.getSquare(x, y.ordinal() + 1).getDisc().getIsBlack() == isBlack)
             return false;
        else{
            for(int i = y.ordinal() + 2; i < board.getRowLength(); i++){
                if(board.getSquare(x, i).isEmpty())
                    return false;
                else if(board.getSquare(x, i).getDisc().getIsBlack() == isBlack)
                    return true;
            }
            return false;
        }
    }
    
    public boolean down(int x, Rows y){
        if(y.ordinal() - 1 < 0 || board.getSquare(x, y.ordinal() - 1).isEmpty())
            return false;
        else if(board.getSquare(x, y.ordinal() - 1).getDisc().getIsBlack() == isBlack)
            return false;
        else{
            for(int i = y.ordinal() - 2; i >= 0; i--){
                if(board.getSquare(x, i).isEmpty())
                    return false;
                else if(board.getSquare(x, i).getDisc().getIsBlack() == isBlack)
                    return true;
            }
            return false;
        }
    }
    
    public boolean upRight(int x, Rows y){
        if(x + 1 > 7 || y.ordinal() + 1 > 7 || board.getSquare(x + 1, y.ordinal() + 1).isEmpty())
            return false;
        else if(board.getSquare(x + 1, y.ordinal() + 1).getDisc().getIsBlack() == isBlack)
            return false;
        else{
            int j = y.ordinal() + 2;
            for(int i = x + 2; i < board.getRowLength() && j < board.getRowLength(); i++){
                if(board.getSquare(i, j).isEmpty())
                    return false;
                else if(board.getSquare(i, j).getDisc().getIsBlack() == isBlack)
                    return true;
                j++;
            }
            return false;
        }
    }
    
    public boolean upLeft(int x, Rows y){
        if(x - 1 < 0 || y.ordinal() + 1 > 7 || board.getSquare(x - 1, y.ordinal() + 1).isEmpty())
            return false;
        else if(board.getSquare(x - 1, y.ordinal() + 1).getDisc().getIsBlack() != isBlack)
            return false;
        else{
            int j = y.ordinal() + 2;
            for(int i = x - 2; i >= 0 && j < board.getRowLength(); i--){
                if(board.getSquare(i, j).isEmpty())
                    return false;
                else if(board.getSquare(i, j).getDisc().getIsBlack() == isBlack)
                    return true;
                j++;
            }
            return false;
        }
    }
    
    public boolean downRight(int x, Rows y){
        if(x + 1 > 7 || y.ordinal() - 1 < 0 || board.getSquare(x + 1, y.ordinal() - 1).isEmpty())
            return false;
        else if(board.getSquare(x + 1, y.ordinal() - 1).getDisc().getIsBlack() == isBlack)
            return false;
        else{
            int j = y.ordinal() - 2;
            for(int i = x + 2; i < board.getRowLength() && j >= 0; i++){
                if(board.getSquare(i, j).isEmpty())
                    return false;
                else if(board.getSquare(i, j).getDisc().getIsBlack() == isBlack)
                    return true;
                j--;
            }
            return false;
        }
    }
    
    public boolean downLeft(int x, Rows y){
        if(x - 1 < 0 || y.ordinal() - 1 < 0 || board.getSquare(x - 1, y.ordinal() - 1).isEmpty())
            return false;
        else if(board.getSquare(x - 1, y.ordinal() - 1).getDisc().getIsBlack() == isBlack)
            return false;
        else{
            int j = y.ordinal() - 2;
            for(int i = x - 2; i >= 0 && j >= 0; i--){
                if(board.getSquare(i, j).isEmpty())
                    return false;
                else if(board.getSquare(i, j).getDisc().getIsBlack() == isBlack)
                    return true;
                j--;
            }
            return false;
        }
    }
}
