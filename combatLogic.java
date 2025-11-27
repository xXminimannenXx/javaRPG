import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class combatLogic {
    private static int enemyHP;
    private static int enemyAGL;
    private static int enemySTR;
    private static boolean generated = false;

        
    public static int getEnemyStats(String stat) {
        if (!generated) {
            Random random = new Random();
            enemyHP = random.nextInt(5) + 3;
            enemyAGL = random.nextInt(5) + 3;
            enemySTR = random.nextInt(5) + 3;
            generated = true;
        }

        switch (stat) {
            case "HP": return enemyHP;
            case "AGL": return enemyAGL;
            case "STR": return enemySTR;
        }
        return -1;
    }

   
    public static void playerAttack() {
        int playerSTR = getPlayerSTR();
        enemyHP -= playerSTR;   // MINSKA PÅ RIKTIGT

        System.out.println("You attack the enemy!"); 
        System.out.println("You deal " + playerSTR + " DMG!");
        System.out.println("The enemy has " + enemyHP + " HP left.\n");
    }

   
    public static void enemyAttack() {
        int newHP = getPlayerHp() - enemySTR;
        updatePlayerHP(newHP - getPlayerHp()); // bara skillnaden

        System.out.println("Enemy attacks!");
        System.out.println("Enemy deals " + enemySTR + " DMG!");
        System.out.println("You now have " + newHP + " HP left.\n");
    }

    public static boolean playerStarts() {
        int playerAGL = getPlayerAGL();
        int eAGL = getEnemyStats("AGL");

        return playerAGL >= eAGL;
    }

  
    public static boolean combat() {
        boolean playerTurn = playerStarts();
        boolean fighting = true;

        System.out.println("\n--- Combat Start! ---\n");

        while (fighting) {

            if (playerTurn) {
                playerAttack();
            } else {
                enemyAttack();
            }

            
            if (enemyHP <= 0) {
                System.out.println("You defeated the enemy!\n");
                resetEnemy();
                return true;
            }

            if (getPlayerHp() <= 0) {
                System.out.println("You died...\n");
                resetEnemy();
                System.out.println("Thank you for playing, restart to play again :)");
                System.exit(0);
                return false;
            }

            playerTurn = !playerTurn; // byt tur
        }
        return false;
    }

    
    private static void resetEnemy() {
        generated = false;
    }

    
    public static void updatePlayerHP(int hpDelta) {
        // hpDelta är en förändring, t.ex. -3
        changePlayerStat(2, hpDelta);
    }

       public static int getPlayerHp() {
    try (BufferedReader br = new BufferedReader(new FileReader("SavedCharacter.txt"))) {
        String line;
        int lineNumber = 1;

        while ((line = br.readLine()) != null) {
            if (lineNumber == 2) { // rad 2
                return Integer.parseInt(line);
            }
            lineNumber++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return -1; // om raden inte finns
}

        public static int getPlayerSTR(){
              try (BufferedReader br = new BufferedReader(new FileReader("SavedCharacter.txt"))){
                String line;
                int lineNumber = 1;
                while((line = br.readLine()) != null){
                    if (lineNumber == 5){
                        return Integer.parseInt(line);
                    }
                    lineNumber++;
                }
              
            } catch (IOException e){
                e.printStackTrace();
            }
            return -1;
        }
        public static int getPlayerINT(){
              try(BufferedReader br = new BufferedReader(new FileReader("SavedCharacter.txt"))){
                String line;
                int lineNumber = 1;
                while((line = br.readLine()) != null){
                    if(lineNumber == 4){
                        return Integer.parseInt(line);
                    }
                    lineNumber++;
                }
              
            } catch (IOException e){
                e.printStackTrace();
            }
        return -1;
            
        }
        public static int getPlayerAGL(){
              try(BufferedReader br = new BufferedReader(new FileReader("SavedCharacter.txt"))){
               String line;
               int lineNumber = 1;
               while((line = br.readLine()) != null){
                    if(lineNumber == 3){
                        return Integer.parseInt(line);
                    }
                    lineNumber++;
               }

            } catch (IOException e){
                e.printStackTrace();
            }
        return -1;
        }
       public static void changePlayerStat(int rad, int statChange) {
    try {
        // Read all lines into a List<String>
        Path path = Paths.get("SavedCharacter.txt");
        List<String> lines = Files.readAllLines(path);

        // rad is 1-based, list is 0-based
        int index = rad - 1;

        // Safety check
        if (index < 0 || index >= lines.size()) {
            System.out.println("Invalid line number: " + rad);
            return;
        }

        // Parse, modify, save
        int value = Integer.parseInt(lines.get(index));
        value += statChange;
        lines.set(index, Integer.toString(value));

        // Write changes back to file
        Files.write(path, lines);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
