package chapter_08;

public class PairAlg {
	//是一个泛型方法
		public static <T> void swapHelper(Pair<T> p){
			T t = p.getFirst();
			p.setFirst(p.getSecond());
			p.setSecond(t);
		}
		
		//不是一个泛型方法
		public static void swap(Pair<?> p){
			swapHelper(p);
		}
		
		public static boolean hasNulls(Pair<?> p){
			return p.getFirst() == null || p.getSecond() == null;
		}
}
