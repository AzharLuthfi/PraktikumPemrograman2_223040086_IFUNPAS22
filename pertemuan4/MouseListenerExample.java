package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
	public static void main(String[] args) {
		// Membuat Farme
		JFrame frame = new JFrame("MouseListener Example");
		
		// Membuat Label untuk menampilkan pesan
		JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
		label.setBounds(50, 50, 300, 30);
		
		// Menambahkan MouseListener ke label
		label.addMouseListener(new MouseListener() {
			
			// dijalankan ketika mouse dilapaskan setelah ditekan
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setText("Mouse Pressed aat: (" + e.getX() + ", " + e.getY() + ")");
			}
			
			// Dijalankan ketika mouse ditekan (tanpa dilepaskan)
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setText("Mouse Pressed aat: (" + e.getX() + ", " + e.getY() + ")");
			}
			
			// dijalankan ketika mouse masuk kearea komponen 
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setText("Mouse Entered the area.");
			}
			
			// dijalankan ketika mouse keluar dari area komponen
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setText("Mouse Entered the area.");
			}
			
			// dijalankan ketika mouse diklik (klik kiri, kanan atau tegah)
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setText("Mouse Pressed aat: (" + e.getX() + ", " + e.getY() + ")");
			}
		});
		
		// menambakan label ke frame
		frame.add(label);
		
		// setting frame
		frame.setSize(400, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
