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

        public static int getEnemyStats(String stat){
           
        if (!generated) {
            Random random = new Random();

            enemyHP = random.nextInt(5) + 3;
            enemyAGL = random.nextInt(5) + 3;
            enemySTR = random.nextInt(5) + 3;

            generated = true;
        }

            switch (stat) {
                case "HP":
                    return enemyHP;
                case "AGL":
                return enemyAGL;
                case "STR":
                return enemySTR;
                default:
                    return -1;
            }




        }

     
        public static void firstHit(int enemyAGL, int playerAGL){
            if(playerAGL >= enemyAGL){
               playerAttack(getEnemyStats("HP"),getPlayerSTR());
                
            }
            else{
                //fiende slå först
            }
            
        }
        public static int playerAttack(int enemyHP, int playerSTR){

            enemyHP -=playerSTR;
            return enemyHP;

        }
        public static int enemyAttack(int playerHP, int enemySTR){
            playerHP -= enemySTR;
            updatePlayerHP(playerHP);
            return playerHP;
        }
        public static void xpGain(int gainedXP){
            //få xp om man har mer xp än vad som levelREQ calla levelUP script
        }
        public static boolean combat(){
            boolean combatRun = true;
            boolean win = true;
            boolean playerTurn = true;
            firstHit(getEnemyStats("AGL"), getPlayerAGL());
            while (combatRun) {
                if(getPlayerHp() > 0 && getEnemyStats("HP") > 0){
                    if(playerTurn){
                        playerAttack(getEnemyStats("HP"), getPlayerSTR());
                            playerTurn = false;
                        }
                    if(!playerTurn){
                        enemyAttack(getPlayerHp(),getEnemyStats("STR"));
                        playerTurn = true;

                    }


                    }
                    if(getPlayerHp() < 0){
                       
                        combatRun = false;
                        win = false;
                         return win;
                    }  
                    else if(getEnemyStats("HP")< 0){
                        combatRun = false;
                        win = true;
                        return win;


                    }
                    else{
                        combatRun = true;
                    }

                }
            
        


            if(win == true){
                return true;

            }
            else{
                return false;
            }
        }
        public static void updatePlayerHP(int newHP){
           changePlayerStat(2, newHP);
        }
        public static void updateEnemyHP(int newHP){
            enemyHP = newHP;


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
