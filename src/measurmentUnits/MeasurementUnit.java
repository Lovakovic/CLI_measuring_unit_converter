package measurmentUnits;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class MeasurementUnit {

    private BigDecimal numericalValue;
    private String measuringUnit;

    public static final List<String> lengthUnitSymbols =
            Arrays.stream("mm,cm,dm,m,km,in,in.,inch,ft,ft.,foot,feet,yard,yards,mile,miles".split(","))
                    .map(String::toLowerCase).toList();

    public static final List<String> speedUnitSymbols =
            Arrays.stream("m/s,km/h,mph,knot,knots,ft/s".split(","))
                    .map(String::toLowerCase).toList();

    public static final List<String> temperatureUnitSymbols =
            Arrays.stream("°C,C,°K,K,°F,F".split(","))
                    .map(String::toLowerCase).toList();

    public static final List<String> volumeUnitSymbols =
            Arrays.stream("ml,cl,dl,l,mm^3,mm3,cm^3,cm3,dm^3,dm3,m^3,m3,fl.oz,fl.oz.,fl. oz,fl. oz.".split(","))
                    .map(String::toLowerCase).toList();

    public static final List<String> weightUnitSymbols =
            Arrays.stream("mg,g,kg,t,lb,lb.,oz,oz.".split(","))
                    .map(String::toLowerCase).toList();

    public MeasurementUnit(BigDecimal numericalValue, String measuringUnit) {
        this.numericalValue = numericalValue;
        this.measuringUnit = measuringUnit;
    }

    public BigDecimal getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(BigDecimal numericalValue) {
        this.numericalValue = numericalValue;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }
}
