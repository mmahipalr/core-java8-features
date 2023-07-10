package com.learning.java8.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LisaWorkbookExample {
	
	public static int workbook(int n, int k, List<Integer> arr) {
	    // Write your code here
		if(arr.isEmpty()) {
			return 0;
		}
		
		AtomicInteger totalPages = new AtomicInteger();
//		Consumer<Integer> problemConsumer = (problems) -> {
//			
//		};
//		
//		BiConsumer<Integer, Integer> problemBiConsumer = (problems, pageCount) ->{
//			
//		};
//		
//		
//		IntFunction<Integer> problemIntFunction = (index)->{
//			int pageCount = 0;
//			int problems = arr.get(index);
//			pageCount = pageCount+(problems/k);
//			pageCount = problems%k >0 ? pageCount+1:pageCount;
//			return pageCount;
//		};
//		
		
		Function<Integer, Integer> problemFunction = (problems)->{
			int pageCount = 0;
			int specialIndex = 0;
			int startQ = 0;
			int endQ = 0;
			pageCount = pageCount+(problems/k);
			pageCount = problems%k >0 ? pageCount+1:pageCount;
			startQ = 1;
			if(problems >= startQ+k-1) {
				endQ = k;
			} else {
				endQ = problems;
			}
			while(pageCount > 0) {
				totalPages.incrementAndGet();
				if(totalPages.get()>=startQ && totalPages.get() <= endQ) {
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
			return pageCount;
		};
	
		
		BiFunction<Integer, Integer, Integer> specialIndexFunction = (index, pageCount)->{
			int problems = arr.get(index);
			int specialIndex = 0;
			int startQ = 0;
			int endQ = 0;
			startQ = 1;
			if(problems >= startQ+k-1) {
				endQ = k;
			} else {
				endQ = problems;
			}
			while(pageCount > 0) {
				totalPages.incrementAndGet();
				if(totalPages.get()>=startQ && totalPages.get() <= endQ) {
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
			return specialIndex;
		};
			
//		BinaryOperator<Integer> operator = (specialIndexCount, specialIndex) -> {
//			return specialIndexCount+specialIndex;
//		};
		
		int count = arr.stream().map(problemFunction).reduce(0, Integer::sum);
	
		
	//	List<Integer> list =  IntStream.range(0, n).mapToObj(problemIntFunction).map(i -> i).collect(Collectors.toList());
		
		
		
		System.out.println(count);
		
		return count;
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = Stream.of(4, 2, 6, 1, 10).collect(Collectors.toList());
		System.out.println(workbook(5, 3, list));

	}
	
}
