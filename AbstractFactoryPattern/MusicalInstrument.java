package AbstractFactoryPattern;

abstract class MusicalInstrument {
    public void play() { }
    public void model(){}
}


class Trembita extends MusicalInstrument {
    @Override
    public void play() {
        System.out.println("\nPlay the guitar");
    }

    @Override
    public void model() {
        System.out.println("\nUkrainian guitar\nmanufacturer: Trembita");
    }
}

class Fender extends MusicalInstrument {
    @Override
    public void play() {
        System.out.println("\nPlay the guitar");
    }

    @Override
    public void model() {
        System.out.println("\nUSA guitar\nmanufacturer: Fender");
    }
}

