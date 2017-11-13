package chapter_14;

import java.util.Arrays;

public class Bank2 {
	
	public static final int NACCOUNTS = 10;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 100;
	public static final int DELAY = 10;
	
	private final double[] accounts;
	
	public Bank2(int n, double initialBalance){
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
	}
	
	//采用同步方法synchronized，更加简洁，减少出错可能性
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
		while(accounts[from] < amount) 
			wait();//导致线程进入等待状态，知道它被通知，可以指定时间
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		notifyAll();//解除那些在该对象上调用wait方法的线程的阻塞状态
	}
	
	//synchronized方法
	public synchronized double getTotalBalance(){
		double sum = 0;
		for(double a : accounts){
			sum += a;
		}
		return sum;
	}
	
	public int size(){
		return accounts.length;
	}
	
	public static void main(String[] args){
		Bank2 bank2 = new Bank2(NACCOUNTS, INITIAL_BALANCE);
		for(int i = 0; i < NACCOUNTS; i++){
			int fromAccount = i;
			Runnable r = ()->{
				try{
					while(true){
						int toAccount = (int)(bank2.size() * Math.random());
//						double amount = MAX_AMOUNT * Math.random();
						double amount = 2 * INITIAL_BALANCE * Math.random();
						bank2.transfer(fromAccount, toAccount, amount);
						Thread.sleep((int)(DELAY * Math.random()));
					}
				}catch(InterruptedException e){
					
				}
					
			};
			Thread t = new Thread(r);
			t.start();
		}
	}
}
