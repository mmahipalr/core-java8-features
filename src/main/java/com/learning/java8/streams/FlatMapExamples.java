package com.learning.java8.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(5);
		list1.add(6);
		List<List<Integer>> listInteger = new ArrayList<List<Integer>>();
		listInteger.add(list);
		listInteger.add(list1);
		
		System.out.println(listInteger.stream().map(Collection :: stream).collect(Collectors.toList()));
		
		System.out.println(list1.stream().reduce(Integer::sum).get());
		
		System.out.println(listInteger.stream().map(t -> (t.stream().mapToInt(i -> i).sum())>10).collect(Collectors.toList()));
		
		System.out.println(listInteger.stream().map(t -> (t.stream().reduce(Integer::sum).get())).collect(Collectors.toList()));
		
		System.out.println(listInteger.stream().filter(t -> (t.stream().mapToInt(i -> i).sum())>10).collect(Collectors.toList()));
		
		System.out.println(listInteger.stream().flatMap(Collection :: stream).collect(Collectors.toList()));
		
		IntStream ints =  listInteger.stream().flatMapToInt(list2 ->(list2.stream().mapToInt(i -> i)));
		
		IntSummaryStatistics intSummaryStatistics = ints.peek(System.out::println).summaryStatistics();
		System.out.println(intSummaryStatistics);
		
		System.out.println(listInteger.stream().flatMap(Collection :: stream).flatMapToInt(i -> IntStream.of(i)).summaryStatistics());
		
		System.out.println(listInteger.stream().flatMap(Collection :: stream).filter(i-> i>2).collect(Collectors.toList()));
		
		
	}

}
