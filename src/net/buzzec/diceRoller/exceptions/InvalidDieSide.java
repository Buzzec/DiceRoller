package net.buzzec.diceRoller.exceptions;

public class InvalidDieSide extends  RuntimeException{
    private int side;
    
    public InvalidDieSide(int side){
        this.side = side;
    }
    
    @Override
    public String toString(){
        return "Invalid Die Side: " + side;
    }
}
