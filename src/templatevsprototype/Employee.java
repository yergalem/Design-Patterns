package templatevsprototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
/**
 *  Makes deep copy of an instance through the Serializable interface. Shallow copy fails to clone references with
 *  in a class or that belong to object where as the Serializable interface makes deep copy possible if
 *  all references implement Serializable.
 * 
 * @author Yergalem
 *
 */
interface IPrototype {

	public Employee doClone();
}

public class Employee implements IPrototype, Cloneable, Serializable {

		private int id;
		private String Lastname;		
		private Employee supervisor;
		private Employee staff[];
		

	public Employee() {

	}	

	public Employee(  String name) {
       this.Lastname  = name;
	}

	@Override
	public Employee doClone() {
		Employee obj = null;

		try {

			obj = (Employee) super.clone();

		} catch (CloneNotSupportedException ex) {

			System.out.println("Cloning failure");
			return null;
		}

		return obj;
	}

	public Employee doDeepClone() {
		Employee obj = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream obos = new ObjectOutputStream(baos);

			obos.writeObject(this);

			ByteArrayInputStream bios = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bios);

			obj = (Employee) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public Employee[] getStaff() {
		return staff;
	}

	public void setStaff(Employee[] staff) {
		this.staff = staff;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Lastname=" + Lastname + ", supervisor=" + supervisor + ", staff="
				+ Arrays.toString(staff) + "]";
	}

	public static void main(String[] args) {

		Employee emp = new Employee();

		System.out.println(" Before");
		emp.id = 19;
		emp.Lastname = "Yergalem";
		emp.setSupervisor( new Employee("Prof- John")); 
		emp.setStaff(new Employee[]{ new Employee("Frank"), new Employee("Samson")});

		System.out.println(emp);
		Employee empShallow = emp.doClone();
		Employee empDp = emp.doDeepClone();
		emp.id = 24;
		emp.Lastname = "Rihanna";
		emp.setSupervisor( new Employee("Prof- Fredrick")); 
		emp.setStaff(new Employee[]{ new Employee("William"), new Employee("Alexander")});
		
		System.out.println(" After Shallow");

		System.out.println(empShallow);

		System.out.println(" After Deep");

		System.out.println(empDp);
		System.out.println("After Change");
		System.out.println(emp);

	}

}

