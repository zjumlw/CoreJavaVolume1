package chapter_06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

	
public class TalkingClock4_Lambda {
	
	public void start(int interval, boolean beep){
		//采用Lambda方法
		Timer t= new Timer(interval, event->{
			System.out.println("At the tone, the time is " + new Date());
			if(beep)  Toolkit.getDefaultToolkit().beep();
		});
		t.start();
	}
	
	public static void main(String[] args) {
		TalkingClock4_Lambda tc = new TalkingClock4_Lambda();
		tc.start(1000, true);
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}

}
