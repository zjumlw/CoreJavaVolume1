package chapter_05;

public class Student extends Person {
	private String major;
	
	public Student(String name, String major){
		super(name);
		this.major = major;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a student majoring in " + major;
	}
	
	public static void main(String[] args){
		Student st = new Student("Z", "English");
		
		
	}

}
