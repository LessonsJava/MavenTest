package exampleClasses.characters;

import exampleClasses.characters.movements.SmartAttack;

public class Knight  extends Character{
    public Knight() {
        movement = new SmartAttack();
    }
}
