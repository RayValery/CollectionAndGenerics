package VisitorPattern;

import VisitorPattern.*;

import java.util.ArrayList;
import java.util.List;

public class VisitorPatternRunner {
    public static void main(String[] args) {
        List<Auto> cars = createCars();
        Visitor visitorCar = (Visitor) new AutoVisitor();
        Visitor visitorTrans = (Visitor) new TransportationVisitor();
        for (Auto car : cars) {
            car.Axcept(visitorCar);
            car.Axcept(visitorTrans);
        }
    }

    private static ArrayList<Auto> createCars() {
        ArrayList<Auto> cars = new ArrayList<>();
        cars.add(new Car("Mercedes"));
        cars.add(new Track("Gazel"));
        cars.add(new Car("Mazda"));
        cars.add(new Track("BMW"));
        cars.add(new Car("Lanos"));

        return cars;
    }
}
