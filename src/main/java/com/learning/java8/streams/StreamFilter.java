package com.learning.java8.streams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(41);
		list.add(15);
		
		List<Integer> output = list.stream().filter(i -> (i.toString().startsWith("1"))).collect(Collectors.toList());
		System.out.println(output);
		
		String str = "Mahipal Reddy";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) {
				int val = map.get(c);
				map.put(c, val+1);
			} else {
				map.put(c, 1);
			}
		}
		Set<Character> set = map.keySet();
		for(Character ch : set) {
			if(map.get(ch)>1) {
				System.out.println(map.get(ch)+" "+ch);
			}
		}
	}

}
