package test;

import exampleClasses.characters.Knight;
import exampleClasses.heroes.CharacterAdapter;
import exampleClasses.heroes.Hero;
import exampleClasses.heroes.Samurai;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    @Test
    void knightAdapterTest() {
        //Arrange
        Hero knight = new CharacterAdapter(new Knight());
        String response;
        //Act
        response = knight.whoAreYou();
        //Assert
        assertEquals("Я - геройский адаптер", response);
    }

    @Test
    void samuraiTest() {
        //Arrange
        Samurai samurai = new Samurai();
        Boolean response;
        //Act
        response = samurai.doYouHaveSword();
        //Assert
        assertTrue(response);
    }

    @Test
    void samuraiWithoutSwordTest() {
        //Arrange
        Samurai samurai = new Samurai();
        Boolean response;
        //Act
        samurai.bringMeYourSword();
        response = samurai.doYouHaveSword();
        //Assert
        assertFalse(response);
    }
}
