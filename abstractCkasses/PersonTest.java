package abstractCkasses;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] people = new Person[2];
		
		//fill the people array with Student and Employee objects
		people[0] = new Employee("Harray Hacker", 50000, 1989, 10, 1);
		people[1] = new Student("Maria Morris", "Computer Science");
		
		//print out names and descriptions of all Person objects
		for (Person person : people) {
			System.out.println(person.getName() + "," + person.getDescription());
		}
	}

}
