

public class Rpggame {

     public static void main (String[] args){
        boolean running = true;
        helloMessage();
        CharacterCreator.userCharacterCreator();
        enviromentCheck.changeEnv( "outside");
        while(running == true){
       
       
        RpgMap.runMap();
        }

     }
     public static void helloMessage(){
      System.out.print("Welcome to javaRPG v1.0\n made by Anton Finn and Leon Kärkkäinen Lind");
         try { Thread.sleep(5000); } catch (InterruptedException e) { }



     }


}