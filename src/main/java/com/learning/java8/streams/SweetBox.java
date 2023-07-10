package com.learning.java8.streams;

import java.util.stream.IntStream;

public class SweetBox {

	public static int insertAdditionalSweets(int n, int[] sweets, int k) {
		if(sweets == null || sweets.length == 0 || k == 0) {
			return 0;
		}
		
		int count = IntStream.range(1, n-1).map(i -> {
			int previous = sweets[i-1];
			int present = sweets[i];
			int next = sweets[i+1];
			if(previous == 0 && next == 0 && present == 0) {
				return 1;
			} else if(present == 0 && next == 0 && i+1 == n-1) {
				return 1;
			}
			return 0; 
		
		}).sum();
		return count >= k ? 1 :0;	
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(insertAdditionalSweets(7, new int[]{1,0,0,0,1,0,0} ,2));
	}

}
