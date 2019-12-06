package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationTemperature {public enum Temperature{
	Celsius(1f),
	Fahrenheit(6f),
	Kelvin(1+273f);

	public final float value;

	private Temperature(float value) {
		this.value = value;
	}
}
	public double Temperature(UnitConverterOperationTemperature.Temperature from,UnitConverterOperationTemperature.Temperature to, double input){
		return input * to.value / from.value;
	}

}


