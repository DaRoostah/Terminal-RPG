package fileOrganizerlol.code.Enemies;

import java.util.ArrayList;
import java.util.Random;

import fileOrganizerlol.code.Enemies.DifferentEnemies.Bandit;
import fileOrganizerlol.code.Enemies.DifferentEnemies.Slime;
public class EnemyChooser {
    private Random rand = new Random();
    public EnemyBuild chosenEnemy() {
        ArrayList<EnemyBuild> randEnemy = new ArrayList<EnemyBuild>();
        randEnemy.add(new Slime("Slime", rand.nextInt(30)+1, rand.nextInt(10)+1, rand.nextInt(1)+1));
        randEnemy.add(new Bandit("Bandit", rand.nextInt(50)+1, rand.nextInt(20)+1, rand.nextInt(5)+1));
        return randEnemy.get(rand.nextInt(randEnemy.size()));
    }    
    
}
