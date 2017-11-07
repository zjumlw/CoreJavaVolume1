package chapter_08;

import java.time.LocalDate;
import java.util.Collection;

public class DateInterval extends Pair<LocalDate> {
	public void setSecond(LocalDate second){
		if(second.compareTo(getFirst()) >= 0)
			super.setSecond(second);
	}
	
	public static void main(String[] args){
		DateInterval interval = new DateInterval();
		interval.setFirst(LocalDate.of(1991, 2, 18));
		interval.setSecond(LocalDate.of(1900, 11, 6));
		
		System.out.println("first date = " + interval.getFirst());
		System.out.println("second date = " + interval.getSecond());
		
		Pair<LocalDate> pair = interval;
		
		System.out.println("first date = " + pair.getFirst());
		System.out.println("second date = " + pair.getSecond());
		System.out.println(pair.getClass());
		
		
		pair.setSecond(LocalDate.of(1990, 11, 11));
		
		System.out.println("first date = " + pair.getFirst());
		System.out.println("second date = " + pair.getSecond());
		
		Pair<String> p = Pair.makePair(String.class);
		System.out.println(String.class);
		
		
		
	}
	
	
	public static<T> void addAll(Collection<T> coll, T...ts ){
		for(T t : ts){
			coll.add(t);
		}
	}
}
