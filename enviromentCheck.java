public class enviromentCheck {
    
    private static String currentEnv = "outside"; 

    public static String envCheck() {
        return currentEnv;
    }

    public static void changeEnv(String enviroment) {
        if(enviroment == null) return; 
        switch(enviroment) {
            case "outside": currentEnv = "outside"; break;
            case "inside": currentEnv = "inside"; break;
            default: currentEnv = "outside"; break;
        }
    }
}
