package fileOrganizerlol.code.Enemies;
import java.util.Random;

import fileOrganizerlol.code.Player.player;

public abstract class EnemyBuild {
    private int BaseHP, HP, ATK, DEF;
    private String name;
    private Random rand;
    public EnemyBuild(String name, int BaseHP, int ATk, int DEF) {
        this.name = name;
        this.BaseHP = BaseHP;
        this.HP = BaseHP;
        this.ATK = ATk;
        this.DEF = DEF;
    }
    public void resetEnemy(int x, int y, int z) {
        this.BaseHP = x;
        this.HP = this.BaseHP;
        this.ATK = y;
        this.DEF = z;
    }
    public EnemyBuild() {}
    
    public int drops() {
        return (int) (Math.pow(this.BaseHP, 2));
    }
    public String getName() {
        return name;
    }
    public int getBaseHP() {
        return BaseHP;
    }
    public int getHP() {
        return HP;
    }
    public int getDEF() {
        return DEF;
    }
    public int getATK() {
        return this.ATK;
    }
    public void setHP(int x) {
        this.HP -= x;
    }
    public void killEnemy() {
        this.HP = 0;
    }

    public int getDamageDealt() {
        rand = new Random();
        return rand.nextInt(this.ATK);
    }

    public abstract int specialAttack(player player,int round);
    public abstract String specialAttackLine();
    
    public void DamageTaken(int pATK) {
        HP -= this.getDamageTaken(pATK);
    }

    public int getDamageTaken(int pATK) {
        int DMG;
        DMG = pATK - DEF;
        if(DMG < 0) {
            DMG = 0;
        }
        return DMG;
    }
    
}