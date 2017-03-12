package org.cradle.practice;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.gradle.practice.FindMaxValueFromArrayOfInteger;

public class FindMaxValueFromArrayTester {
    @Test
    public void canConstructAPersonWithAName() {
    	List<Integer> input =  Arrays.asList(11,222,-222);
    	
    	assertEquals(Integer.valueOf(222), FindMaxValueFromArrayOfInteger.findMaxValue(input));
    }
}
