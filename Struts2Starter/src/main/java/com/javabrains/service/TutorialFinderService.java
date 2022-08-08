package com.javabrains.service;

public class TutorialFinderService {

	public String getBestTutorialSite(String lang) {
		if(lang.equalsIgnoreCase("java")) {
			return "Java Brains";
		}else {
			return "Language not supported yet"; 
		}
		
	}
}
