import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//Stat ordning HP,  AGL, INT, STR med namn på rad 1(/0 beronde på hur du tänker)
public class GetPlayerStats {
     public static int getPlayerStat(int lineNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader("SavedCharacter.txt"))) {
            String line;
            int current = 1;
            while ((line = br.readLine()) != null) {
                if (current == lineNumber) return Integer.parseInt(line);
                current++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void changePlayerStat(int lineNumber, int delta) {
       
        try {
            Path path = Paths.get("SavedCharacter.txt");
            List<String> lines = Files.readAllLines(path);

            int index = lineNumber - 1; // 0-based
            if (index < 0 || index >= lines.size()) {
                System.out.println("Invalid line number: " + lineNumber);
                return;
            }

            int value = Integer.parseInt(lines.get(index));
            value += delta;
            lines.set(index, Integer.toString(value));

            Files.write(path, lines);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    static void printPlayerStats(){
        for (int i = 2; i <= 5; i++){
            System.out.print("[ " + GetPlayerStats.getPlayerStat(i) + " ]");
            
        }
    System.err.println(); // input under stats
    }
}
