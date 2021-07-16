package items;

import character.Warrior;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void equipWeapon_tryAndEquipToHighLevelWeapon_invalidWeaponException(){
        Warrior warrior = new Warrior("warrior");
        Weapon weapon = new Weapon(Slot.MAINHAND, 2, "Axe", WeaponType.AXE, 7, 1.1);

        assertThrows(InvalidWeaponException.class, () ->{
           warrior.equipWeapon(weapon);
        });
    }

    @Test
    void equipArmor_tryAndEquipToHighLevelArmor_invalidArmorException(){
        Warrior warrior = new Warrior("warrior");
        Armor armor = new Armor(Slot.BODY, 2, "Body", ArmorType.PLATE, 1,2,3,4);

        assertThrows(InvalidArmorException.class, () ->{
            warrior.equipArmor(armor);
        });
    }
    @Test
    void equipWeapon_tryEquipWrongWeaponType_invalidWeaponException(){
        Warrior warrior = new Warrior("warrior");
        Weapon weapon = new Weapon(Slot.MAINHAND, 2, "BOW", WeaponType.BOW, 7, 1.1);

        assertThrows(InvalidWeaponException.class, () ->{
            warrior.equipWeapon(weapon);
        });
    }
    @Test
    void equipArmor_tryAndEquipWrongArmor_invalidArmorException(){
        Warrior warrior = new Warrior("warrior");
        Armor armor = new Armor(Slot.BODY, 2, "Body", ArmorType.CLOTH, 1,2,3,4);

        assertThrows(InvalidArmorException.class, () ->{
            warrior.equipArmor(armor);
        });
    }
    @Test
    void equipWeapon_weaponEquipped_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        Weapon weapon = new Weapon(Slot.MAINHAND, 2, "AXE", WeaponType.AXE, 7, 1.1);
        try{
            warrior.equipWeapon(weapon);
            assertTrue(true);
        }catch(InvalidWeaponException ex){
            System.out.println(ex.getMessage());
        }

    }
    @Test
    void equipArmor_armorEquipped_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        Armor armor = new Armor(Slot.LEGS, 2, "LEGS", ArmorType.MAIL, 7, 1, 1,1);
        try{
            warrior.equipArmor(armor);
            assertTrue(true);
        }catch(InvalidArmorException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Test
    void getDps_checkDpsWithoutWeapon_expectRightCalc(){
        Warrior warrior = new Warrior("warrior");
        warrior.calculateDps();
        assertTrue(warrior.getDps() == Math.round(1*(1.0 + ( 5 / 100.0))));

    }
    @Test
    void getDps_equipWeapon_expectCorrectCalc(){
        Warrior warrior = new Warrior("warrior");
        Weapon weapon = new Weapon(Slot.MAINHAND, 1, "AXE", WeaponType.AXE, 7, 1.1);
        try{
            warrior.equipWeapon(weapon);
            assertTrue(true);
        }catch(InvalidWeaponException ex){
            System.out.println(ex.getMessage());
        }
        assertTrue(warrior.getDps() == Math.round((7*1.1)*(1+(6/100))));
    }
    @Test
    void calcDps_withWeaponAndArmorEquipped_expectCorrectCalc(){
        Warrior warrior = new Warrior("warrior");
        Weapon weapon = new Weapon(Slot.MAINHAND, 1, "AXE", WeaponType.AXE, 7, 1.1);
        Armor armor = new Armor(Slot.LEGS, 1, "LEGS", ArmorType.PLATE, 1, 0, 0,2);

        try{
            warrior.equipWeapon(weapon);
        }catch(InvalidWeaponException ex){
            System.out.println(ex.getMessage());
        }
        try{
            warrior.equipArmor(armor);
        }catch(InvalidArmorException ex){
            System.out.println(ex.getMessage());
        }
        assertTrue(warrior.getDps() == Math.round((7*1.1)*(1+(6/100))));
    }
}