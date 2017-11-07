package chapter_05;

public class WrapperTest {
	
	public static double max(double... values){
		double target = Double.NEGATIVE_INFINITY;
		for(double v : values)
			if(v > target)
				target = v;
		return target;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {2,Math.PI,3.13,-5};
		System.out.println(a);
	}

}
