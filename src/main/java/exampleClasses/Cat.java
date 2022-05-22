package exampleClasses;

public class Cat {
    private String owner;
    private int age;
    private String color;
    private String bestToy;
    public String getVoice() {
        return "Мяу";
    }


    public Cat goToOwner() {
        System.out.println("Подошёл к хозяину");
        return this;
    }

    public Cat setToOwnersKnees() {
        System.out.println("Сел к хозяину на коленки");
        return this;
    }

    public Cat tryGetEat() {
        System.out.println("Дай жраааааать");
        return this;
    }

    public void getOut() {
        System.out.println("После того как хозяин дал пожрать, свалить в закат.");
    }


    public static void main(String[] args) {
        new Cat().goToOwner()
                .setToOwnersKnees()
                .tryGetEat()
                .getOut();
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBestToy(String bestToy) {
        this.bestToy = bestToy;
    }

    public String getOwner() {
        return owner;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getBestToy() {
        return bestToy;
    }
}
