package racingcarGame.domain;

public class Vehicle extends Equipment implements Movable {
    private int position;

    public Vehicle(String name, int position) {
        super(name);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public void move() {
        this.position++;
    }

    @Override
    public String getMoveLog() {
        StringBuilder output = new StringBuilder(getName() + ": ");
        for (int i = 0; i < this.position; i++) {
            output.append(MOVE_MARK);
        }
        output.append("\n");
        return output.toString();
    }
}
