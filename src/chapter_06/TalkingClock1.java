package chapter_06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

	
public class TalkingClock1 {
	private int interval;
	private boolean beep;
	
	public TalkingClock1(int interval, boolean beep){
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start(){
		
		ActionListener timePrinter = new TimePrinter();
		Timer t= new Timer(interval, timePrinter);
		t.start();
	}
	
//	内部类，可以为私有类
	private class TimePrinter implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.out.println("At the tone, the time is " + new Date());
			if(beep){
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
	
	public static void main(String[] args) {
		TalkingClock1 tc = new TalkingClock1(1000, true);
		tc.start();
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}

}
