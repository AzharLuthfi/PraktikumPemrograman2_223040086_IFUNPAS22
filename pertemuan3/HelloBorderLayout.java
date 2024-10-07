package pertemuan3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pertemuan2.Latihan7;

public class HelloBorderLayout extends JFrame {
 public HelloBorderLayout() {
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 JLabel LabelPertanyaan = new JLabel("Apakah Ibukota INdonesia? ");
	 JLabel LabelHasil = new JLabel("Jawab pertanyaan diatas");
	 
	 JButton buttonA = new JButton("Jakarta");
	 JButton buttonB = new JButton("Bandung");
	 JButton buttonC = new JButton("Surabaya");
	 
	 buttonA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LabelHasil.setText("jawaban anda benar");
			}
		});
	 
	 buttonB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LabelHasil.setText("jawaban anda salah");
			}
		});
	 
	 buttonC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LabelHasil.setText("jawaban anda salah");
			}
		});
	 
     this.add(LabelPertanyaan, BorderLayout.NORTH);
     this.add(LabelHasil, BorderLayout.SOUTH);
     this.add(buttonA, BorderLayout.WEST);
     this.add(buttonB, BorderLayout.CENTER);
     this.add(buttonC, BorderLayout.EAST);
     
     this.setSize(400, 200);
     
 }
 
 public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				HelloBorderLayout h = new HelloBorderLayout();
				h.setVisible(true);
			}
		});
	}
}
