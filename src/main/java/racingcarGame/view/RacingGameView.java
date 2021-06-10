package racingcarGame.view;

import java.io.PrintStream;

public class RacingGameView {
    private final PrintStream out = new PrintStream(System.out);

    public void showInputString() {
        out.print("참가자 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n-> ");
    }

    public void showInputMoveCnt() {
        out.print("시도할 회수는 몇회인가요?\n-> ");
    }

    public void showMessage(String message) {
        out.println(message);
    }
}
