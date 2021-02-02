package com.examples.Junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1,2);
        Assert.assertEquals(3, result);
    }
}
