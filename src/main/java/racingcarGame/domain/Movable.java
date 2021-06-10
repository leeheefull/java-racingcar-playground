package racingcarGame.domain;

public interface Movable {
    int POSITION_INIT = 0;

    String MOVE_MARK = "-";

    void move();

    String getMoveLog();
}
