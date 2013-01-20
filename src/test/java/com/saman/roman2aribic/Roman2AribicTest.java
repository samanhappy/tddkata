package com.saman.roman2aribic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Roman2AribicTest {

	private String romanNumber;
	private int expectedAribicNumber;

	public Roman2AribicTest(String theRomanNumber, int theExpectedAribicNumber) {
		romanNumber = theRomanNumber;
		expectedAribicNumber = theExpectedAribicNumber;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> romanNumberAndExpectedAribicNumber() {
		return Arrays.asList(new Object[][] { { "I", 1 }, { "II", 2 },
				{ "III", 3 }, { "V", 5 }, { "IV", 4 }, { "VI", 6 },
				{ "X", 10 }, { "IX", 9 }, { "L", 50 }, { "XL", 40 },
				{ "C", 100 }, { "XC", 90 }, { "CX", 110 }, { "D", 500 },
				{ "CD", 400 }, { "DC", 600 }, { "M", 1000 }, { "DM", 500 },
				{ "MD", 1500 }, { "MCMXCIX", 1999 } });
	}

	@Test
	public void convert() {
		Roman2Aribic convertor = new Roman2Aribic();
		assertEquals(expectedAribicNumber, convertor.convert(romanNumber));
	}

}
