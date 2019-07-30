package StatePattern;

public class StatePattern {
    public static void main(String[] args) {
        Door myDoor = new Door(new Open());

        for (int i = 0; i < 6; i++) {
            myDoor.move();
            myDoor.changeState();
        }
    }

}

class Door {

    private State state;

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public Door(State state) { this.state = state; }

    public void changeState() {
        if (this.getState() instanceof Open) {
            this.setState(new Close());
        } else if (this.getState() instanceof Close) {
            this.setState(new Open());
        }
    }

    public void move() { this.getState().openClose(); }
}

interface State { void openClose(); }

class Open implements State {
    @Override
    public void openClose() {
        System.out.println("StatePattern.Door is open.");
    }
}

class Close implements State {
    @Override
    public void openClose() {
        System.out.println("StatePattern.Door is close.");
    }
}