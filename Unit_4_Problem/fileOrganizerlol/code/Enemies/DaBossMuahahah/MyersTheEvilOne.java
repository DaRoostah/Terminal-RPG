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
        switch(rand.nextInt(3)) {
            case 0: damage = (int) ((int) rand.nextInt(this.getATK())*2.5);
                    return damage;
            case 1: damage = rand.nextInt(this.getATK());
                    int healed = (int) (damage*1.5)*-1;
                    this.setHP((int) (damage*1.5)*-1);
                    if(this.getHP()>this.getBaseHP()) {
                        this.setHP(this.getBaseHP()-healed);
                    }
                    return damage;
            case 2: player.poisonDebuff();
                    
            default: return 0;
        }
    }
    @Override
    public String specialAttackLine() {
      return this.getName() + " used 1st form, code breathing, FORK YOUR REPLIT!!\nDealing " + damage + " damage";
    }

    
    
}
