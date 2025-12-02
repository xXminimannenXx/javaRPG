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

  public static void playerInteractLevelup() {
    Scanner uInput = new Scanner(System.in); 
    
    while(true) {
        GetPlayerStats.printPlayerStats();
        System.out.println("\nLevel Up! Choose stat to increase:");
        System.out.println("1 - HP | 2 - Agility | 3 - Intelligence | 4 - Strength");
        System.out.print("Choice: ");
        
        try {
            int choice = Integer.parseInt(uInput.nextLine().trim());
            
            if (choice >= 1 && choice <= 4) {
                GetPlayerStats.changePlayerStat(choice, 1);
                System.out.println("Stat increased!");
                break;
            }
            System.out.println("Please enter 1, 2, 3, or 4.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
}
