package fileOrganizerlol.code.TheGameItself;
// Import different files from other files

// Player file
import fileOrganizerlol.code.Player.*;
import fileOrganizerlol.code.Store.LevelUp;
import fileOrganizerlol.DataStorage.Data;
// Enemy files
import fileOrganizerlol.code.Enemies.EnemyBuild;
import fileOrganizerlol.code.Enemies.EnemyChooser;

// Import libraries
import java.util.Scanner;
import java.util.Random;

public class game {
    /*****************\
     * Player Var! :D *
    \*****************/
    private static player player;
    private static Scanner sc;
    private static EnemyChooser Renemy = new EnemyChooser();
    private static boolean began = false, running = true, levelUp, quitting = false;
    private static int levelsGained = 0;
    private static Random rand = new Random();
    private static LevelUp marketplace = new LevelUp();
    /***********\
     * GAME :D *
    \***********/
    public static void runGame() {
        
        if(!began) {
            sc = new Scanner(System.in);
            System.out.print("What is your name?\n\t> ");
            player = new player(sc.nextLine()); 
            // DEBUG: player = new player("DEBUG");
            showStats(player);
            System.out.println("\nThese are your stats ^^");
            began = true;
        }
        run:
        while(running && !quitting) {

            if(levelUp) {
              System.out.println("\nWhat would you like to do?");
              System.out.println("1. Fight Enemies");
              System.out.println("2. Rest");
              System.out.println("3. Show Stats");
              System.out.println("4. Level Up!");
              System.out.println("5. Save Game");
              System.out.println("6. Quit");
              int intInput = sc.nextInt();
              switch(intInput) {
                case 1: EnemyBuild enemy = Renemy.chosenEnemy(player);
                        fightStarted = true;
                        fightEnemy(player, enemy);
                        break;
                case 2: rest(player);
                        break;
                case 3: showStats(player);
                        break;
                case 4: inMarketPlace(player);
                        break;
                case 5: saveGame(player);
                        break;
                case 6: cya();
                        quitting = true;
                        break;
                default: System.out.println("That's not a valid command");
                        continue run;
              }
            } else {
              System.out.println("\nWhat would you like to do?");
              System.out.println("1. Fight Enemies");
              System.out.println("2. Rest");
              System.out.println("3. Show Stats");
              System.out.println("4. Save Game");
              System.out.println("5. Quit");
              int intInput = sc.nextInt();
              switch(intInput) {
                  case 1: EnemyBuild enemy = Renemy.chosenEnemy(player);
                          fightStarted = true;
                          fightEnemy(player, enemy);
                          break;
                  case 2: rest(player);
                          break;
                  case 3: showStats(player);
                          break;
                  case 4: saveGame(player);
                          break;
                  case 5: cya();
                          quitting = true;
                          break;
                  default: System.out.println("That's not a valid command");
                          continue run;
              }
            }
        }
    }

    /****************\
     * MECHANICS :D *
    \****************/
    
    // Player starts fight with a enemy
    private static boolean fightStarted = false;
    private static int round;
    public static void fightEnemy(player player, EnemyBuild enemy) {
        run:
        while(fightStarted && !quitting) {
            if(player.getHP() <= 0) {
                if(rand.nextInt(100) < 15) {
                    player.usePlotArmor();
                } else {
                    quitting = true;
                    fightStarted = false;
                    cya(player, enemy);
                    break;
                }
            }
            if(enemy.getHP() <= 0) {
                round = 0;
                fightStarted = false;
                System.out.println("\nYou have defeated " + enemy.getName() + " Congratulations!");
                System.out.println("EXP gained: " + enemy.drops());
                player.increaseCurrentEXP(enemy.drops());
                if(player.getCurrentEXP()>=player.getBaseEXP()) {
                    levelUpPlayer(player);
                }
                runGame();
            }  else {
                makeLines();
                showFightStats(player, enemy);
            }

            round++;
            if(!quitting) {
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
        } // Out of loop
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
          player.decreaseHP(enemyDamage);
        } else {
            int enemyDamage = enemy.getDamageDealt();
            System.out.println("The Enemy tackled you for " + enemyDamage + " damage");
            player.decreaseHP(enemyDamage);
        }
    }

    // One way to heal! B)
    public static void rest(player player, EnemyBuild enemy) {

        int healAmount = (rand.nextInt(player.getINT())+5);
        player.increaseHP(healAmount);
        System.out.println(player.getName() + " has healed for " + String.valueOf(healAmount*-1) + " HP!");
        enemyAttacks(player, enemy);
        if(player.getHP() > player.getBaseHP()) {
            player.setHP(player.getBaseHP());
        }
    }


    public static void rest(player player) {
        System.out.println("\n\nYou have fully rested, and returned to max stats");
        player.healPlayer();
        showStats(player);
    }
    
    // A way to run from the enemy
    public static void run() {
        makeLines();
        System.out.println("You ran and didn't fight back!");
        fightStarted = false;
    }

    /****************\
     * STATISTICS :D *
    \****************/

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
        String stats = player.getName() + "'s Stats\n" +
        "Level: " + player.getLevel() + "\tEXP: " + player.getCurrentEXP() + "/" + player.getBaseEXP() +
        "\nHP: " + player.getHP() + "/" + player.getBaseHP() + "\tDEF: " + player.getBaseDEF();
        if(!fightStarted)
            stats = player.getName() + "'s Stats\n" +
            "Level: " + player.getLevel() + "\tEXP: " + player.getCurrentEXP() + "/" + player.getBaseEXP() +
            "\nHP: " + player.getHP() + "/" + player.getBaseHP() + "\tDEF: " + player.getBaseDEF() +
            "\nATK: " + player.getATK() + "\tINT: " + player.getINT();
        System.out.println(stats);
        System.out.println("---------------------------------------------------------------------");
    }

    // Show's the evil enemy statistics muahahaha >:D
    private static void showEnemyStats(EnemyBuild enemy) {
        if(enemy.getHP() <= 0)
            enemy.killEnemy();
        System.out.println("---------------------------------------------------------------------");
        System.out.println(enemy.getName() + "'s Stats\n" +
                           "\nHP: " + enemy.getHP() + "/" + enemy.getBaseHP() +
                           "\nDEF: " + enemy.getDEF());
        System.out.println("---------------------------------------------------------------------");
    }

    /************\
     * Levels :D *
    \************/

    private static void levelUpPlayer(player player) {
        while(player.getCurrentEXP()>=player.getBaseEXP()) {
            player.decreaseCurrentEXP(player.getBaseEXP());
            levelsGained++;
        }
        if(player.getCurrentEXP()<0)
            player.setCurrentEXP(0);
        if(levelsGained!=0) {
            levelUp = true;
            System.out.println("\nYou leveled up: " + String.valueOf(levelsGained) + " times!");
            player.setLevel(levelsGained);
        }
    }
    // The marketplace for levels!
    private static void inMarketPlace(player player) {
        run:
        for(int pointsUsed = 0; pointsUsed < levelsGained;levelsGained--) {
          System.out.println("Points to spend: " + levelsGained + "\n" + marketplace.showStore(player));
            int input = sc.nextInt();
            switch(input) {
                case 1: player.setBaseHP(10); levelUp = false;
                        break;
                case 2: player.setBaseDEF(2); levelUp = false;
                        break;
                case 3: player.setATK(10);    levelUp = false;
                        break;
                case 4: player.setINT(2);     levelUp = false;
                        break;
                default: System.out.println("Invalid Command"); continue run;
            }
        }
    }

    // Leaving the game :(
    public static void cya(player player, EnemyBuild enemy) {

        fightStarted = false;
        makeLines();
        showFightStats(player, enemy);
        System.out.println("Should've just used recovery breathing smh");
    }
    public static void cya() {
        running = false;
        fightStarted = false;
        makeLines();
        System.out.println("Thanks for playing the game!");
    }

    // Makes lines in the output! :D     
    private static void makeLines() {
        for(int i = 0;i < 15;i++) {
            System.out.print("\n");
        }
    }

    private static void saveGame(player player) {
      Data d = new Data();
      sc = new Scanner(System.in);
      System.out.println("Which slot do you want to save your game? (1, 2, 3)");
      int Input = sc.nextInt();
      d.Save(Input, player);
      System.out.println("Game Saved!");
    }

}
