package fileOrganizerlol.code.TheGameItself;
// Import different files from other files

// Player file
import fileOrganizerlol.code.Player.*;
import fileOrganizerlol.Store.LevelUp;
// Enemy files
import fileOrganizerlol.code.Enemies.EnemyBuild;
import fileOrganizerlol.code.Enemies.EnemyChooser;

// Import libraries
import java.util.Scanner;
import java.util.Random;

public class game {
    private static player player;
    private static Scanner sc;
    private static EnemyChooser Renemy = new EnemyChooser();
    private static boolean began = false, running;
    private static Random rand = new Random();
    private static LevelUp marketplace = new LevelUp();
    /***********\
     * GAME :D *
    \***********/
    public static void runGame() {
        
        if(!began) {
            sc = new Scanner(System.in);
            System.out.print("What is your name?\n\t> ");
            // player = new player(sc.nextLine()); 
            DEBUG: player = new player("DEBUG");

            System.out.println("---------------------------------------------------------------------");
            System.out.println(player.getName() + "'s Stats\n" +
                               "HP: " + player.getHP() + "\\" + player.getBaseHP());
            System.out.println("---------------------------------------------------------------------");
            
            System.out.println("\nThese are your stats ^^");
            began = true;
        }

        running = true;
        run:
        while(running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Fight Enemies");
            System.out.println("2. Rest");
            System.out.println("3. Show Stats");
            System.out.println("4. Show Store");
            System.out.println("5. Quit");
            int intInput = sc.nextInt();
            switch(intInput) {
                case 1: EnemyBuild enemy = Renemy.chosenEnemy();
                        fightOver = false;
                        fightEnemy(player, enemy);
                        break;
                case 2: rest(player);
                        break;
                case 3: showStats(player);
                        break;
                case 4: inMarketPlace(player);
                        break;
                case 5: cya();
                        break;
                default: System.out.println("That's not a valid command");
                         continue run;
            }
        }
    }

    /****************\
     * MECHANICS :D *
    \****************/
    
    // Player starts fight with a enemy
    private static boolean fightStarted = false, fightOver = false;
    private static int round;
    public static void fightEnemy(player player, EnemyBuild enemy) {
        if(!fightStarted || !fightOver) {
            round = 0;
            fightStarted = true;
        }


        run:
        while(fightStarted && !fightOver) {

            if(enemy.getHP() <= 0) {
                round = 0;
                fightOver = true;
                System.out.println("You have defeated " + enemy.getName() + " Congratulations!");
                runGame();
            }

            if(player.getHP() <= 0) {
                fightOver = true;
                player.killPlayer();
                cya(player, enemy);
                break;
            } else {
                makeLines();
                showFightStats(player, enemy);
            }
            round++;
            System.out.println("What do you want to do?");
            System.out.println("1. Attack");
            System.out.println("2. Rest");
            System.out.println("3. Run");
            int intInput = sc.nextInt();
            
            switch(intInput) {
                case 1: Attack(player, enemy);
                        break;
                case 2: rest(player, enemy);
                        break;
                case 3: run();
                        break;
                default: System.out.println("That's not valid command.");
                         continue run;
            }
        }
        
    }
    
    // Method for the player fighting
    public static void Attack(player player, EnemyBuild enemy) {
        switch(rand.nextInt(3)) {
            case 0: System.out.println("You slashed " + enemy.getName());
                    break;
            case 1: System.out.println("You tackled " + enemy.getName());
                    break;
            case 2: System.out.println("You sliced " + enemy.getName());
                    break;
            default: System.out.println("You kicked " + enemy.getName());
        }
        int playerDamage = rand.nextInt(player.getATK());
        System.out.println("Dealing " + enemy.getDamageTaken(playerDamage) + " damage!");
        
        enemy.DamageTaken(playerDamage);
        enemyAttacks(player, enemy);
    }

    // A way for the enemy to attack!
    public static void enemyAttacks(player player, EnemyBuild enemy) {
        if (rand.nextInt(100)<=10) {
          int enemyDamage = enemy.specialAttack(player);
          System.out.println(enemy.specialAttackLine());
          player.setHP(enemyDamage);
        } else {
            int enemyDamage = enemy.getDamageDealt();
            System.out.println("The Enemy tackled you for " + enemyDamage + " damage");
            player.setHP(enemyDamage);
        }
    }

    // One way to heal! B)

    public static void rest(player player, EnemyBuild enemy) {
        if(player.getHP() > player.getBaseHP()) {
            player.setHP((player.getBaseHP() - player.getHP())*-1);
        }
        int healAmount = (rand.nextInt(player.getINT())+5)*-1;
        player.setHP(healAmount);
        System.out.println(player.getName() + " has healed for " + String.valueOf(healAmount*-1) + " HP!");
        enemyAttacks(player, enemy);
    }


    public static void rest(player player) {
        System.out.println("\n\nYou have fully rested, and returned to max stats");
        player.setHP((player.getBaseHP() - player.getHP())*-1);
        showStats(player);
    }
    
    // A way to run from the enemy
    public static void run() {
        makeLines();
        System.out.println("You ran and didn't fight back!");
        fightOver = true;
    }

    /*****************\
     * STATISTICS :D *
    \*****************/

    // Show the stats during the fight!
    public static void showFightStats(player player, EnemyBuild enemy) {
        showStats(player);
        System.out.println("\n");
        showEnemyStats(enemy);
        System.out.println("\n");
    }

    // Show player's statistics! :)
    private static void showStats(player player) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println(player.getName() + "'s Stats\n" +
                           "HP: " + player.getHP() + "\\" + player.getBaseHP());
        System.out.println("---------------------------------------------------------------------");
    }

    // Show's the evil enemy statistics muahahaha >:D
    private static void showEnemyStats(EnemyBuild enemy) {
        if(enemy.getHP() <= 0)
        enemy.killEnemy();
        System.out.println("---------------------------------------------------------------------");
        System.out.println(enemy.getName() + "'s Stats\n" +
                           "HP: " + enemy.getHP() + "\\" + enemy.getBaseHP());
        System.out.println("---------------------------------------------------------------------");
    }

    // The marketplace for levels!
    private static void inMarketPlace(player player) {
        System.out.println(marketplace.showStore(player));
    }

    // Leaving the game :(
    public static void cya(player player, EnemyBuild enemy) {
        running = false;
        makeLines();
        if(player.getHP() <= 0) {
            showFightStats(player, enemy);
            System.out.println("Should've just used recovery breathing smh");
        }
    }
    public static void cya() {
        running = false;
        makeLines();
        System.out.println("Thanks for playing the game!");
    }

    // Makes lines in the output! :D     
    private static void makeLines() {
        for(int i = 0;i < 15;i++) {
            System.out.print("\n");
        }
    }

}
