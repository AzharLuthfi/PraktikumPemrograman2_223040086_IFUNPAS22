package pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class Latihan7 extends JFrame {
	private boolean checkBoxSelected;
	public Latihan7() {
		this.checkBoxSelected = false;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel inputNama = new JLabel("Nama: ");
		inputNama.setBounds(15, 40, 350, 10); // set posisi
		
		JTextField textField1 = new JTextField();
		textField1.setBounds(15, 60, 350, 30); // set posisi
		
		JLabel inputHp = new JLabel("Nomor HP: ");
		inputHp.setBounds(15, 100, 350, 10); // set posisi
		
		JTextField textField2 = new JTextField();
		textField2.setBounds(15, 120, 350, 30); // set posisi
		
		JLabel labelRadio = new JLabel("Jenis Kelamin: ");
		labelRadio.setBounds(15, 160, 350, 10); // set posisi
		
		JRadioButton RadioButton1 = new JRadioButton("Laki-Laki", true);
		RadioButton1.setBounds(15, 175, 350, 30); // set posisi
		
		JRadioButton RadioButton2 = new JRadioButton("Perempuan");
		RadioButton2.setBounds(15, 210, 350, 30); // set posisi
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(RadioButton1);
		bg.add(RadioButton2);
		
		JCheckBox checkbox = new JCheckBox("Warga Negara Asing");
		checkbox.setBounds(15, 260, 350, 30); // set posisi
				
		JButton button = new JButton("Simpan");
		button.setBounds(15, 295, 100, 40); // set posisi
		
		JTextArea txtOutput = new JTextArea("");
		txtOutput.setBounds(15, 350, 370, 100); // set posisi
		
		checkbox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Mengubah status checkbox
				checkBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String jenisKelamin = RadioButton1.isSelected() ? RadioButton1.getText() : RadioButton2.getText();
				String nama = textField1.getText();
				String no_hp = textField2.getText();
				String wnaStatus = checkBoxSelected ? "ya" : "tidak";
				
				txtOutput.setText(""); // Mengosongkan output area
				txtOutput.append("Nama: " + nama + "\n");
				txtOutput.append("Nomor HP: " + no_hp + "\n");
				txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
				txtOutput.append("WNA: " + wnaStatus + "\n");
				txtOutput.append("=====================================\n");
				
				// Mengosongkan text field
				textField1.setText("");
				textField2.setText("");
			}
		});
		
		this.add(inputNama);
		this.add(textField1);
		this.add(inputHp);
		this.add(textField2);
		this.add(labelRadio);
		this.add(RadioButton1);
		this.add(RadioButton2);
		this.add(checkbox);
		this.add(button);
		this.add(txtOutput);
		
		this.setSize(400, 600);
		this.setLayout(null);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Latihan7 h = new Latihan7();
				h.setVisible(true);
			}
		});
	}
}
