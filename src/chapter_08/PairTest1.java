package chapter_08;

import java.time.LocalDate;

public class PairTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"Mary", "had", "a", "little", "lamb"};
		Pair<String> mm = ArrayAlg.minmax(words);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());
		double middle = ArrayAlg.getMiddle(2.11, 33.0, 54.1);
		System.out.println(middle);
		
		Integer[] numbers = {10, 3, 54, 323, 9909, 7687, 876, -234};
		Integer minNumber = ArrayAlg.min(numbers);
		System.out.println("Min number is " + minNumber);
		
		LocalDate[] birthdays = {
				LocalDate.of(1906, 12, 9),
				LocalDate.of(1815, 12, 10),
				LocalDate.of(1903, 12, 3),
				LocalDate.of(1910, 6, 22),
		};
		Pair<LocalDate> mmbirthdays = ArrayAlg.minmax(birthdays);
		System.out.println("min birthday is " + mmbirthdays.getFirst());
		System.out.println("max birthday is " + mmbirthdays.getSecond());
		System.out.println(mmbirthdays.getClass());
	}

}

class ArrayAlg{
	
	public static <T extends Comparable> Pair<T> minmax(T[] a){
		if(a == null || a.length == 0) return null;
		T min = a[0];
		T max = a[0];
		for(int i = 1; i < a.length; i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair<>(min, max);
	}
	
	public static <T> T getMiddle(T... a){
		return a[a.length/2];
	}
	
	public static <T extends Comparable<T>> T min(T[] a){
		if(a == null || a.length == 0) return null;
		T smallest = a[0];
		for(int i = 1; i < a.length; i++){
			if(smallest.compareTo(a[i]) > 0) smallest = a[i];
		}
		return smallest;
	}
}