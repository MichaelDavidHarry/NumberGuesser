package numberguesser.input;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import numberguesser.game.InclusiveIntegerRange;
import numberguesser.game.IntegerNumberGenerator;
import numberguesser.game.InvalidNumberRangeException;
import numberguesser.game.NumberGuessingGame;

public class NumberGuessingGameManager {
    private Scanner inputScanner;
    private PrintStream output;
    public NumberGuessingGameManager(InputStream input, PrintStream output) {
        this.inputScanner = new Scanner(input);
        this.output = output;
    }

    private static final int LOW_NUMBER = 0;
    private static final int HIGH_NUMBER = 100;
    public void manageNumberGuessingGames() throws InvalidNumberRangeException {
        while(true) {
            output.println(String.format("Starting a new game, please guess a number from %d to %d", LOW_NUMBER, HIGH_NUMBER));
            NumberGuessingGame game = new NumberGuessingGame(new InclusiveIntegerRange(LOW_NUMBER, HIGH_NUMBER), new IntegerNumberGenerator());
            while(!game.getIsGameCompleted()) {
                Integer userInput = tryParseInteger(inputScanner.next());
                if(userInput == null){
                    output.println("Hey, this doesn't seem to be an integer number. Try typing that again!");
                    continue;
                }
                output.println(game.processGuessedNumber(userInput));
            }
        }
    }

    private Integer tryParseInteger(String str){
        try{
            return Integer.parseInt(str);
        }
        catch(NumberFormatException e) {
            return null;
        }
    }
}