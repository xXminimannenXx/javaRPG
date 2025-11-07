

import java.io.FileWriter;
import java.io.IOException; // Import IOException to handle errors
import java.util.Scanner;
//import java.util.Arrays;

public class CharacterCreator {
    
    static int cursorLocation = 0;
    static int[] attributeValue = {0,0,0,0};
    static String[] attributeName = {"health","agility","intelligence","strenght"};
    static int TOTAL_POINTS = 16;
    static int USED_POINTS = 0;

    //färger
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    static Scanner scanner = new Scanner(System.in);
    
    public static void userCharacterCreator() {
        
        
        String userInput;

        boolean creating = true;

        while (creating) {
            clearConsole();
            System.out.println("\nCharacter Creator");
            System.out.println("W/S for up/down, A/D to decrease/increase value");
            System.out.println("P to proceed\n");
            redrawOnClear();
            userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput){
                case "w": // up
                if (cursorLocation > 0) cursorLocation--;
                break;

                case "s": // down
                if (cursorLocation < 3) cursorLocation++;
                break;

                case "a": // left
                if(USED_POINTS > 0 && attributeValue[cursorLocation] > 0) {
                    
                    USED_POINTS--;
                    attributeValue[cursorLocation]--;
                }
                break;

                case "p":
                if(attributeValue[0] != 0) {
                    SaveCharacter();
                    return;
                } else{
                    System.out.println("You need atleast 1 health to continue");
                     try{
                    Thread.sleep(500);
                    }catch(InterruptedException e){
                     e.printStackTrace();
                     }
                }
                
                
                break;

                case "d": // right
                if (USED_POINTS != TOTAL_POINTS) {
                    USED_POINTS++;
                    attributeValue[cursorLocation]++;
                }
                break;

                default: // inte bra tecken
                break;
            }
        } 

    }
    

    public static void SaveCharacter(){
        
        System.out.print("What is your name, adventurer?: ");
        
        String playerName = scanner.nextLine();

        try { // w3schools min älskade
            FileWriter myWriter = new FileWriter("SavedCharacter.txt");
            
            myWriter.write(playerName);

            for (int value : attributeValue) {
                myWriter.write("\n" + value );
            }

            myWriter.close();  // must close manually
            
        } catch (IOException e) {
            System.out.println("An error occurred."); // tror inte att errorn någonsin syns pga clearconsole men aja
            e.printStackTrace();
        }
        

        
    }


    public static void redrawOnClear(){
        //System.out.println("["+ attributeValue[cursorLocation] +"]" + " " + attributeName[cursorLocation]);
        //System.out.println(USED_POINTS);
        
    if (USED_POINTS == TOTAL_POINTS){
        System.out.println(ANSI_RED+"Attribute Points Left: " + (TOTAL_POINTS - USED_POINTS) + " / 16"+ANSI_RESET);
    } else {
        System.out.println("Attribute Points Left: " + (TOTAL_POINTS - USED_POINTS) + " / 16");
    }
   
    for (int i = 0; i < attributeName.length; i++) {
        String selector = (i == cursorLocation) ? ANSI_GREEN+"->"+ANSI_RESET : "  ";
        System.out.println(selector + " [" + attributeValue[i] + "] : " + attributeName[i] ); //ser ut såhär --> [1] : sak
    }



    }
    public static void clearConsole(){
        System.out.print("\033[H\033[2J"); // ansi console clear sak

    }
}
