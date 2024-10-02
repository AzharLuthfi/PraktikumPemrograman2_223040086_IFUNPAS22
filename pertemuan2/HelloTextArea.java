package pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class HelloTextArea extends JFrame{
	public HelloTextArea(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelInput = new JLabel("Input Nama: ");
		labelInput.setBounds(130, 40, 100, 10); // set posisi
		
		JTextField textField = new JTextField();
		textField.setBounds(130, 60, 100, 30); // set posisi
		
		JButton button = new JButton("klik");
		button.setBounds(130, 100, 100, 40); // set posisi
		
		JTextArea txtOutput = new JTextArea("");
		txtOutput.setBounds(130, 150, 100, 100); // set posisi
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nama = textField.getText();
				txtOutput.append("Hello "+ nama+"\n");
				textField.setText("");
			}
		});
		
		this.add(button);
		this.add(textField);
		this.add(labelInput);
		this.add(txtOutput);
		
		this.setSize(400, 500);
		this.setLayout(null);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HelloTextArea h = new HelloTextArea();
				h.setVisible(true);
			}
		});
	}

}
