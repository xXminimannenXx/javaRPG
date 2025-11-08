import java.util.Random;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class chestLogic {
    //loot är tänkt att ge +1 på den staten man får de i rn på potionsen, kan också ha olika variationer på antinen saker så typ intellegence kan vara en bok för +1 etc
    public static void runChest(){
       Random random = new Random();
        //int lootRand = random.nextInt(0)+1;
        int lootRand = 1;
        System.out.print("\033[H\033[2J");
        loot(lootRand);
         try{
                Thread.sleep(1000);
                enviromentCheck.changeEnv("outside");
                return;
                }catch(InterruptedException e){
                      e.printStackTrace();

                }

    }
    public static void loot(int lootRand){
        switch (lootRand) {
            case 1:
                System.out.print("------------------------\n");
                System.out.print("|You got a healt potion|\n");
                System.out.print("------------------------\n"); 
                return;
                
        
            default:
                break;
        }

    }
    

}
