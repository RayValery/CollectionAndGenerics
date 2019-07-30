package Factory_Singleton_Patterns;

public class Factory_Singleton_Patterns {
    public static void main(String[] args) {
        Car jeep = CarSelector.getInstance().getCar(RoadType.OFF_ROAD);
        jeep.drive();
        jeep.stop();

        Car porsche = CarSelector.getInstance().getCar(RoadType.CITY);
        porsche.drive();
        porsche.stop();

        Car newJeep = CarSelector.getInstance().getCar(RoadType.GROSS);
        newJeep.drive();
        newJeep.stop();
    }
}
