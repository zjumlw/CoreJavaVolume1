package chapter_14_Concurrent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(()->{
			JFrame frame = new BounceFrame1();
			frame.setTitle("BounceThread");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class BounceFrame1 extends JFrame{
	private BallComponent comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;
	
	public BounceFrame1(){
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", event->addBall());
		addButton(buttonPanel, "Close", event->System.exit(0));
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	
	public void addButton(Container c, String title, ActionListener listener){
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall(){
		Ball ball = new Ball();
		comp.add(ball);
		Runnable r = ()->{
			try{
//				for(int i = 1; i <=STEPS; i++){
//					ball.move(comp.getBounds());
//					comp.repaint();
//					Thread.sleep(DELAY);
//				}
				
				while(true){
					ball.move(comp.getBounds());
					comp.repaint();
					Thread.sleep(DELAY);
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
}