package Users;

public class Admin extends Employee{
	private static Admin instance ; 
	private static final String admin_username = "a_admin" ;
	private static final String admin_password = "admin"; 
	private Admin() {
		super(admin_username , admin_password); 
	}
	public static Admin getInstance() {
		if(instance == null) {
			instance = new Admin(); 
		}
		return instance ; 
	}
	public Admin(String username, String password) {
		super(username, password);
	}
	
}
