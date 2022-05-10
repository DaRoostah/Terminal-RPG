package fileOrganizerlol.DataStorage;

import fileOrganizerlol.code.Player.player;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
  private static File slotOne = new File("Unit_4_Problem\\fileOrganizerlol\\DataStorage\\LoadDataStorage\\Load_Game_1.txt");
  private static File slotTwo = new File("Unit_4_Problem\\fileOrganizerlol\\DataStorage\\LoadDataStorage\\Load_Game_2.txt");
  private static File slotThree = new File("Unit_4_Problem\\fileOrganizerlol\\DataStorage\\LoadDataStorage\\Load_Game_3.txt");
  public void Save(int slot, player player) {
    BufferedWriter writer;  
    try {
      FileWriter cFile;
      switch(slot) {
        case 3: cFile = new FileWriter(slotThree);
                break;
        case 2: cFile = new FileWriter(slotTwo);
                break;
        default: cFile = new FileWriter(slotOne);
      }
      writer = new BufferedWriter(cFile);
      // System.out.println("Save Check");
      writer.write("Name: " + player.getName() + "\n" +
      "Level: " + player.getLevel() + "\nEXP: " + player.getCurrentEXP() + "\nBaseEXP: " + player.getBaseEXP() +
      "\nHP: " + player.getHP() + "\nBaseHP: " + player.getBaseHP() +
      "\nDEF: " + player.getBaseDEF() +
       "\nATK: " + player.getATK() + "\nINT: " + player.getINT());
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void loadGame(int slot, File file) {
    
  }

  public int getValue(String v) {
    int value = 0;
    for(int i = v.length();i > 0;i--) {
      if(v.substring(i-1, i).equals(" "))
        value = Integer.parseInt(v, v.length()-i-1);
    }
    return value;
  }

}
