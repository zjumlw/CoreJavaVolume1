package chapter_05;

import java.util.Scanner;

public class EnumTest {

	public enum Size{
		SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
		
		private Size(String abbreviation){
			this.abbreviation = abbreviation;
		}
		
		private String abbreviation;
		
		public String getAbbreviation(){
			return abbreviation;
		}
		
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		
		
		System.out.println("size = " + size);
		System.out.println("abbreviation = " + size.abbreviation);
		Size[] values = Size.values();
		System.out.println(values[3]);
	}

}
