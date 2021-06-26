package racingcarGame.controller;

import racingcarGame.domain.Car;
import racingcarGame.domain.Name;
import racingcarGame.domain.RacingGame;
import racingcarGame.view.RacingGameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class RacingGameController {
    private final RacingGameView view = new RacingGameView();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = getInput(br);
            int moveCnt = getMoveCnt(br);
            RacingGame racingGame = new RacingGame(inputString, moveCnt);

            view.showMessage(racingGame.play());
            view.showMessage(getResult(racingGame));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInput(BufferedReader br) throws IOException {
        view.showInputString();
        return br.readLine();
    }

    private int getMoveCnt(BufferedReader br) throws IOException {
        view.showInputMoveCnt();
        return Integer.parseInt(br.readLine());
    }

    private String getResult(RacingGame racingGame) {
        return racingGame.getCars()
                .getWinner()
                .stream()
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.joining(",", "", "이 최종 우승했습니다."));
    }
}
