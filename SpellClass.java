public class SpellClass {
   private String spellName = "";
   private int spellCost = 0;
   private int spellCostStat = 0; // 1 = hp, 2 = AGL, 3 = INT, 4 = STR om jag tänkt rätt  
   private boolean canDoDMG = true;
   


    public String getSpellName(){

            return spellName;

    }
    public int getSpellCost(){

        return spellCost;

    }
    public int getSpellCostStat(){
        return spellCostStat;

    }
    public int getDamage(){
        int DMG = 0;
        if(canDoDMG == true){
            

        }
        return DMG;
    }
}
