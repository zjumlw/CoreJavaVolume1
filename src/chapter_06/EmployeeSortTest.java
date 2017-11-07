package chapter_06;

import java.util.Arrays;

import chapter_06.Employee;

public class EmployeeSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry", 35000);
		staff[1] = new Employee("Carl", 25000);
		staff[2] = new Employee("Toby", 57000);
		Arrays.sort(staff);
		for(Employee e:staff)
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
	}

}
