package Researching;

import java.util.Date;

import Users.User;

public class ResearchPaper {
	String title ; 
	User author ; 
	String journal ; 
	int pages ; 
	Date publicDate ;
	
	public ResearchPaper(String title, User author ,String journal, int pages , Date publicDate) {
		this.title = title ; 
		this.author = author; 
		this.journal = journal;  
		this.pages = pages ; 
		this.publicDate = publicDate ; 
	}
	public String getCitation(java.text.Format format) {
		return format.format(publicDate) ;
	}
	@Override 
	public String toString() {
		return "Title : " + title + ", author : " + author + " , journal : " + journal + " , pages : " + pages ; 
	}
}
