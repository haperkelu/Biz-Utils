/**
 * 
 */
package org.gradle.practice;

import java.util.List;

/**
 * @author pai.li
 *
 */
public class FindMaxValueFromArrayOfInteger {

	public static Integer findMaxValue(List<Integer> input) {
		if(input == null 
				|| input.size() == 0) throw new IllegalArgumentException("illegal argument!"); 
		Integer finalResult = input.get(0);
		for(Integer i: input){
			if(finalResult < i) finalResult = i;
		}	
		return finalResult;
	}
	
	public static Integer findMaxValueFromThree(List<Integer> input) {
		if(input == null 
				|| input.size() != 3) throw new IllegalArgumentException("illegal argument!"); 
		
		Integer finalResult = input.get(0);
		finalResult = finalResult < input.get(1)? input.get(1): finalResult;
		finalResult = finalResult < input.get(2)? input.get(2): finalResult;
		return finalResult;
	}
}
