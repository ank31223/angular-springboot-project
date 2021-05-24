package com.io.springboot.commonutils;

import java.util.UUID;

public class CommonUtils {
	
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
