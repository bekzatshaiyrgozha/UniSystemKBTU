package Researching;

import java.util.List;

import Users.User;

public class ResearchProject {
    String title;
    String description;
    Boolean isActive;
    List<User> participants;

    public ResearchProject(String title, String description, Boolean isActive, List<User> participants) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description + ", Active: " + isActive + ", Participants: " + participants;
    }
}