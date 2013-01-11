package com.saman.stringcalculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimeterHandler
{
	private static final int REGEX_GROUP_NUMBER_OF_ONE_USER_DEFINED_DELIMETER = 1;
	private static final int REGEX_GROUP_NUMBER_OF_ALL_USER_DEFINED_DELIMETERS = 1;
	private static final String USER_DEFINED_DELIMETER_REGEX_PATTERN = "//((.)|(\\[(.+)\\])*)\n(.*)";
	private static final String ALL_USER_DEFINED_DELIMETER_REGEX_PATTERN = "\\[(.+?)\\]";
	private static final String REGEX_KEYWORD_OR = "|";
	private static final String PREDEFINED_DELIMETERS = ",|\n";
	private static final int REGEX_GROUP_NUMBER_OF_SINGLE_CHARACTER_DELIMETERS = 2;
	private static final int REGEX_GROUP_NUMBER_OF_NUMBER_STRING = 5;
	
	public String getNumberString(String numbers)
	{
		Matcher m = Pattern.compile(USER_DEFINED_DELIMETER_REGEX_PATTERN).matcher(numbers);
		if (m.find())
		{
			return m.group(REGEX_GROUP_NUMBER_OF_NUMBER_STRING);
		}
		return numbers;
	}
	
	public String getDelimeters(String numbers)
	{
		Matcher m = Pattern.compile(USER_DEFINED_DELIMETER_REGEX_PATTERN).matcher(numbers);
		if (m.find())
		{
			return getUserDefineDelimeter(m);
		}
		return PREDEFINED_DELIMETERS;
	}

	private String getUserDefineDelimeter(Matcher m)
	{
		if (hasUserDefinedSingleCharacterDelimeter(m))
		{
			return getUserDefinedSingleDelimeter(m);
		}
		else
		{
			return getUserDefinedMultipleDelimeter(m);
		}
	}

	private String getUserDefinedMultipleDelimeter(Matcher m)
	{
		String delimeters = m.group(REGEX_GROUP_NUMBER_OF_ALL_USER_DEFINED_DELIMETERS);
		Matcher delimeterMatcher = Pattern.compile(ALL_USER_DEFINED_DELIMETER_REGEX_PATTERN).matcher(delimeters);
		StringBuffer allDelimeters = new StringBuffer();
		while (delimeterMatcher.find())
		{
			addOneDelimeterToAllDelimers(allDelimeters, delimeterMatcher.group(REGEX_GROUP_NUMBER_OF_ONE_USER_DEFINED_DELIMETER));
		}

		return allDelimeters.toString();
	}

	private void addOneDelimeterToAllDelimers(StringBuffer userDelimeters, String delimeter)
	{
		if (userDelimeters.length() == 0)
		{
			userDelimeters.append(quote(delimeter));
		}
		else
		{
			userDelimeters.append(REGEX_KEYWORD_OR + quote(delimeter));
		}
	}

	private String quote(String delimeter)
	{
		return Pattern.quote(delimeter);
	}

	private String getUserDefinedSingleDelimeter(Matcher m)
	{
		return quote(m.group(REGEX_GROUP_NUMBER_OF_SINGLE_CHARACTER_DELIMETERS));
	}

	private boolean hasUserDefinedSingleCharacterDelimeter(Matcher m)
	{
		return m.group(REGEX_GROUP_NUMBER_OF_SINGLE_CHARACTER_DELIMETERS) != null;
	}

}
