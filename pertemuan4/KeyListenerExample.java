package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample {
	public static void main(String[] args) {
		// Membuat Farme
		JFrame frame = new JFrame("MouseListener Example");
		
		// Membuat Label untuk menampilkan pesan
		JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
		label.setBounds(50, 50, 300, 30);
		
		JTextField textField = new JTextField();
		textField.setBounds(50, 100, 200, 30); // set posisi
		
		textField.addKeyListener(new KeyListener() {
			
			// dijalankan ketika tombol ditekan dan dilepaskan (sama dengan mengetik karakter)
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				label.setText("Key Type: " + e.getKeyChar());
			}
			
			// dijalankan ketika tombol dilapaskan
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
			}
			
			// dijalankan ketika tombol ditekan
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
		
		// menambakan komponen ke frame
		frame.add(label);
		frame.add(textField);
		
		// setting frame
		frame.setSize(400, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
