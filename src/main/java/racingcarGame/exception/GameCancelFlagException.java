package racingcarGame.exception;

public class GameCancelFlagException extends RuntimeException {
    @Override
    public String getMessage() {
        return "게임이 취소되었습니다.";
    }
}
