package pertemuan1;

import javax.swing.*;

public class HelloWorldSwing {
	private static void createAndShowGUI() {
		
		// MEMBUAT FRAME
		JFrame frame = new JFrame("Tugas1_HelloWorldSwing"); // nama untuk frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ISI UNTUK DALAM FRAME
		JLabel label = new JLabel("Hello, Muhamad Azhar Luthfiadi, Selamat Siang😀😀");	
		frame.getContentPane().add(label); //cara menambahkan teks ke frame		

		
		frame.pack(); //secara otomatis menyesuaikan ukuran frame sesuai dengan konten di dalamnya.
		frame.setVisible(true);//  membuat frame muncul di layar.
	}
	
	public static void main(String[] args) {
		/*	
		Program dijalankan di dalam "SwingUtilities.invokeLater" untuk memastikan GUI dibuat
		di thread khusus untuk event GUI.
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createAndShowGUI();
			}
		});
	}

}
