package chapter_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = new int[20];
		
		Arrays.parallelSetAll(values, i -> i + 1);

		System.out.println(Arrays.toString(values));
		
		List<String> synchArrayList = Collections.synchronizedList(new ArrayList<String>());
		
	}

}
