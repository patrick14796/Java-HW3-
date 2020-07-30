/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * Courier Tournament
 * 
 */

package Tournaments;

import Animals.Animal;

public class CourierTournament extends Tournament {

    private Scores scores;
    private Boolean startFlag;
    private int n;



    public CourierTournament(Animal[][] arr) {
        super(arr);
    }

    public void Setup(Animal[][] arr) {
        this.startFlag=false;
        Referee[] referee = new Referee[arr.length];
        AnimalThread[] animalArray=new AnimalThread[arr.length];
        Boolean[] endFlag=new Boolean[arr.length];
        for(int i=0;i<arr.length;++i){
            this.n=arr[i].length;

            for(int j=0;j<arr[i].length;++j){
                endFlag[j]=new Boolean(false);
                animalArray[j]=new AnimalThread(arr[i][0],arr[i][0].getTotalDistance(),startFlag,endFlag[i]);
                referee[j]=new Referee("Team"+String.valueOf(i), scores,endFlag[i]);
            }
            
            }

    }
    

    public int get_Number_Of_Teams(){
        return this.n;
    }
}