package pl.mzerek.firstSwing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DrawArc extends JApplet {
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// g2.draw(new Arc2D.Double(x, y, width, height, 0, 90, Arc2D.OPEN));
		g2.setStroke(new BasicStroke(2.0f));

		// UP
		g2.setPaint(Color.RED);
		g2.draw(new Arc2D.Double(50, 50, 100, 100, 0, 90, Arc2D.OPEN));

		// LEFT
		g2.setPaint(Color.GREEN);
		g2.draw(new Arc2D.Double(50, 50, 100, 100, 90, 90, Arc2D.OPEN));

		// DOWN
		g2.setPaint(Color.BLUE);
		g2.draw(new Arc2D.Double(50, 50, 100, 100, 180, 90, Arc2D.OPEN));

		// RIGHT
		g2.setPaint(Color.YELLOW);
		g2.draw(new Arc2D.Double(50, 50, 100, 100, 270, 90, Arc2D.OPEN));
		// g2.setPaint(Color.GREEN);
		// g2.draw(new Arc2D.Double(50, 50, 300, 300, 90, 90, Arc2D.PIE));
		// g2.setPaint(Color.BLUE);
		// g2.fill(new Arc2D.Double(50, 50, 300, 300, 180, 90, Arc2D.PIE));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Arch Demo");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JApplet applet = new DrawArc();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setSize(new Dimension(400, 450));
		frame.setVisible(true);
	}
}
