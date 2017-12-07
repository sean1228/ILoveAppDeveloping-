import arc.*;
import java.awt.*;
import java.awt.image.*;

public class RPGUtility{
  
  //Load array
  public static String[][] loadArray(String strFileName){
    TextInputFile file = new TextInputFile(strFileName);
    String strLoadArray[][];
    strLoadArray = new String[20][20];
    String strSplit[];
    strSplit = new String[20];
    String strRead;
    
    int intCount;
    int intCount2 = 0;
    while(file.eof() == false){
      strRead = file.readLine();
      strSplit = strRead.split(",");
      for(intCount = 0; intCount < 20; intCount++){
        strLoadArray[intCount2][intCount] = strSplit[intCount];
      }
      intCount2++;
    }
    return strLoadArray;
  }
  
  //Replace Player
  public static void replaceplayer(String strMap[][], int intPlayerRow, int intPlayerCol, Console con){
    BufferedImage theimage;
    if(strMap[intPlayerRow][intPlayerCol].equals("w-")){
      
      theimage = con.loadImage("Wall.png");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("g-")){
      
      theimage = con.loadImage("Ground.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("t-")){
      
      theimage = con.loadImage("Trap Closed.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("sk")){
      
      theimage = con.loadImage("Skeleton in map.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("sp")){
      
      theimage = con.loadImage("Spider in map.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("c-")){
      
      theimage = con.loadImage("Chest.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("h-")){
      
      theimage = con.loadImage("Health.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
      //boss
    }else if(strMap[intPlayerRow][intPlayerCol].equals("p-")){
      
      theimage = con.loadImage("Player in map forward.jpg");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }else if(strMap[intPlayerRow][intPlayerCol].equals("b-")){
      
      theimage = con.loadImage("Boss in map.png");
      con.drawImage(theimage, (intPlayerCol * 30 + 380), intPlayerRow * 30);
      con.repaint();
    }
  }
  
  //replace map
  public static void replacemap(String strMap[][], int intRowCount, int intColCount, Console con){
    BufferedImage theimage;
    for(intRowCount = 0; intRowCount < 20; intRowCount++){
      
      for(intColCount = 0; intColCount < 20; intColCount++){
        
        if(strMap[intRowCount][intColCount].equals("w-")){
          theimage = con.loadImage("Wall.png");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("g-")){
          theimage = con.loadImage("Ground.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("t-")){
          theimage = con.loadImage("Trap Closed.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("sk")){
          theimage = con.loadImage("Skeleton in map.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("sp")){
          theimage = con.loadImage("Spider in map.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("cc")){
          //Chestplate
          theimage = con.loadImage("Chest.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("cg")){
          //Gauntlet
          theimage = con.loadImage("Chest.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("ch")){
          //Helmet
          theimage = con.loadImage("Chest.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("cs")){
          //Sword
          theimage = con.loadImage("Chest.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("cb")){
          //Boots
          theimage = con.loadImage("Chest.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("cu")){
          //Ultimate sword
          theimage = con.loadImage("Chest.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("h-")){
          theimage = con.loadImage("Health.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("p-")){
          theimage = con.loadImage("Player in map forward.jpg");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }else if(strMap[intRowCount][intColCount].equals("b-")){
          theimage = con.loadImage("Boss in map.png");
          con.drawImage(theimage, (intColCount * 30 + 380), intRowCount * 30);
          con.repaint();
        }
      }
    }          
  }
  
  //Battle Animation
  public static void animation(Console con){
    int intAnimation;
    for(intAnimation = 0; intAnimation < 100; intAnimation++){
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(0,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(80,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(160,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(240,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(320,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(400,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(480,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(560,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(640,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(720,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(800,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(880,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(960,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(1040,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(1120,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(1200,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.WHITE);
      intAnimation = intAnimation + 1;
      con.fillRect(1280,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
      con.setDrawColor(Color.BLACK);
      intAnimation = intAnimation + 1;
      con.fillRect(1360,0,intAnimation,600);
      con.repaint();
      con.sleep(10);
    }
  }
}