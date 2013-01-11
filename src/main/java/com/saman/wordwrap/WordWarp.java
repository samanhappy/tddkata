package com.saman.wordwrap;

public class WordWarp
{

	public static String generate(String text, int length)
	{
		if (text == null)
		{
			return "";
		}

		if (text.length() <= length)
		{
			return text;
		}
		else
		{
			int space = text.substring(0, length).lastIndexOf(" ");
			if (space >= 0)
			{
				return breakText(text, space, space + 1, length);
			}
			else
			{
				return breakText(text, length, length, length);
			}
		}
	}

	private static String breakText(String text, int start, int end, int length)
	{
		return text.substring(0, start) + "\n" + WordWarp.generate(text.substring(end).trim(), length);
	}
}
