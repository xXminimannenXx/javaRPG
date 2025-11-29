import java.util.Random;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

 
public class ChestLogic {
    //loot är tänkt att ge +1 på den staten man får de i rn på potionsen, kan också ha olika variationer på antinen saker så typ intellegence kan vara en bok för +1 etc
    public static void runChest(){
       Random random = new Random();
       int lootRand = random.nextInt(4)+1;
       
        System.out.print("\033[H\033[2J");
        loot(lootRand);
         try{
                Thread.sleep(1000);
               EnviromentCheck.changeEnv("outside");
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
                //increaseStat("SavedCharacter.txt", "hp", 1);
                GetPlayerStats.changePlayerStat(2, 1);
                return;
              case 2:
                System.out.print("------------------------\n");
                System.out.print("|You got a rabbits foot|\n");
                System.out.print("------------------------\n"); 
                //increaseStat("SavedCharacter.txt", "agility", 1);
                GetPlayerStats.changePlayerStat(3, 1);
                return;
          
            case 3:
                System.out.print("-----------------------------\n");
                System.out.print("|You got a tome of knowladge|\n");
                System.out.print("-----------------------------\n"); 
                //increaseStat("SavedCharacter.txt", "intelligence", 1);
                GetPlayerStats.changePlayerStat(4, 1);
                return;
            case 4:
                System.out.print("------------------------\n");
                System.out.print("|You got a strengh rune|\n");
                System.out.print("------------------------\n"); 
                //increaseStat("SavedCharacter.txt", "strength", 1);
                GetPlayerStats.changePlayerStat(5, 1);
                return;
            default:
                break;
        }

    }
    //100% inte chatgpt va absoult inte lite lat
     public static void increaseStat(String fileName, String stat, int amount) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Kunde inte läsa filen: " + e.getMessage());
            return;
        }

        if (lines.size() < 5) {
            System.out.println("Felaktigt format i filen!");
            return;
        }

        // index: 0=name, 1=hp, 2=agility, 3=intelligence, 4=strength
        switch (stat.toLowerCase()) {
            case "hp":
                lines.set(1, Integer.toString(Integer.parseInt(lines.get(1)) + amount));
                break;
            case "agility":
                lines.set(2, Integer.toString(Integer.parseInt(lines.get(2)) + amount));
                break;
            case "intelligence":
                lines.set(3, Integer.toString(Integer.parseInt(lines.get(3)) + amount));
                break;
            case "strength":
                lines.set(4, Integer.toString(Integer.parseInt(lines.get(4)) + amount));
                break;
            default:
                System.out.println("Okänd stat: " + stat);
                return;
        }

        // Skriv tillbaka till filen
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String s : lines) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("Kunde inte spara filen: " + e.getMessage());
        }

       // System.out.println(stat + " ökade med +" + amount + "!");
    }
}


