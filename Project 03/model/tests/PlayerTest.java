package project03.model.tests;
import project03.model.*;

public class PlayerTest{
    
    public static void main(String[] args){
        Board board = new Board();
        Player test = new Player("P1", true, board);
        Player test2 = new Player("P2", false, board);
        
        System.out.println(test);
        try{
            test.placeDisc(2,"E");
            System.out.println(test.getBoard());
            System.out.println(test);
            test2.placeDisc(4,"F");
            System.out.println(test.getBoard());
            System.out.println(test2);
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }
}
