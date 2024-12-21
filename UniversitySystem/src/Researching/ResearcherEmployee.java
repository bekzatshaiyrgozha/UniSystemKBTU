package Researching;
import Researching.* ;

import java.util.Comparator;
import java.util.List;

public class ResearcherEmployee implements Researcher{
	List<ResearchPaper> researchPapers;
    List<ResearchProject> researchProjects;

    public ResearcherEmployee(List<ResearchPaper> researchPapers, List<ResearchProject> researchProjects) {
        this.researchPapers = researchPapers;
        this.researchProjects = researchProjects;
    }

    @Override
    public void addResearcherProject(ResearchProject project) {
        researchProjects.add(project);
    }

    @Override
    public void addResearcherPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }

    @Override
    public int calculateHindex() {
        return 0;
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.sort(comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper);
        }
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }
}
