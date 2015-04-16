package pl.mzerek.firstSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rysunek implements ActionListener {
	JFrame ramka;
	JButton liniaButton;
	JButton kwadratButton;
	JButton koloButton;
	JButton wzorekButton;
	PanelRysunkowy rysunkowyP;

	public static void main(String[] args) {
		Rysunek rysunek = new Rysunek();
		rysunek.zbudujGUI();
	}

	public void zbudujGUI() {
		ramka = new JFrame();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setSize(400, 400);

		liniaButton = new JButton("Linia");
		kwadratButton = new JButton("Kwadrat");
		koloButton = new JButton("Kolo");
		wzorekButton = new JButton("Wzorek");

		liniaButton.addActionListener(this);
		kwadratButton.addActionListener(this);
		koloButton.addActionListener(this);
		wzorekButton.addActionListener(this);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		rysunkowyP = new PanelRysunkowy();
		JToolBar tb = new JToolBar();

		tb.add(liniaButton);
		tb.add(kwadratButton);
		tb.add(koloButton);
		tb.add(wzorekButton);
		jp.add("Center", rysunkowyP);
		jp.add("North", tb);
		ramka.add(jp);
		ramka.setVisible(true);
	}

	public void actionPerformed(ActionEvent akcja) {
		// pobieramy z panelu rysunkoweg obiekt typu Graphics
		// - b�dziemy go uzywa� do rysowania
		Graphics gr = rysunkowyP.getGraphics();
		gr.clearRect(0, 0, 400, 400);
		if (akcja.getSource() == liniaButton)
			// Rysujemy lini�
			gr.drawLine(20, 20, 200, 200);
		else if (akcja.getSource() == kwadratButton) {
			// Rysujemy prostok�t (tu kwadrat)
			gr.drawRect(20, 20, 220, 220);
			// Ustawiamy kolor wype�niania figur  na niebieski
			gr.setColor(Color.BLUE);
			// Rysujemy prostok�t (tu kwadrat) z zaokr�glonymi rogami, wype�niony kolorem
			gr.fillRoundRect(50, 50, 100, 100, 40, 40);}
		else if (akcja.getSource() == koloButton) {
			// Ustawiamy kolor wype�niania figur  na zielony
			gr.setColor(Color.GREEN);
			// Rysujemy owal (tu ko�o) wype�nione kolorem
			gr.fillOval(20, 20, 200, 200);
		} else if (akcja.getSource() == wzorekButton)
			// Rysujemy fraktalopodobn� struktur� opart� na ko�ach
			malujWzorek(rysunkowyP, (int) rysunkowyP.getWidth() / 2,
					(int) rysunkowyP.getHeight() / 2, 200);
		else
			System.out.println("Skontaktowali si� ze mn� kosmici");
	}

	public void malujWzorek(PanelRysunkowy pr, int x, int y, int r) {
		// mo�na te� tak si� odwo�a� do grafiki w panelu
		rysunkowyP.getGraphics().drawOval(x - r / 2, y - r / 2, r, r);

		if (r > 1) {
			// wewn�trz metody odwo�ujemy si� do tej samej metody -
			// jest to REKURENCJA
			malujWzorek(pr, x + r / 2, y, r / 2);
			malujWzorek(pr, x - r / 2, y, r / 2);
		}
	}
}

// Druga klasa w tym samym pliku!
// Tak tez si� da (czy si� powinno tak robi� to rzecz dyskusyjna)
class PanelRysunkowy extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
}