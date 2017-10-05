package com.buzzec;

import com.buzzec.exceptions.*;

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