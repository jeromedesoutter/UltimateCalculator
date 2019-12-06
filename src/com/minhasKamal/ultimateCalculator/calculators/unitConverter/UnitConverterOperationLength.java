package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationLength {public enum Length{
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

	private Length(float value) {
		this.value= value;
	}
}
	public double Length(UnitConverterOperationLength.Length from,UnitConverterOperationLength.Length to, double input){
		return input * to.value / from.value;
	}

}



