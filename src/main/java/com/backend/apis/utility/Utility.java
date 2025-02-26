package com.backend.apis.utility;

public class Utility {
	
	public String generatePassword(String name, String mobile) {
		return name + "_" + mobile.substring(0,4);
	}

}
