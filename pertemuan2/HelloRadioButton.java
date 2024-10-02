package pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class HelloRadioButton extends JFrame{

	public HelloRadioButton(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelInput = new JLabel("Nama: ");
		labelInput.setBounds(15, 40, 350, 10); // set posisi
		
		JTextField textField = new JTextField();
		textField.setBounds(15, 60, 350, 30); // set posisi
		
		JLabel labelRadio = new JLabel("Jenis Member: ");
		labelRadio.setBounds(15, 100, 350, 10); // set posisi
		
		JRadioButton RadioButton1 = new JRadioButton("Silver", true);
		RadioButton1.setBounds(15, 115, 350, 30); // set posisi
		
		JRadioButton RadioButton2 = new JRadioButton("Gold");
		RadioButton2.setBounds(15, 145, 350, 30); // set posisi
		
		JRadioButton RadioButton3 = new JRadioButton("Platinum");
		RadioButton3.setBounds(15, 175, 350, 30); // set posisi
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(RadioButton1);
		bg.add(RadioButton2);
		bg.add(RadioButton3);
		
		JButton button = new JButton("Simpan");
		button.setBounds(15, 205, 100, 40); // set posisi
		
		JTextArea txtOutput = new JTextArea("");
		txtOutput.setBounds(15, 250, 350, 100); // set posisi
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String jenisMember = "";
				if(RadioButton1.isSelected()) {
					
					jenisMember= RadioButton1.getText();
					
				} else if(RadioButton2.isSelected()) {
					
					jenisMember= RadioButton2.getText();
					
				}else if(RadioButton3.isSelected()) {
					
					jenisMember= RadioButton3.getText();
					
				}
				String nama = textField.getText();
				txtOutput.append("Hello "+ nama+"\n");
				txtOutput.append("Anda Adalah Member "+ jenisMember +"\n");
				textField.setText("");
			}
		});
		
		this.add(button);
		this.add(textField);
		this.add(labelRadio);
		this.add(RadioButton1);
		this.add(RadioButton2);
		this.add(RadioButton3);
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
				HelloRadioButton h = new HelloRadioButton();
				h.setVisible(true);
			}
		});
	}

}
