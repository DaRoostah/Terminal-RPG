package fileOrganizerlol.code.Player;
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
