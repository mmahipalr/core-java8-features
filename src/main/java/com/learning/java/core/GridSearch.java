package com.learning.java.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GridSearch {
	
	public static boolean checkWhole(List<String> G, List<String> P, int i, int j){
        for(int q=0 ; q<P.size() ; q++,i++ ){
            if(  G.get(i).substring(j,j+P.get(0).length()) .equals(P.get(q))) continue;
            else return false;
        }
        return true; 
    }
    
    public static String gridSearch(List<String> G, List<String> P) {
        int L=G.size(),l=P.size(),W=G.get(0).length(),w=P.get(0).length();
        for(int i=0;i<=L-l;i++){
            for(int j=0;j<=W-w;j++){
                if(G.get(i).substring(j, j+w).equals(P.get(0)) && checkWhole(G,P,i,j)) return "YES";
            }
        }
        return "NO";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> g = Stream.of("1234567890","0987654321","1111111111","1111111111","2222222222").collect(Collectors.toList());
		List<String> p = Stream.of("876543","111111","111111").collect(Collectors.toList());
		System.out.println(gridSearch(g, p));
		
		System.out.println("0987654321".indexOf("876543", 2));
	}

}
