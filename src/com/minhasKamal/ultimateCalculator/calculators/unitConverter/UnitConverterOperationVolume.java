package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationVolume {public enum Volume{
	CUBICCENTIMER(0.000001f),
	CUBICMETER(1f),
	CUBICINCH(61023.74409473228f),
	CUBICFEET(35.31466672148859f),
	CUBICYARD(1.307950619314392f),
	LITER(1000),
	GALLONUK(219.9692482990878f),
	GALLONUS(264.1720523581484f);

	public final float value;
	private Volume(float value) {
		this.value= value;
	}
}
	public double Volume(UnitConverterOperationVolume.Volume from,UnitConverterOperationVolume.Volume to, double input){
		return input * to.value / from.value;
	}

}

