package chapter_06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

	
public class TalkingClock {
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval, boolean beep){
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start(){
		
		//局部内部类，不能声明public或private
		class TimePrinter implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone, the time is " + new Date());
				if(beep)  Toolkit.getDefaultToolkit().beep();
			}
		}
		
		ActionListener timePrinter = new TimePrinter();
		Timer t= new Timer(interval, timePrinter);
		t.start();
	}
	
	public static void main(String[] args) {
		TalkingClock tc = new TalkingClock(1000, true);
		tc.start();
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}

}
