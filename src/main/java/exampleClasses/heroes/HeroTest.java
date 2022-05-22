package exampleClasses.heroes;

import exampleClasses.characters.Knight;

import java.util.ArrayList;
import java.util.List;

public class HeroTest {

    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Samurai());
        heroes.add(new CharacterAdapter(new Knight()));

        heroes.forEach(Hero::attack);
    }
}
