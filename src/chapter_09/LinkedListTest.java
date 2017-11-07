package chapter_09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new LinkedList<>();
		a.add("Mao");
		a.add("Ling");
		a.add("Wei");
		
		List<String> b = new LinkedList<>();
		b.add("xiao");
		b.add("yang");
		b.add("yan");
		b.add("bao");
//		System.out.println(a);
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext()){
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		bIter = b.iterator();
		while(bIter.hasNext()){
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}
	

}
