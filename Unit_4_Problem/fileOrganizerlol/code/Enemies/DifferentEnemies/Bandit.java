package fileOrganizerlol.code.Enemies.DifferentEnemies;

import fileOrganizerlol.code.Enemies.EnemyBuild;
import fileOrganizerlol.code.Player.player;
import java.util.Random;
public class Bandit extends EnemyBuild {

    public Bandit(String name, int BaseHP, int ATk, int DEF) {
        super(name, BaseHP, ATk, DEF);
    }
    private Random rand = new Random();
    private int damage;
    @Override
    public int specialAttack(player player, int round) {
        
        damage = (int) ((int) rand.nextInt(this.getATK())*2.15);
        return damage;
    }
    @Override
    public String specialAttackLine() {
      return this.getName() + " used power house kick\nDealing " + damage + " damage";
    }

    
    
}
