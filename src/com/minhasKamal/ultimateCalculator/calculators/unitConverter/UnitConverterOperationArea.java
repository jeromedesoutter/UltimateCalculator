package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationArea {public enum Area{
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
	private Area(float value) {
		this.value= value;
	}
}
	public double Area(UnitConverterOperationArea.Area from,UnitConverterOperationArea.Area to, double input){
		return input * to.value / from.value;
	}

}

