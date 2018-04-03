package net.buzzec.diceRoller;

import com.buzzec.exceptions.*;
import com.buzzec.loggger.*;
import net.buzzec.diceRoller.exceptions.InvalidNumDice;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class DieRoller{
    private Random random;
    private ArrayList<Die> lastRoll;
    private Logger logger;
    
    public DieRoller(long seed){
        random = new Random(seed);
        lastRoll = new ArrayList<>();
    }
    
    public DieRoller(){
        random = new Random();
        lastRoll = new ArrayList<>();
    }
    
    public ArrayList<Die> rollDice(int numDice){
        if(numDice < 1){
            throw new InvalidNumDice(numDice);
        }
        
        lastRoll = new ArrayList<>();
        
        for(int x = 0; x < numDice; x++){
            lastRoll.add(rollDice());
        }
        
        return lastRoll;
    }
    
    public ArrayList<Die> getLastRoll(){
        return lastRoll;
    }
    
    public Die rollDice(){
        int roll = abs(random.nextInt()) % 6 + 1;
        logger.log("Rolled: " + roll, LogLevel.INFO);
        return new Die(roll);
    }
}
