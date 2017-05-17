package org.ncibi.commons.lang;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

public final class NumUtils {
	private NumUtils() {};
	
	private static NumberFormat numberFormat = NumberFormat.getInstance();
	private static DecimalFormat formatter = new DecimalFormat("#0.0E0");

	public static Double truncate(Double in) {
		if(in == null || in.equals(Double.NaN) || 
				in.equals(Double.POSITIVE_INFINITY) ||
				in.equals(Double.NEGATIVE_INFINITY))
			return in;
		else
			return toDouble(formatter.format(in));
	}
	
	public static Double toDouble(String value) {
		if(value != null) {
			value = value.trim();
			ParsePosition pos = new ParsePosition(0);
			Number returnValue = numberFormat.parse(value,pos);
			if(returnValue != null && pos.getIndex() == value.length())
				return returnValue.doubleValue();
		}
		return null;
	}
	
	public static Integer toInteger(String value) {
		if(value != null) {
			value = value.trim();
			ParsePosition pos = new ParsePosition(0);
			Number returnValue = numberFormat.parse(value,pos);
			if(returnValue != null && pos.getIndex() == value.length())
				return returnValue.intValue();
		}
		return null;
	}
	
	public static Boolean toBoolean(String value)
	{
		if ("true".equalsIgnoreCase(value))
		{
			return true;
		}
		else if ("false".equalsIgnoreCase(value))
		{
			return false;
		}
		else
		{
			return null;
		}
	}
	
	public static List<Integer> splitCommaOrSpaceSeparatedString(String string) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(string == null) return ret;
		
		string = string.replace(',', ' ');
		String[] parts = string.trim().split("\\s+");
		for (String part: parts){
			try {
				part = part.trim();
				Integer numericVal = NumUtils.toInteger(part);
				if(numericVal != null)
					ret.add(numericVal);
				else if(part != null || numericVal == null)
					throw new Exception();
			} catch (Throwable t) {
				return null;
			}
		}
		return ret;
	}
}
