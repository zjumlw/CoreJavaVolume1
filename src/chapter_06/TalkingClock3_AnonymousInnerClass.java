package chapter_06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

	
public class TalkingClock3_AnonymousInnerClass {
	
	public void start(int interval, boolean beep){
		
		ActionListener timePrinter = new TimePrinter(){
			public void actionPerformed(ActionEvent e) {	//匿名内部类
				System.out.println("At the tone, the time is " + new Date());
				if(beep)  Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer t= new Timer(interval, timePrinter);
		t.start();
	}
	
	public static void main(String[] args) {
		TalkingClock3_AnonymousInnerClass tc = new TalkingClock3_AnonymousInnerClass();
		tc.start(1000, true);
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}

}
