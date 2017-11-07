package chapter_06;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] planets = new String[]{
			"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
		};
		System.out.println(Arrays.toString(planets));
		Arrays.sort(planets);
		System.out.println("Sorted in dictionary order:");
		System.out.println(Arrays.toString(planets));
		
		Arrays.sort(planets,(first, second)->first.length()-second.length());
		System.out.println("Sorted length:");
		System.out.println(Arrays.toString(planets));
		
		Timer t = new Timer(1000, event->System.out.println("The time is " + new Date()));
		t.start();
		JOptionPane.showMessageDialog(null, "Quit");
		System.exit(0);
	}

}
