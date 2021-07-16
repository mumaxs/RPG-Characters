package stats;

/**
 * Class that holds the primary attribute of a character or a armor.
 */
public class PrimaryAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    public PrimaryAttribute(){
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
        this.vitality = 0;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getVitality() {
        return this.vitality;
    }

    /**
     * Method that returns the total vitality a character have.
     * @param baseStatsVitality - the vitality a character have from levels.
     * @return - the total vitality. Adding the vitality a character have form levels
     * with the vitality from equipped armor.
     */
    public int getCharacterTotalVitality(int baseStatsVitality) {
        return this.vitality + baseStatsVitality;
    }

    /**
     * Method that returns the total intelligence a character have.
     * @param baseStatsIntelligence - the intelligence a character have from levels.
     * @return - the total intelligence. Adding the intelligence a character have form levels
     * with the intelligence from equipped armor.
     */
    public int getCharacterTotalIntelligence(int baseStatsIntelligence) {
        return this.intelligence + baseStatsIntelligence;
    }

    /**
     * Method that returns the total dexterity a character have.
     * @param baseStatsDexterity - the dexterity a character have from levels.
     * @return - the total dexterity. Adding the dexterity a character have form levels
     * with the dexterity from equipped armor.
     */
    public int getCharacterTotalDexterity(int baseStatsDexterity) {
        return this.dexterity + baseStatsDexterity;
    }

    /**
     * Method that returns the total strength a character have.
     * @param baseStatsStrength - the strength a character have from levels.
     * @return - the total strength. Adding the strength a character have form levels
     * with the strength from equipped armor.
     */
    public int getCharacterTotalStrength(int baseStatsStrength) {
        return this.strength + baseStatsStrength;
    }

    public void updateStrength(int strength) {
        this.strength += strength;
    }

    public void updateIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    public void updateDexterity(int dexterity) {
        this.dexterity += dexterity;
    }

    public void updateVitality(int vitality) {
        this.vitality += vitality;
    }

    /**
     * Method that are used to reset the primary attributes a character have form armor.
     * This method are used when unequipping armor to recalculate the primary attribute.
     */
    public void resetPrimaryAttributes(){
        this.vitality = 0;
        this.dexterity = 0;
        this.intelligence = 0;
        this.strength = 0;
    }
}
