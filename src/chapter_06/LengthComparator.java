package chapter_06;

import java.util.Arrays;
import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
	public static void main(String[] args){
		String[] friends = {"Peter", "Paul", "Mike"};
		for(int i = 0; i < friends.length; i++)
			System.out.print(friends[i] + " ");
		System.out.println();
		Arrays.sort(friends, new LengthComparator());
		for(int i = 0; i < friends.length; i++)
		System.out.print(friends[i] + " ");
		System.out.println();
	}

}
