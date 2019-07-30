package VisitorPattern;

public interface Visitor {
    void visit(Auto auto);
}

class AutoVisitor implements Visitor {
    @Override
    public void visit(Auto auto) {
        String prefics = "";
        if (auto instanceof Car) {
            prefics = "Factory_Singleton_Patterns.Factory_Singleton_Patterns.MusicalInstrument model: ";
        }
        if (auto instanceof Track) {
            prefics = "Track model: ";
        }
        System.out.println(prefics + auto.getModel());
    }
}

class TransportationVisitor implements Visitor{
    @Override
    public void visit(Auto auto) {
        String prefics = "";
        if (auto instanceof Car){
            prefics = "Passenger transportation\n";
        }
        if (auto instanceof Track){
            prefics = "Transportation of goods\n";
        }
        System.out.println(prefics);
    }
}
