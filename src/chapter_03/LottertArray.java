package chapter_03;

import java.util.Arrays;
import java.util.Scanner;

public class LottertArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int NMAX = in.nextInt();
		
		int[][] odds = new int[NMAX + 1][];
		for(int i = 0; i <= NMAX; i++)
			odds[i] = new int[i + 1];
		
		for(int i = 0; i < odds.length; i++){
			for(int j = 0; j < odds[i].length; j++){
				int lotteryOdds = 1;
				
				for(int k = 1; k <= j; k++){
					lotteryOdds = lotteryOdds*(i-k+1)/k;
				}
				odds[i][j] = lotteryOdds;
				System.out.print(odds[i][j] + " ");
			}
			System.out.println();
		}
		//System.out.println(Arrays.deepToString(odds));
	}
	
}
