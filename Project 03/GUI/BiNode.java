package project03.GUI;

/*
* BiNode.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 30th, 2015
*/
public class BiNode{
    private double max;
    private double min;
    private int value;
    private BiNode right;
    private BiNode left;
    
    public BiNode(){
        
    }
    
    public BiNode(int value, double min, double max){
        this.value = value;
        this.min = min;
        this.max = max;
    }
    
    public void setRight(BiNode right){
        this.right = right;
    }
    
    public void setLeft(BiNode left){
        this.left = left;
    }
    
    public double getMax(){
        return max;
    }
    
    public double getMin(){
        return min;
    }
    
    public int getValue(){
        return value;
    }
    
    public BiNode getRight(){
        return right;
    }
    
    public BiNode getLeft(){
        return left;
    }
}
