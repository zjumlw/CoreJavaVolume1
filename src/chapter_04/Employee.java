package chapter_04;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
	private static int nextId;
	private int id;
	private String name;
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
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}
	public Employee(String name, double salary){
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(double salary){
		this("Employee #" + nextId, salary);
	}
	
	public Employee(){
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public LocalDate getHireDay(){
		return hireDay;
	}
	
	public int getId(){
		return id;
	}
	
	public void raiseSalary(double byPercent){
		salary = salary*(1 + byPercent/100);
	}
}
