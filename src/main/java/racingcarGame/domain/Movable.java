package racingcarGame.domain;

public interface Movable {
    int POSITION_INIT = 0;

    Car move();

    boolean isMove();
}
