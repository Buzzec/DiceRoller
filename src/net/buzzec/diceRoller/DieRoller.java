package net.buzzec.diceRoller;

import net.buzzec.diceRoller.exceptions.InvalidNumDice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

@SuppressWarnings({"WeakerAccess", "unused"})
public class DieRoller{
    private Random random;
    private ArrayList<Die> lastRoll;
    private Logger logger = LoggerFactory.getLogger(DieRoller.class);
    
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
        logger.info("Rolled: " + roll);
        return new Die(roll);
    }
}
