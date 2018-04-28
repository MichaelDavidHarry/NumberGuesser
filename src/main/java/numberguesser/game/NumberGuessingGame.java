package numberguesser.game;

public class NumberGuessingGame {
    private InclusiveIntegerRange numberRange;
    private int targetNumber;
    private boolean isGameCompleted;
    public NumberGuessingGame(InclusiveIntegerRange numberRange, RandomNumberGenerator numberGenerator) {
        if(numberRange == null) {
            // Note: This is a runtime exception, so we don't need to indicate we throw it in the method signature.
            throw new NullPointerException("numberRange was null");
        }
        this.numberRange = numberRange;
        this.targetNumber = numberGenerator.generateRandomNumber(numberRange);
    }

    public String processGuessedNumber(int guessedNumber) {
        if(!numberRange.isNumberInRange(guessedNumber)) {
            return String.format("Hey! You guessed %d, but the number we're thinking of is between %d and %d.", guessedNumber, numberRange.getLowNumber(), numberRange.getHighNumber());
        }
        else if(guessedNumber > targetNumber) {
            return "Your guess was too high!";
        }
        else if(guessedNumber < targetNumber) {
            return "Your guess was too low!";
        }
        else {
            // The only remaining possibility is that the user has guessed our number.
            isGameCompleted = true;
            return String.format("You got it! The number we were thinking of was %d. Thanks for playing!", targetNumber);
        }
    }

    public boolean getIsGameCompleted() {
        return isGameCompleted;
    }
}