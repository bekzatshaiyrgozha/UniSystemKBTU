package Researching;

import java.util.Comparator;
import java.util.List;

public interface Researcher {
	 void addResearcherPaper(ResearchPaper paper);
	    void addResearcherProject(ResearchProject project);
	    int calculateHindex();
	    List<ResearchPaper> getResearchPapers();
	    List<ResearchProject> getResearchProjects();
	    void printPapers(Comparator<ResearchPaper> comparator);
}
