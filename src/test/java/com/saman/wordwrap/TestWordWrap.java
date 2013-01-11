package com.saman.wordwrap;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestWordWrap
{
	@Test
	public void null_Returns_Empty()
	{
		assertEquals("", WordWarp.generate(null, 5));
	}
	
	@Test
	public void empty_Returns_Empty()
	{
		assertEquals("", WordWarp.generate("", 5));
	}
	
	@Test
	public void one_Word_Shorter_Than_Length_Should_Returns_This_Word()
	{
		assertEquals("word", WordWarp.generate("word", 4));
		assertEquals("word", WordWarp.generate("word", 5));
	}
	
	@Test
	public void one_Word_Longer_Than_Length_Should_Break_In_Between()
	{
		assertEquals("long\nword", WordWarp.generate("longword", 4));
	}
	
	@Test
	public void one_Word_Longer_Than_Twice_Of_Length_Should_Break_Twice()
	{
		assertEquals("very\nlong\nword", WordWarp.generate("verylongword", 4));
	}
	
	@Test
	public void two_Words_Longer_Than_Length_Returns_Wrap()
	{
		assertEquals("word\nword", WordWarp.generate("word word", 6));
	}
	
	@Test
	public void two_Words_And_Word_Longer_Than_Length_Should_Wrap_More()
	{
		assertEquals("wo\nrd\nwo\nrd", WordWarp.generate("word word", 2));
		assertEquals("wor\nd\nwor\nd", WordWarp.generate("word word", 3));
		assertEquals("wor\nd\nwor", WordWarp.generate("word wor", 3));
	}
	
	@Test
	public void three_Words_Longer_Than_Twice_Of_Length_Should_Wrap_Twice()
	{
		assertEquals("word\nword\nword", WordWarp.generate("word word word", 6));
	}
	
	@Test
	public void three_Words_Just_Longer_Than_Length_Should_Wrap()
	{
		assertEquals("word word\nword", WordWarp.generate("word word word", 11));
	}
	
	@Test
	public void two_Words_And_First_Word_Equals_To_Length_Should_Wrap_Without_Leading_Space_In_Second_Line()
	{
		assertEquals("word\nword", WordWarp.generate("word word", 4));
	}
}
