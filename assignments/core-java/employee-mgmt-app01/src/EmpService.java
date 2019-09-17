import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
	List<Employee> empList = new ArrayList<Employee>();
	public void getInput() {
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter the option: \n 1.add\n 2.view \n 3.update \n 4.delete \n 5.view all \n 10.exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					add();
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					update(x);
					break;
				case 4:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					delete(x);
					break;
				case 5:
					viewAll();
					break;
				case 10:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid entry please try again!!");
			}
			
			
		}while(choice!=10);
	}
	public void add() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id:");
		int nId=sc.nextInt();
		System.out.println("Enter Name:");
		String nName=sc.next();
		System.out.println("Enter Age:");
		int nAge=sc.nextInt();
		System.out.println("Enter Designation:");
		String nDesign=sc.next();
		System.out.println("Enter Department:");
		String nDept=sc.next();
		System.out.println("Enter Country:");
		String nCountry=sc.next();
		Employee newEmp = new Employee(nId, nName, nAge, nDesign, nDept, nCountry);
		empList.add(newEmp);
		
	}
	public void view(int x) {
		empList.forEach(e->{if(e.getId()==x) {
			System.out.println(e);
		}});
	}
	public void update(int x) {
		//List<Employee> tempEmpList = new ArrayList<Employee>();
		//empList.forEach(e->{
			//if(e.getId()!=x) {
				//tempEmpList.add(e);
			//}
			//else {
				//System.out.println(e);
			//}
		//});
		//empList=tempEmpList;
		//add();
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter Emp Id:");
		//int eid=sc.nextInt();
		empList.forEach(e->{
			if(e.getId()==x) {
				
				System.out.println("Enter Name:");
				String nName=sc.next();
				System.out.println("Enter Age:");
				int nAge=sc.nextInt();
				System.out.println("Enter Designation:");
				String nDesign=sc.next();
				System.out.println("Enter Department:");
				String nDept=sc.next();
				System.out.println("Enter Country:");
				String nCountry=sc.next();
				e.setName(nName);
				e.setAge(nAge);
				e.setDesign(nDesign);
				e.setDept(nDept);
				e.setCountry(nCountry);
				
			}
		});
	}
	public void delete(int x) {
		List<Employee> tempEmpList = new ArrayList<Employee>();
		empList.forEach(e->{
			if(e.getId()!=x) {
				tempEmpList.add(e);
			}
		});
		empList=tempEmpList;
	}
	public void viewAll() {
		empList.forEach(e->{
			System.out.println(e);
		});
	}
	
	

}
