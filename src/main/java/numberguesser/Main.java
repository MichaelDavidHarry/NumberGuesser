package numberguesser;

import numberguesser.input.NumberGuessingGameManager;
import numberguesser.game.InvalidNumberRangeException;

class Main {
    public static void main(String[] args) {
        try{
            new NumberGuessingGameManager(System.in, System.out).manageNumberGuessingGames();
        }
        catch(InvalidNumberRangeException e){
            System.out.println(e.toString());
        }
    }
}