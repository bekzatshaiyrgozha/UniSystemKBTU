package Researching;
import Researching.* ; 
import java.util.Comparator;
import java.util.List;

public class ResearcherStudent implements Researcher {
    public List<ResearchPaper> researchPapers;
    public List<ResearchProject> researchProjects;

    public ResearcherStudent(List<ResearchPaper> researchPapers, List<ResearchProject> researchProjects) {
        this.researchPapers = researchPapers;
        this.researchProjects = researchProjects;
    }
    
    public void addResearcherPaper(ResearchPaper paper) {
    	researchPapers.add(paper); 
    }
    public List<ResearchPaper> getResearchPapers() {
    	return researchPapers ; 
    }
    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }
    @Override
    public int calculateHindex() {
        return 0;
    }

	@Override
	public void printPapers(Comparator<ResearchPaper> comparator) {
		// TODO Auto-generated method stub
		System.out.println("Res"); 
	}

	@Override
	public void addResearcherProject(ResearchProject project) {
		// TODO Auto-generated method stub
		researchProjects.add(project); 
		
	}
}