package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

public class JUnitTest {
		@BeforeAll
		public static void beforeAll()
		{
			
		}
		
		@AfterAll
		public static void afterAll()
		{
			
		}
		
		@Test
		public void test()
		{	
			
			Assertions.assertEquals(true, true);
		}
}
