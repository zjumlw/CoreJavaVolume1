package chapter_06;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		repeat(10,(i)->System.out.println("Count down: " + (9-i)));
	}
	
	public static void repeat(int n, IntConsumer action){
		for(int i = 0; i < n; i++){
			action.accept(i);
		}
	}
}

