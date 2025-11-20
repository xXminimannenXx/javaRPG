import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class combatLogic {
    
  
        

     
        public static void firstHit(int enemyAGL, int playerAGL){
            if(playerAGL >= enemyAGL){
                //spelare slå först

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
            return playerHP;
        }
        public static void xpGain(int gainedXP){
            //få xp om man har mer xp än vad som levelREQ calla levelUP script
        }
        public static void combat(){
            boolean combatRun = true;
            Random random = new Random();
            int enemyHP, enemyAGL, enemySTR;
            enemyHP = random.nextInt(5)+3;
            enemyAGL = random.nextInt(5)+3;
            enemySTR = random.nextInt(5)+3;
            firstHit(enemyAGL, getPlayerAGL());
            while (combatRun) {
                
            }




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
}
