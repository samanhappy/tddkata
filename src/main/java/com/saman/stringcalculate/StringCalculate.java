package com.saman.stringcalculate;

public class StringCalculate
{
	private static final int IGNORED_NUMBER_UPPER_BOUNDARY = 1000;
	private static final String ZERO = "0";
	private static final String SPACE = " ";
	private static final String NAGATIVES_NOT_ALLOWS_PREFIX = "nagatives not allows";

	public int run(String str)
	{
		DelimeterHandler delimeterHandler = new DelimeterHandler();
		String delimeters = delimeterHandler.getDelimeters(str);
		String numberString = delimeterHandler.getNumberString(str);
		return getSum(getAllNumber(numberString, delimeters));
	}

	private String[] getAllNumber(String str, String delimeters)
	{
		if (str.isEmpty())
		{
			return new String[] { ZERO };
		}
		return str.split(delimeters);
	}

	private int getSum(String[] numbers)
	{
		int sum = 0;
		StringBuffer error = new StringBuffer();
		for (String number : numbers)
		{
			sum += toIntAndAddErrorMessageToBuffer(number, error);
		}
		throwsNagativeException(error);
		return sum;
	}

	private void throwsNagativeException(StringBuffer error)
	{
		if (error.length() > 0)
		{
			throw new RuntimeException(NAGATIVES_NOT_ALLOWS_PREFIX + error.toString());
		}
	}

	private int toIntAndAddErrorMessageToBuffer(String str, StringBuffer error)
	{
		int num = Integer.parseInt(str);
		if (num < 0)
			error.append(SPACE + str);
		return ignoreNumberLargerThanUpperBoundary(num);
	}

	private int ignoreNumberLargerThanUpperBoundary(int num)
	{
		if (num > IGNORED_NUMBER_UPPER_BOUNDARY)
		{
			return 0;
		}
		else
		{
			return num;
		}
	}

}
