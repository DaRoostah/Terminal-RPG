package fileOrganizerlol.code.Enemies;

import java.util.ArrayList;
import java.util.Random;

import fileOrganizerlol.code.Enemies.DifferentEnemies.Bandit;
import fileOrganizerlol.code.Enemies.DifferentEnemies.Slime;
import fileOrganizerlol.code.Player.player;
public class EnemyChooser {
    private Random rand = new Random();
    public EnemyBuild chosenEnemy(player player) {
        
        ArrayList<EnemyBuild> randEnemy = new ArrayList<EnemyBuild>();
        randEnemy.add(new Slime("Slime", rand.nextInt(5*(int)(player.getLevel()*1.625))+1, rand.nextInt(5*(int)(player.getLevel()*1.625))+1, rand.nextInt(15*(int)(player.getLevel()*1.625))));
        randEnemy.add(new Bandit("Bandit", rand.nextInt(15*(int)(player.getLevel()*1.625))+1, rand.nextInt(10*(int)(player.getLevel()*1.625))+1, rand.nextInt(5*(int)(player.getLevel()*1.625))+1));
        return randEnemy.get(rand.nextInt(randEnemy.size()));
    }    
    
}
