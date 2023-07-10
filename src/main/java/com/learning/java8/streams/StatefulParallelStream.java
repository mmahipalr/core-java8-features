package com.learning.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StatefulParallelStream {

	public static <U> void main(String[] args) {

		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		 
		Stream<Integer> stream = ss.parallelStream();
		 
		stream.map(s -> {
		     //   synchronized (result) {
		          if (result.size() < 10) {
		            result.add(s);
		          }
		   //     }
				return s;
		    }).forEach( e -> {});
		 System.out.println(result+"  "+result.size()); 
		 
		 Stream<Integer> stream1 = ss.stream().map( s -> s).limit(3);
		 
		 System.out.println(stream1.limit(3));
		 
		 int val =  ss.stream().mapToInt(new ToIntFunction<Integer>() {

			@Override
			public int applyAsInt(Integer value) {
				// TODO Auto-generated method stub
				return value;
			}
			 
		 }).sum();
		 
		 System.out.println(val);
		// val.forEach(n -> System.out.println(n));
		 
		 List<Integer> lengths = new ArrayList<>();
		 
		 IntStream ival =  ss.stream().mapToInt(new ToIntFunction<Integer>() {

				@Override
				public int applyAsInt(Integer value) {
					// TODO Auto-generated method stub
					return value;
				}
				 
			 });
		 
		 ival.forEach(lengths::add);
		 lengths.forEach(n -> System.out.println(n));
		 
		 int ival1 =  ss.stream().reduce(0, (sum ,b) -> sum+b
			 , Integer::sum);
		 System.out.println(ival1+" ival1");
	}
}
