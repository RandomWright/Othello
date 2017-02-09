package project03.GUI;

/*
* BiNodeTree.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 30th, 2015
*/
public class BiNodeTree{
    private BiNode top;
    
    public BiNodeTree(double size){
        double section = size/8;
        BiNode[] list = new BiNode[8];
        
        double create = 20;
        for(int i = 0; i < 8; i++){
            list[i] = new BiNode(i, create, create + section);
            create += section;
        }
        
        list[3].setRight(list[5]);
        list[3].setLeft(list[1]);
        list[1].setRight(list[2]);
        list[1].setLeft(list[0]);
        list[5].setRight(list[6]);
        list[5].setLeft(list[4]);
        list[6].setRight(list[7]);
        
        top = list[3];
    }
    
    public BiNode getTop(){
        return top;
    }
    
    public int searchFromTop(double click){
        return search(top, click);
    }
    
    public int search(BiNode point, double click){
        try{
            if(click > point.getMax() )
                return search(point.getRight(), click);
            else if(click < point.getMin() )
                return search(point.getLeft(), click);
            else
                return point.getValue();
        }
        catch(NullPointerException e){
            System.out.print("Null Pointer");
            return 0;
        }
    }

}
