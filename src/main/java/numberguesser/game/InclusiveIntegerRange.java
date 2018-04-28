package numberguesser.game;

import numberguesser.game.InvalidNumberRangeException;

public class InclusiveIntegerRange {
    private int lowNumber;
    private int highNumber;
    public InclusiveIntegerRange(int lowNumber, int highNumber) throws InvalidNumberRangeException {
        if(lowNumber > highNumber) {
            throw new InvalidNumberRangeException(String.format("low number %d is greater than high number %d", lowNumber, highNumber));
        }
        this.lowNumber = lowNumber;
        this.highNumber = highNumber;
    }

    public int getLowNumber() {
        return lowNumber;
    }

    public int getHighNumber() {
        return highNumber;
    }

    public boolean isNumberInRange(int number) {
        return number >= lowNumber && number <= highNumber;
    }
}