import java.util.ArrayList;

public class SpellClass {
public static ArrayList<SpellClass> allSpells = new ArrayList<SpellClass>();
   private String spellName = "";
   private int spellCost = 0;
   private int spellCostStat = 0; // 1 = hp, 2 = AGL, 3 = INT, 4 = STR om jag tänkt rätt  
   private int targetSpellBuff = 0;
   public boolean canDoDMG = true;
   

    public SpellClass(String spellName, int spellCost, int spellCostStat, boolean canDoDMG, int targetSpellBuff){
        this.spellCost = spellCost;
        this.spellName = spellName;
        this.spellCostStat = spellCostStat;
        this.canDoDMG = canDoDMG;
        this.targetSpellBuff = targetSpellBuff;
        allSpells.add(this);

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
            DMG = spellCost * spellCostStat;

        }
        return DMG;
    }
    public int doBuff(){
       
        int buff = 0;
        if(canDoDMG != true && targetSpellBuff != 0){
            buff = spellCost * spellCostStat;
            GetPlayerStats.changePlayerStat(targetSpellBuff, buff);
        }

        return buff;
    }

    public static void printAllSpells(){
        for(SpellClass s : allSpells){
            System.out.print(s + " ");
        }

    }
}
