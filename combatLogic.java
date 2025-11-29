
import java.util.Random;


public class CombatLogic {

    // Enemy class for better structure
    private static class Enemy {
        int HP;
        int AGL;
        int STR;
        int XPGained;

        Enemy() {
            Random random = new Random();
            this.HP = random.nextInt(5) + 3; // 3-7
            this.AGL = random.nextInt(5) + 3;
            this.STR = random.nextInt(5) + 3;
            this.XPGained = random.nextInt(50)+1;
        }
    }

    private static Enemy enemy;

    // Combat starts: determines turn order
    public static boolean playerStarts() {
        int playerAGL = GetPlayerStats.getPlayerStat(3); // AGL is line 3
        return playerAGL >= getEnemy().AGL;
    }

    // Main combat loop
    public static boolean combat() {
        enemy = new Enemy(); // generate a new enemy
        boolean playerTurn = playerStarts();

        System.out.println("\n--- Combat Start! ---\n");

        while (true) {
            if (playerTurn) {
                playerAttack();
            } else {
                enemyAttack();
            }

            if (enemy.HP <= 0) {
                System.out.println("You defeated the enemy!\n");
            
                XpSystem.getXP(getEnemy().XPGained);
                return true;
            }

            if (GetPlayerStats.getPlayerStat(2) <= 0) { // HP is line 2
                System.out.println("You died...\n");
                System.out.println("Thank you for playing, restart to play again :)");
                System.exit(0);
            }

            playerTurn = !playerTurn;
        }
    }

    // Player attacks enemy
    private static void playerAttack() {
        int playerSTR = GetPlayerStats.getPlayerStat(5); // STR is line 5
        enemy.HP -= playerSTR;

        System.out.println("You attack the enemy!");
        System.out.println("You deal " + playerSTR + " DMG!");
        System.out.println("Enemy has " + enemy.HP + " HP left.\n");
    }

    // Enemy attacks player
    private static void enemyAttack() {
        int enemySTR = getEnemy().STR;
        updatePlayerHP(-enemySTR);

        System.out.println("Enemy attacks!");
        System.out.println("Enemy deals " + enemySTR + " DMG!");
        System.out.println("You now have " + GetPlayerStats.getPlayerStat(2) + " HP left.\n");
    }

    // Update player's HP (or other stats if needed)
    private static void updatePlayerHP(int delta) {
        GetPlayerStats.changePlayerStat(2, delta); // HP is line 2
    }

    // Get enemy instance (lazy initialization)
    private static Enemy getEnemy() {
        if (enemy == null) {
            enemy = new Enemy();
        }
        return enemy;
    }

   
}
