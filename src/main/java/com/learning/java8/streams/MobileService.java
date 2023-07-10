package com.learning.java8.streams;

import java.util.Optional;

import com.learning.java.model.DisplayFeatures;
import com.learning.java.model.Mobile;
import com.learning.java.model.ScreenResolution;

public class MobileService {
	public Integer getMobileScreenWidth(Optional<Mobile> mobile){
//		return mobile.flatMap(Mobile::getDisplayFeatures)
//			 .flatMap(DisplayFeatures::getResolution)
//			 .map(ScreenResolution::getWidth)
//			 .orElse(0);

//		return mobile.map(mob -> mob.getDisplayFeatures().map(fet -> fet.getResolution().map(res -> res.getWidth()).get()).orElse(0)).orElse(0);
		
		return mobile.flatMap(mob -> mob.getDisplayFeatures().flatMap(fet -> fet.getResolution().map(res -> res.getWidth()))).orElse(0);
	  }

}