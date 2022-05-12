package fileOrganizerlol.DataStorage;

import fileOrganizerlol.code.Player.player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
  public void loadGame(int slot, player Player) {
    try {
      FileReader cFile;
      switch(slot) {
        case 3: cFile = new FileReader(slotThree);
                break;
        case 2: cFile = new FileReader(slotTwo);
                break;
        default: cFile = new FileReader(slotOne);
      }
      BufferedReader read = new BufferedReader(cFile);
      String line, name;
      int baseHP, HP, ATK, INT, baseDEF, Level, cEXP;
      try {
        while ((line = read.readLine())!=null) {
          System.out.println(line);
          name = getStringValue(line, "Name: ");
          baseHP = getIntValue(line, "baseHP: ");
          HP = getIntValue(line, "HP: ");
          ATK = getIntValue(line, "ATK: ");
          INT = getIntValue(line, "INT: ");
          baseDEF = getIntValue(line, "baseDEF: ");
          Level = getIntValue(line, "level: ");
          cEXP = getIntValue(line, "cEXP: ");
          Player.loadPlayer(name, baseHP, HP, ATK, INT, baseDEF, Level, cEXP);
          Thread.sleep(1000);
        }
        read.close();
      } catch (IOException | InterruptedException e) {
        return;
      }
    } catch (FileNotFoundException e) {
      return;
    }
  }

  public int getIntValue(String line, String dataValue) {
    int value = 0;
    if(line.indexOf(dataValue) != -1) {
      value = Integer.parseInt(line.substring(line.length()-dataValue.length(), line.length()));
    }
    return value;
  }
  public String getStringValue(String line, String dataValue) {
    String value = "";
    if(line.indexOf(dataValue) != -1) {
      for(int i = line.length();i > 0;i--) {
        if(line.substring(i-1, i).equals(" "))
          value = line.substring(line.length()-i-1);
      }
    }
    return value;
  }

}
