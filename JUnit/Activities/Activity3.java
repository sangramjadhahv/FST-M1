package activity3;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demos.Calculator;

public class Activity3 {
	
	private Calculator calculator;
	
	@BeforeAll
	public static void beforeAllTxt()
	{
		System.out.println("Before All block");
	}
	 
    @BeforeEach
    public void setUp() throws Exception 
    {
        calculator = new Calculator();
    }
 
    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply()
    {
        assertEquals(20, calculator.multiply(4, 5));
        assertNotEquals(30,calculator.multiply(4, 5));
       
    }
    
    @Test
    @Disabled("Disable until testMultiply is executed ")
    @DisplayName("Addition method")
    public void additionTest()
    {
    	assertEquals(20, calculator.add(10, 10));
    }
     
    @AfterEach
    public void cleanup()
    {
    	System.out.println("This method is used to cleanup the env");
    }
    @AfterAll
    public static void disconnect()
    {
    	System.out.println("This method is used to disconnect the session");
    }
		
	}


