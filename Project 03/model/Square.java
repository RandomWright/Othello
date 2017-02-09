package project03.model;

/*
* Square.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 21st, 2015
*/
public class Square{
    private Disc disc;
    
    public Square(){
        this.disc = null;
    }
    
    public Square(Disc disc){
        this.disc = disc;
    }
    
    public Disc getDisc(){
        return disc;
    }
    
    public void setDisc(Disc disc){
        this.disc = disc;
    }
    
    public void addDisc(boolean isBlack) throws CustomException{
        if(isEmpty())
            this.disc = new Disc(isBlack);
        else
            throw new CustomException("There is already a Disc there");
    }

    public void addDisc(Disc disc) throws CustomException{
        if(isEmpty())
            this.disc = disc;
        else
            throw new CustomException("There is already a Disc there");
    }
    
    public void removeDisc() throws CustomException{
        if(!isEmpty())
            this.disc = null;
        else
            throw new CustomException("There is no Disc there");
    }
    
    public boolean isEmpty(){
        if(disc == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        if(isEmpty())
            return "Empty Square";
        else
            return "A " + disc;
    }
}
