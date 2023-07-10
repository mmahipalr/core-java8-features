package com.learning.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStreamsExamples {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		listOfNumbers.stream().forEach(number ->
		    System.out.println(number + " " + Thread.currentThread().getName())
		);
		
		System.out.println("saparator");
		
		List<Integer> listOfNumbers1 = Arrays.asList(1, 2, 3, 4,5,6,7,8,9);
		listOfNumbers1.parallelStream().forEach(number ->
		    System.out.println(number + " " + Thread.currentThread().getName())
		);
		
		List<Integer> listOfNumbers2 = Arrays.asList(1, 2, 3, 4);
		int sum = listOfNumbers2.parallelStream().reduce(0, Integer::sum);
		System.out.println("sum "+sum);
		
		List<Integer> listOfNumbers4 = Arrays.asList(1, 2, 3, 4,5,6,7,8,9);
		int sum4 = listOfNumbers4.parallelStream().reduce(5, Integer::sum);
		System.out.println("sum4 "+sum4);
		
		List<Integer> listOfNumbers3 = Arrays.asList(1, 2, 3, 4,5,6,7,8,9);
		int sum1 = listOfNumbers3.stream().reduce(5, Integer::sum);
		System.out.println("sum1 "+sum1);
		
		
		List<Integer> listOfNumbers5 = Arrays.asList(1, 2, 3, 4);
		ForkJoinPool customThreadPool = new ForkJoinPool(1);
		int sum5 = customThreadPool.submit(
		    () -> listOfNumbers5.parallelStream().reduce(5, Integer::sum)).get();
		customThreadPool.shutdown();
		
		System.out.println("sum5 "+sum5);
		
		long seconds = System.currentTimeMillis();
		int sums = IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);
		System.out.println("sums "+sums);
		long diff = System.currentTimeMillis() - seconds;
		System.out.println("diff "+diff);
		seconds = System.currentTimeMillis();
		int sump = IntStream.rangeClosed(1, 100).parallel().reduce(0, Integer::sum);
		System.out.println("sump "+sump);
		diff = System.currentTimeMillis() - seconds;
		System.out.println("diff1 "+diff);
	}

}
