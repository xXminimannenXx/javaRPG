package rpgGame;


public class Rpggame {

     public static void main (String[] args){

         System.out.println("Welcome to the world of SigmaLand\nWho are you?\n");
         CharacterCreator.userCharacterCreator();
         RpgMap.runMap("outside");

     }
}