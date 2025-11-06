


public class Rpggame {

     public static void main (String[] args){

        CharacterCreator.userCharacterCreator();
        enviromentCheck.changeEnv( "outside");
        RpgMap.runMap(enviromentCheck.envCheck());


     }
}