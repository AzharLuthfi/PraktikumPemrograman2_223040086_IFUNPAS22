package pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class HelloCheckBox extends JFrame{

		private boolean checkBoxSelected;

		public HelloCheckBox(){
			this.checkBoxSelected = false;
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel labelInput = new JLabel("Input Nama: ");
			labelInput.setBounds(15, 40, 350, 10); // set posisi
			
			JTextField textField = new JTextField();
			textField.setBounds(15, 60, 350, 30); // set posisi
			
			JCheckBox checkbox = new JCheckBox("saya menyetujui syarat dan ketentuan yang berlaku");
			checkbox.setBounds(15, 100, 350, 30); // set posisi
			
			JButton button = new JButton("Simpan");
			button.setBounds(15, 150, 100, 40); // set posisi
			
			JTextArea txtOutput = new JTextArea("");
			txtOutput.setBounds(15, 200, 350, 100); // set posisi
			
			checkbox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					checkBoxSelected = e.getStateChange()==1;
				}
			});
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(checkBoxSelected) {
						String nama = textField.getText();
						txtOutput.append("Hello "+ nama+"\n");
						textField.setText("");
					} else {
						txtOutput.append("Anda Tidak Mencentang Kotak Persetujuan\n");
					}
				}
			});
			
			this.add(button);
			this.add(textField);
			this.add(checkbox);
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
					HelloCheckBox h = new HelloCheckBox();
					h.setVisible(true);
				}
			});
		}

}
