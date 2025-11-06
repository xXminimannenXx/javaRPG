


public class Rpggame {

     public static void main (String[] args){
        boolean running = true;
         CharacterCreator.userCharacterCreator();
        while(running == true){
       
        enviromentCheck.changeEnv( "outside");
        RpgMap.runMap();
        }

     }
}