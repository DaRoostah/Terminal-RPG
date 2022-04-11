package fileOrganizerlol.code.Enemies;
import java.util.Random;

import fileOrganizerlol.code.Player.player;

public abstract class EnemyBuild {
    private int BaseHP, HP, ATK, DEF, experienceOnDeath;
    private String name;
    private Random rand;
    public EnemyBuild(String name, int BaseHP, int ATk, int DEF) {
        this.name = name;
        this.BaseHP = BaseHP;
        this.HP = BaseHP;
        this.ATK = ATk;
        this.DEF = DEF;
    }

    public EnemyBuild() {}
    
    public int drops() {
        double experienceOnDeath = Math.pow(getBaseHP(), 2) ;
        return (int) experienceOnDeath;
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

    public int specialAttack(player player) {
        return this.ATK + 5;
    }

    public String specialAttackLine() {
      return "";
    }
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