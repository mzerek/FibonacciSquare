package pl.mzerek.firstSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class YAnswers extends JPanel {

	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(50, 50, 100, 100);
		g.setColor(Color.white);
		g.fillArc(50, 50, 100, 100, 0, 180);
		g.setColor(Color.black);
		g.drawLine(50, 100, 150, 100);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setPreferredSize(new Dimension(300, 500));
		jf.add(new YAnswers());
		jf.pack();
		jf.setVisible(true);
	}

}
