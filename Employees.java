package CollectionAssignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Employees {
	
	public enum Dep { 
		IT, Operations, Sales
	}  
	
	private static Employees e = new Employees();
	private Map<Integer, List<String>> employee;
	
	public static void main(String args[]) {
/*		System.out.print("Please enter an employee ID");
		Scanner sc=new Scanner(System.in);
		int empID = sc.nextInt();
		System.out.print("Please enter Name:");
		String name = sc.next();
		System.out.print("Please enter Department: \n");
		String dep = sc.next();
		e.addEmp(empID, name, dep);
		System.out.print("Please enter the department you do not want included in the total employee search
		dep = sc.next();
		System.out.print("Searching for all employees that are not in" + dep + "\n");
		e.empTotal(dep);		
		*/
		e.addEmp(10000, "John Doe", "IT");
		e.addEmp(12000, "Jane Doe", "Sales");
		e.addEmp(13000, "Jane Doe", "IT");
		e.addEmp(14000, "Hello Kitty", "Operations");
		
		System.out.print("Searching for all employees that are not in" + " Sales \n");
		System.out.print(e.depFilter("Sales") + "\n");
	}
	
	public Employees() {
		employee = new HashMap<Integer, List<String>>();
	}
	
	
	public void addEmp(int empID, String name, String department) {
		if(this.departmentCheck(department)) {
			List<String> val = new ArrayList<String>();
	        val.add(name);
	        val.add(department);
			employee.put(empID, val);
		}
		else {
			System.out.print("Department Does Not Exist");
			System.exit(1);
		}
			
	}
	
	private boolean departmentCheck (String Department) {
		for (Dep d : Dep.values()) {
			if (d.name().equals(Department)) {
				return true;
			}
		}
		return false;
	}
	
	private Map<Integer, List<String>> empShow(String dep) {
		Map<Integer, List<String>> filteredEmp = new HashMap<Integer, List<String>>();
		for(Integer key: employee.keySet()){
			if(employee.get(key).get(1) == dep) {
				filteredEmp.put(key, employee.get(key));
			}
		}
		return filteredEmp;
	}
	
	private Map<Integer, List<String>> depFilter(String notIn) {
		int count =0;
		Map<Integer, List<String>> filteredEmp = new HashMap<Integer, List<String>>();
		for(Integer key: employee.keySet()){
			if(employee.get(key).get(1) != notIn) {
				filteredEmp.put(key, employee.get(key));
				count++;
			}
		}
		System.out.printf("Total Employees are: %d \n", count);
		return filteredEmp;

	}
}

