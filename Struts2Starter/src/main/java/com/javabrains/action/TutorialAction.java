package com.javabrains.action;

import com.javabrains.service.TutorialFinderService;

public class TutorialAction{

	TutorialFinderService tutorialFinderService;
	private String bestTutorialSite;
	private String language;
	/*
	 * return type String is to specify the code to inform
	 * struts.xml to which jsp to be rendered
	 */
	public String execute(){
		tutorialFinderService = new TutorialFinderService();
		System.out.println("Hello from execute");
		setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));
//		System.out.println(bestTutorialSite);
		System.out.println(getLanguage());
		return "success";
	}

	public String vamsiExecute() {
		System.out.println("User Defined execute() method");
		return "success";
	}
	
	public String addTutorial() {
		System.out.println("Tutorial Added");
		return "success";
	}
	
	public String getBestTutorialSite() {
		return bestTutorialSite;
	}
	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
