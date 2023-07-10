package com.learning.java8.streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GridSearch {

	public static boolean checkWhole(List<String> G, List<String> P, int i, int j){
		AtomicInteger k = new AtomicInteger(i);
		return IntStream.range(0, P.size()).allMatch( q -> {
			if(G.get(k.get()).substring(j,j+P.get(0).length()) .equals(P.get(q))) {
				k.incrementAndGet();
				return true;
			} else {
				k.incrementAndGet();
				return false;
			}
		});
		
    }
	
	public static String gridSearch(List<String> G, List<String> P) {
		int L=G.size(),l=P.size(),W=G.get(0).length(),w=P.get(0).length();

		IntFunction<Integer> intFunction = (i -> {
			boolean flag = IntStream.range(0, W-w).anyMatch( j -> G.get(i).substring(j, j+w).equals(P.get(0)) && checkWhole(G,P,i,j));
			
			return flag ? 1 : 0;
		});
      
      return IntStream.range(0, L-l).mapToObj(intFunction).anyMatch(flag -> flag == 1) ? "YES" : "NO";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> g = Stream.of("400453592126560","114213133098692","474386082879648","522356951189169","887109450487496","252802633388782","502771484966748","075975207693780","511799789562806","404007454272504","549043809916080","962410809534811","445893523733475","768705303214174","650629270887160").collect(Collectors.toList());
//		List<String> p = Stream.of("99","99").collect(Collectors.toList());
		
		List<String> g = Stream.of("1234567890","0987654321","1111111111","1111111111","2222222222").collect(Collectors.toList());
		List<String> p = Stream.of("876543","111111","111111").collect(Collectors.toList());
		
		System.out.println(gridSearch(g, p));
		
		System.out.println("0987654321".indexOf("876543", 1));
	}
}
