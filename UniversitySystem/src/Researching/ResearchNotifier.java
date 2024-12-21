package Researching;

import java.util.List;

import Users.User;

public class ResearchNotifier {
    List<ResearchPaper> papers;
    List<User> subscribers;

    public ResearchNotifier(List<ResearchPaper> papers, List<User> subscribers) {
        this.papers = papers;
        this.subscribers = subscribers;
    }

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void notifySubscribers(ResearchPaper paper) {
        for (User user : subscribers) {
            System.out.println("Notifying " + paper.toString() + " to " + user.toString());
        }
    }

    public List<ResearchPaper> getAllResearchPapers() {
        return papers;
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }
}
