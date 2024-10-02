package pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class HelloInput extends JFrame{
	
	public HelloInput() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelInput = new JLabel("Input Nama: ");
		labelInput.setBounds(130, 40, 100, 10); // set posisi
		
		JTextField textField = new JTextField();
		textField.setBounds(130, 60, 100, 30); // set posisi
		
		JButton button = new JButton("klik");
		button.setBounds(130, 100, 100, 40); // set posisi
		
		JLabel labelOutput = new JLabel("");
		labelOutput.setBounds(130, 150, 100, 10); // set posisi
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nama = textField.getText();
				labelOutput.setText("Hello "+ nama);
			}
		});
		
		this.add(button);
		this.add(textField);
		this.add(labelInput);
		this.add(labelOutput);
		
		this.setSize(400, 500);
		this.setLayout(null);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HelloInput h = new HelloInput();
				h.setVisible(true);
			}
		});
	}
}
