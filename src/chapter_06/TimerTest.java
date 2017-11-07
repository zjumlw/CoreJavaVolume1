package chapter_06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

//包可见性
class TimePrinter implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("At the tone, the time is" + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}

public class TimerTest {

	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(2000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

	
	
	

