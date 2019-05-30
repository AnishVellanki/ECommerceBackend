package com.ani.ECommerceBackend;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

public class TestProgram {

	@BeforeClass
	public static void TestFirst() {
		System.out.println("before class");
	}
	@Test
	public void Test1() {
		System.out.println("test");
		Cal c=new Cal();
		assertEquals("success",true,c.even(3));
	}
	@AfterClass
	public static void TestLast() {
		System.out.println("after class");
	}
	}
