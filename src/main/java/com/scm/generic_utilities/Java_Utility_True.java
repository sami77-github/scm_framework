package com.scm.generic_utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility_True {

	// Generate Random Number
	public int getRandomNumber() {
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		return randomInt;
	}

	// Generate System date
	public String getSystemDate() {
		Date date = new Date();
		return date.toString().replace(" ", "").replace(":", "");
	}
}
