package chapter_05;

public class HashCodeTest {
	public static void main(String[] args){
		String str = "Hello";
		StringBuilder sb = new StringBuilder(str);
		String str1 = new String("Hello");
		StringBuilder sb1 = new StringBuilder(str1);
		
		int strHashCode = str.hashCode();
		int hash = 0;
		for(int i = 0; i < str.length(); i++){
			hash = 31*hash + str.charAt(i);
		}
		System.out.println("hash = " + hash);
		System.out.println("strHashCode = " + strHashCode);
		System.out.println("sbHashCode = " + sb.hashCode());
		System.out.println("str1HashCode = " + str1.hashCode());
		System.out.println("sb1HashCode = " + sb1.hashCode());
	}
}
