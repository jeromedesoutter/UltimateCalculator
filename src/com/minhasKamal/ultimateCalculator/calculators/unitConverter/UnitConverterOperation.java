package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

import java.util.function.Function;

class UnitConverterOperation {
    private interface UnitConverter<T>{
        double convert(T from, T to, double input);
    }

    public enum Area implements UnitConverter<Area>{
        SQUARECENTIMETER(10000f),
        SQUAREMETER(1f),
        HECTARE(0.0001f),
        SQUAREKILOMETER(0.000001f),
        SQUAREINCH(1550.0031000062f),
        SQUAREFEET(10.76391041671f),
        SQUAREYARD(10.76391041671f/9f),
        SQUAREMILE(10.76391041671f/27878400f),
        KATHA(0.0029585798816568047f),
        BIGHA(0.000616772066877f),
        SATAK(10.76391041671f/435.60f),
        ACRE(10.76391041671f/43560f),
        ;

        public final float value;
        Area(float value) { this.value= value; }

        @Override
        public double convert(Area from, Area to, double input) {
            return input * to.value / from.value;
        }
    }
    public enum Energy implements UnitConverter<Energy>{
        JOULE(1f),
        KILOJOULE(0.001f),
        CALORIE(0.239006f),
        KILOCALORIE(0.000239006f),
        ELECTRONVOLTS(6.241509479607718e+18f),
        FOOTPOUND(0.7375621492772656f);

        public final float value;
        Energy(float value) { this.value= value; }

        @Override
        public double convert(Energy from, Energy to, double input) {
            return input * to.value / from.value;
        }
    }
    public enum Length implements UnitConverter<Length>{
        ANGSTROM(1e10f),
        NANOMETER(1e9f),
        MICRON(1000000f),
        MILLIMETER(1000f),
        CENTIMETER(100f),
        METER(1f),
        KILOMETER(1e-3f),
        INCH(39.37007874015748f),
        FEET(3.28083989501312f),
        YARD(1.09361329833771f),
        NAUTICALMILE(0.0005399568034557235f),
        MILE(0.000621371192237334f),
        ROD(0.19883878151595f);

        public final float value;
        Length(float value) { this.value= value; }

        @Override
        public double convert(Length from, Length to, double input) {
            return input * to.value / from.value;
        }
    }
    public enum Power implements UnitConverter<Power>{
        WATT(1f),
        KILOWATT(0.001f),
        HORSEPOWER(0.001341022089595f);

        public final float value;
        Power(float value) { this.value= value; }

        @Override
        public double convert(Power from, Power to, double input) {
            return input * to.value / from.value;
        }
    }
    public enum Temperature implements UnitConverter<Temperature>{
        Celsius(x->x,x->x),
        Fahrenheit(x->((x-32)/9)*5,x->((x/5)*9)+32),
        Kelvin(x->x-273.16,x->x+273.15);

        public final Function<Double,Double> toCelsius;
        public final Function<Double,Double> toUnit;

        Temperature(Function<Double,Double> toCelsius,Function<Double,Double> toUnit) { this.toCelsius= toCelsius;this.toUnit= toUnit; }

        @Override
        public double convert(Temperature from, Temperature to, double input) {
            return to.toUnit.apply(from.toCelsius.apply(input));
        }
    }
    public enum Time implements UnitConverter<Time>{
        NANOSECOND(1000000000f),
        MILLISECOND(1000f),
        SECOND(1f),
        MINUTE(1/60f),
        HOUR(1/3600f),
        DAY(1/86400f),
        WEEK(1/604800f);

        public final float value;
        Time(float value) { this.value= value; }

        @Override
        public double convert(Time from, Time to, double input) {
            return input * to.value / from.value;
        }
    }
    public enum Volume implements UnitConverter<Volume>{
        CUBICCENTIMER(0.000001f),
        CUBICMETER(1f),
        CUBICINCH(61023.74409473228f),
        CUBICFEET(35.31466672148859f),
        CUBICYARD(1.307950619314392f),
        LITER(1000),
        GALLONUK(219.9692482990878f),
        GALLONUS(264.1720523581484f);

        public final float value;
        Volume(float value) { this.value= value; }

        @Override
        public double convert(Volume from, Volume to, double input) {
            return input * to.value / from.value;
        }
    }
    public enum Weight implements UnitConverter<Weight>{
        MILLIGRAM(1000000f),
        GRAM(1000f),
        KILOGRAM(1f),
        TONNE(0.001f),
        OUNCE(35.2739619495804f),
        POUND(2.2046226218488f),
        CARAT(5000f);

        public final float value;
        Weight(float value) { this.value= value; }

        @Override
        public double convert(Weight from, Weight to, double input) {
            return input * to.value / from.value;
        }
    }

    static <T extends UnitConverter> double Convert(T from, T to, double input) {
        return from.convert(from, to, input);
    }
}
