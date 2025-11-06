


public class Rpggame {

     public static void main (String[] args){
        boolean running = true;
        CharacterCreator.userCharacterCreator();
        enviromentCheck.changeEnv( "outside");
        while(running == true){
       
       
        RpgMap.runMap();
        }

     }
}