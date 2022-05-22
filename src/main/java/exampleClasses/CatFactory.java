package exampleClasses;

import static exampleClasses.CatType.DOMESTIC;
import static exampleClasses.CatType.SIMPLE;

public class CatFactory {

    public static Cat createCat(CatType type) {
        if (type == DOMESTIC)
            return CatBuilder.create().setOwner("Айдар").build();
        if (type == SIMPLE)
            return CatBuilder.create().build();

        return CatBuilder.create().build();
    }
}
