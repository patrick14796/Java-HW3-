package Tournaments;

/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * Scores class
 */


import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scores {

    private  Map<String, Date> scores=Collections.synchronizedMap(new HashMap<>());
    LocalDate date = LocalDate.now();  


    //adding current time to score string 
    public void add(String name){
        scores.put(name, Date.valueOf(date));
    }
    //returng time with scores 
    public  Map<String, Date> getALL(){
        return this.scores;
        
    }
}