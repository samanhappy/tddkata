package com.saman.wordwrap;

import org.junit.Test;

public class TestMinValue
{
	@Test
	public void test()
	{
		int[] arr = { 5, 6, 7, 2, 9, 8 };
		int first_min = arr[0], second_min = arr[0];
		for (int i : arr)
		{
			if (i < first_min)
			{
				first_min = i;
			}
			else if (i > first_min && i < second_min)
			{
				second_min = i;
			}
		}
		System.out.println(first_min);
		System.out.println(second_min);
	}
}
