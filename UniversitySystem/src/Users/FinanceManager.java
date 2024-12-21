package Users;


public class FinanceManager extends Employee{
	private static FinanceManager instance ;
	private static boolean salaryPaid; 
	private static final String financeManager_username = "f_manager" ;
	private static final String financeManager_password = "manager"; 
	private FinanceManager() {
		super(financeManager_username , financeManager_password, salaryPaid); 
	}
	public static FinanceManager getInstance() {
		if(instance == null) {
			instance = new FinanceManager(); 
		}
		return instance ; 
	}
	public FinanceManager(String username, String password,boolean salaryPaid) {
		super(username, password, salaryPaid);
	}
	
}