package racingcarGame.utils;

import java.util.Random;

public class RandomGenerator {
    public static boolean moveOrStop() {
        return new Random().nextBoolean();
    }
}
