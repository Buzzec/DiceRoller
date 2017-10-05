package com.buzzec.exceptions;

public class InvalidNumDice extends RuntimeException {
    private int num;
    
    public InvalidNumDice(int num){
        this.num = num;
    }
    
    @Override
    public String toString(){
        return "Invalid Number of Dice: " + num;
    }
}
