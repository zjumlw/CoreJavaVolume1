package chapter_05;

import java.util.Objects;

import chapter_05.Employee;

public class Manager extends Employee {
	private double bonus;
	
	//有参数构造函数
	public Manager(String name, double salary, int year, int month, int day){
		super(name, salary, year, month, day);
		bonus = 0;
	}
	
	//单参数构造函数
	public Manager(double salary){
		super(salary);
	}
	
	//设置奖金
	public void setBonus(double b){
		bonus = b;
	}
	
	public double getBonus(){
		return bonus;
	}
	
	//覆盖超类方法
	public double getSalary(){
		return super.getSalary()+bonus;
	}
	
	//覆盖equals、hashCode和toString方法
	public boolean equals(Object otherObject){
		if(!super.equals(otherObject))
			return false;
		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}
	
	public int hashCode(){
		return super.hashCode() + 17*new Double(bonus).hashCode();
	}
	
	public String toString(){
		return super.toString() + "[bonus=" + bonus + "]";
	}
	
	
	public static void main(String[] args){
		Manager boss = new Manager("Wang", 20000, 2016, 12, 22);
		boss.setBonus(1000);
		
		System.out.println(boss.toString());
		
		
		
		
	}
}
