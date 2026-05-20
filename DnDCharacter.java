import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {
    private final int initHP = 10;
    private int strength = 0;
    private int dexterity = 0;
    private int constitution = 0;
    private int intelligence = 0;
    private int wisdom = 0;
    private int charisma = 0;
    private int HP = 0;

    DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        //HP
        modifier(constitution);
    }

   int diceRoller (){
    Random rnd = new Random();
    return rnd.nextInt(6)+1;
   }

    List<Integer> rollDice() {
        List<Integer> diceValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            diceValues.add(diceRoller());
        }
        return diceValues;
    }

    int ability(List<Integer> scores) {
        int ability = 0;
        int min = 6;
        for (int i = 0; i < scores.size(); i++) {
            ability += scores.get(i);
            if (min > scores.get(i)) {
                min = scores.get(i);
            }

        }

        return ability - min;
    }

    int modifier(int input) {
        double modifier = Math.floor((input - 10) / 2.0);
        HP = initHP + Integer.valueOf(((int) modifier));

        // Your character's initial hitpoints are 10 +
        // your character's constitution modifier.
        // You find your character's constitution modifier by
        // subtracting 10 from your character's constitution,
        // divide by 2 and round down.
        return Integer.valueOf(((int) modifier));

    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return HP;
    }
}
