import java.util.Random;
import java.io.FileReader;

public class combatLogic {
    
        int enemyHP, enemyAGL, enemySTR;

        public static void enemyStats(int enemyHP, int enemyAGL, int enemySTR){
            Random random = new Random();
            enemyHP = random.nextInt(5)+3;
            enemyAGL = random.nextInt(5)+3;
            enemySTR = random.nextInt(5)+3;
        }
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
        public static void xpGain(int gainedXP, int levelREQ){
            //få xp om man har mer xp än vad som levelREQ calla levelUP script
        }
}
