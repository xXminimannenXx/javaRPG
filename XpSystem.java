import java.util.Scanner;

public class XpSystem {
    public static int currentXP = 0;
    public static int neededXP = 50;
    public static int level = 1;
   




  public static void getXP(int xpgain) {
   
    int intelligence = GetPlayerStats.getPlayerStat(4);
    currentXP += xpgain * ((intelligence + 1));  
    LevelUp();
}

   public static void LevelUp() {
    
    while (currentXP >= neededXP) {
        currentXP -= neededXP;
        level++;
        neededXP = (int)(neededXP * 1.5f);
        playerInteractLevelup();
    }
}

    public static void playerInteractLevelup(){
        Scanner uInput = new Scanner(System.in); 
        GetPlayerStats.printPlayerStats();
        System.out.print("\n Brave adventurer you have gained enough expericence during your travles to incresse on of your stats with 1 point, enter the index of the stat you want to incress\n");
        int userInput = uInput.nextInt();
        
        GetPlayerStats.changePlayerStat(userInput, 1);
        

    }
}
