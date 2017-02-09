package project03.GUI;
import project03.model.*;
import javax.swing.*;
import java.awt.*;

/*
* PlayerGUI.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: April 23th, 2015
*/
public class PlayerGUI extends JPanel{
    private Player player;
    
    public static void main(String[] args){
        Player pl = new Player("Player 1", true, new Board());
        pl.setDiscNumber(28);
        PlayerGUI test = new PlayerGUI(pl);
        JFrame frame = new JFrame();
        frame.setSize(300,500);
        frame.add(test);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public PlayerGUI(Player player){
        this.player = player;
        
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel name = new JLabel(player.getName());
        name.setFont(new Font("Serif", Font.BOLD, 28));
        name.setAlignmentX(CENTER_ALIGNMENT);
        add(name);
        
        String color;
        if(player.getIsBlack())
            color = "Black";
        else
            color = "White";
        
        JLabel colorLabel = new JLabel(color);
        add(colorLabel);
        
        JPanel PFrame = new JPanel();
        JPanel pieces = new JPanel();
        pieces.setPreferredSize(new Dimension(150, 350));
        pieces.setLayout(new GridLayout(32,1));
        
        boolean isBlack = player.getIsBlack();
        for(int i = 1; i <= player.getDiscNumber(); i++){
            if(isBlack){
                JPanel one = new JPanel();
                one.setBackground(Color.BLACK);
                pieces.add(one);
            }
            else{
                JPanel two = new JPanel();
                two.setBackground(Color.WHITE);
                pieces.add(two);
            }
            isBlack = !isBlack;
        }
        for(int j = 1; j <= 32 - player.getDiscNumber(); j++){
            JPanel three = new JPanel();
            three.setBackground(Color.GRAY);
            pieces.add(three);
        }
        PFrame.add(pieces, BorderLayout.CENTER);
        
        JPanel blank = new JPanel();
        PFrame.add(blank, BorderLayout.LINE_START);
        PFrame.add(blank, BorderLayout.LINE_END);
        
        add(PFrame);
    }
    
    public Player getPlayer(){
        return player;
    }

}
