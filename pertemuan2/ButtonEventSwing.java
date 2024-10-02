package pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class ButtonEventSwing extends JFrame{
	public ButtonEventSwing () {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Hello World");
		label.setBounds(130, 40, 400, 10);
		
		JButton button = new JButton("klik");
		button.setBounds(130, 100, 100, 40);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label.setText("Hello Pemrograman II");
			}
		});
		
		this.add(button);
		this.add(label);
		
		this.setSize(400, 500);
		this.setLayout(null);
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ButtonEventSwing b = new ButtonEventSwing();
				b.setVisible(true);
			}
		});
	}
}
