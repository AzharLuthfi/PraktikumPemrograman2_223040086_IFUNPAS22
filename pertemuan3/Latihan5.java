package pertemuan3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Latihan5 extends JFrame{

		    public Latihan5() {
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        JLabel headerLabel = new JLabel("Layout in action: Form Biodata", JLabel.CENTER);

		        JPanel panel = new JPanel();
		        panel.setLayout(new GridBagLayout());
		        GridBagConstraints gbc = new GridBagConstraints();

		        gbc.insets = new Insets(5, 5, 5, 5); // Adding padding between components
		        JLabel genderLabel = new JLabel("Jenis Kelamin:");
		        JLabel nameLabel = new JLabel("Nama:");
		        JTextField nameField = new JTextField(15);
		        gbc.gridx = 0;
		        gbc.gridy = 0;
		        gbc.anchor = GridBagConstraints.WEST;
		        panel.add(nameLabel, gbc);

		        gbc.gridx = 1;
		        gbc.gridy = 0;
		        panel.add(genderLabel, gbc);

		        
		        JTextField nameField1 = new JTextField(15);
		        JRadioButton maleButton = new JRadioButton("Laki-Laki");
		        JRadioButton femaleButton = new JRadioButton("Perempuan");
		        ButtonGroup genderGroup = new ButtonGroup();
		        genderGroup.add(maleButton);
		        genderGroup.add(femaleButton);

		        gbc.gridx = 0;
		        gbc.gridy = 1;
		        panel.add(nameField1, gbc);

		        gbc.gridx = 1;
		        gbc.gridy = 1;
		        panel.add(maleButton, gbc);

		        gbc.gridx = 1;
		        gbc.gridy = 2;
		        panel.add(femaleButton, gbc);

		        JLabel phoneLabel = new JLabel("Nomor HP:");
		        JTextField phoneField = new JTextField(10);
		        gbc.gridx = 0;
		        gbc.gridy = 3;
		        panel.add(phoneLabel, gbc);

		        gbc.gridx = 0;
		        gbc.gridy = 4;
		        panel.add(phoneField, gbc);

		        JCheckBox foreignCheckBox = new JCheckBox("Warga Negara Asing");
		        gbc.gridx = 1;
		        gbc.gridy = 4;
		        panel.add(foreignCheckBox, gbc);

		        JButton submitButton = new JButton("Simpan");
		        gbc.gridx = 1;
		        gbc.gridy = 5;
		        gbc.anchor = GridBagConstraints.CENTER;
		        panel.add(submitButton, gbc);

		        this.setLayout(new GridLayout(2, 1));
		        this.add(headerLabel);
		        this.add(panel);
		        this.setSize(400, 400);
		        this.setLocationRelativeTo(null); // Center the frame on the screen
		    }

		    public static void main(String[] args) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						Latihan5 h = new Latihan5();
						h.setVisible(true);
					}
				});
			}
	}

	

