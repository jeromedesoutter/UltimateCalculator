package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

public class UnitConverterOperationTime {public enum Time{
	NANOSECOND(1000000000f),
	MILLISECOND(1000f),
	SECOND(1f),
	MINUTE(1/60f),
	HOUR(1/3600f),
	DAY(1/86400f),
	WEEK(1/604800f);

	public final float value;
	private Time(float value) {
		this.value= value;
	}
}
	public double Time(UnitConverterOperationTime.Time from,UnitConverterOperationTime.Time to, double input){
		return input * to.value / from.value;
	}

}

