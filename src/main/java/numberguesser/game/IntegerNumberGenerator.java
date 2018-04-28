package numberguesser.game;

import java.util.Random;

import numberguesser.game.InclusiveIntegerRange;
import numberguesser.game.RandomNumberGenerator;

public class IntegerNumberGenerator implements RandomNumberGenerator {
    private Random generator;
    public IntegerNumberGenerator() {
        this.generator = new Random();
    }

    public int generateRandomNumber(InclusiveIntegerRange range) {
        return generator.nextInt(range.getHighNumber() - range.getLowNumber()) + range.getLowNumber();
    }
}