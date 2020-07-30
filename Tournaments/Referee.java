package Tournaments;

/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * Referee class implements Runnable
 */

public class Referee implements Runnable {

    private Boolean arrived=false;
    private String teamName;
    private Scores score;

    public Referee(String name,Scores Score,Boolean arrived){
        this.teamName=name;
        this.score=Score;
        this.arrived=arrived;
    }

    public void run() {
        if(arrived){
            score.add(teamName);
        }
    }
    
}