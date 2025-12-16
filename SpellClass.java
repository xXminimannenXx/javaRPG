public class SpellClass {
   private String spellName = "";
   private int spellCost = 0;
   private int spellCostStat = 0; // 1 = hp, 2 = AGL, 3 = INT, 4 = STR om jag tänkt rätt  
   private boolean canDoDMG = true;
   

    public SpellClass(String spellName, int spellCost, int spellCostStat, boolean canDoDMG){
        this.spellCost = spellCost;
        this.spellName = spellName;
        this.spellCostStat = spellCostStat;
        this.canDoDMG = canDoDMG;

    }
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
