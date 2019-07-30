package Factory_Singleton_Patterns;

public abstract class Car {
    public void drive() { }

    public void stop() { }
}

class Jeep extends Car {
    @Override
    public void drive() {
        System.out.println("\nMove Jeep");
    }

    @Override
    public void stop() {
        System.out.println("Stop Jeep");
    }
}

class Porsche extends Car {
    @Override
    public void drive() {
        System.out.println("\nMove Porsche");
    }

    @Override
    public void stop() {
        System.out.println("Stop Porsche");
    }
}

class NewJeep extends Jeep {
    @Override
    public void drive() {
        System.out.println("\nMove NewJeep");
    }

    @Override
    public void stop() {
        System.out.println("Stop NewJeep");
    }
}

class Moskvich extends Car {
    @Override
    public void drive() {
        System.out.println("\nMove Moskvich");
    }

    @Override
    public void stop() {
        System.out.println("Stop Moskvich");
    }
}

class Slavuta extends Car {
    @Override
    public void drive() {
        System.out.println("\nMove Slavuta");
    }

    @Override
    public void stop() {
        System.out.println("Stop Slavuta");
    }
}
