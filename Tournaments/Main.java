/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 */

package Tournaments;

import graphics.CompetitionFrame;




public class Main {
    public static void main(String[] args) {
        Tournament[] tur = new  Tournament[1];
        
        CompetitionFrame fr = new CompetitionFrame(tur);
        fr.display();
    }
}