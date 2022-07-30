package com.VTiger.generic;

import com.github.javafaker.Faker;

public class TestData 
{		
	/**
	 * @author Saikr This method gonna create fake data for first name
	 * @return String First Name
	 */

	public String firstName() 
	{
		Faker fake = new Faker();
		String name = fake.name().firstName();
		return name;
	}

	/**
	 * @author Saikr This method gonna create fake data for Last name
	 * @return String Last Name
	 */
	public String getLastName() 
	{
		Faker faker = new Faker();
		String lastName = faker.name().lastName();
		return lastName;
	}

	/**
	 * @author Saikr This Method gonna create fake data for organization
	 * @return
	 */
	public String oraganization() 
	{
		Faker fake1 = new Faker();
		String company = fake1.company().industry();
		return company;

	}

	/**
	 * @author Saikr This method gonna create fake data for phone number
	 * @return String phone number
	 */

	public String mobileNumber() 
	{
		Faker fake2 = new Faker();
		String phno = fake2.phoneNumber().cellPhone();
		return phno;
	}

	/**
	 * @author Saikr This method will return name of the city
	 * @return String city name
	 */

	public String getCityName() 
	{
		Faker faker = new Faker();
		return faker.address().cityName();
	}

}
