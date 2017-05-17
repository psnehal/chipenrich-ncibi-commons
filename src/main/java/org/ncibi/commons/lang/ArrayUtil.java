package org.ncibi.commons.lang;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;

public class ArrayUtil
{

	private ArrayUtil()
	{
	}

	public static int[] toIntArray(String values)
	{
		List<Integer> convertedValues = new ArrayList<Integer>();
		for (String value : StrUtils.COMMA_SPLITTER.trimResults().split(values))
		{
			convertedValues.add(NumberUtils.toInt(value, -1));
		}

		return ArrayUtils.toPrimitive(convertedValues.toArray(new Integer[0]));
	}

	public static double[] toDoubleArray(String values)
	{
		List<Double> convertedValues = new ArrayList<Double>();
		for (String value : StrUtils.COMMA_SPLITTER.trimResults().split(values))
		{
			convertedValues.add(NumberUtils.toDouble(value, 0));
		}

		return ArrayUtils.toPrimitive(convertedValues.toArray(new Double[0]));
	}

	public static String[] toStringArray(String values)
	{
		if ("".equals(values))
		{
			return null;
		}
		List<String> convertedValues = new ArrayList<String>();
		for (String value : StrUtils.COMMA_SPLITTER.trimResults().split(values))
		{
			convertedValues.add(value);
		}

		return convertedValues.toArray(new String[0]);
	}
}
