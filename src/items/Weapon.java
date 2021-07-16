package items;

/**
 * Child that extends abstract class Item. The weapon object have a enum type, a damage and attack speed.
 */
public class Weapon extends Item{
    private final WeaponType weaponType;
    private int damage;
    private double attackSpeed;

    /**
     * Constructor of the weapon object.
     * @param slot - Enum for where the weapon are equipped. Can only be equipped in MAINHAND.
     * @param reqLevel - Required level to wear the weapon.
     * @param name - Name of the weapon.
     * @param weaponType - Enum for the weapon typ. AXE, STAFF etc..
     * @param damage - The damage a weapon have.
     * @param attackSpeed - The attack speed a weapon have.
     */
    public Weapon(Slot slot, int reqLevel, String name, WeaponType weaponType, int damage, double attackSpeed) {
        super(slot, reqLevel, name);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    /**
     * Calculates the damage per second. Weapon damage * Weapon attack speed.
     * @return - Returns the damage per second as a double.
     */
    public double getDps(){
        return this.damage*this.attackSpeed;
    }
    public WeaponType getWeaponType(){
        return this.weaponType;
    }
}
