package abstractCkasses;


public class Student extends Person{
	private String major;
	
	/**
	 * 
	 * @param name the student's name
	 * @param major the student's major
	 */
	public Student(String name,String major) {
		//pass n to superclass constructor
		super(name);
		// TODO Auto-generated constructor stub
		this.major = major;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a student majoring in " + major;
	}

}
