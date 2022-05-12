package fileOrganizerlol.code.Player;

import java.util.Random;

public class player {
    private String name;
    private int level;
    private int baseHP;
    private int baseDEF;
    private int HP, ATK, INT, cEXP;
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
        this.level += x;
    }
    public void setBaseHP(int x) {
        this.baseHP += x;
    }
    public void setHP(int x) {
        this.HP = x;
    }
    public void decreaseHP(int x) {
        this.HP -= x;
    }
    public void increaseHP(int x) {
        this.HP += x;
    }
    public void setATK(int x) {
        this.ATK += x;
    }
    public void setINT(int x) {
        this.INT += x; 
    }
    public void setBaseDEF(int x) {
        this.baseDEF += x;
    }
    public void killPlayer() {
        this.HP = 0;
    }
    public void healPlayer() {
        this.HP = this.baseHP;
    }
    public void setCurrentEXP(int x) {
        this.cEXP += x;
    }
    public void increaseCurrentEXP(int x) {
        this.cEXP += x;
    }
    public void decreaseCurrentEXP(int x) {
        this.cEXP -= x;
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
        this.baseHP += 15;
        this.HP = (int)this.baseHP/20;
        this.ATK += 10;
        this.baseDEF += 5;
    }
    public boolean poisonDebuff() {
        return true;
    }

    public void loadPlayer(String name, int baseHP, int HP, int ATK, int INT, int baseDEF, int level, int cEXP) {
        this.name = name;
        this.baseHP = baseHP;
        this.HP = HP;
        this.ATK = ATK;
        this.INT = INT;
        this.baseDEF = baseDEF;
        this.level = level;
        this.cEXP = cEXP;
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
