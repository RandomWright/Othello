package project03.GUI;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import project03.model.*;
import project03.controller.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/*
* Othello.java
* Version 1.0
* Copyright Charlotte
* Course: CSC 171 SPRING 2015
* Assignment: Project 03
* Author: Charlotte Wright
* Lab Session: Monday/Wednesday 12:30-13:45
* Lab TA: Wilfred Wallis
* Last Revised: May 1st, 2015
*/
public class Othello extends JFrame implements ActionListener{
    private BoardGUI board;
    private JLabel text;
    private PlayerGUI P1;
    private PlayerGUI P2;
    
    public static void main(String[] args){
        Board board = new Board();
        Othello test = new Othello(board, new Player("Player 1", true, board), new Player("Player 2", false, board), false);
        test.setVisible(true);
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public Othello(Board theBoard, Player one, Player two, boolean customRules){
        setSize(800,800);
        board = new BoardGUI(theBoard, this);
        
        add(board, BorderLayout.CENTER);
        board.setClicks(new Clicks(one, two, customRules));
        P1 = new PlayerGUI(one);
        P2 = new PlayerGUI(two);
        add(P1, BorderLayout.WEST);
        add(P2, BorderLayout.EAST);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        text = new JLabel();
        
        JButton movesButton = new JButton("Check for Legal Moves");
        movesButton.setActionCommand("legal");
        movesButton.addActionListener(this);
        
        JButton end = new JButton("End Game");
        end.setActionCommand("end");
        end.addActionListener(this);
        
        JButton rules = new JButton("The Rules");
        rules.setActionCommand("rules");
        rules.addActionListener(this);
        
        panel.add(rules);
        panel.add(text);
        panel.add(movesButton);
        panel.add(end);
        
        add(panel, BorderLayout.SOUTH);
        
        setSize(1200, 900);
        
        board.MyRepaint(theBoard);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getActionCommand().equals("legal")){
            if(board.getClicks().isBlacksTurn()){
                if(P1.getPlayer().getMoving().colorLegalMoves(true)){
                    text.setText("There are legal Black moves left");
                }
                else if(P1.getPlayer().getMoving().anyLegalMoves()){
                    board.getClicks().getIsBlacksTurn(false);
                    text.setText("There are legal White moves left");
                }
                else
                    text.setText("There are No Legal Moves");
            }
            else{
                if(P2.getPlayer().getMoving().colorLegalMoves(false)){
                    text.setText("There are legal White moves left");
                }
                else if(P1.getPlayer().getMoving().anyLegalMoves()){
                    board.getClicks().getIsBlacksTurn(true);
                    text.setText("There are legal Black moves left");
                }
                else{
                    text.setText("There are No Legal Moves");
                    JOptionPane.showMessageDialog(new JFrame(),"Game Over \n" + board.getBoard().wins());
                    System.exit(0);
                }
            }
        }
        if(event.getActionCommand().equals("end")){
            JOptionPane.showMessageDialog(new JFrame(),"Game Over \n" + board.getBoard().wins());
            System.exit(0);
        }
        if(event.getActionCommand().equals("rules")){
            JOptionPane.showMessageDialog(new JFrame(),getRules());
        }
    }
    
    public String getRules(){
        String message = "";
        message += "Othello Rules\n";
        message += "1. Black always moves first.\n";
        message += "2. If on your turn you cannot outflank and flip at least one opposing disc, your turn is forfeited and your opponent moves again. However, if a move is available to you, you may not forfeit your turn.\n";
        message += "3. A disc may outflank any number of discs in one or more rows in any number of directions at the same time - horizontally, vertically or diagonally. (A row is defined as one or more discs in a continuous straight line ).\n";
        message += "4. You may not skip over your own colour disc to outflank an opposing disc.\n";
        message += "5. Discs may only be outflanked as a direct result of a move and must fall in the direct line of the disc placed down.\n";
        message += "6. All discs outflanked in any one move must be flipped, even if it is to the player's advantage not to flip them at all.\n";
        message += "7. A player who flips a disc which should not have been turned may correct the mistake as long as the opponent has not made a subsequent move. If the opponent has already moved, it is too late to change and the disc(s) remain as is.\n";
        message += "8. Once a disc is placed on a square, it can never be moved to another square later in the game.";
        message += "9. If a player runs out of discs, but still has an opportunity to outflank an opposing disc on his or her turn, the opponent must give the player a disc to use. (This can happen as many times as the player needs and can use a disc).\n";
        message += "10. When it is no longer possible for either player to move, the game is over. Discs are counted and the player with the majority of his or her colour discs on the board is the winner.\n";
        message += "CUSTOM RULE: A Player can remove any disc from the board as their turn";
        return message;
    }
}
