package fileOrganizerlol.code.Player;

import java.util.Random;

public class player {
    private String name;
    private static int level;
    private static int baseHP;
    private static int baseDEF;
    private static int HP, ATK, INT, cEXP;
    // Accessors
    public int getBaseEXP() {
        exp exp = new exp();
        return exp.experiencePerLevel(level);
    }
    public int getCurrentEXP() {
        return cEXP;
    }
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
    
    public int getBaseHP() {
        return baseHP;
    }

    public int getHP() {
        return HP;
    }

    public int getATK() {
        return ATK;
    }

    public int getINT() {
        return INT;
    }

    public int getBaseDEF() {
        return baseDEF;
    }

    // Mutators
    public void setLevel(int x) {
        player.level += x;
    }
    public void setBaseHP(int x) {
        player.baseHP += x;
    }
    public void setHP(int x) {
        player.HP = x;
    }
    public void decreaseHP(int x) {
        player.HP -= x;
    }
    public void increaseHP(int x) {
        player.HP += x;
    }
    public void setATK(int x) {
        player.ATK += x;
    }
    public void setINT(int x) {
        player.INT += x; 
    }
    public void setBaseDEF(int x) {
        player.baseDEF += x;
    }
    public void killPlayer() {
        player.HP = 0;
    }
    public void healPlayer() {
        player.HP = player.baseHP;
    }
    public void setCurrentEXP(int x) {
        player.cEXP += x;
    }
    public void increaseCurrentEXP(int x) {
        player.cEXP += x;
    }
    public void decreaseCurrentEXP(int x) {
        player.cEXP -= x;
    }
    public void usePlotArmor() {
        System.out.print("You nearly died, til you");
        Random rand = new Random();
        switch(rand.nextInt(3)) {
            case 0: System.out.println(" used recovery breathing");
                    break;
            case 1: System.out.println( " unlocked ultra instinct");
                    break;
            case 2: System.out.println(" had a flashback for who you're fighting for");
                    break;
            default: System.out.println(" unknown causes has brought you back to life");
        }
        player.baseHP += 15;
        player.HP = (int)player.baseHP/20;
        player.ATK += 10;
        player.baseDEF += 5;
    }

    // Player
    public player(String name) {
        this.name = name;
        baseHP = 5;
        HP = baseHP;
        ATK = 15;
        INT = 15;
        baseDEF = 5;
        level = 1;
    }

}
