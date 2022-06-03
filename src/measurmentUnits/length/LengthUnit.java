package measurmentUnits.length;

import exception.NoMatchingUnitsFoundException;
import measurmentUnits.MeasurementUnit;
import threads.CalculateOtherUnitsOfLengthRunnable;

import java.math.BigDecimal;
import java.util.Map;

public class LengthUnit extends MeasurementUnit {

    private BigDecimal lengthInMeters;

    Map<LengthUnitsAvailable, BigDecimal> lengthInOtherUnits;

    public LengthUnit(BigDecimal numericalValue, String measuringUnit) {
        super(numericalValue, measuringUnit);

       lengthInMeters = anyUnitToMeters(numericalValue, measuringUnit);
       lengthInOtherUnits = calculateOtherUnits();
    }

    private BigDecimal anyUnitToMeters(BigDecimal numericalValue, String measuringUnitString) {

        LengthUnitsAvailable measuringUnit = stringUnitToEnum(measuringUnitString);

        // kilometers to meters
        if(measuringUnit == LengthUnitsAvailable.KILOMETER) {
            return numericalValue.multiply(new BigDecimal(1000));
        }

        // meters to meters :)
        if(measuringUnit == LengthUnitsAvailable.METER) {
            return numericalValue;
        }

        // decimeters to meters
        if(measuringUnit == LengthUnitsAvailable.DECIMETER) {
            return numericalValue.multiply(new BigDecimal("0.1"));
        }

        // centimeters to meters
        if(measuringUnit == LengthUnitsAvailable.CENTIMETER) {
            return numericalValue.multiply(new BigDecimal("0.01"));
        }

        // millimeters to meters
        if(measuringUnit == LengthUnitsAvailable.MILLIMETER) {
            return numericalValue.multiply(new BigDecimal("0.001"));
        }

        // inches to meters
        if(measuringUnit == LengthUnitsAvailable.INCH) {
            return numericalValue.multiply(new BigDecimal("0.0254"));
        }

        // feet to meters
        if(measuringUnit == LengthUnitsAvailable.FOOT) {
            return numericalValue.multiply(new BigDecimal("0.3048"));
        }

        // yards to meters
        if(measuringUnit == LengthUnitsAvailable.YARD) {
            return numericalValue.multiply(new BigDecimal("0.9144"));
        }

        // miles to meters
        if(measuringUnit == LengthUnitsAvailable.MILE) {
            return numericalValue.multiply(new BigDecimal("1 609.344"));
        }

        return BigDecimal.ZERO;
    }

    private Map<LengthUnitsAvailable, BigDecimal> calculateOtherUnits() {

        CalculateOtherUnitsOfLengthRunnable calculateLengthsRunnable = new CalculateOtherUnitsOfLengthRunnable(lengthInMeters);
        Thread calculateLengthsThread = new Thread(calculateLengthsRunnable);
        calculateLengthsThread.start();

        return calculateLengthsRunnable.getCalculatedValues();
    }

    private LengthUnitsAvailable stringUnitToEnum(String unitInString) throws NoMatchingUnitsFoundException {

        boolean isMillimeter = unitInString.equals("mm");
        if(isMillimeter) { return LengthUnitsAvailable.MILLIMETER; }

        boolean isCentimeter = unitInString.equals("cm");
        if(isCentimeter) { return LengthUnitsAvailable.CENTIMETER; }

        boolean isDecimeter = unitInString.equals("dm");
        if(isDecimeter) { return LengthUnitsAvailable.DECIMETER; }

        boolean isMeter = unitInString.equals("m");
        if(isMeter) { return LengthUnitsAvailable.METER; }

        boolean isKilometer = unitInString.equals("km");
        if(isKilometer) { return LengthUnitsAvailable.KILOMETER; }

        boolean isInch = unitInString.equals("in") || unitInString.equals("in.") || unitInString.equals("inch");
        if(isInch) { return LengthUnitsAvailable.INCH; }

        boolean isFoot = unitInString.equals("ft") || unitInString.equals("ft.") || unitInString.equals("foot") || unitInString.equals("feet");
        if(isFoot) { return LengthUnitsAvailable.FOOT; }

        boolean isYard = unitInString.equals("yard") || unitInString.equals("yards");
        if(isYard) { return LengthUnitsAvailable.YARD; }

        boolean isMile = unitInString.equals("mile") || unitInString.equals("miles");
        if(isMile) { return LengthUnitsAvailable.MILE; }

        throw new NoMatchingUnitsFoundException("Couldn't match units in string to unit enum.");
    }
}
