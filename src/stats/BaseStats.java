package stats;

/**
 * Holds the base stats for the characters. This stats are without any bonus attributes from equipment.
 */
public class BaseStats {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    public BaseStats() {
        this.intelligence = 0;
        this.strength = 0;
        this.vitality = 0;
        this.dexterity = 0;
    }

    /**
     * Mages level one stats.
     */
    public void setMageStats(){
        this.strength = 1;
        this.dexterity = 1;
        this.vitality = 5;
        this.intelligence = 8;
    }

    /**
     * Warriors level one stats.
     */
    public void setWarriorStats(){
        this.strength = 5;
        this.dexterity = 2;
        this.vitality = 10;
        this.intelligence = 1;
    }

    /**
     * Rogues level one stats.
     */
    public void setRogueStats(){
        this.strength = 2;
        this.dexterity = 6;
        this.vitality = 8;
        this.intelligence = 1;
    }

    /**
     * Rangers level one stats.
     */
    public void setRangerStats(){
        this.strength = 1;
        this.dexterity = 7;
        this.vitality = 8;
        this.intelligence = 1;
    }
    public int getDexterity(){
        return this.dexterity;
    }
    public int getVitality(){
        return this.vitality;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getIntelligence(){
        return this.intelligence;
    }

    /**
     * Are used to increase the dexterity when a character level up.
     * @param dexterity - the dexterity that should be increased.
     */
    public void updateDexterity(int dexterity){
        this.dexterity += dexterity;
    }

    /**
     * Are used to increase the vitality when a character level up.
     * @param vitality - the vitality that should be increased.
     */
    public void updateVitality(int vitality){
        this.vitality += vitality;
    }

    /**
     * Are used to increase the strength when a character level up.
     * @param strength - the strength that should be increased.
     */
    public void updateStrength(int strength){
        this.strength += strength;
    }

    /**
     * Are used to increase the intelligence when a character level up.
     * @param intelligence - the intelligence that should be increase.
     */
    public void updateIntelligence(int intelligence){
        this.intelligence += intelligence;
    }

}
