package exampleClasses.characters.movements;

public class SimpleAttack implements Movement{
    @Override
    public void makeMove() {
        System.out.println("Атакую!!!");
    }
}
