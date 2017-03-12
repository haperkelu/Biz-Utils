package org.gradle.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
	/**
	 * Given a string and an integer k, you need to reverse the first k
	 * characters for every 2k characters counting from the start of the string.
	 * If there are less than k characters left, reverse all of them. If there
	 * are less than 2k but greater than or equal to k characters, then reverse
	 * the first k characters and left the other as original.
	 * 
	 * Example:
	 * 
	 * Input: s = "abcdefg", k = 2 Output: "bacdfeg"
	 * 
	 * Restrictions:
	 * 
	 * The string consists of lower English letters only. Length of the given
	 * string and k will in the range [1, 10000]
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public String reverseStr(String s, int k) {

		if (s == null)
			throw new IllegalArgumentException("illegal argument!");

		char[] cArr = s.toCharArray();
		if (s.length() <= k) {
			reverseCharArray(cArr, 0, s.length() - 1);
			return new String(cArr);
		}
		int doubleK = 2 * k;
		if (s.length() > k && s.length() <= doubleK) {
			reverseCharArray(cArr, 0, k - 1);
			return new String(cArr);
		}

		int index = 0;
		while (true) {
			int begin = index;
			int end = (begin + k - 1 > s.length() - 1) ? s.length() - 1 : begin + k - 1;
			reverseCharArray(cArr, begin, end);
			index += doubleK;
			if (index > s.length() - 1)
				break;
		}
		return new String(cArr);
	}

	private char[] reverseCharArray(char[] cArr, int begin, int end) {

		while (begin < end) {
			char temp = cArr[begin];
			cArr[begin++] = cArr[end];
			cArr[end--] = temp;
		}
		return cArr;
	}

	/**
	 * 
	 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find
	 * the minimum minutes difference between any two time points in the list.
	 * 
	 * Example 1:
	 * 
	 * Input: ["23:59","00:00"] Output: 1
	 * 
	 * Note:
	 * 
	 * The number of time points in the given list is at least 2 and won't
	 * exceed 20000. The input time is legal and ranges from 00:00 to 23:59.
	 * 
	 * @param timePoints
	 * @return
	 */
	public int findMinDifference(List<String> timePoints) {

		List<Integer> newList = new ArrayList<Integer>(timePoints.size());
		for (String s : timePoints) {
			int value = Integer.valueOf(s.split(":")[0]) * 60 + Integer.valueOf(s.split(":")[1]);
			newList.add(value);
		}
		Collections.sort(newList);
		int currentTime, minDiff = 1440;

		for (int i = 0; i < newList.size(); i++) {
			currentTime = newList.get(i);
			int diff;
			if (i == 0) {
				diff = currentTime + 1440 - newList.get(newList.size() - 1);
			} else {
				diff = currentTime - newList.get(i - 1);
			}
			if (diff < minDiff)
				minDiff = diff;
		}
		return minDiff;
	}

	public TreeNode str2tree(String s) {

		if (!s.contains("(") && !s.contains(")"))
			return new TreeNode(Integer.parseInt(s));
		
		Stack st = new Stack();
		TreeNode current;

		for(char c: s.toCharArray()){
			if(c != ')') st.push(c);
			
			if(c == ')') {
				String valueStr = "";
				while(!st.peek().equals("(")) {
					valueStr = st.pop().toString() + valueStr;
				}
				current = new TreeNode(Integer.parseInt(valueStr));			
				Object prev = st.pop(); // pop '('
			}			
		}

		return null;
	}

}
