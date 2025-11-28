import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class combatLogic {

    // Enemy class for better structure
    private static class Enemy {
        int HP;
        int AGL;
        int STR;

        Enemy() {
            Random random = new Random();
            this.HP = random.nextInt(5) + 3; // 3-7
            this.AGL = random.nextInt(5) + 3;
            this.STR = random.nextInt(5) + 3;
        }
    }

    private static Enemy enemy;

    // Combat starts: determines turn order
    public static boolean playerStarts() {
        int playerAGL = getPlayerStat(3); // AGL is line 3
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
                return true;
            }

            if (getPlayerStat(2) <= 0) { // HP is line 2
                System.out.println("You died...\n");
                System.out.println("Thank you for playing, restart to play again :)");
                System.exit(0);
            }

            playerTurn = !playerTurn;
        }
    }

    // Player attacks enemy
    private static void playerAttack() {
        int playerSTR = getPlayerStat(5); // STR is line 5
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
        System.out.println("You now have " + getPlayerStat(2) + " HP left.\n");
    }

    // Update player's HP (or other stats if needed)
    private static void updatePlayerHP(int delta) {
        changePlayerStat(2, delta); // HP is line 2
    }

    // Get enemy instance (lazy initialization)
    private static Enemy getEnemy() {
        if (enemy == null) {
            enemy = new Enemy();
        }
        return enemy;
    }

    // Generic method to read a stat from file by line number (1-based)
    public static int getPlayerStat(int lineNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader("SavedCharacter.txt"))) {
            String line;
            int current = 1;
            while ((line = br.readLine()) != null) {
                if (current == lineNumber) return Integer.parseInt(line);
                current++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Change a stat in the file by line number
    private static void changePlayerStat(int lineNumber, int delta) {
        try {
            Path path = Paths.get("SavedCharacter.txt");
            List<String> lines = Files.readAllLines(path);

            int index = lineNumber - 1; // 0-based
            if (index < 0 || index >= lines.size()) {
                System.out.println("Invalid line number: " + lineNumber);
                return;
            }

            int value = Integer.parseInt(lines.get(index));
            value += delta;
            lines.set(index, Integer.toString(value));

            Files.write(path, lines);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
