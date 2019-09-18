import java.io.*;
public class EmployeeException extends Exception {
	public String employeeNotFound(int eid) {
		if(empList.indexOf(eid)==-1)
			return "Employee Id not found";
		
		};
}
	
