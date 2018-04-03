package net.buzzec.diceRoller;

import net.buzzec.diceRoller.exceptions.InvalidDieSide;

public class Die{
    private int side;
    
    public Die(int input){
        setSide(input);
    }
    
    public void setSide(int input){
        if(input < 0 || input > 6){
            throw new InvalidDieSide(input);
        }
    
        side = input;
    }
    
    public int getSide(){
        return side;
    }
}