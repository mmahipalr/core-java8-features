package com.learning.java.model;

import java.util.Optional;

public class DisplayFeatures {

	private String size; // In inches
	private Optional<ScreenResolution> resolution;
	
	public DisplayFeatures(String size, Optional<ScreenResolution> optional){
		this.size = size;
		this.resolution = optional;
	}
	
	public String getSize() {
		return size;
	}
	public Optional<ScreenResolution> getResolution() {
		return resolution;
	}
	
}
