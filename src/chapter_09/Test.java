package chapter_09;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args){
		LinkedList<String> staff = new LinkedList<String>();
		staff.add("Mao");
		staff.add("Ling");
		staff.add("Wei");
		ListIterator listIterator = staff.listIterator();
		listIterator.add("Lao");
		while(listIterator.hasNext()){
			if(listIterator.next() == "Wei"){
				listIterator.add("Yang");
				listIterator.add("Yan");
			}
		}
		
		LinkedList<String> subStaff = new LinkedList<String>();
		subStaff.add("Mao");
		subStaff.add("Ling");
		subStaff.add("wei");
		
		System.out.println(staff);
		System.out.println(staff.contains("Mao"));
		System.out.println(staff.containsAll(subStaff));
		
	}
}
