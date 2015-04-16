package pl.mzerek.firstSwing;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class FibonacciSquare implements ActionListener {

	JFrame ramka;
	Panel panel;
	JButton rysujButton;

	public static void main(String[] args) {
		FibonacciSquare fibonacciSquare = new FibonacciSquare();
		fibonacciSquare.buildGui();
	}

	public void buildGui() {
		ramka = new JFrame();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setSize(400, 400);

		rysujButton = new JButton("Rysunek");
		rysujButton.addActionListener(this);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		panel = new Panel();
		JToolBar tb = new JToolBar();
		tb.add(rysujButton);

		jp.add("Center", panel);
		jp.add("North", tb);

		ramka.add(jp);
		ramka.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		malujWzorek(panel, (int) panel.getWidth() / 2,
				(int) panel.getHeight() / 2);

	}

	public void malujWzorek(Panel pr, int width, int height) {
		int z = 15;
		int[] xTab = new int[z];
		int[] yTab = new int[z];
		Graphics2D g2 = (Graphics2D) pr.getGraphics();
		g2.setPaint(Color.RED);
		// g2.draw(new Arc2D.Double(x, y, width, height, 0, 90, Arc2D.OPEN));
		g2.setStroke(new BasicStroke(2.0f));
		for (int i = 0; i < z; i++) {
			System.out.println("============ i =" + i);			
			xTab[0] = width;
			yTab[0] = height;
			int r = fibonacci(i);
			System.out.println("r = " + r);
			if (i == 0) {
				xTab[i] = xTab[0];
				yTab[i] = yTab[0];
				System.out.println("x = " + (width-xTab[i]) + ",y = "
						+ (height - yTab[i]));
				System.out.println("xOrg = " + (xTab[i]) + ",yOrg = "
						+ (yTab[i]));
				pr.getGraphics().drawRect(xTab[i], yTab[i], r, r);

			} else if (i == 1) {
				xTab[i] = xTab[i - 1];
				yTab[i] = yTab[i - 1] + fibonacci(i);
				System.out.println("x = " + (width-xTab[i]) + ",y = "
						+ (height - yTab[i]));
				System.out.println("xOrg = " + (xTab[i]) + ",yOrg = "
						+ (yTab[i]));
				pr.getGraphics().drawRect(xTab[i], yTab[i], r, r);
				
				g2.draw(new Arc2D.Double(xTab[i], yTab[i], 2*r, 2*r, 180, 90, Arc2D.OPEN));

			} else {				
				if (i % 4 == 0) {
					System.out.println("Left");
					xTab[i] = xTab[i - 1] - r;
					yTab[i] = yTab[i - 1];	
					
					pr.getGraphics().drawRect(xTab[i], yTab[i], r, r);					
					
					g2.draw(new Arc2D.Double(xTab[i], yTab[i], 2*r, 2*r, 90, 90, Arc2D.OPEN));
					
				} else if (i % 4 == 2) {
					System.out.println("Right");
					xTab[i] = xTab[i - 1] + fibonacci(i - 1);
					yTab[i] = yTab[i - 1] - fibonacci(i - 2);
					
					pr.getGraphics().drawRect(xTab[i], yTab[i], r, r);
					
					g2.draw(new Arc2D.Double(xTab[i]-r, yTab[i]-r, 2*r, 2*r, 270, 90, Arc2D.OPEN));
				} else if (i % 4 == 3) {
					System.out.println("Up");
					xTab[i] = xTab[i - 2];
					yTab[i] = yTab[i - 1] - r;
					
					pr.getGraphics().drawRect(xTab[i], yTab[i], r, r);
					
					g2.draw(new Arc2D.Double(xTab[i]-r, yTab[i], 2*r, 2*r, 0, 90, Arc2D.OPEN));
					
				} else if (i % 4 == 1) {
					System.out.println("Down");
					xTab[i] = xTab[i - 1];
					yTab[i] = yTab[i - 1] + fibonacci(i - 1);
					
					pr.getGraphics().drawRect(xTab[i], yTab[i], r, r);
					
				
					g2.draw(new Arc2D.Double(xTab[i], yTab[i]-r, 2*r, 2*r, 180, 90, Arc2D.OPEN));
				}
			}

		}

	}

	public static int fibonacci(int i) {
		if (i == 0) {
			return 1;
		} else if (i == 1) {
			return 1;
		} else {
			int wynik = fibonacci(i - 1) + fibonacci(i - 2);
			return wynik;
		}
	}

}

class Panel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
}
