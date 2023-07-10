package com.learning.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceLaneEx {

	public static List<Integer> serviceLane(int n, List<List<Integer>> cases, List<Integer> width) {
	    // Write your code here	
		
		Function<List<Integer>, List<Integer>> indexList = (caseList) -> {
			List<Integer> subList = width.subList(caseList.get(0), caseList.get(1)+1);
			return subList;
		};		
		
//		Function<List<Integer>, Integer> subList = (caseList) -> {
//			Integer min = caseList.stream().min(Integer::compare).get();
//			return min;
//		};	
		
		ToIntFunction<List<Integer>> intFunction = (caseList) -> {
			return caseList.stream().min(Integer::compare).get();
		};
		
//		List<Integer> list = cases.stream().map(indexList).map(subList).collect(Collectors.toList());
		
		
		List<Integer> list1 = cases.stream().map(indexList).mapToInt(intFunction).boxed().collect(Collectors.toList());
//		
//		OptionalInt i =  cases.stream().map(indexList).mapToInt(intFunction).max();
		
		System.out.println(list1);
//		System.out.println(list);
				
		return list1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		
		List<Integer> width = Stream.of(2, 3, 1, 2, 3, 2, 3, 3).collect(Collectors.toList()); 
		List<Integer> caseArr =  Stream.of(0, 3).collect(Collectors.toList());
		List<List<Integer>> cases = new ArrayList<List<Integer>>();
		cases.add(caseArr);
		caseArr = Stream.of(4, 6).collect(Collectors.toList());
		cases.add(caseArr);
		caseArr = Stream.of(6, 7).collect(Collectors.toList());
		cases.add(caseArr);
		caseArr = Stream.of(3, 5).collect(Collectors.toList());
		cases.add(caseArr);
		caseArr = Stream.of(0, 7).collect(Collectors.toList());
		cases.add(caseArr);
		
		List<Integer> result = ServiceLaneEx.serviceLane(n, cases, width);
		
	}

}
