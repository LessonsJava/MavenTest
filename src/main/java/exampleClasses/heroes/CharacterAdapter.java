package exampleClasses.heroes;

import exampleClasses.characters.Character;

public class CharacterAdapter implements Hero {
    public Character character;

    public CharacterAdapter(Character character) {
        this.character = character;
    }

    @Override
    public void attack() {
        character.makeMove();
    }

    @Override
    public String whoAreYou() {
        return "Я - геройский адаптер";
    }
}
