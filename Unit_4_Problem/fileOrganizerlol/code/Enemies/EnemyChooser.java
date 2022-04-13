package fileOrganizerlol.code.Enemies;

import java.util.ArrayList;
import java.util.Random;

import fileOrganizerlol.code.Enemies.DifferentEnemies.Bandit;
import fileOrganizerlol.code.Enemies.DifferentEnemies.Slime;
import fileOrganizerlol.code.Player.player;
public class EnemyChooser {
    private Random rand = new Random();
    private ArrayList<EnemyBuild> randEnemy;
    private EnemyBuild EnemyChosen;
    // private void resetEnemy(EnemyBuild enemyChosen, player player) {
    //     enemyChosen.resetEnemy(rand.nextInt(5*(int)(player.getLevel()*1.2))+1, rand.nextInt(5*(int)(player.getLevel()*1.2))+1, rand.nextInt(5*(int)(player.getLevel()*1.2)));
    // }
    public EnemyBuild chosenEnemy(player player) {
        
        randEnemy = new ArrayList<EnemyBuild>();
        randEnemy.add(new Slime("Slime", rand.nextInt(5*(int)(player.getLevel()*1.2))+1, rand.nextInt(5*(int)(player.getLevel()*1.2))+1, rand.nextInt(5*(int)(player.getLevel()*1.2))));
        randEnemy.add(new Bandit("Bandit", rand.nextInt(5*(int)(player.getLevel()*1.2))+1, rand.nextInt(10*(int)(player.getLevel()*1.2))+1, rand.nextInt(5*(int)(player.getLevel()*1.2))+1));
        EnemyChosen = randEnemy.get(rand.nextInt(randEnemy.size()));
        // resetEnemy(EnemyChosen, player);
        return EnemyChosen;
    }    
    
}
