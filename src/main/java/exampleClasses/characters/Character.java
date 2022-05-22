package exampleClasses.characters;

import exampleClasses.characters.movements.Movement;
import exampleClasses.characters.movements.SimpleAttack;

public abstract class Character {
    public Movement movement = new SimpleAttack();

    public void makeMove() {
        movement.makeMove();
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}
