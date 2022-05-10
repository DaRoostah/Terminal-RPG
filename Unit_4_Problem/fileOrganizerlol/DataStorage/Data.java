package fileOrganizerlol.DataStorage;

import fileOrganizerlol.code.Player.player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
  
  public void Save(int slot, player player) {
    BufferedWriter writer;
    
    try {
      FileWriter cFile;
      switch(slot) {
        case 3: cFile = new FileWriter("Unit_4_Problem\\fileOrganizerlol\\DataStorage\\LoadDataStorage\\Load_Game_3.txt");
                break;
        case 2: cFile = new FileWriter("Unit_4_Problem\\fileOrganizerlol\\DataStorage\\LoadDataStorage\\Load_Game_2.txt");
                break;
        default: cFile = new FileWriter("Unit_4_Problem\\fileOrganizerlol\\DataStorage\\LoadDataStorage\\Load_Game_1.txt");
      }
      writer = new BufferedWriter(cFile);
      // System.out.println("Save Check");
      writer.write("Name: " + player.getName() + "\n" +
      "Level: " + player.getLevel() + "\tEXP: " + player.getCurrentEXP() + "/" + player.getBaseEXP() +
      "\nHP: " + player.getHP() + "/" + player.getBaseHP() +
      "\tDEF: " + player.getBaseDEF() +
       "\nATK: " + player.getATK() + "\tINT: " + player.getINT());
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String playerData(player player) {
    return "";
  }


}
