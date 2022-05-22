package exampleClasses.characters;

import exampleClasses.characters.movements.HideAttack;

public class Elf extends Character {
    public Elf() {
        movement = new HideAttack();
    }
}
