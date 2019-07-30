package AbstractFactoryPattern;

public interface Factories {
    MusicalInstrument createGuitar();
    MusicalInstrument createDrum();
}

class UkrainianFactory implements Factories {

    private static UkrainianFactory instance;                 // SINGLETON
    public static UkrainianFactory getInstance(){             //
        if(instance == null){                                 //
            instance = new UkrainianFactory();                //
        } return instance;                                    //
    }                                                         //
    private UkrainianFactory(){}                              // PATTERN

    public MusicalInstrument createInstrument(TypeOfInstrument typeOfInstrument){   // Create the Instrument
        switch (typeOfInstrument) {                                                 // according to needed type
            case STRINGS: return new Trembita();                                    // using SINGLETON pattern
            case DRUMS: return new Trommel();
        } return null;
    }

    @Override
    public MusicalInstrument createGuitar(){
        return new Trembita();
    }

    @Override
    public MusicalInstrument createDrum(){
        return new Trommel();
    }

}

class AmericanFactory implements Factories {

   /* private static AmericanFactory instance;                // SINGLETON
    public static AmericanFactory getInstance(){              //
        if(instance == null){                                 //
            instance = new AmericanFactory();                 //
        } return instance;                                    //
    }                                                         //
    private AmericanFactory(){}*/                             // PATTERN

    public MusicalInstrument createInstrument(TypeOfInstrument typeOfInstrument){
        switch (typeOfInstrument) {
            case STRINGS: return new Fender();
            case DRUMS: return new Roland();
        } return null;
    }

    @Override
    public MusicalInstrument createGuitar(){
        return new Fender();
    }

    @Override
    public MusicalInstrument createDrum(){
        return new Roland();
    }
}
