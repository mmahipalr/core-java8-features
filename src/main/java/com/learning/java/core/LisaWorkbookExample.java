package com.learning.java.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LisaWorkbookExample {
	
	public static int workbook(int n, int k, List<Integer> list) {
	    // Write your code here
		if(list.isEmpty()) {
			return 0;
		}
		
		int specialIndex=0, pageCount=0, totalPages=0, startQ=0, endQ=0;
		for(int problems: list) {
			pageCount=0;
			pageCount = pageCount+(problems/k);
			pageCount = problems%k >0 ? pageCount+1:pageCount;
			
			startQ=1;
			if(problems >= startQ+k-1) {
				endQ=k;
			} else {
				endQ = problems;
			}
			while(pageCount > 0) {
				totalPages++;
				if(totalPages>=startQ && totalPages <= endQ) {
					specialIndex++;
				}
				startQ = endQ+1;
				if(problems >= startQ+k-1) {
					endQ = startQ+k-1;
				} else {
					endQ = problems;
				}
				pageCount--;
			}
			
		}
		
		
		return specialIndex;
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = Stream.of(4, 2, 6, 1, 10).collect(Collectors.toList());
		System.out.println(workbook(5, 3, list));

	}
	
}
