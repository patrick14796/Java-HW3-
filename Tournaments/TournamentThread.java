/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 *  TournamentThread implements Runnable
 */

package Tournaments;


public class TournamentThread implements Runnable {

    private Scores scores;
    private Boolean startSignal;
    private int groups;

    public TournamentThread(){
        this.startSignal=true;
    }

    public void run() {
        synchronized(startSignal){
            notifyAll();
        }
        scores.getALL();
    }

    public int get_Groups(){
        return this.groups;
    }
    
} 