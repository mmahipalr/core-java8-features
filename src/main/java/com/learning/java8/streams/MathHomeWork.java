package com.learning.java8.streams;

import java.util.stream.IntStream;

public class MathHomeWork {

	public static int findSumOfPerfectNumbers(int start, int end) {
		
		int count = IntStream.range(start, end).filter(num -> {
			int temp = num;
			int reminder = 0;
			boolean perfectNumber = true;
			while(temp > 0) {
				reminder = temp%10;
				if(reminder == 0 || num % reminder != 0 ) {
					perfectNumber = false;
				}
				break;
			}
			return perfectNumber ;
		}).sum() ;
		
		return count;
	}
		
	public static void main(String[] args) {
		System.out.println(findSumOfPerfectNumbers(2, 13));
	}

}
