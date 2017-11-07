package chapter_06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Employee extends Person implements Comparable<Employee>{
	private static int nextId;
	private int id;
	private double salary;
	private LocalDate hireDay;
	
	static{
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	
	{
		id = nextId;
		nextId++;
	}
	
	//有参数构造函数
	public Employee(String name, double salary, int year, int month, int day){
		super(name);
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}
	public Employee(String name, double salary){
		super(name);
		this.salary = salary;
	}
	
	public Employee(double salary){
		this("Employee #" + nextId, salary);
	}
	
	//get方法
	public double getSalary(){
		return salary;
	}
	
	public LocalDate getHireDay(){
		return hireDay;
	}
	
	public int getId(){
		return id;
	}
	//加薪水方法
	public void raiseSalary(double byPercent){
		salary = salary*(1 + byPercent/100);
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return String.format("an employee with a salary of $%.2f", salary);
	}
	//覆盖equals hashCode toString方法
	public boolean equals(Object otherObject){
		if(this == otherObject)
			return true;
		if(otherObject == null)
			return false;
		if(getClass() != otherObject.getClass())
			return false;
		
		Employee other = (Employee) otherObject;
		
		return Objects.equals(name, other.name)
				&&salary == other.salary
				&&Objects.equals(hireDay, other.hireDay);
	}
	
	public int hashCode(){
		return Objects.hash(name, salary, hireDay);
	}
	
	public String toString(){
		return getClass().getName() + "[Id=" + id + 
				",name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}
	
	public static void main(String[] args){
		Employee em = new Employee("Wang", 30000, 2017, 1, 22);
		Employee em2 = new Employee("Mao", 20000,2017, 10, 21);
		ArrayList<Employee> emList = new ArrayList<>(100);
		System.out.println("emList.size() = " + emList.size());
		emList.add(em);
		emList.add(em2);
		System.out.println(emList);
		System.out.println("emList.size() = " + emList.size());
		
		
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return Double.compare(salary, o.salary);
	}
}