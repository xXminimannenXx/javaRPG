import java.util.Scanner;

public class PlayerMovment {
       static int[] playerMove(int playerX, int playerY, Scanner scanner, int maxX, int maxY) {
        String input = scanner.nextLine();


        if (input.length() == 0) {
         // bara Enter
         return new int[]{playerX, playerY};
         }

        char userInput = Character.toLowerCase(input.charAt(0));

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
