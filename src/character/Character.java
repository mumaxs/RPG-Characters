package character;

import items.*;
import exceptions.*;
import stats.*;

import java.util.HashMap;

/***
 * Abstract class character that the different subclasses inherits from. Have shared attributes and methods but also a few abstract methods.
 */
public abstract class Character {
    protected String name;
    protected int level;
    protected RoleClass roleClass;
    protected BaseStats baseStats;
    protected PrimaryAttribute primaryAttribute;
    protected SecondaryAttribute secondaryAttribute;
    protected HashMap<Slot, Item> equipped;
    protected double dps;

    /**
     * Constructor that sets the shared attributes. The child specific attributes are set in the corresponding constructor.
     * @param name
     */
    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.baseStats = new BaseStats();
        this.primaryAttribute = new PrimaryAttribute();
        this.secondaryAttribute = new SecondaryAttribute();
        this.equipped = new HashMap<Slot, Item>();

    }

    public int getLevel() {
        return this.level;
    }

    public double getDps() {
        return this.dps;
    }

    /**
     * Prints out the characters stats.
     */
    public void showStats() {
        System.out.println("Name:\t" + this.name);
        System.out.println("Class:\t" + this.roleClass);
        System.out.println("Level:\t" + this.level);
        System.out.println("Primary Attirbutes:\tStrength: " +
                this.primaryAttribute.getCharacterTotalStrength(this.baseStats.getStrength()) + ", Dexterity: " +
                this.primaryAttribute.getCharacterTotalDexterity(this.baseStats.getDexterity()) + ", Intelligence: " +
                this.primaryAttribute.getCharacterTotalIntelligence(this.baseStats.getIntelligence()) + ", Vitality: " +
                this.primaryAttribute.getCharacterTotalVitality(this.baseStats.getVitality()));
        System.out.println("Secondary Attributes:\tHealth: " + this.secondaryAttribute.getHealth() + ", Armor Rating: " +
                this.secondaryAttribute.getArmorRating() + ", Elemental Resistance: " +
                this.secondaryAttribute.getElementalResistance());
        System.out.println("DPS:\t" + this.dps + "\n");

    }

    /**
     * Iterates through the hashmap where all the armor and equipment is stored. Updates the primary and secondary stats accordingly.
     */
    public void updatePrimaryAndSecondaryStats() {
        this.primaryAttribute.resetPrimaryAttributes();
        for (HashMap.Entry<Slot, Item> entry : this.equipped.entrySet()) {
            if (entry.getKey() != Slot.MAINHAND) {
                this.primaryAttribute.updateStrength(((Armor) entry.getValue()).getStrength());
                this.primaryAttribute.updateDexterity(((Armor) entry.getValue()).getDexterity());
                this.primaryAttribute.updateIntelligence(((Armor) entry.getValue()).getIntelligence());
                this.primaryAttribute.updateVitality(((Armor) entry.getValue()).getVitality());
                this.secondaryAttribute.updateElementalResistance(((Armor) entry.getValue()).getIntelligence());
                this.secondaryAttribute.updateArmorRation(((Armor) entry.getValue()).getDexterity(), ((Armor) entry.getValue()).getDexterity());
                this.secondaryAttribute.updateHealth(((Armor) entry.getValue()).getVitality());
            }
        }
    }

    /**
     * Removes the equipment with a certain key(slot). Throws an exception if the hashmap don't have that key.
     * @param slot
     * @throws NoArmorEquippedException
     */
    public void unequip(Slot slot) throws NoArmorEquippedException {

        if (!this.equipped.containsKey(slot)) {
            throw new NoArmorEquippedException("Do not have anything equipped at that slot.");
        } else if (((Item) this.equipped.get(slot)).getSlot() != Slot.MAINHAND) {
            this.secondaryAttribute.updateArmorRation(-((Armor) this.equipped.get(slot)).getStrength(), ((Armor) this.equipped.get(slot)).getDexterity());
            this.secondaryAttribute.updateHealth(-((Armor) this.equipped.get(slot)).getVitality());
            this.secondaryAttribute.updateElementalResistance(-((Armor) this.equipped.get(slot)).getIntelligence());
        }
        this.equipped.remove(slot);
        updatePrimaryAndSecondaryStats();
        calculateDps();
    }

    /**
     * Abstract method that are implemented in the subclasses as each child have different conditions for what they can equip.
     * Throws custom InvalidWeaponException if they are not allowed to equip that weapon.
     * @param weapon
     * @throws InvalidWeaponException
     */
    abstract public void equipWeapon(Weapon weapon) throws InvalidWeaponException;

    /**
     * Abstract method that are implemented in the subclasses as each child have different conditions for what they can equip.
     * Throws custom InvalidArmorException if they are not allowed to equip that armor type.
     * @param armor
     * @throws InvalidArmorException
     */
    abstract public void equipArmor(Armor armor) throws InvalidArmorException;

    /**
     * Abstract method that are implemented in each child depending on what primary attribute that should increase their damage.
     */
    abstract public void calculateDps();

    /**
     * Abstract method that increases the characters level this 1. Also updates the BaseStats and secondary attributes.
     */
    abstract public void levelUp();

    /**
     * Abstract method that increases the characters level and updates the BaseStats and secondary attributes.
     * This method takes a parameter to increase more than one level. Throws exception if argument are lower than 1.
     * @param levels
     * @throws IllegalArgumentException
     */
    abstract public void levelUp(int levels) throws IllegalArgumentException;

}
