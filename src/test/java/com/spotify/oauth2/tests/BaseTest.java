package com.spotify.oauth2.tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	//We should use this to get the method name and the Thread count
	@BeforeMethod
	public void beforeMethod(Method m)
	{
		System.out.println("STARTING TEST: " +m.getName());
		System.out.println("THREAD ID: " +Thread.currentThread().getId());
	}

}
