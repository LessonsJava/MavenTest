package exampleClasses;

public class CatBuilder {
    Cat cat;

    private CatBuilder() {
        cat = new Cat();
    }

    public static CatBuilder create() {
        return new CatBuilder();
    }

    public CatBuilder setCatColor(String color) {
        cat.setColor(color);
        return this;
    }

    public CatBuilder setOwner(String owner) {
        cat.setOwner(owner);
        return this;
    }

    public CatBuilder setAge(int age) {
        cat.setAge(age);
        return this;
    }

    public CatBuilder setBestToy(String bestToy) {
        cat.setBestToy(bestToy);
        return this;
    }

    public Cat build() {
        if (cat.getOwner() == null) cat.setOwner("Сам по себе");
        if (cat.getAge() == 0) cat.setAge(1);
        if (cat.getColor() == null) cat.setColor("Серый");
        if (cat.getBestToy() == null) cat.setBestToy("Мышка с моторчиком");

        return cat;
    }
}
