package AbstractFactoryPattern;

import static AbstractFactoryPattern.TypeOfInstrument.*;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        MusicalInstrument guitar = UkrainianFactory.getInstance().createInstrument(STRINGS); // Using SINGLETON pattern
        guitar.model();
        guitar.play();

        Factories USAfactory = new AmericanFactory();                                        // Without SINGLETON pattern
        MusicalInstrument drum = ((AmericanFactory) USAfactory).createInstrument(DRUMS);     // you need to create the instance of Factory
        drum.model();                                                                        // each time you need to create the Instrument
        drum.play();
    }
}
