package Tournaments;
/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 *  Tournament class
 */
import Animals.Animal;

public abstract class Tournament {

    protected TournamentThread tournamentThread;

    //constructor gets animal two dimensional array
    public Tournament(Animal[][] arr){
        this.Setup(arr);
    } 


    public abstract void Setup(Animal[][] arr);
    

    //Return tournament thread
    public TournamentThread get_Tournament_Thread(){
        return this.tournamentThread;
    }


}