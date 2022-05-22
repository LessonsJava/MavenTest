package exampleClasses.heroes;

public class Samurai implements Hero{
    boolean doIHaveSword = true;

    @Override
    public void attack() {
        System.out.println("Атакую!");
    }

    @Override
    public String whoAreYou() {
        return "Я самурай";
    }

    public Boolean doYouHaveSword() {
        return doIHaveSword;
    }

    public void bringMeYourSword() {
        doIHaveSword = false;
    }
}
