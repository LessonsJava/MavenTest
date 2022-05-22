package exampleClasses.characters;

import exampleClasses.characters.movements.SimpleAttack;
import exampleClasses.characters.movements.SmartAttack;

public class CharacterTest {
    public static void main(String[] args) {
        Knight knight = new Knight();

        knight.setMovement(new SimpleAttack());

        knight.makeMove();
        knight.makeMove();
        knight.makeMove();
        knight.makeMove();

        knight.setMovement(new SmartAttack());

        knight.makeMove();
    }
}
