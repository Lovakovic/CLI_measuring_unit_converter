package userInterface;

import exception.InvalidInputException;
import exception.KeywordFoundException;
import inputFormatters.StringToUnitConverter;
import measurmentUnits.length.LengthUnit;

import java.util.Scanner;

public class LengthScreenController implements UI {

    private final Scanner input;
    private LengthUnit enteredUnit;
    private LengthUnit convertedUnit;

    public LengthScreenController(Scanner input) {
        this.input = input;
    }

    @Override
    public void display() {
        enterValueAndUnit();
        enterDesiredUnit();
    }

    @Override
    public void exit() {
        // Implement exiting back to welcome screen
    }

    public void enterValueAndUnit() {
        System.out.println("For more info about input format type EXPLAIN, or type EXIT to go back to welcome screen.");
        System.out.print("Convert from: ");

        String userInput = input.nextLine();


        try {
           this.enteredUnit = (LengthUnit) StringToUnitConverter.parseInput(userInput, LengthUnit.class);


        } catch (InvalidInputException | KeywordFoundException ex) {

            if(ex instanceof KeywordFoundException) {
                explainInputFormat();
            } else {
                ex.printStackTrace();
            }
        }
    }

    public void explainInputFormat() {
        System.out.println("These are the currently recognized length symbols: ");
        LengthUnit.lengthUnitSymbols.stream().map(symbol -> symbol + " ").forEach(System.out::print);

        display();
    }

    public void enterDesiredUnit() {
        System.out.print("Please enter the desired unit symbol: ");

        String userInput = input.nextLine();

        try {

        }
    }
}
