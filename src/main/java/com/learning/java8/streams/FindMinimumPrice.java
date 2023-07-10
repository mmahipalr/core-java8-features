package com.learning.java8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinimumPrice {

	public static long findMinimumPrice(List<Integer> price, int m) {
	    // Write your code here
		long minimumAmt = 0;
		AtomicInteger codes = new AtomicInteger(m); 
		if(price != null) {
			minimumAmt = price.stream().sorted(Comparator.reverseOrder()).map(p -> {
				if(codes.get() == 0) {
					return p;
				} else {
					int x = findPowerOfTwo(p);
					codes.set(codes.get()-x);
					return (int)Math.floor(p/Math.pow(2, x));
				}
			}).reduce(Integer::sum).get();
		}
		
		return minimumAmt;
	}
	
	static int findPowerOfTwo(int n)
    {
        if (n == 0)
            return 0;
        int count = 0;
        while (n > 1) {
        	count++;
            n = n / 2;
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> price = Stream.of(1,2,17).collect(Collectors.toList());
		System.out.println(FindMinimumPrice.findMinimumPrice(price, 1));
		
//		System.out.println(2 >> 12);
//		
//		System.out.println(2 << 2);
//		
//		System.out.println((int)Math.pow(2, 6));
		
		
	}

}
