package VisitorPattern;

public abstract class Auto {
    private String model;

    public Auto(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract void Axcept(Visitor visitor);
}

class Car extends Auto {
    public Car(String model) {
        super(model);
    }

    @Override
    public void Axcept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Track extends Auto {
    public Track(String model) {
        super(model);
    }

    @Override
    public void Axcept(Visitor visitor) {
        visitor.visit(this);
    }
}


