package org.ncibi.commons.lang;

import junit.framework.Assert;

import org.junit.Test;

public class NumUtilsTest {
	
	@Test
	public void test1() {
		Double testVar = NumUtils.toDouble("2.0");
		Double testVar2 = NumUtils.toDouble("2eggs");
		Assert.assertTrue(testVar != null && testVar.equals(2.0));
		Assert.assertTrue(testVar2 == null);
		
		Integer testInt = NumUtils.toInteger("2");
		Integer testInt2 = NumUtils.toInteger("2eggs");
		Assert.assertTrue(testInt != null && testInt.equals(2));
		Assert.assertTrue(testInt2 == null);
	}

}
