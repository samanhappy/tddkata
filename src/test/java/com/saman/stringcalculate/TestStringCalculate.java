package com.saman.stringcalculate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class TestStringCalculate
{
	private StringCalculate stringCalculate;

	@Before
	public void createStringCalculate()
	{
		stringCalculate = new StringCalculate();
	}

	@Test
	public void empty_String_Return_0()
	{
		assertEquals(0, stringCalculate.run(""));
	}

	@Test
	public void one_Number_Return_This_Number()
	{
		assertEquals(1, stringCalculate.run("1"));
	}

	@Test
	public void mult_Number_Return_Sum()
	{
		assertEquals(3, stringCalculate.run("1,2"));
		assertEquals(6, stringCalculate.run("1,2,3"));
	}
	
	@Test
	public void new_line_delimeter_shoule_be_handled()
	{
		assertEquals(3, stringCalculate.run("1\n2"));
	}
	
	@Test
	public void user_defined_delimeters_should_be_handled()
	{
		assertEquals(3, stringCalculate.run("//;\n1;2"));
	}
	
	@Test
	public void user_defined_delimeters_and_regex_keyword_should_be_handled()
	{
		assertEquals(3, stringCalculate.run("//?\n1?2"));
	}
	
	@Rule public ExpectedException expectedExc = ExpectedException.none(); 
	
	@Test
	public void nagetive_number_shoule_return_exception()
	{
		expectedExc.expect(RuntimeException.class);
		expectedExc.expectMessage("nagatives not allows -1");
		stringCalculate.run("-1");
	}
	
	@Test
	public void multi_nagetive_number_shoule_return_exception()
	{
		expectedExc.expect(RuntimeException.class);
		expectedExc.expectMessage("nagatives not allows -1 -3");
		stringCalculate.run("-1,2,-3");
	}
	
	@Test
	public void number_larger_than_1000_shoule_be_ignored()
	{
		assertEquals(1, stringCalculate.run("1,1001"));
	}
	
	@Test
	public void user_defined_multiple_character_delimeters_should_be_handled()
	{
		assertEquals(3, stringCalculate.run("//[,,,]\n1,,,2"));
	}
	
	@Test
	public void user_defined_multiple_single_character_delimeters_should_be_handled()
	{
		assertEquals(6, stringCalculate.run("//[,][?]\n1,2?3"));
	}
	
	@Test
	public void user_defined_multiple_multiple_character_delimeters_should_be_handled()
	{
		assertEquals(6, stringCalculate.run("//[,,,][???]\n1,,,2???3"));
	}
}
