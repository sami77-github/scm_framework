package com.scm.login_verifications;

import java.io.IOException;

import com.scm.generic_utilities.FileUtility_True;

public class Temp {

	public static void main(String[] args) throws IOException {
		FileUtility_True fu = new FileUtility_True();
		String Browser = fu.getDataFromProperties("browser");
		String Url = fu.getDataFromProperties("url");
		System.out.println(Browser);
		System.out.println(Url);
	}
}
