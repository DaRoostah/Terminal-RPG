package fileOrganizerlol.code.Enemies.DaBossMuahahah;

import fileOrganizerlol.code.Enemies.EnemyBuild;
import fileOrganizerlol.code.Player.player;
import java.util.Random;
public class MyersTheEvilOne extends EnemyBuild {

    public MyersTheEvilOne(String name, int BaseHP, int ATk, int DEF) {
        super(name, BaseHP, ATk, DEF);
    }
    private Random rand = new Random();
    private int damage;
    @Override
    public int specialAttack(player player) {
        damage = (int) ((int) rand.nextInt(this.getATK())*2.5);
        return damage;
    }
    @Override
    public String specialAttackLine() {
      return this.getName() + " used 1st form, code breathing, FORK YOUR REPLIT!!\nDealing " + damage + " damage";
    }

    
    
}
