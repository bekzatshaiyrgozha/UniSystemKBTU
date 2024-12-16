package Controllers;

import DLL.DBContext;
import Utils.News;

public class ManagerController {
	public static void createNews(String title , String content) {
		News news = new News(title , content); 
		DBContext.addNews(news);
	}

	public static boolean createNews(News news) {
		DBContext.addNews(news);
		return true; 
	}
}
