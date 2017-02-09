package project03.model;


/*
* CustomException.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 22th, 2015
*/
public class CustomException extends Exception{
    private String message;
    
    public CustomException(String message){
        super(message);
        this.message = message;
    }

    @Override 
    public String toString(){
        return message;
    }

}

