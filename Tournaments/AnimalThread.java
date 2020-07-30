package Tournaments;

import Animals.Animal;

/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * Animal Thread
 * 
 */

public class AnimalThread implements Runnable{
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;
    private Animal participant;
    private Boolean isStopped;
    public AnimalThread(Animal animal,double neededDistance,Boolean s,Boolean f){
        this.startFlag =s;
        this.finishFlag=f;
        this.isStopped=false;
        this.participant=animal;
        this.neededDistance=neededDistance;
    }

    public void run() {
        try {
            synchronized(startFlag){    
                while(!isStopped){
                    synchronized(participant){
                        if(participant.getTotalDistance() == neededDistance){
                            isStopped=true;
                            notify();
                            this.finishFlag=true;
                        }
                        else{
                            participant.addTotalDistance(1);
                        }
    
                    }
                }
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e); 
        }
     
    }
    public Boolean get_Finish(){
        return this.finishFlag;
    }
}