package com.dinesh.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestClass1 {
	
	private static Logger Log = Logger.getLogger(TestClass1.class.getName());
	
	@Test
	public void testCase1() {
		System.out.println("Test Case 1 Executed");
		Log.info("Test Case 1 Executed");
	}
	
	@Test
	public void testCase2() {
		System.out.println("Test Case 2 Executed");
		Log.error("Test Case 2 Executed");
	}

	@Test
	public void testCase3() {
		System.out.println("Test Case 3 Executed");
		Log.fatal("Test Case 3 Executed");
	}

}
