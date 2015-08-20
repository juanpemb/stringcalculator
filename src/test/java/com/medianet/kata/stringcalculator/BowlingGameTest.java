package com.medianet.kata.stringcalculator;
import static org.junit.Assert.*;

import org.junit.Test;

import com.medianet.kata.stringcalculator.StringCalculator;

public class BowlingGameTest {

    private static final String STRING_TWENTY_ANY_NUMBERS = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2";

    private static final String STRING_ONE_TWO = "1,2";
    private static final String STRING_ONE_TWO_WITH_DIFERENT_DELIMITER = "//_\n1_2";

    private final StringCalculator calculator = new StringCalculator();
    
    @Test
    public void test_add_empty_string() throws Exception {
        
        int expected = 0;
        
        int result = calculator.add("");
        
        assertEquals("the result should be 0", expected , result);
    }
    @Test 
    public void test_add_one_an_two(){
        int expected = 3;
        
        int result = calculator.add(STRING_ONE_TWO);
        
        assertEquals("the result should be 3", expected , result);
    }
    
    @Test
    public void test_add_twenty_numbers(){
        int expected = 21;
        
        int result = calculator.add(STRING_TWENTY_ANY_NUMBERS);

        assertEquals("the sum should be 21",expected, result);
    }
    
    @Test
    public void test_one_plus_two_with_other_delimiter(){
        int expected = 3;
      
        int result = calculator.add(STRING_ONE_TWO_WITH_DIFERENT_DELIMITER);
        
        assertEquals("Should be 3" , expected,result);
    }
    
    @Test
    public void test_no_add_more_that_1000(){
      int expected = 2;
      
      int result = calculator.add("2,1001");
      
      assertEquals("Should be 2",expected, result);
    }
    
    @Test
    public void test_no_add_more_that_1001(){
      int expected = 8;

      int result = calculator.add("//_\n3_5_1001");
      
      assertEquals("Should be 8",expected, result);
    }
}
