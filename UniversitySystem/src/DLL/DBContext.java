package DLL;
import java.io.File;
import java.util.*; 
import Users.*;
import Utils.News; 
public class DBContext {
	
	private static String fullPath = "C:\\Users\\Asus\\Desktop\\UniSystemKBTU\\UniversitySystem\\src\\Data\\" ; 
	private static DBContext db = new DBContext();
	
	public static Vector<Teacher> teacher;
	public static Vector<Student> student ;
	public static Vector<Manager> manager; 
	public static Vector<News> newsList ; 
	{
		this.teacher = getTeachers();
		this.student = getStudents() ; 
		this.manager = getManagers() ; 
		this.newsList = getNews(); 
	}
	
	private DBContext() {
		
	}
	
	// ...
	public static Vector<Student> getStudents(){
		String filePath = fullPath + "students.txt" ; 
		File file = new File(filePath) ; 
		
		if(!file.exists() || file.length() == 0) {
			System.out.println("File is empty or does not exist , returning an empty list."); 
			return new Vector<>() ;
		}
		Object o = ReaderWriter.deserialize(filePath); 
		if(o instanceof Vector) {
			return (Vector<Student>) o ; 
		}
		return new Vector<>() ; 
	}
	public static Vector<Teacher> getTeachers() {
	    String filePath = fullPath + "teachers.txt";
	    File file = new File(filePath);

	    // check file is empty or no >> ; 
	    if (!file.exists() || file.length() == 0) {
	        System.out.println("File is empty or does not exist, returning an empty list.");
	        return new Vector<>();
	    }
	    else {

	    Object o = ReaderWriter.deserialize(filePath);

	    if (o instanceof Vector) {
	        return (Vector<Teacher>) o;
	    }
	    return new Vector<>();
	    }
	}
	public static Vector<Manager> getManagers(){
		String filePath = fullPath + "manager.txt"; 
		File file = new File(filePath) ;
		if (!file.exists() || file.length() == 0) {
	        System.out.println("File is empty or does not exist, returning an empty list.");
	        return new Vector<>();
	    }

	    Object o = ReaderWriter.deserialize(filePath);

	    if (o instanceof Vector) {
	        return (Vector<Manager>) o;
	    }
	    return new Vector<>();
	}
	public static Vector<News> getNews() {
        String filePath = fullPath + "news.txt";
        File file = new File(filePath);

        if (!file.exists() || file.length() == 0) {
            System.out.println("File is empty or does not exist, returning an empty list.");
            return new Vector<>();
        }
        Object o = ReaderWriter.deserialize(filePath);
        if (o instanceof Vector) {
            return (Vector<News>) o;
        }
        return new Vector<>();
    }
	public static boolean saveTeachers() {
		return ReaderWriter.serialize(teacher, fullPath + "teachers.txt");
	}
	public static boolean saveStudents() {
		return ReaderWriter.serialize(student, fullPath + "students.txt"); 
	}
	public static boolean saveManagers() {
		return ReaderWriter.serialize(manager, fullPath + "manager.txt"); 
	}
	public static DBContext getDb() {
		return db;
	}
	public static boolean saveNews() {
		return ReaderWriter.serialize(newsList, fullPath+ "news.txt"); 
	}
	public static void addNews(News news) {
		newsList.add(news); 
		saveNews(); 
	}
	public static Vector<User> getAllUsers(){
		Vector<User> allUsers = new Vector<>(); 
		allUsers.addAll(teacher) ;
		allUsers.addAll(student); 
		allUsers.addAll(manager);
		return allUsers; 
	}
}
