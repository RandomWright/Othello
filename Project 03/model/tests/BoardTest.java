package project03.model.tests;
import project03.model.*;

public class BoardTest{
    
    public static void main(String[] args){
        Board test = new Board();
        try{
            test.addDisc(0, Rows.A, true);
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
    
        System.out.print(test);
    }
}
