package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationEnergy {public enum Energy{
	JOULE(1f),
	KILOJOULE(0.001f),
	CALORIE(0.239006f),
	KILOCALORIE(0.000239006f),
	ELECTRONVOLTS(6.241509479607718e+18f),
	FOOTPOUND(0.7375621492772656f);


	public final float value;
	private Energy(float value) {
		this.value= value;
	}
}
	public double Energy(UnitConverterOperationEnergy.Energy from,UnitConverterOperationEnergy.Energy to, double input){
		return input * to.value / from.value;
		}

}

