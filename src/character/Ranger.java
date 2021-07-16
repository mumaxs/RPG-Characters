package character;

import items.*;
import exceptions.*;

/**
 * Child class that extends the abstract class Character. Sets the child specific attributes;
 * RoleClass and BaseStats, then updating the secondary attributes.
 */
public class Ranger extends Character{
    public Ranger(String name) {
        super(name);
        this.roleClass = RoleClass.RANGER;
        this.baseStats.setRangerStats();
        this.secondaryAttribute.setArmorRating(this.baseStats.getStrength(), this.baseStats.getDexterity());
        this.secondaryAttribute.setHealth(this.baseStats.getVitality());
        this.secondaryAttribute.setElementalResistance(this.baseStats.getIntelligence());
    }

    /**
     * Check if the character have high enough level and that the weapon type is allowed.
     * Throws custom InvalidWeaponException if the criteria is not meet.
     * @param weapon - what weapon object that should be equipped.
     * @throws InvalidWeaponException - Custom weapon exception.
     */
    @Override
    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (this.level < weapon.getReqLevel()) {
            throw new InvalidWeaponException("Required level; " + weapon.getReqLevel());
        } else if (weapon.getWeaponType() == WeaponType.BOW) {
            this.equipped.put(Slot.MAINHAND, weapon);
            calculateDps();
        } else {
            throw new InvalidWeaponException("Can't equip that weapon type; " + weapon.getWeaponType());
        }

    }

    /**
     * Check if the character have high enough level and that the armor type is allowed.
     * Throws custom InvalidArmorException if the criteria is not meet.
     * @param armor - what armor object that should be equipped.
     * @throws InvalidArmorException - Custom armor exception.
     */
    @Override
    public void equipArmor(Armor armor) throws InvalidArmorException {
        if (this.level < armor.getReqLevel()){
            throw new InvalidArmorException("Required level; "+armor.getReqLevel());
        }else if(armor.getArmorType() == ArmorType.LEATHER || armor.getArmorType() == ArmorType.MAIL) {
            this.equipped.put(armor.getSlot(), armor);
            updatePrimaryAndSecondaryStats();
            calculateDps();
        }else{
            throw new InvalidArmorException("Can't equip that armor type; "+armor.getArmorType());
        }

    }

    /**
     * Calculate the damage per second of the character. Ranger have a increase in damage by 1% for each dexterity point.
     * If no weapon is equipped, weapon dps are set to 1.
     * Calculated by; weapon dps * (1 + (total dexterity / 100 ))
     */
    @Override
    public void calculateDps() {
        if(this.equipped.containsKey(Slot.MAINHAND)){
            this.dps = Math.round((((Weapon) equipped.get(Slot.MAINHAND)).getDps() * (1.0 + (this.primaryAttribute.getCharacterTotalDexterity(this.baseStats.getDexterity()) / 100.0))));
        }else{
            this.dps = Math.round( 1 * (1.0 + (this.primaryAttribute.getCharacterTotalDexterity(this.baseStats.getIntelligence()) / 100.0)));
        }

    }

    /**
     * Increase level by one and updates the baseStats. Then update and calculate the primary and secondary attributes.
     */
    @Override
    public void levelUp() {
        this.level += 1;
        this.baseStats.updateDexterity(5);
        this.baseStats.updateIntelligence(1);
        this.baseStats.updateVitality(2);
        this.baseStats.updateStrength(1);
        this.secondaryAttribute.setHealth(this.baseStats.getVitality());
        this.secondaryAttribute.setArmorRating(this.baseStats.getStrength(), this.baseStats.getDexterity());
        this.secondaryAttribute.setElementalResistance(this.baseStats.getIntelligence());
        updatePrimaryAndSecondaryStats();
    }

    /**
     * Increases levels by the input and updates the baseStats. Also update and calculate the primary and secondary attributes.
     * @param levels - number of levels that the character should increase with.
     */
    @Override
    public void levelUp(int levels) {
        if(levels<1){
            throw new IllegalArgumentException();
        }else{
            for (int i = 0; i < levels; i++) {
                this.level += 1;
                this.baseStats.updateDexterity(5);
                this.baseStats.updateIntelligence(1);
                this.baseStats.updateVitality(2);
                this.baseStats.updateStrength(1);
                this.secondaryAttribute.setHealth(this.baseStats.getVitality());
                this.secondaryAttribute.setArmorRating(this.baseStats.getStrength(), this.baseStats.getDexterity());
                this.secondaryAttribute.setElementalResistance(this.baseStats.getIntelligence());
                updatePrimaryAndSecondaryStats();
            }
        }
    }
}
