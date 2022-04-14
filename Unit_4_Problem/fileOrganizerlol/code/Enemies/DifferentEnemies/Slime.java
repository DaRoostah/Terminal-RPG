package fileOrganizerlol.code.Enemies.DifferentEnemies;

import fileOrganizerlol.code.Enemies.EnemyBuild;
import fileOrganizerlol.code.Player.player;
import java.util.Random;
public class Slime extends EnemyBuild {

    public Slime(String name, int BaseHP, int ATk, int DEF) {
        super(name, BaseHP, ATk, DEF);
    }
    private Random rand = new Random();
    private int damage, healed;

    @Override
    public int specialAttack(player player, int round) {
        damage = rand.nextInt(this.getATK());
        healed = (int) (damage*1.5)*-1;
        this.setHP((int) (damage*1.5)*-1);
        if(this.getHP()>this.getBaseHP()) {
            this.setHP(this.getBaseHP()-healed);
        }
        return damage;
    }
    @Override
    public String specialAttackLine() {
      return this.getName() + " used absorb!\nDealing " + damage + "\nHealing for " + String.valueOf(healed*-1) + " health!";
    }

    
    
}
