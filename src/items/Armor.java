package items;

import stats.PrimaryAttribute;

/**
 * Child that extends abstract class Item. The armors stats are stored in a PrimaryAttribute object.
 */
public class Armor extends Item{
    private final ArmorType armorType;
    private PrimaryAttribute primaryAttribute;

    /**
     * Constructor for armor.
     * @param slot - Where the armor are going to be equipped. BODY, LEGS etc..
     * @param reqLevel - The required level that are needed to wear armor.
     * @param name - Name of the armor.
     * @param armorType - Enum for the armor type. PLATE, CLOTH etc..
     * @param strength - The number of strength the armor provide.
     * @param dexterity - The number of dexterity the armor provide.
     * @param intelligence - The number of intelligence the armor provide.
     * @param vitality - The number of vitality the armor provide.
     */
    public Armor(Slot slot, int reqLevel, String name, ArmorType armorType, int strength, int dexterity, int intelligence, int vitality) {
        super(slot, reqLevel, name);
        this.armorType = armorType;
        this.primaryAttribute = new PrimaryAttribute();
        this.primaryAttribute.setStrength(strength);
        this.primaryAttribute.setDexterity(dexterity);
        this.primaryAttribute.setIntelligence(intelligence);
        this.primaryAttribute.setVitality(vitality);
    }
    public ArmorType getArmorType(){
        return this.armorType;
    }
    public int getStrength(){
        return this.primaryAttribute.getStrength();
    }
    public int getDexterity(){
        return this.primaryAttribute.getDexterity();
    }
    public int getIntelligence(){
        return this.primaryAttribute.getIntelligence();
    }
    public int getVitality(){
        return this.primaryAttribute.getVitality();
    }
}
