package project03.GUI;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/*
* SquareGUI.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 22th, 2015
*/
public class SquareGUI extends JPanel{
    private String color;
    
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(200,200);
        SquareGUI square = new SquareGUI();
        square.setColor("white");
        frame.add(square);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public SquareGUI(){
        setBackground(new Color(25600));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    }
    
    public SquareGUI(String color){
        setBackground(new Color(25600));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        this.color = color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(color != null && color.equals("white")){
            g.setColor(Color.WHITE);
            g.fillOval(8,8,getWidth()-16, getHeight()-16);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(3));
            g2.drawOval(8,8,getWidth()-16, getHeight()-16);
        }
        else if(color != null && color.equals("black")){
            g.setColor(Color.BLACK);
            g.fillOval(8,8,getWidth()-16, getHeight()-16);
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
            g2.drawOval(8,8,getWidth()-16, getHeight()-16);
        }
    }
    
    
}
