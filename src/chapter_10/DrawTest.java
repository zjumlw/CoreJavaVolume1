package chapter_10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(()->{
			JFrame frame = new DrawFrame();
			frame.setTitle("DrawTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class DrawFrame extends JFrame{
	public DrawFrame(){
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));
		
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
		g2.draw(circle);
		
		g2.setPaint(new Color(0, 128, 128));
		g2.drawString("Welcome", 75, 125);
		
		g2.setPaint(Color.RED);
		g2.drawString("Warning", 100, 200);
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}