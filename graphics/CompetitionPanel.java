/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 

 */

package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import Animals.Animal;
import graphics.CompetitionFrame.TableExample;
import java.util.Random;

public class CompetitionPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    protected BufferedImage background;
    Animal[][] arr;
    private int yOffset = 30;
    private int xOffset=180;
    private int xDelta=4;
    private int yDelta = 4;
    private int xBackset=100;
    private int yBackset=750;
    private String CompetitionType;
    private String Comp;
    TableExample tb;
    private boolean flag;
    private boolean flag1;
    private boolean flag2;
    private boolean flag3;
    Random rand = new Random();

    public CompetitionPanel(Animal[][] arr,String competitionType,String c,TableExample tb) {
      int x = rand.nextInt(20)+30;
        try {
            background = ImageIO.read(new File("graphics/competitionBackground.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        this.Comp=c;
        this.arr = arr;
        this.CompetitionType=competitionType;
        this.tb=tb;
        flag=false;
        flag1=false;
        flag2=false;
        flag3=false;
        
   //instead of 50 speed of animal
   Timer timer = new Timer(x, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(Comp.equals("Water Competition")){
           //from left to right 
           if (xOffset < 1030 ) {
            xOffset += xDelta;
            repaint();
          if(xOffset >=1026){
            xBackset=xOffset;
          }
        }
        //from right to left
         else if(xBackset>100){
         xBackset -= xDelta*2;
         repaint();
        }
      }
      else if(Comp.equals("Air Competition")){
        if (xOffset < 1050 ) {
          xOffset += xDelta;
          repaint();
        }
      }
      else if(Comp.equals("Land Competition")){

         //from left to right 
         if (xOffset < 1100 ) {
          xOffset += xDelta*2;
          repaint();
        if(xOffset >=1096){
          yBackset=80;
        }
      }
      // from high to low
      else if(yBackset<740){
        yBackset += yDelta;
        repaint();
        if(yBackset >=740){
          flag1=true;
          xBackset=xOffset;
        }
      }
      //from right to left
      else if(xBackset>30){
        xBackset -= xDelta*2;
        repaint();
        if(xBackset<=30){
          flag2=true;
          yOffset=yBackset;
        }
      }
      //from low to high
      else if( yOffset>30){
        yOffset -= yDelta*2;
        repaint();
        if(yOffset < 30 ){
          flag3=true;

        }
      }
      }

      }
    });
     timer.start();
     
  }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), this);
        if (true) {
          if(this.CompetitionType.equals("Regular Competition")){
            for (int i = 0; i < arr.length && arr[i][0] != null; ++i) {
              if (arr[i][0].get_Category().equals("Water")) { 
                  Graphics2D g2d = (Graphics2D) g.create();
                  int xPos = xOffset;
                  int yPos = 180;
                  xPos = xOffset;

                 while (xPos < arr[i][0].get_position().get_x()+920) {
                  g2d.drawImage(arr[i][0].get_img1(), xPos, yPos*i+110,65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos += background.getWidth();
                }
                if(xOffset>1026 && !flag){
                  flag=true;
                  tb.addAnimalsArray(arr);
                }
                if(xBackset>=101){
                  xPos=xBackset;
                  while (xPos > arr[i][0].get_position().get_x()) {
                    g2d.drawImage(arr[i][0].get_img2(), xPos, yPos*i+110,65,65, this);  
                    arr[i][0].addTotalDistance(xPos/180);
                    xPos -= background.getWidth();
                  }
                  }
                if(xBackset < 97){
                  tb.addAnimalsArray(arr);
                }

                  g2d.dispose();
              }



              if (arr[i][0].get_Category().equals("Terrestrial")) {
                  Graphics2D g2d = (Graphics2D) g.create();
                  int xPos ;
                  int yPos = 20;
                //from left to to right

                if(xOffset<1100){
                  xPos = xOffset;
                 while (xPos < arr[i][0].get_position().get_x()+1150) {
                  g2d.drawImage(arr[i][0].get_img1(), xPos, yPos*i,65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos += background.getWidth();
                }
                
              }
              if(xOffset>1026 && !flag){
                flag=true;
                tb.addAnimalsArray(arr);
              }

                // from high to low
                
                if(yBackset<=740){
                    yPos=yBackset;
                    xPos=xOffset;
                    while (yPos < arr[i][0].get_position().get_y()+700) {
                    g2d.drawImage(arr[i][0].get_img4(), xPos, yPos,65,65, this);  
                    arr[i][0].addTotalDistance(xPos/180);
                    yPos += background.getHeight();
                  }
                  }

                  
                  if(flag1){
                    tb.addAnimalsArray(arr);
                    flag1=false;
                  }
                  
                  //from right to left
                  if(xBackset>=101){
                  xPos=xBackset;
                  while (xPos > arr[i][0].get_position().get_x()) {
                  g2d.drawImage(arr[i][0].get_img2(), xPos, yPos,65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos -= background.getWidth();
                }


                }
                if(flag2){
                  tb.addAnimalsArray(arr);
                  flag2=false;
                  }
                  
                // from low to high
                if(yOffset>=30){
                  yPos=yOffset;
                  xPos=xBackset;
                while (yPos > arr[i][0].get_position().get_y()+30) {
                g2d.drawImage(arr[i][0].get_img3(), xPos, yPos,65,65, this);  
                arr[i][0].addTotalDistance(xPos/180);
                yPos -= background.getHeight();
              }
              }
              if(flag3){
                tb.addAnimalsArray(arr);
                flag3=false;
              }
              

              
              g2d.dispose();     
              }



              if (arr[i][0].get_Category().equals("Air")) {    
                  Graphics2D g2d = (Graphics2D) g.create();
                  int xPos = xOffset;
                  int yPos = 100;
                  xPos = xOffset;
                 while (xPos < arr[i][0].get_position().get_x()+1100) {
                  g2d.drawImage(arr[i][0].get_img1(), xPos , yPos - 90 + (2 * i * 95),65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos += background.getWidth();
                }
                if(xOffset>1026 && !flag){
                  flag=true;
                  tb.addAnimalsArray(arr);
                }
                g2d.dispose();

              }
              
          }

          }


           else if(this.CompetitionType.equals("Courier Competition"))
          {

            for (int i = 0; i < arr.length && arr[i][0] != null; ++i) {
              if (arr[i][0].get_Category().equals("Water")) { 
                  Graphics2D g2d = (Graphics2D) g.create();
                  int xPos = xOffset;
                  int yPos = 180;
                  xPos = xOffset;


                  
                 while (xPos < arr[i][0].get_position().get_x()+920) {
                  g2d.drawImage(arr[i][0].get_img1(), xPos, yPos*i+110,65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos += background.getWidth();
                }
                if(xOffset>1026 && !flag){
                  flag=true;
                  tb.addAnimalsArray(arr);
                }


                if(xBackset>=101){
                  xPos=xBackset;
                  while (xPos > arr[i][1].get_position().get_x()) {
                    g2d.drawImage(arr[i][1].get_img2(), xPos, yPos*i+110,65,65, this);  
                    arr[i][1].addTotalDistance(xPos/180);
                    xPos -= background.getWidth();
                  }

                  }

                  
                  if(xBackset < 97){
                    tb.addAnimalsArray(arr);
                  }
                  g2d.dispose();
              }
              
              if (arr[i][0].get_Category().equals("Terrestrial")) {
                  Graphics2D g2d = (Graphics2D) g.create();
                  int xPos ;
                  int yPos = 20;
                //from left to to right

                if(xOffset<1100){
                  xPos = xOffset;
                 while (xPos < arr[i][0].get_position().get_x()+1150) {
                  g2d.drawImage(arr[i][0].get_img1(), xPos, yPos*i,65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos += background.getWidth();
                }
                
              }


              if(xOffset>1026 && !flag){
                flag=true;
                tb.addAnimalsArray(arr);
              }

                // from high to low
                
                if(yBackset<=740){
                    yPos=yBackset;
                    xPos=xOffset;
                    while (yPos < arr[i][0].get_position().get_y()+700) {
                    g2d.drawImage(arr[i][0].get_img4(), xPos, yPos,65,65, this); 
                    arr[i][0].addTotalDistance(xPos/180); 
                    yPos += background.getHeight();
                  }
                  }

                  if(flag1){
                    tb.addAnimalsArray(arr);
                    flag1=false;
                  }
                  

                  //from right to left
                  if(xBackset>=101){
                  xPos=xBackset;
                  while (xPos > arr[i][1].get_position().get_x()) {
                  g2d.drawImage(arr[i][1].get_img2(), xPos, yPos,65,65, this);  
                  arr[i][1].addTotalDistance(xPos/180);
                  xPos -= background.getWidth();
                }
                }

                if(flag2){
                  tb.addAnimalsArray(arr);
                  flag2=false;
                  }
                  


                // from low to high
                if(yOffset>=30){
                  yPos=yOffset;
                  xPos=xBackset;
                while (yPos > arr[i][1].get_position().get_y()+30) {
                g2d.drawImage(arr[i][1].get_img3(), xPos, yPos,65,65, this);
                arr[i][1].addTotalDistance(xPos/180);  
                yPos -= background.getHeight();
              }
              }
              if(flag3){
                tb.addAnimalsArray(arr);
                flag3=false;
              }

              g2d.dispose();     
              }



              if (arr[i][0].get_Category().equals("Air")) {    
                  Graphics2D g2d = (Graphics2D) g.create();
                  int xPos = xOffset;
                  int yPos = 100;
                  xPos = xOffset;
                 while (xPos < arr[i][0].get_position().get_x()+1100) {
                  g2d.drawImage(arr[i][0].get_img1(), xPos , yPos - 90 + (2 * i * 95),65,65, this);  
                  arr[i][0].addTotalDistance(xPos/180);
                  xPos += background.getWidth();
                }
                if(xOffset>1026 && !flag){
                  flag=true;
                  tb.addAnimalsArray(arr);
                }
                g2d.dispose();

              }
              
          }




          }
           




  }      
}
           
    }

