package chapter_09;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet<Item> parts = new TreeSet<>();	//默认排序方法，按照编号排序
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Moden", 9912));
		System.out.println(parts);
		
		NavigableSet<Item> sortByDescription = new TreeSet<>(
				Comparator.comparing(Item::getDescription));	//按照描述信息排序
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}

}
