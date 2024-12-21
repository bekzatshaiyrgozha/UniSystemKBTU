package Researching;
import java.util.* ; 
import Researching.*; 
public class ResearchDecorator implements Researcher{
	private final Researcher delegate;

    public ResearchDecorator(Researcher delegate) {
        this.delegate = delegate;
    }

    @Override
    public int calculateHindex() {
        return delegate.calculateHindex();
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return delegate.getResearchPapers();
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return delegate.getResearchProjects();
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        delegate.printPapers(comparator);
    }

    @Override
    public void addResearcherPaper(ResearchPaper paper) {
        delegate.addResearcherPaper(paper);
    }

    @Override
    public void addResearcherProject(ResearchProject project) {
        delegate.addResearcherProject(project);
    }
}
