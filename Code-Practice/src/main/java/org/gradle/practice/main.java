/**
 * 
 */
package org.gradle.practice;

import java.util.Arrays;
import java.util.List;

/**
 * @author pai.li
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 15;  
		int k = 2;
		System.out.println(new Solution().reverseStr("abcdefgdqyi", 3));
		List<String> l = Arrays.asList("23:59","00:00", "12:46");
		System.out.println(new Solution().findMinDifference(l));

	}

}
