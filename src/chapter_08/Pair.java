package chapter_08;

import java.util.function.Supplier;

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair(){first = null; second = null;}
	public Pair(T first, T second){
		this.first = first;
		this.second = second;
	}
	
	public T getFirst(){return first;}
	public T getSecond(){return second;}
	
	public void setFirst(T newValue){first = newValue;}
	public void setSecond(T newValue){second = newValue;}
	
//	public boolean equals(T value){
//		return first.equals(value) && second.equals(value);
//	}
	
	public static <T> Pair<T> makePair(Class<T> c1){
		try{
			return new Pair<>(c1.newInstance(), c1.newInstance());
		}catch(Exception ex){
			return null;
		}
	}
	
}
