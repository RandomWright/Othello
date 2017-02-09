package project03.GUI;
import javax.swing.*;
import java.awt.*;
import project03.model.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import project03.controller.*;

/*
* BoardGUI.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 22th, 2015
*/
public class BoardGUI extends JPanel implements MouseListener{
    public BiNodeTree numbers;
    public BiNodeTree letters;
    public Clicks clicks;
    public Board board = new Board();
    public Square[][] squares;
    public JFrame frame;
    public String text = "";
    
    public static void main(String[] args){
        Board theBoard = new Board();
        BoardGUI board = new BoardGUI(theBoard, new JFrame());
        board.setClicks(new Clicks(new Player("One", true, theBoard), new Player("Two", false, theBoard), false));
        board.create();
    }
    
    public void create(){
        //frame = new JFrame();
        frame.setSize(800,800);
        //frame.setResizable(false);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public BoardGUI(Board theBoard, JFrame frame){
        this.frame = frame;
        this.board = theBoard;
        setSize(800,800);
        numbers = new BiNodeTree(getWidth());
        letters = new BiNodeTree(getHeight());
        setLayout(new GridLayout(8,8));
        addMouseListener(this);
        for(int i = 0; i<64; i++){
            SquareGUI square = new SquareGUI();
            add(square);
        }
    }
    
    public void setClicks(Clicks clicks){
        this.clicks = clicks;
    }
    
    public Clicks getClicks(){
        return clicks;
    }
    
    @Override
    public void mouseClicked( MouseEvent event) {
        //System.out.println(event.getX() + " " + event.getXOnScreen());
        //System.out.println(event.getY() + " " + event.getYOnScreen());
        int x = letters.searchFromTop(event.getX());
        //System.out.println(x);
        int y = letters.searchFromTop(event.getY());
        //System.out.println(y);
        
        clicks.clickSquare( x , y );
        
        MyRepaint(board);
      
    }
    
    public String getText(){
        return text;
    }
    
    @Override
    public void mousePressed( MouseEvent e){
        
    }
    
    @Override  
    public void mouseEntered(MouseEvent e){
        
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        
    }
   
    public void MyRepaint(Board aBoard){ 
        removeAll();
        Square[][] squares = aBoard.getSquareBoard();
        
        for(int i = squares.length - 1; i >= 0; i--) {
            for(int j = 0; j < squares.length; j++) {
                if(squares[j][i].getDisc() == null)
                    add(new SquareGUI());
                else if(squares[j][i].getDisc().getIsBlack())
                    add(new SquareGUI("black"));
                else if(!squares[j][i].getDisc().getIsBlack())
                    add(new SquareGUI("white"));
            }
        }
        frame.setVisible(true);
    }
    
    public void setBoard(Board board){
        this.board = board;
    }
    
    public Board getBoard(){
        return board;
    }
}
