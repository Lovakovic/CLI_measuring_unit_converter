package inputFormatters;

import exception.InvalidInputException;
import exception.KeywordFoundException;
import exception.NoDigitsFoundException;
import measurmentUnits.MeasurementUnit;
import measurmentUnits.length.LengthUnit;
import measurmentUnits.speed.SpeedUnit;

import java.math.BigDecimal;
import java.util.Locale;

public class  StringToUnitConverter {

    public static MeasurementUnit parseInput(String input, Class<?> measurementType) throws InvalidInputException, KeywordFoundException {

        searchForKeyWords(input);
        BigDecimal numberFound = searchForNumber(input);

        return searchForSymbols(input, measurementType, numberFound);
    }

    public static BigDecimal searchForNumber(String userInput) throws NoDigitsFoundException {

        String numberOnly = userInput.replaceAll("[^0-9.]", "");
        boolean foundNumbers = numberOnly.length() > 0;

        if(!foundNumbers) {
            throw new NoDigitsFoundException("Found 0 digits in string: " + userInput);
        }

        return new BigDecimal(numberOnly);
    }

    public static void searchForKeyWords(String userInput) throws KeywordFoundException {
        boolean goBackToWelcomeScreen = userInput.equalsIgnoreCase("exit");
        boolean explainInputFormat = userInput.equalsIgnoreCase("explain");

        if(goBackToWelcomeScreen) {
            throw new KeywordFoundException("exit");
        }

        if(explainInputFormat) {
            throw new KeywordFoundException("explain");
        }
    }

    public static MeasurementUnit searchForSymbols(String input, Class<?> measurementType, BigDecimal foundNumber) throws InvalidInputException {

        String inputWithoutNumbers = input.replaceAll("[0-9.]", "").trim().toLowerCase(Locale.ROOT);

        // Match against length symbols?
        if (LengthUnit.class.equals(measurementType)) {
            boolean foundMatchingSymbol = MeasurementUnit.lengthUnitSymbols.contains(inputWithoutNumbers);

            if(foundMatchingSymbol) {
                return new LengthUnit(foundNumber, inputWithoutNumbers);
            }
        }

        // Match against speed symbols?
        if (SpeedUnit.class.equals(measurementType)) {

        }

        // ...

        throw new InvalidInputException("No matching measurement unit found.");
    }
}
