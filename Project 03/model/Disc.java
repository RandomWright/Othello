package project03.model;


/**
 * @Charlotte Wright 
 * @4/21/2015
 */
public class Disc{
    private boolean isBlack;

    public Disc(boolean isBlack){
        this.isBlack = isBlack;
    }
    
    public boolean getIsBlack(){
        return isBlack;
    }
    
    public void setIsBlack(boolean isBlack){
        this.isBlack = isBlack;
    }
    
    public void flip(){
        isBlack = !isBlack;
    }
    
    @Override
    public String toString(){
        if(isBlack)
            return "Black Disc";
        else
            return "White Disc";
    }

}
