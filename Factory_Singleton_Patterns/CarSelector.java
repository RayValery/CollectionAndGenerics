package Factory_Singleton_Patterns;

import static Factory_Singleton_Patterns.RoadType.*;

public class CarSelector {
    private static CarSelector instance;

    // створює екземпляр класу ТІЛЬКИ за необхідності при виклику
    public static CarSelector getInstance() {
        if (instance == null) {
            instance = new CarSelector();
        }
        return instance;
    }

    private CarSelector() {
    }

    public Car getCar(RoadType roadType) {
        switch (roadType) {
            case CITY:
                return new Porsche();
            case GROSS:
                return new NewJeep();
            case OFF_ROAD:
                return new Jeep();
        }
        return null;
    }
}
