package chapter_08;


public class PairTest2 {

	public static void printBuddies(Pair<? extends Employee> p){
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
	}
	
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){
		if(a.length == 0) return;
		Manager min = a[0];
		Manager max = a[1];
		for(int i = 1; i < a.length; i++){
			if(min.getBonus() > a[i].getBonus()) min = a[i];
			if(max.getBonus() < a[i].getBonus()) max = a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	
	public static void maxminBonus(Manager[] a, Pair<? super Manager> result){
		minmaxBonus(a, result);
		PairAlg.swap(result);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee xiaoming = new Employee("xiaoming", 1000);
		Employee xiaohong = new Employee("xiaohong", 2000);
		Manager laowang = new Manager("laowang", 5000, 2017, 1, 7);
		Manager laomao = new Manager("laomao", 8000, 2017, 11, 11);
		Manager laolin = new Manager("laolin", 10000, 2016, 10, 8);
		laolin.setBonus(200);
		laomao.setBonus(800);
		laowang.setBonus(500);
		Manager[] managers = new Manager[]{laowang, laomao, laolin};
		Employee[] employees = new Employee[]{xiaoming, xiaohong};
		
		Pair<Manager> managerBuddies = new Pair<>(laowang, laomao);
		Pair<Employee> employeeBuddies = new Pair<>(xiaoming, xiaohong);
		
		Employee someone = laowang;
		
		Pair<? extends Employee> p = managerBuddies;
		printBuddies(p);
		
		System.out.println(laowang.getName() + " has salary " + laowang.getSalary() + ",hireday is " + laowang.getHireDay());

		minmaxBonus(managers, managerBuddies);
//		swapHelper(managerBuddies);
//		PairAlg.swap(managerBuddies);
		maxminBonus(managers, managerBuddies);
		
		System.out.println("min: " + managerBuddies.getFirst().getName()+ " has " + managerBuddies.getFirst().getBonus());
		System.out.println("max: " + managerBuddies.getSecond().getName()+ " has " +managerBuddies.getSecond().getBonus());

		minmaxBonus(managers, employeeBuddies);
		
		
	}

}
