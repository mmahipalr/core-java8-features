package com.learning.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learning.java.model.Score;

public class SortingUsingStream extends Object{

	static List<Score> scores = new ArrayList<Score>();
	
	public static List<Score> addScrore(Score score) {
		scores.add(score);
		Comparator<Score> sortByValue = (Comparator.comparing(Score::getScoreValue).reversed());
		Comparator<Score> sortByName = Comparator.comparing(Score::getName);
		scores = scores.stream().sorted(sortByValue.thenComparing(sortByName)).collect(Collectors.toList());
		return scores;
	}
	
	//&& (s1.getName().compareTo(s2.getName())<=1)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addScrore(new Score(1, "user1"));
		addScrore(new Score(2, "user2"));
		addScrore(new Score(2, "user1"));
		addScrore(new Score(3, "user15"));
		addScrore(new Score(1, "user15"));
		addScrore(new Score(4, "user10"));
		
		System.out.println(scores);
		
		Map<String, List<Score>> groupByAlphabet = scores.stream().collect(Collectors.groupingBy(e -> new String(e.getName())));
		
		System.out.println(groupByAlphabet.get("user1"));
		
		System.out.println(groupByAlphabet.keySet());
		
		Integer sumSal =  scores.stream().map(Score :: getScoreValue).reduce(0, Integer::max);
		
		System.out.println("user2");
		
		Predicate<Score> filterScoreVal = score -> score.getScoreValue()%2 == 0;
		
		List<Score> l = scores.stream().filter(filterScoreVal).collect(Collectors.toList());
		
		System.out.println(sumSal);
		
		System.out.println(l);
		
		System.out.println(scores.stream().map(score -> score.getScoreValue()*2).filter(score -> score > 6).collect(Collectors.toList()));
		
		System.out.println(scores.stream().toArray(Score[]::new));
		
		System.out.println(scores.parallelStream().toArray(Score[]::new));
		
		System.out.println("groupByInt");
		
		Comparator<Score> byVal = Comparator.comparing(Score::getName);
		
		Map<Integer, Optional<Score>> groupByInt = scores.stream().collect(Collectors.groupingBy(e -> e.getScoreValue(),  Collectors.reducing(BinaryOperator.maxBy(byVal))));
		
		System.out.println(groupByInt);
		
		Comparator<Score> byVal1 = Comparator.comparing(Score::getScoreValue);
		
		Map<Integer, Optional<Score>> groupByIntVal = scores.stream().collect(Collectors.groupingBy(e -> e.getScoreValue(),  Collectors.reducing(BinaryOperator.maxBy(byVal1))));
				
		System.out.println(groupByIntVal);
				
	}

}
