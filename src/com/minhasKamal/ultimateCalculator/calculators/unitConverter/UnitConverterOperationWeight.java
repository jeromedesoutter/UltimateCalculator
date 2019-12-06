package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationWeight {public enum Weight{
	MILLIGRAM(1000000f),
	GRAM(1000f),
	KILOGRAM(1f),
	TONNE(0.001f),
	OUNCE(35.2739619495804f),
	POUND(2.2046226218488f),
	CARAT(5000f);


	public final float value;
	private Weight(float value) {
		this.value= value;
	}
}
	public double Weight(UnitConverterOperationWeight.Weight from, UnitConverterOperationWeight.Weight to, double input){
		return input * to.value / from.value;
	}

}





