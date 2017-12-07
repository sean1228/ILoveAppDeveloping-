// Open with Windows
// The intention of this game is to provide entertainment and education 
// Version 1.0
// Created By Sean Lau
// Launched on 5 October 2017

import arc.*;
import java.awt.*;
import java.awt.image.*;

public class SeanRPG{
  public static void main(String[] args){
    Console con = new Console(1360,600);
    //380,600,380
    //Tiles 30x30
    
    
    int intMenu;
    intMenu = 4;
    char chrKey;
    int intHealth;
    intHealth = 50;
    int intArmour;
    intArmour = 0;
    int intAttack;
    intAttack = 10;
    int intMana;
    String strMap[][];
    int intPlayerCol = 1;
    int intPlayerRow = 0;
    int intRowCount;
    int intColCount;
    String strTemp;
    int intCount;
    int intAlive;
    intAlive = 1;
    int intAlive2;
    intAlive2 = 0;
    BufferedImage picture;
    
    //Main Menu
    BufferedImage MenuScreen;
    MenuScreen = con.loadImage("Menu Screen.png");
    con.drawImage(MenuScreen, 0,0);
    con.repaint();
    Font Parisish;
    Parisish = con.loadFont("Parisish.ttf", 70);
    con.setDrawFont(Parisish);
    con.drawString("-",150,190);
    con.drawString("-",150,290);
    con.drawString("-",150,390);
    con.repaint();
    Font Royal;
    Royal = con.loadFont("Royal2.ttf", 60);
    con.setDrawFont(Royal);
    con.drawString("DUNGEON HUNTER",100,90);
    con.drawString("P PLAY", 100,200);
    con.drawString("H HELP", 100,300);
    con.drawString("Q QUIT", 100,400);
    con.repaint();
    
    while(intMenu == 4){
      chrKey = con.getChar();
      if(chrKey == 'p'){
        //Play 
        intMenu = 1;
      }else if(chrKey == 'h'){
        //Help
        intMenu = 2;
      }else if(chrKey == 'q'){
        //Quit 
        intMenu = 3;
      }
      
      if(intMenu == 1){  
        //Play
        con.setDrawColor(Color.BLACK);
        con.fillRect(0,0,1360,600);
        con.repaint();
        strMap = RPGUtility.loadArray("RPG.csv");
        strMap[intPlayerRow][intPlayerCol] = "p-";
        strTemp = strMap[intPlayerRow][intPlayerCol];
        
        while(intAlive != 0){
          intAlive2 =1;
          for(intRowCount = 0; intRowCount < 20; intRowCount++){
            for(intColCount = 0; intColCount < 20; intColCount++){
              if(strMap[intRowCount][intColCount].equals("w-")){
                picture = con.loadImage("Wall.png");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("g-")){
                picture = con.loadImage("Ground.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("t-")){
                picture = con.loadImage("Trap Closed.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("sk")){
                picture = con.loadImage("Skeleton in map.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("sp")){
                picture = con.loadImage("Spider in map.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("cc")){
                //Chestplate
                picture = con.loadImage("Chest.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("cg")){
                //Gauntlet
                picture = con.loadImage("Chest.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("ch")){
                //Helmet
                picture = con.loadImage("Chest.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("cs")){
                //Sword
                picture = con.loadImage("Chest.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("cb")){
                //Boots
                picture = con.loadImage("Chest.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("cu")){
                //Ultimate sword
                picture = con.loadImage("Chest.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("h-")){
                picture = con.loadImage("Health.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("b-")){
                //boss
                //slash slash fireball slash slash slash slash icetomb to kill
                //360 health
                //35 damage
                picture = con.loadImage("Boss in map.png");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }else if(strMap[intRowCount][intColCount].equals("p-")){
                picture = con.loadImage("Player in map forward.jpg");
                con.drawImage(picture, (intColCount * 30 + 380), intRowCount * 30);
                con.repaint();
              }
            }            
          }
          con.setDrawFont(Parisish);
          con.setDrawColor(Color.WHITE);
          con.drawString("Health: "+intHealth, 0, 70);
          con.drawString("Armour: "+intArmour, 0, 140);
          con.drawString("Attack: "+intAttack, 0, 210);
          con.repaint();
          
          while(intAlive2 != 0){
            chrKey = con.getChar();
            if(chrKey == 's'){
              if(intPlayerRow + 1 >= 0 && intPlayerRow + 1 < 20){
                if(strMap[intPlayerRow + 1][intPlayerCol].equals("g-")){
                  //Down
                  strMap[intPlayerRow][intPlayerCol] = strTemp;
                  strMap[intPlayerRow][intPlayerCol] = "g-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                  intPlayerRow = intPlayerRow + 1;
                  strTemp = strMap[intPlayerRow][intPlayerCol];
                  strMap[intPlayerRow][intPlayerCol] = "p-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                }else if(strMap[intPlayerRow + 1][intPlayerCol].equals("t-")){
                  //die in trap 
                  intHealth = 0;
                  if(intHealth <= 0){
                    con.setDrawColor(Color.BLACK);
                    con.fillRect(0,0,1360,600);
                    con.repaint();
                    while(intHealth <= 0){
                      char chrQuit;
                      BufferedImage GameOver;
                      GameOver = con.loadImage("Game Over.png");
                      con.drawImage(GameOver, 190,0);
                      con.setDrawColor(Color.WHITE);
                      con.drawString("Press 1 to Quit", 520,550);
                      con.repaint();
                      chrQuit = con.getChar();
                      if(chrQuit == '1'){
                        System.exit(0);
                      }           
                    }                            
                  }
                }else if(strMap[intPlayerRow  + 1][intPlayerCol].equals("h-")){
                  //Health
                  con.setDrawColor(Color.BLACK);
                  intHealth = intHealth + 10;
                  con.fillRect(0,0,380,600);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0, 140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow + 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow + 1][intPlayerCol].equals("cb")){
                  //Boots
                  BufferedImage Boots;
                  Boots = con.loadImage("Boots.jpg");
                  con.drawImage(Boots,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intArmour = intArmour + 5;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow + 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow + 1][intPlayerCol].equals("ch")){
                  //Helmet
                  BufferedImage Helmet;
                  Helmet = con.loadImage("Helmet.jpg");
                  con.drawImage(Helmet,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intArmour = intArmour + 5;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow + 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow + 1][intPlayerCol].equals("cg")){
                  //Gauntlet
                  BufferedImage Gauntlet;
                  Gauntlet = con.loadImage("Gauntlet.jpg");
                  con.drawImage(Gauntlet,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intArmour = intArmour + 5;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow + 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow + 1][intPlayerCol].equals("cu")){
                  //Ultimate Sword
                  BufferedImage UltimateSword;
                  UltimateSword = con.loadImage("UltimateSword.jpg");
                  con.drawImage(UltimateSword,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intAttack = intAttack + 20;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();          
                  strMap[intPlayerRow + 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow + 1][intPlayerCol].equals("sk")){  
                  //Battle scene with skeleton
                  //Animation to battle scene
                  intMana = 0;
                  RPGUtility.animation(con);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(0,0,1360,600);
                  BufferedImage Battlescene;
                  Battlescene = con.loadImage("Battle Scene Background.jpg");
                  con.drawImage(Battlescene,380,0);
                  BufferedImage Skeleton;
                  Skeleton = con.loadImage("Skeleton in battle.png");
                  con.drawImage(Skeleton,553,50);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.drawString("1)Slash (0)",0,280);
                  con.drawString("2)FireBall (2)",0,350);
                  con.drawString("3)Ice Tomb (4)",0,420);
                  con.drawString("Mana: "+intMana,0,490);
                  con.repaint();
                  //Battle
                  int intSkeletonHealth;
                  intSkeletonHealth = 30;
                  char chrMove;
                  while(intSkeletonHealth > 0){
                    con.setDrawColor(Color.WHITE);
                    con.drawString("Skeleton Health:" , 980,70);
                    con.drawString(""+intSkeletonHealth , 980,140);
                    con.repaint();
                    int intTempAttack;
                    int intSkeletonAttack;
                    if(intMana < 2){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }                       
                          }   
                        }
                      }  
                    }else if(intMana >= 2 && intMana < 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);  
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              } 
                            }    
                          }      
                        }   
                      }
                    }else if(intMana >= 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }      
                          }
                        }
                      }else if(chrMove == '3'){
                        //Ice Tomb
                        intSkeletonHealth = intSkeletonHealth - intAttack - 30;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }
                          }
                        }  
                      }
                    }
                  }
                  //back to map
                  con.clear();
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();                 
                  strMap[intPlayerRow + 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }
              }
            }else if(chrKey == 'w'){
              if(intPlayerRow - 1 >= 0 && intPlayerRow - 1 < 20){
                if(strMap[intPlayerRow - 1][intPlayerCol].equals("g-")){
                  //Up
                  strMap[intPlayerRow][intPlayerCol] = strTemp;
                  strMap[intPlayerRow][intPlayerCol] = "g-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                  intPlayerRow = intPlayerRow - 1;
                  strTemp = strMap[intPlayerRow][intPlayerCol];
                  strMap[intPlayerRow][intPlayerCol] = "p-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                }else if(strMap[intPlayerRow - 1][intPlayerCol].equals("t-")){
                  //die in trap 
                  intHealth = 0;
                  if(intHealth <= 0){
                    con.setDrawColor(Color.BLACK);
                    con.fillRect(0,0,1360,600);
                    con.repaint();
                    while(intHealth <= 0){
                      char chrQuit;
                      BufferedImage GameOver;
                      GameOver = con.loadImage("Game Over.png");
                      con.drawImage(GameOver, 190,0);
                      con.setDrawColor(Color.WHITE);
                      con.drawString("Press 1 to Quit", 520,550);
                      con.repaint();
                      chrQuit = con.getChar();
                      if(chrQuit == '1'){
                        System.exit(0);
                      }           
                    }                            
                  }
                }else if(strMap[intPlayerRow  - 1][intPlayerCol].equals("h-")){
                  //Health
                  con.setDrawColor(Color.BLACK);
                  intHealth = intHealth + 10;
                  con.fillRect(0,0,380,600);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0, 140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow - 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow - 1][intPlayerCol].equals("b-")){
                  //Battle scene with Boss
                  //Animation to battle scene
                  intMana = 0;
                  RPGUtility.animation(con);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(0,0,1360,600);
                  BufferedImage Battlescene;
                  Battlescene = con.loadImage("Battle Scene Background.jpg");
                  con.drawImage(Battlescene,380,0);
                  BufferedImage Boss;
                  Boss = con.loadImage("Boss.png");
                  con.drawImage(Boss,417,0);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.drawString("1)Slash (0)",0,280);
                  con.drawString("2)FireBall (2)",0,350);
                  con.drawString("3)Ice Tomb (4)",0,420);
                  con.drawString("Mana: "+intMana,0,490);
                  con.repaint();
                  //Battle
                  int intBossHealth;
                  intBossHealth = 360;
                  char chrMove;
                  while(intBossHealth > 0){
                    con.setDrawColor(Color.WHITE);
                    con.drawString("Boss Health:" , 980,70);
                    con.drawString(""+intBossHealth , 980,140);
                    con.repaint();
                    int intTempAttack;
                    int intBossAttack;
                    if(intMana < 2){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intBossHealth = intBossHealth - intAttack;
                        if(intBossHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }     
                          }
                        }
                      }
                    }else if(intMana >= 2 && intMana < 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intBossHealth = intBossHealth - intAttack;
                        if(intBossHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }                            
                            }         
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intBossHealth = intBossHealth - intAttack - 10;
                        if(intBossHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }  
                          }   
                        }                    
                      }
                    }else if(intMana >= 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intBossHealth = intBossHealth - intAttack;
                        if(intBossHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              } 
                            }         
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intBossHealth = intBossHealth - intAttack - 10;
                        if(intBossHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }     
                          }
                        }   
                      }else if(chrMove == '3'){
                        //Ice Tomb
                        intBossHealth = intBossHealth - intAttack - 30;
                        if(intBossHealth <= 0){
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 30;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 30;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550); 
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }
                          }
                        }  
                      }
                    }
                  }
                  while(intBossHealth <= 0){
                    BufferedImage Win;
                    Win = con.loadImage("Win.png");
                    con.drawImage(Win,0,0);
                    con.repaint();
                    intBossHealth = 1;
                  }
                  con.sleep(2000);
                  System.exit(0);
                }else if(strMap[intPlayerRow - 1][intPlayerCol].equals("sk")){  
                  //Battle scene with skeleton
                  //Animation to battle scene
                  intMana = 0;
                  RPGUtility.animation(con);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(0,0,1360,600);
                  BufferedImage Battlescene;
                  Battlescene = con.loadImage("Battle Scene Background.jpg");
                  con.drawImage(Battlescene,380,0);
                  BufferedImage Skeleton;
                  Skeleton = con.loadImage("Skeleton in battle.png");
                  con.drawImage(Skeleton,553,50);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.drawString("1)Slash (0)",0,280);
                  con.drawString("2)FireBall (2)",0,350);
                  con.drawString("3)Ice Tomb (4)",0,420);
                  con.drawString("Mana: "+intMana,0,490);
                  con.repaint();
                  //Battle
                  int intSkeletonHealth;
                  intSkeletonHealth = 50;
                  char chrMove;
                  while(intSkeletonHealth > 0){
                    con.setDrawColor(Color.WHITE);
                    con.drawString("Skeleton Health:" , 980,70);
                    con.drawString(""+intSkeletonHealth , 980,140);
                    con.repaint();
                    int intTempAttack;
                    int intSkeletonAttack;
                    if(intMana < 2){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 25;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }                            
                            }                       
                          }                          
                        }
                      }
                    }else if(intMana >= 2 && intMana < 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);                
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 25;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }      
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 25;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }          
                            }
                          }
                        }     
                      }
                    }else if(intMana >= 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 25;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }       
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 25;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }   
                            }  
                          }
                        } 
                      }else if(chrMove == '3'){
                        //Ice Tomb
                        intSkeletonHealth = intSkeletonHealth - intAttack - 30;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 25;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }     
                            }           
                          }
                        }  
                      }
                    }
                  }
                  //back to map
                  con.clear();
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();                 
                  strMap[intPlayerRow - 1][intPlayerCol] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }
              }
            }else if(chrKey == 'a'){
              if(intPlayerCol - 1 >= 0 && intPlayerCol - 1 < 20){
                if(strMap[intPlayerRow][intPlayerCol - 1].equals("g-")){
                  //Left
                  strMap[intPlayerRow][intPlayerCol] = strTemp;
                  strMap[intPlayerRow][intPlayerCol] = "g-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                  intPlayerCol = intPlayerCol - 1;
                  strTemp = strMap[intPlayerRow][intPlayerCol];
                  strMap[intPlayerRow][intPlayerCol] = "p-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                }else if(strMap[intPlayerRow][intPlayerCol - 1].equals("t-")){
                  //die in trap 
                  intHealth = 0;
                  if(intHealth <= 0){
                    con.setDrawColor(Color.BLACK);
                    con.fillRect(0,0,1360,600);
                    con.repaint();
                    while(intHealth <= 0){
                      char chrQuit;
                      BufferedImage GameOver;
                      GameOver = con.loadImage("Game Over.png");
                      con.drawImage(GameOver, 190,0);
                      con.setDrawColor(Color.WHITE);
                      con.drawString("Press 1 to Quit", 520,550);
                      con.repaint();
                      chrQuit = con.getChar();
                      if(chrQuit == '1'){
                        System.exit(0);
                      }           
                    }                            
                  }
                }else if(strMap[intPlayerRow][intPlayerCol - 1].equals("sk")){  
                  //Battle scene with skeleton
                  //Animation to battle scene
                  intMana = 0;
                  RPGUtility.animation(con);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(0,0,1360,600);
                  BufferedImage Battlescene;
                  Battlescene = con.loadImage("Battle Scene Background.jpg");
                  con.drawImage(Battlescene,380,0);
                  BufferedImage Skeleton;
                  Skeleton = con.loadImage("Skeleton in battle.png");
                  con.drawImage(Skeleton,553,50);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.drawString("1)Slash (0)",0,280);
                  con.drawString("2)FireBall (2)",0,350);
                  con.drawString("3)Ice Tomb (4)",0,420);
                  con.drawString("Mana: "+intMana,0,490);
                  con.repaint();
                  //Battle
                  int intSkeletonHealth;
                  intSkeletonHealth = 30;
                  char chrMove;
                  while(intSkeletonHealth > 0){
                    con.setDrawColor(Color.WHITE);
                    con.drawString("Skeleton Health:" , 980,70);
                    con.drawString(""+intSkeletonHealth , 980,140);
                    con.repaint();
                    int intTempAttack;
                    int intSkeletonAttack;
                    if(intMana < 2){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }               
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            } 
                          }
                        }
                      }
                    }else if(intMana >= 2 && intMana < 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{                
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550); 
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }       
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420); 
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }       
                          }                        
                        }           
                      }
                    }else if(intMana >= 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }   
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }       
                          }
                        }                        
                      }else if(chrMove == '3'){
                        //Ice Tomb
                        intSkeletonHealth = intSkeletonHealth - intAttack - 30;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              } 
                            }  
                          }
                        }     
                      }
                    }
                  }
                  //back to map
                  con.clear();
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();                 
                  strMap[intPlayerRow][intPlayerCol - 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow][intPlayerCol - 1].equals("h-")){
                  //Health
                  con.setDrawColor(Color.BLACK);
                  intHealth = intHealth + 10;
                  con.fillRect(0,0,380,600);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  con.repaint();
                  strMap[intPlayerRow][intPlayerCol - 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow][intPlayerCol - 1].equals("cc")){
                  //Chestplate
                  BufferedImage Chestplate;
                  Chestplate = con.loadImage("Chestplate.jpg");
                  con.drawImage(Chestplate,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intArmour = intArmour + 10;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();                 
                  strMap[intPlayerRow][intPlayerCol - 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }
              }
            }else if(chrKey == 'd'){
              if(intPlayerCol + 1 >= 0 && intPlayerCol + 1 < 20){
                if(strMap[intPlayerRow][intPlayerCol + 1].equals("g-")){
                  //Left
                  strMap[intPlayerRow][intPlayerCol] = strTemp;
                  strMap[intPlayerRow][intPlayerCol] = "g-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                  intPlayerCol = intPlayerCol + 1;
                  strTemp = strMap[intPlayerRow][intPlayerCol];
                  strMap[intPlayerRow][intPlayerCol] = "p-";
                  RPGUtility.replaceplayer(strMap, intPlayerRow, intPlayerCol, con);
                }else if(strMap[intPlayerRow][intPlayerCol + 1].equals("t-")){
                  //die in trap 
                  intHealth = 0;
                  if(intHealth <= 0){
                    con.setDrawColor(Color.BLACK);
                    con.fillRect(0,0,1360,600);
                    con.repaint();
                    while(intHealth <= 0){
                      char chrQuit;
                      BufferedImage GameOver;
                      GameOver = con.loadImage("Game Over.png");
                      con.drawImage(GameOver, 190,0);
                      con.setDrawColor(Color.WHITE);
                      con.drawString("Press 1 to Quit", 520,550);
                      con.repaint();
                      chrQuit = con.getChar();
                      if(chrQuit == '1'){
                        System.exit(0);
                      }           
                    }                            
                  }
                }else if(strMap[intPlayerRow][intPlayerCol + 1].equals("h-")){
                  //Health
                  con.setDrawColor(Color.BLACK);
                  intHealth = intHealth + 10;
                  con.fillRect(0,0,380,600);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0, 140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow][intPlayerCol + 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow][intPlayerCol + 1].equals("cs")){
                  //Sword
                  BufferedImage Sword;
                  Sword = con.loadImage("Sword.jpg");
                  con.drawImage(Sword,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intAttack = intAttack + 10;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint(); 
                  strMap[intPlayerRow][intPlayerCol + 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow][intPlayerCol + 1].equals("cg")){
                  //Gauntlet
                  BufferedImage Gauntlet;
                  Gauntlet = con.loadImage("Gauntlet.jpg");
                  con.drawImage(Gauntlet,380,0);
                  con.repaint();
                  con.sleep(3000);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  intArmour = intArmour + 5;
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();
                  strMap[intPlayerRow][intPlayerCol + 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }else if(strMap[intPlayerRow][intPlayerCol + 1].equals("b-")){
                  //Battle scene with Boss
                  //Animation to battle scene
                  intMana = 0;
                  RPGUtility.animation(con);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(0,0,1360,600);
                  BufferedImage Battlescene;
                  Battlescene = con.loadImage("Battle Scene Background.jpg");
                  con.drawImage(Battlescene,380,0);
                  BufferedImage Boss;
                  Boss = con.loadImage("Boss.png");
                  con.drawImage(Boss,417,0);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.drawString("1)Slash (0)",0,280);
                  con.drawString("2)FireBall (2)",0,350);
                  con.drawString("3)Ice Tomb (4)",0,420);
                  con.drawString("Mana: "+intMana,0,490);
                  con.repaint();
                  //Battle
                  int intBossHealth;
                  intBossHealth = 360;
                  char chrMove;
                  while(intBossHealth > 0){
                    con.setDrawColor(Color.WHITE);
                    con.drawString("Boss Health:" , 980,70);
                    con.drawString(""+intBossHealth , 980,140);
                    con.repaint();
                    int intTempAttack;
                    int intBossAttack;
                    if(intMana < 2){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intBossHealth = intBossHealth - intAttack;
                        if(intBossHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }     
                          }
                        }
                      }
                    }else if(intMana >= 2 && intMana < 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intBossHealth = intBossHealth - intAttack;
                        if(intBossHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }                            
                            }         
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intBossHealth = intBossHealth - intAttack - 10;
                        if(intBossHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }  
                          }   
                        }                    
                      }
                    }else if(intMana >= 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intBossHealth = intBossHealth - intAttack;
                        if(intBossHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              } 
                            }         
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intBossHealth = intBossHealth - intAttack - 10;
                        if(intBossHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }     
                          }
                        }   
                      }else if(chrMove == '3'){
                        //Ice Tomb
                        intBossHealth = intBossHealth - intAttack - 30;
                        if(intBossHealth <= 0){
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 30;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 30;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Boss Health:" , 980,70);
                          con.drawString(""+intBossHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intBossAttack = 35;
                          intBossAttack = intBossAttack - intArmour;
                          if(intBossAttack < 0){
                            intBossAttack = 0;
                          }
                          con.drawString("-"+intBossAttack,280,70);
                          intHealth = intHealth - intBossAttack;
                          con.drawImage(Battlescene,380,0);
                          
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Boss,417,0);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550); 
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }
                          }
                        }  
                      }
                    }
                  }
                  while(intBossHealth <= 0){
                    BufferedImage Win;
                    Win = con.loadImage("Win.png");
                    con.drawImage(Win,0,0);
                    con.repaint();
                    intBossHealth = 1;
                  }
                  con.sleep(2000);
                  System.exit(0);
                }else if(strMap[intPlayerRow][intPlayerCol + 1].equals("sk")){  
                  //Battle scene with skeleton
                  //Animation to battle scene
                  intMana = 0;
                  RPGUtility.animation(con);
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(0,0,1360,600);
                  BufferedImage Battlescene;
                  Battlescene = con.loadImage("Battle Scene Background.jpg");
                  con.drawImage(Battlescene,380,0);
                  BufferedImage Skeleton;
                  Skeleton = con.loadImage("Skeleton in battle.png");
                  con.drawImage(Skeleton,553,50);
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.drawString("1)Slash (0)",0,280);
                  con.drawString("2)FireBall (2)",0,350);
                  con.drawString("3)Ice Tomb (4)",0,420);
                  con.drawString("Mana: "+intMana,0,490);
                  con.repaint();
                  //Battle
                  int intSkeletonHealth;
                  intSkeletonHealth = 30;
                  char chrMove;
                  while(intSkeletonHealth > 0){
                    con.setDrawColor(Color.WHITE);
                    con.drawString("Skeleton Health:" , 980,70);
                    con.drawString(""+intSkeletonHealth , 980,140);
                    con.repaint();
                    int intTempAttack;
                    int intSkeletonAttack;
                    if(intMana < 2){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack; 
                        if(intSkeletonHealth <= 0){   
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);                         
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }       
                          }        
                        }
                      }      
                    }else if(intMana >= 2 && intMana < 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{                          
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }  
                            }     
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }      
                          }           
                        }                       
                      }
                    }else if(intMana >= 4){
                      chrMove = con.getChar();
                      if(chrMove == '1'){
                        //Slash
                        intSkeletonHealth = intSkeletonHealth - intAttack;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana + 1;
                          BufferedImage Slash;
                          Slash = con.loadImage("Slash.png");
                          con.drawImage(Slash,430,50);
                          intTempAttack = intAttack;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }       
                          }
                        }
                      }else if(chrMove == '2'){
                        //FireBlast
                        intSkeletonHealth = intSkeletonHealth - intAttack - 10;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 2;
                          BufferedImage Fireblast;
                          Fireblast  = con.loadImage("Fireblast.png");
                          con.drawImage(Fireblast,460,80);
                          intTempAttack = intAttack + 10;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }
                            }
                          }
                        }
                      }else if(chrMove == '3'){
                        //Ice Tomb
                        intSkeletonHealth = intSkeletonHealth - intAttack - 30;
                        if(intSkeletonHealth <= 0){
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                        }else{
                          intMana = intMana - 4;
                          BufferedImage Icetomb;
                          Icetomb  = con.loadImage("Icetomb.png");
                          con.drawImage(Icetomb,280,-100);
                          intTempAttack = intAttack + 20;
                          con.drawString("-"+intTempAttack,1100,140);
                          con.repaint();
                          intTempAttack = 0;
                          con.sleep(1000);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.repaint();
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(980,0,380,600);
                          con.drawString("Skeleton Health:" , 980,70);
                          con.drawString(""+intSkeletonHealth , 980,140);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.setDrawColor(Color.WHITE);
                          con.sleep(1000);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          intSkeletonAttack = 10;
                          intSkeletonAttack = intSkeletonAttack - intArmour;
                          if(intSkeletonAttack < 0){
                            intSkeletonAttack = 0;
                          }
                          con.drawString("-"+intSkeletonAttack,280,70);
                          intHealth = intHealth - intSkeletonAttack;
                          con.drawImage(Battlescene,380,0);
                          BufferedImage SkeletonAttack;
                          SkeletonAttack = con.loadImage("Skeleton attack.png");
                          con.drawImage(SkeletonAttack,430,50);
                          BufferedImage Blood;
                          Blood = con.loadImage("Blood.png");
                          con.drawImage(Blood,400,200);
                          con.repaint();
                          con.sleep(1500);
                          con.drawImage(Battlescene,380,0);
                          con.drawImage(Skeleton,553,50);
                          con.setDrawColor(Color.BLACK);
                          con.fillRect(0,0,380,600);
                          con.repaint();
                          con.setDrawColor(Color.WHITE);
                          con.drawString("Health: "+intHealth,0,70);
                          con.drawString("Armour: "+intArmour,0,140);
                          con.drawString("Attack: "+intAttack,0,210);
                          con.drawString("Mana: "+intMana,0,490);
                          con.drawString("1)Slash (0)",0,280);
                          con.drawString("2)FireBall (2)",0,350);
                          con.drawString("3)Ice Tomb (4)",0,420);
                          con.clear();
                          if(intHealth <= 0){
                            con.setDrawColor(Color.BLACK);
                            con.fillRect(0,0,1360,600);
                            con.repaint();
                            while(intHealth <= 0){
                              char chrQuit;
                              BufferedImage GameOver;
                              GameOver = con.loadImage("Game Over.png");
                              con.drawImage(GameOver, 190,0);
                              con.setDrawColor(Color.WHITE);
                              con.drawString("Press 1 to Quit", 520,550);
                              con.repaint();
                              chrQuit = con.getChar();
                              if(chrQuit == '1'){
                                System.exit(0);
                              }           
                            }                            
                          }
                        }         
                      }
                    }
                  }
                  //back to map
                  con.clear();
                  con.setDrawColor(Color.BLACK);
                  con.fillRect(380,0,600,600);
                  con.fillRect(0,0,380,600);
                  con.repaint();
                  con.setDrawColor(Color.WHITE);
                  con.drawString("Health: "+intHealth,0,70);
                  con.drawString("Armour: "+intArmour,0,140);
                  con.drawString("Attack: "+intAttack,0,210);
                  con.repaint();                 
                  strMap[intPlayerRow][intPlayerCol + 1] = "g-";
                  intColCount = 0;
                  RPGUtility.replacemap(strMap,intRowCount, intColCount, con);
                }
              }
            }
          } 
        } 
      }else if(intMenu == 2){
        //Help 
        con.setDrawColor(Color.BLACK); 
        con.fillRect(0,0,1360,600);
        con.repaint(); 
        BufferedImage Instructions;
        Instructions = con.loadImage("Instructions 1.png");
        con.drawImage(Instructions,0,0);
        con.repaint();
        chrKey = con.getChar();
        Instructions = con.loadImage("Instructions 2.png");
        con.drawImage(Instructions,0,0);
        con.repaint();
        chrKey = con.getChar();
        Instructions = con.loadImage("Instructions 3.png");
        con.drawImage(Instructions,0,0);
        con.repaint();
        chrKey = con.getChar();
        Instructions = con.loadImage("Instructions 4.png");
        con.drawImage(Instructions,0,0);
        con.repaint();
        chrKey = con.getChar();
        Instructions = con.loadImage("Instructions 5.png");
        con.drawImage(Instructions,0,0);
        con.repaint();
        chrKey = con.getChar();
        Instructions = con.loadImage("Instructions 6.png");
        con.drawImage(Instructions,0,0);
        con.repaint();
        chrKey = con.getChar();
        intMenu = 4;
        MenuScreen = con.loadImage("Menu Screen.png");
        con.drawImage(MenuScreen, 0,0);
        con.repaint();
        con.setDrawColor(Color.WHITE);
        Parisish = con.loadFont("Parisish.ttf", 70);
        con.setDrawFont(Parisish);
        con.drawString("-",150,190);
        con.drawString("-",150,290);
        con.drawString("-",150,390);
        con.repaint();
        Royal = con.loadFont("Royal2.ttf", 60);
        con.setDrawFont(Royal);
        con.drawString("DUNGEON HUNTER",100,90);
        con.drawString("P PLAY", 100,200);
        con.drawString("H HELP", 100,300);
        con.drawString("Q QUIT", 100,400);
        con.repaint();
        con.clear();
      }
    }
    if(intMenu == 3){
      //Quit
      System.exit(0);
    }
  }
}