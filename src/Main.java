import character.*;
import items.*;
import items.exceptions.*;

/**
 * A text based RPG program that can create different characters, weapons and armors. Each character can level up to
 * increase their stats, equip and unequip armor and weapons.
 *
 * @author Marcus Thornemo Larsson
 */
public class Main {

    public static void main(String[] args) {
        // Examples..
        Warrior warriorOne = new Warrior("warrior");
        warriorOne.showStats();
        warriorOne.levelUp();
        warriorOne.showStats();

        try{
            warriorOne.equipArmor(new Armor(Slot.BODY, 1, "Body" , ArmorType.PLATE, 2,2,2,2));
        }catch(InvalidArmorException ex){
            System.out.println("Exception occurred: " + ex.getMessage());
        }
        warriorOne.showStats();

        try{
            warriorOne.unequip(Slot.BODY);
        }catch(NoArmorEquippedException ex){
            System.out.println("Exception occurred: "+ex.getMessage());
        }
        warriorOne.showStats();

        try{
            warriorOne.equipWeapon(new Weapon(Slot.MAINHAND, 1, "Axe", WeaponType.AXE, 3,2));
        }catch(InvalidWeaponException ex){
            System.out.println("Exception occurred: "+ex.getMessage());
        }
        try{
            warriorOne.unequip(Slot.MAINHAND);
        }catch(NoArmorEquippedException ex){
            System.out.println("Exception occurred: "+ex.getMessage());
        }
        warriorOne.showStats();


    }
}
