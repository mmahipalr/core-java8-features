package com.learning.java8.streams;

import java.util.Optional;

import com.learning.java.model.DisplayFeatures;
import com.learning.java.model.Mobile;
import com.learning.java.model.ScreenResolution;

public class MobileTesterWithOptional {
	
  public static void main(String[] args) {
	ScreenResolution resolution = new ScreenResolution(750,1334);
	DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
	Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
		
	MobileService mService = new MobileService();
		
	// Optional<Object> width = mService.getMobileScreenWidth(Optional.of(mobile));
	 Integer width = mService.getMobileScreenWidth(Optional.of(mobile));
	
	System.out.println("Apple iPhone 6s Screen Width = " + width);

	Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());		
	//Optional<Object> width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
	Integer width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
	System.out.println("Apple iPhone 16s Screen Width = " + width2);
  }
}