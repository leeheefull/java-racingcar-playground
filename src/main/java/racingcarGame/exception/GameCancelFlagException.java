package racingcarGame.exception;

public class GameCancelFlagException extends RuntimeException {
    public GameCancelFlagException() {
        super("게임이 취소되었습니다.");
    }
}
