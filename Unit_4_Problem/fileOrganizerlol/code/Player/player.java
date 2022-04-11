package fileOrganizerlol.code.Player;

public class player {
    private String name;
    private static int level, baseHP, baseDEF;
    private static int HP, ATK, INT;
    // Accessors
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

    public static int getBaseDEF() {
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
        player.HP -= x;
    }
    public void setATK(int x) {
        player.ATK = x;
    }
    public void setINT(int x) {
        player.INT += x; 
    }
    public void killPlayer() {
        player.HP = 0;
    }

    // Player
    public player(String name) {
        this.name = name;
        baseHP = 25;
        HP = baseHP;
        ATK = 15;
        INT = 15;
        baseDEF = 5;
        level = 1;
    }

}
