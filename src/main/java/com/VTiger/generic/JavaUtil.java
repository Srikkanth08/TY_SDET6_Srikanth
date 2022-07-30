package com.VTiger.generic;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtil 
{
	@Test
	public void createRandomNumber()
	{
		Random R = new Random();
		int number = R.nextInt(10);
		System.out.println(number);
	}
}
