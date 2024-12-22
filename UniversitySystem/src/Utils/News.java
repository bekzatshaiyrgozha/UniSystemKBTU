package Utils;

import java.io.Serializable;

import Controllers.UserController;
import Users.User;

public class News implements Serializable{
	private static final long serialVersionUID = 1L; 
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Notify users about the news
    public void notifySubscribers() {
        for (User user : UserController.getAllUsers()) {
            user.receiveNews(this);  // Assuming `receiveNews()` method exists in User class
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content;
    }
}
