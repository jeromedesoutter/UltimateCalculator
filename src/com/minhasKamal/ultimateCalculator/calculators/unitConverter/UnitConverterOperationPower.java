package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationPower {public enum Power{
	WATT(1f),
	KILOWATT(0.001f),
	HORSEPOWER(0.001341022089595f);

	public final float value;
	private Power(float value) {
		this.value= value;
	}
}
	public double Power(UnitConverterOperationPower.Power from, UnitConverterOperationPower.Power to, double input){
		return input * to.value / from.value;
	}

}

