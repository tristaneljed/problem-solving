import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class CompanyHierarchy {

	private static Map<String, Employee> allEmployees;
	private static Employee ceo = null;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		allEmployees = new HashMap<>();
		
		ceo = null;
		for (int i=0; i<n-1; i++) {
			if (i == 0) {
				ceo = getObject(s.next());
				Employee emp = getObject(s.next());
				ceo.setFirstResource(emp);
				emp.setManager(ceo);
			} else {
				Employee manager = getObject(s.next());
				Employee resource = getObject(s.next());
				manager.setResource(resource);
				resource.setManager(manager);
			}
		}
		printHierarchy();
		s.close();
	}
	
	private static void printHierarchy() {
		Queue<Employee> queue = new LinkedList<>();
		queue.add(ceo);
		while (!queue.isEmpty()) {
			Queue<Employee> q = new LinkedList<>();
			while (!queue.isEmpty()) {
				Employee emp = queue.remove();
				System.out.print(emp.name + " ");
				if (emp.getNumOfResource() == 1) {
					q.add(emp.getFirstResource());
				} else if (emp.getNumOfResource() == 2) {
					q.add(emp.getFirstResource());
					q.add(emp.getSecondResource());
				}
			}
			while (!q.isEmpty()) {
				queue.add(q.remove());
			}
			System.out.println();
		}
	}

	private static Employee getObject(String name) {
		if (allEmployees.containsKey(name)) {
			return allEmployees.get(name);
		} else {
			Employee emp = new Employee();
			emp.setName(name);
			allEmployees.put(name, emp);
			return emp;
		}
	}
	
	static class Employee {
		private Employee manager = null;;
		private Employee firstResource = null;
		private Employee secondResource = null;
		private String name;
		private int numOfResource = 0;
		
		public Employee getManager() {
			return manager;
		}
		public void setManager(Employee manager) {
			this.manager = manager;
		}
		public Employee getFirstResource() {
			return firstResource;
		}
		private void setFirstResource(Employee firstResource) {
			setNumOfResource(1);
			this.firstResource = firstResource;
		}
		public Employee getSecondResource() {
			return secondResource;
		}
		private void setSecondResource(Employee secondResource) {
			setNumOfResource(2);
			this.secondResource = secondResource;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getNumOfResource() {
			return numOfResource;
		}
		private void setNumOfResource(int numOfResource) {
			this.numOfResource = numOfResource;
		}
		
		public void setResource(Employee resource) {
			if (numOfResource == 0) {
				setFirstResource(resource);
			} else {
				setSecondResource(resource);
			}
		}
		
	}

}
