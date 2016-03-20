
public class Student {
	private String name;
	private int rollNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "[ name : " + getName() +
				" , roll-number: " + getRollNo() +
				" ]";
	}
	
	
	public int hashCode() {
		return getRollNo();
	}
	
	@Override
	public boolean equals(Object stud) {
		Student s = (Student) stud;
		return (this.getRollNo() == s.getRollNo());
	}
	
	public static void main(String[] args) {
		Student stud1 = new Student();
		stud1.setName("Himanshu");
		stud1.setRollNo(123);
		
		Student stud2 = new Student();
		stud2.setName("Himanshu");
		stud2.setRollNo(123);
		
		stud1.hashCode();
		stud1.equals(stud2);
		if (stud1.equals(stud2)) {
			System.out.println("Same objects lah!!");
		} else {
			System.out.println("Different objects");
		}
	}
	
}
