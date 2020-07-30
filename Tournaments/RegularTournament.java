package Tournaments;

import Animals.Animal;

/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * RegularTournament extends Tournament
 */

public class RegularTournament extends Tournament {
    private Scores scores;
    private Boolean startFlag;
    private int numberOfTeams;

    public RegularTournament(Animal[][] arr) {
        super(arr);
    }

    public void Setup(Animal[][] arr) {
        this.startFlag=false;
        Referee[] referee = new Referee[arr.length];
        AnimalThread[] animalArray=new AnimalThread[arr.length];
        Boolean[] endFlag=new Boolean[arr.length];
        for(int i=0;i<arr.length;++i){
        endFlag[i]=new Boolean(false);
        animalArray[i]=new AnimalThread(arr[i][0],arr[i][0].getTotalDistance(),startFlag,endFlag[i]);
        referee[i]=new Referee("Team"+String.valueOf(i), scores,endFlag[i]);
        }
        this.numberOfTeams=arr.length;

        
    }
    
    public int get_No_Of_Teams(){
        return this.numberOfTeams;
    }
}