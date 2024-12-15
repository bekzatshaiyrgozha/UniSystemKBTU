package DLL;
import java.io.File;
import java.util.*; 
import Users.*; 
public class DBContext {
	
	private static String fullPath = "C:\\Users\\Asus\\Desktop\\UniSystemKBTU\\UniversitySystem\\src\\Data\\" ; 
	private static DBContext db = new DBContext();
	
	public static Vector<Teacher> teacher;
	public static Vector<Student> student ;
	public static Vector<Manager> manager; 
	{
		this.teacher = getTeachers();
		this.student = getStudents() ; 
		this.manager = getManagers() ; 
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

	    Object o = ReaderWriter.deserialize(filePath);

	    if (o instanceof Vector) {
	        return (Vector<Teacher>) o;
	    }
	    return new Vector<>();
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
	
}
