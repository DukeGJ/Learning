package Employee;

import java.time.LocalDate;

/**
 * This program tests the Employee class
 * @version 1.12 2017-09-20
 * @author GJ
 */
public class EmployeeTest {
	
	public static void main(String[] args) {
		//fill the4 staff aray with three Employee objects
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Craker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 5000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 4000, 1990, 3, 15);
		
		//raise everyone's salary by 5%
		for (Employee employee : staff) {
			employee.raiseSalary(5);
		}
		//print out information about all Employee objects
		for (Employee employee : staff) {
			System.out.println("name=" + employee.getName()
				+ ",salary=" + employee.getSalary()
				+ ",hireDay=" + employee.getHireDay());
		}
	}
}
class Employee {
	//instance fields
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	//constructor
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}
	
	//a nethod
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary*byPercent / 100;
		salary+=raise;
	}
}