package AbstractFactoryPattern;


class Trommel extends MusicalInstrument {
    @Override
    public void play() {
        System.out.println("\nPlay the drum");
    }

    @Override
    public void model() {
        System.out.println("\nUkrainian drum\nmanufacturer: Trommel");
    }
}

class Roland extends MusicalInstrument {
    @Override
    public void play() {
        System.out.println("\nPlay the drum");
    }

    @Override
    public void model() {
        System.out.println("\nUSA drum\nmanufacturer: Roland");
    }
}
