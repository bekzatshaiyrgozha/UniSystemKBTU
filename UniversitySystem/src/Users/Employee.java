package Users;


public abstract class Employee extends User {
	protected static boolean salaryPaid;
	public Employee(String username, String password,boolean salaryPaid) {
		super(username, password);
		
		this.salaryPaid = false;
	}
	public static boolean isSalaryPaid() {
		return salaryPaid;
	}
	public static void  setSalaryPaid() {
		
		salaryPaid = true;
	}
	public static void resetSalaryPaid() {
		salaryPaid = false;
	}

}