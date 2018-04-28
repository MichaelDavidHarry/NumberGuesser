package numberguesser.game;

import numberguesser.game.InclusiveIntegerRange;

public interface RandomNumberGenerator {
    int generateRandomNumber(InclusiveIntegerRange range);
}