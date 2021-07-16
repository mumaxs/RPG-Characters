package stats;

/**
 * Class that holds the secondary attributes a character have.
 * Includes getters, setters and update.
 *
 * Armor rating = Strength + Dexterity
 * Health = Vitality * 10
 * Elemental Resistance = Intelligence.
 */
public class SecondaryAttribute {
    private int health;
    private int armorRating;
    private int elementalResistance;

    public SecondaryAttribute(){
        this.health = 0;
        this.armorRating = 0;
        this.elementalResistance = 0;
    }
    public void setHealth(int vitality){
        this.health = vitality * 10;
    }
    public void setArmorRating(int strength, int dexterity){
        this.armorRating = strength + dexterity;
    }
    public void setElementalResistance(int intelligence){
        this.elementalResistance = intelligence;
    }
    public int getHealth(){
        return this.health;
    }
    public int getArmorRating(){
        return this.armorRating;
    }
    public int getElementalResistance(){
        return this.elementalResistance;
    }
    public void updateHealth(int vitality){
        this.health += vitality * 10;
    }
    public void updateArmorRation(int strength, int dexterity){
        this.armorRating += (strength + dexterity);
    }
    public void updateElementalResistance(int intelligence){
        this.elementalResistance += intelligence;
    }

}
