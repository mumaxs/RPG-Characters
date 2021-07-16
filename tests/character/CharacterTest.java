package character;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the character.
 */
class CharacterTest {

    @Test
    void warriorConstructor_lvlOne_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        assertTrue(warrior.getLevel() == 1);
    }

    @Test
    void levelUp_updateOneLevel_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        warrior.levelUp();

        assertTrue(warrior.getLevel() == 2);
    }

    @Test
    void levelUpWithArgument_tryLevelUpWithZero_illegalArgumentException(){
        Warrior warrior = new Warrior("warrior");

        assertThrows(IllegalArgumentException.class, () ->{
            warrior.levelUp(0);
        });
    }

    @Test
    void mageConstructor_getRightStatsAsLvlOne_expectedTrue(){
        Mage mage = new Mage("mage");

        assertTrue(mage.getLevel() == 1);
        assertTrue(mage.baseStats.getIntelligence() == 8);
        assertTrue(mage.baseStats.getVitality() == 5);
        assertTrue(mage.baseStats.getDexterity() == 1);
        assertTrue(mage.baseStats.getStrength() == 1);

    }

    @Test
    void warriorConstructor_getRightStatsAsLvlOne_expectedTrue(){
        Warrior warrior = new Warrior("warrior");

        assertTrue(warrior.getLevel() == 1);
        assertTrue(warrior.baseStats.getIntelligence() == 1);
        assertTrue(warrior.baseStats.getVitality() == 10);
        assertTrue(warrior.baseStats.getDexterity() == 2);
        assertTrue(warrior.baseStats.getStrength() == 5);
    }

    @Test
    void rogueConstructor_getRightStatsAsLvlOne_expectedTrue(){
        Rogue rogue = new Rogue("rogue");

        assertTrue(rogue.getLevel() == 1);
        assertTrue(rogue.baseStats.getIntelligence() == 1);
        assertTrue(rogue.baseStats.getVitality() == 8);
        assertTrue(rogue.baseStats.getDexterity() == 6);
        assertTrue(rogue.baseStats.getStrength() == 2);
    }

    @Test
    void rangerConstructor_getRightStatsAsLvlOne_expectedTrue(){
        Ranger ranger = new Ranger("ranger");

        assertTrue(ranger.getLevel() == 1);
        assertTrue(ranger.baseStats.getIntelligence() == 1);
        assertTrue(ranger.baseStats.getVitality() == 8);
        assertTrue(ranger.baseStats.getDexterity() == 7);
        assertTrue(ranger.baseStats.getStrength() == 1);

    }

    @Test
    void levelUp_warriorStatsUpdateCorrectly_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        warrior.levelUp();

        assertTrue(warrior.getLevel() == 2);
        assertTrue(warrior.baseStats.getDexterity() == 4);
        assertTrue(warrior.baseStats.getIntelligence() == 2);
        assertTrue(warrior.baseStats.getStrength() == 8);
        assertTrue(warrior.baseStats.getVitality() == 15);

    }
    @Test
    void levelUpWithParams_warriorStatsUpdateCorrectly_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        warrior.levelUp(1);

        assertTrue(warrior.getLevel() == 2);
        assertTrue(warrior.baseStats.getDexterity() == 4);
        assertTrue(warrior.baseStats.getIntelligence() == 2);
        assertTrue(warrior.baseStats.getStrength() == 8);
        assertTrue(warrior.baseStats.getVitality() == 15);

    }
    @Test
    void levelUp_mageStatsUpdateCorrectly_expectedTrue(){
        Mage mage = new Mage("mage");
        mage.levelUp();

        assertTrue(mage.getLevel() == 2);
        assertTrue(mage.baseStats.getVitality() == 8);
        assertTrue(mage.baseStats.getStrength() == 2);
        assertTrue(mage.baseStats.getIntelligence() == 13);
        assertTrue(mage.baseStats.getDexterity() == 2);
    }

    @Test
    void levelUp_rogueStatsUpdateCorrectly_expectedTrue(){
        Rogue rogue = new Rogue("rogue");
        rogue.levelUp();

        assertTrue(rogue.getLevel() == 2);
        assertTrue(rogue.baseStats.getDexterity() == 10);
        assertTrue(rogue.baseStats.getStrength() == 3);
        assertTrue(rogue.baseStats.getIntelligence() == 2);
        assertTrue(rogue.baseStats.getVitality() == 11);

    }

    @Test
    void levelUp_rangerStatsUpdateCorrectly_expectedTrue(){
        Ranger ranger = new Ranger("ranger");
        ranger.levelUp();

        assertTrue(ranger.getLevel() == 2);
        assertTrue(ranger.baseStats.getVitality() == 10);
        assertTrue(ranger.baseStats.getStrength() == 2);
        assertTrue(ranger.baseStats.getDexterity() == 12);
        assertTrue(ranger.baseStats.getIntelligence()==2);

    }

    @Test
    void secondaryAttribute_warriorSecondAttributeUpdateCorrectly_expectedTrue(){
        Warrior warrior = new Warrior("warrior");
        warrior.levelUp();

        assertTrue(warrior.secondaryAttribute.getArmorRating() == 12);
        assertTrue(warrior.secondaryAttribute.getHealth() == 150);
        assertTrue(warrior.secondaryAttribute.getElementalResistance() == 2);
    }

}