package threads;

import measurmentUnits.length.LengthUnitsAvailable;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculateOtherUnitsOfLengthRunnable implements Runnable {

    private final BigDecimal lengthInMeters;
    private Map<LengthUnitsAvailable, BigDecimal> calculatedValues;

    public CalculateOtherUnitsOfLengthRunnable(BigDecimal lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    @Override
    public void run() {
        calculatedValues = new HashMap<>();

        // Calculating values
        BigDecimal kilometers = metersToKilometers(lengthInMeters);
        BigDecimal decimeters = metersToDecimeters(lengthInMeters);
        BigDecimal centimeters = metersToCentimeters(lengthInMeters);
        BigDecimal millimeters = metersToMillimeters(lengthInMeters);
        BigDecimal inches = metersToInches(lengthInMeters);
        BigDecimal feet = metersToFeet(lengthInMeters);
        BigDecimal yards = metersToYards(lengthInMeters);
        BigDecimal miles = metersToMiles(lengthInMeters);

        // Adding the values to the map
        calculatedValues.put(LengthUnitsAvailable.KILOMETER, kilometers);
        calculatedValues.put(LengthUnitsAvailable.DECIMETER, decimeters);
        calculatedValues.put(LengthUnitsAvailable.CENTIMETER, centimeters);
        calculatedValues.put(LengthUnitsAvailable.MILLIMETER, millimeters);
        calculatedValues.put(LengthUnitsAvailable.INCH, inches);
        calculatedValues.put(LengthUnitsAvailable.FOOT, feet);
        calculatedValues.put(LengthUnitsAvailable.YARD, yards);
        calculatedValues.put(LengthUnitsAvailable.MILE, miles);
    }

    public Map<LengthUnitsAvailable, BigDecimal> getCalculatedValues() {
        return calculatedValues;
    }

    private BigDecimal metersToKilometers(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal("0.001"));
    }

    private BigDecimal metersToDecimeters(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal(10));
    }

    private BigDecimal metersToCentimeters(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal(100));
    }

    private BigDecimal metersToMillimeters(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal(1000));
    }

    private BigDecimal metersToInches(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal("39.3700787"));
    }

    private BigDecimal metersToFeet(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal("3.2808399"));
    }

    private BigDecimal metersToYards(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal("1.0936133"));
    }

    private BigDecimal metersToMiles(BigDecimal lengthInMeters) {
        return lengthInMeters.multiply(new BigDecimal("0.00062137"));
    }
}
