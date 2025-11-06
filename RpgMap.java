
import java.util.Scanner;
import java.util.Random;

public class RpgMap {
    
 public static void runMap() {
    int playerX = 0;
    int playerY = 0;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    boolean running = true;

    int roomSize = random.nextInt(8) + 3;
    int maxX = roomSize;
    int maxY = roomSize;
    int randDoorX = random.nextInt(maxX);
    int randDoorY = random.nextInt(maxY);

    while (running) {
        String env = enviromentCheck.envCheck();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (env.equals("outside")) {
            drawMapOut(playerX, playerY, maxX, maxY,random, randDoorX, randDoorY);

            // Om spelaren står på dörren
            if (playerX == randDoorX && playerY == randDoorY) {
          
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

                enviromentCheck.changeEnv("inside");
                return; 
            }
        } else if (env.equals("inside")) {
            drawMapInside(playerX, playerY, maxX, maxY);
        }

        int[] newPos = playerMove(playerX, playerY, scanner, maxX, maxY);
        playerX = newPos[0];
        playerY = newPos[1];
    }
}

    static void drawMapOut(int playerX, int playerY, int maxX, int maxY, Random random,int randDoorX, int randDoorY){
        int drawX = 0;
        int drawY = 0;
       
        for (int i = 0; i < maxY; i++){
            drawX = 0;
            for(int j = 0; j < maxX; j++){
               if(drawX == playerX && drawY == playerY && drawX == randDoorX && drawY == randDoorY){
                System.out.print("[X]");
               
                
               }
               else if(drawX == playerX && drawY == playerY){
                System.out.print(" x ");
               }
               else if(drawX == randDoorX && drawY == randDoorY){
                System.out.print("[ ]");
               }
               else {
                System.out.print(" . ");
               }
                drawX++;
            }
            System.out.println();
            drawY++;
        }
        if (playerX== randDoorX && playerY == randDoorY) {
        try{
         Thread.sleep(500);
         }catch(InterruptedException e){
            e.printStackTrace();
         }
        enviromentCheck.changeEnv("inside"); // ändrar klassvariabeln
    return;
        }
    }
     static void drawMapInside(int playerX, int playerY, int maxX, int maxY){
        int drawX = 0;
        int drawY = 0;
        for (int i = 0; i < maxY; i++){
            drawX = 0;
            for(int j = 0; j < maxX; j++){
                if(drawX == playerX && drawY == playerY){
                    System.out.print("[X]");
                }
                else{
                System.out.print("[ ]");
                }
                drawX++;
            }
            System.out.println();
            drawY++;
        }

    }
        static int[] playerMove(int playerX, int playerY, Scanner scanner, int maxX, int maxY) {
        char userInput = Character.toLowerCase(scanner.nextLine().charAt(0));

        switch (userInput) {
            case 'w':
                if (playerY > 0) playerY--; 
                break;
            case 's':
                if (playerY < maxY-1) playerY++; 
                break;
            case 'a':
                if (playerX > 0) playerX--;
                break;
            case 'd':
                if (playerX < maxX-1) playerX++;
                break;
            case 'e':
                scanner.close();
                System.exit(0);
                break;
        }
        return new int[]{playerX, playerY};
    }
}

