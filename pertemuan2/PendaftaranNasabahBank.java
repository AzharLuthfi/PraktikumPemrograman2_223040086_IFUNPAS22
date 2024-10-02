package pertemuan2;

import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PendaftaranNasabahBank extends JFrame {
	
	    private boolean checkBoxSelected;

	    public PendaftaranNasabahBank() {
	        this.checkBoxSelected = false;
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setTitle("Form Pendaftaran Nasabah Bank");
	        this.setSize(500, 800);
	        this.setLayout(null); // Menggunakan layout null untuk penempatan manual

	        // *** 1. Menambahkan Menu Bar ***
	        JMenuBar menuBar = new JMenuBar();
	        JMenu menu = new JMenu("Menu");
	        JMenuItem resetItem = new JMenuItem("Reset");
	        JMenuItem exitItem = new JMenuItem("Exit");

	        menu.add(resetItem);
	        menu.add(exitItem);
	        menuBar.add(menu);
	        this.setJMenuBar(menuBar);

	        // *** 2. Label dan Text Field untuk Nama ***
	        JLabel inputNama = new JLabel("Nama: ");
	        inputNama.setBounds(15, 40, 350, 25); // set posisi
	        this.add(inputNama);

	        JTextField textField1 = new JTextField();
	        textField1.setBounds(150, 40, 300, 25); // set posisi
	        this.add(textField1);

	        // *** 3. Label dan Text Field untuk Nomor HP ***
	        JLabel inputHp = new JLabel("Nomor HP: ");
	        inputHp.setBounds(15, 80, 350, 25); // set posisi
	        this.add(inputHp);

	        JTextField textField2 = new JTextField();
	        textField2.setBounds(150, 80, 300, 25); // set posisi
	        this.add(textField2);

	        // *** 4. Label dan Radio Button untuk Jenis Kelamin ***
	        JLabel labelRadio = new JLabel("Jenis Kelamin: ");
	        labelRadio.setBounds(15, 120, 350, 25); // set posisi
	        this.add(labelRadio);

	        JRadioButton RadioButton1 = new JRadioButton("Laki-Laki", true);
	        RadioButton1.setBounds(150, 120, 100, 25); // set posisi

	        JRadioButton RadioButton2 = new JRadioButton("Perempuan");
	        RadioButton2.setBounds(250, 120, 100, 25); // set posisi

	        ButtonGroup bg = new ButtonGroup();
	        bg.add(RadioButton1);
	        bg.add(RadioButton2);

	        this.add(RadioButton1);
	        this.add(RadioButton2);

	        // *** 5. Checkbox untuk Warga Negara Asing ***
	        JCheckBox checkbox = new JCheckBox("Warga Negara Asing");
	        checkbox.setBounds(15, 160, 200, 25); // set posisi
	        this.add(checkbox);

	        checkbox.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                // Mengubah status checkbox
	                checkBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
	            }
	        });

	        // *** 6. Label dan JList untuk Jenis Tabungan ***
	        JLabel labelTabungan = new JLabel("Jenis Tabungan: ");
	        labelTabungan.setBounds(15, 200, 350, 25); // set posisi
	        this.add(labelTabungan);

	        String[] jenisTabungan = {"Tabungan Biasa", "Tabungan Pendidikan", "Tabungan Haji", "Tabungan Anak"};
	        JList<String> listTabungan = new JList<>(jenisTabungan);
	        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        listTabungan.setVisibleRowCount(4);

	        JScrollPane scrollTabungan = new JScrollPane(listTabungan);
	        scrollTabungan.setBounds(150, 200, 300, 80); // set posisi dan ukuran
	        this.add(scrollTabungan);

	        // *** 7. Label dan JSpinner untuk Frekuensi Transaksi ***
	        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi per Bulan: ");
	        labelFrekuensi.setBounds(15, 290, 250, 25); // set posisi
	        this.add(labelFrekuensi);

	        SpinnerModel modelFrekuensi = new SpinnerNumberModel(1, 1, 100, 1); // default, min, max, step
	        JSpinner spinnerFrekuensi = new JSpinner(modelFrekuensi);
	        spinnerFrekuensi.setBounds(270, 290, 80, 25); // set posisi
	        this.add(spinnerFrekuensi);

	        // *** 8. Label dan JPasswordField untuk Password ***
	        JLabel labelPassword = new JLabel("Password: ");
	        labelPassword.setBounds(15, 330, 350, 25); // set posisi
	        this.add(labelPassword);

	        JPasswordField passwordField = new JPasswordField();
	        passwordField.setBounds(150, 330, 300, 25); // set posisi
	        this.add(passwordField);

	        // *** 9. Label dan JPasswordField untuk Confirm Password ***
	        JLabel labelConfirmPassword = new JLabel("Confirm Password: ");
	        labelConfirmPassword.setBounds(15, 370, 350, 25); // set posisi
	        this.add(labelConfirmPassword);

	        JPasswordField confirmPasswordField = new JPasswordField();
	        confirmPasswordField.setBounds(150, 370, 300, 25); // set posisi
	        this.add(confirmPasswordField);

	        // *** 10. Label dan JSpinner untuk Tanggal Lahir ***
	        JLabel labelTglLahir = new JLabel("Tanggal Lahir: ");
	        labelTglLahir.setBounds(15, 410, 350, 25); // set posisi
	        this.add(labelTglLahir);

	        SpinnerModel modelTanggal = new SpinnerDateModel();
	        JSpinner spinnerTanggal = new JSpinner(modelTanggal);
	        spinnerTanggal.setBounds(150, 410, 150, 25); // set posisi
	        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggal, "dd-MM-yyyy");
	        spinnerTanggal.setEditor(editor);
	        this.add(spinnerTanggal);

	        // *** 11. Tombol Simpan ***
	        JButton button = new JButton("Simpan");
	        button.setBounds(15, 450, 100, 40); // set posisi
	        this.add(button);

	        // *** 12. Text Area untuk Output ***
	        JTextArea txtOutput = new JTextArea("");
	        txtOutput.setBounds(15, 510, 455, 200); // set posisi
	        txtOutput.setEditable(false); // Membuat text area tidak bisa diedit oleh user
	        this.add(txtOutput);

	        // *** 13. Action Listener untuk Tombol Simpan ***
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Mengambil jenis kelamin
	                String jenisKelamin = RadioButton1.isSelected() ? RadioButton1.getText() : RadioButton2.getText();

	                // Mengambil nama dan nomor HP
	                String nama = textField1.getText();
	                String no_hp = textField2.getText();

	                // Mengambil jenis tabungan
	                String jenisTabunganSelected = listTabungan.getSelectedValue();
	                if (jenisTabunganSelected == null) {
	                    JOptionPane.showMessageDialog(null, "Pilih jenis tabungan terlebih dahulu.");
	                    return;
	                }

	                // Mengambil frekuensi transaksi
	                int frekuensi = (int) spinnerFrekuensi.getValue();

	                // Mengambil dan memeriksa password
	                String password = new String(passwordField.getPassword());
	                String confirmPassword = new String(confirmPasswordField.getPassword());

	                if (!password.equals(confirmPassword)) {
	                    JOptionPane.showMessageDialog(null, "Password dan Confirm Password tidak cocok!");
	                    return;
	                }

	                // Mengambil tanggal lahir
	                Date tglLahirDate = (Date) spinnerTanggal.getValue();
	                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	                String tglLahir = sdf.format(tglLahirDate);

	                // Membuat output
	                txtOutput.setText(""); // Mengosongkan output area
	                txtOutput.append("=== Data Pendaftaran Nasabah ===\n");
	                txtOutput.append("Nama: " + nama + "\n");
	                txtOutput.append("Nomor HP: " + no_hp + "\n");
	                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
	                txtOutput.append("WNA: " + (checkBoxSelected ? "Ya" : "Tidak") + "\n");
	                txtOutput.append("Jenis Tabungan: " + jenisTabunganSelected + "\n");
	                txtOutput.append("Frekuensi Transaksi per Bulan: " + frekuensi + "\n");
	                txtOutput.append("Tanggal Lahir: " + tglLahir + "\n");
	                txtOutput.append("=====================================\n");

	                // Mengosongkan field setelah simpan
	                textField1.setText("");
	                textField2.setText("");
	                bg.clearSelection();
	                checkbox.setSelected(false);
	                listTabungan.clearSelection();
	                spinnerFrekuensi.setValue(1);
	                passwordField.setText("");
	                confirmPasswordField.setText("");
	                spinnerTanggal.setValue(new Date());
	            }
	        });

	        // *** 14. Action Listener untuk Menu Reset ***
	        resetItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Mengosongkan semua inputan dan output
	                textField1.setText("");
	                textField2.setText("");
	                bg.clearSelection();
	                checkbox.setSelected(false);
	                listTabungan.clearSelection();
	                spinnerFrekuensi.setValue(1);
	                passwordField.setText("");
	                confirmPasswordField.setText("");
	                spinnerTanggal.setValue(new Date());
	                txtOutput.setText("");
	            }
	        });

	        // *** 15. Action Listener untuk Menu Exit ***
	        exitItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Keluar dari aplikasi
	                System.exit(0);
	            }
	        });

	        // *** 16. Menampilkan JFrame ***
	        this.setVisible(true);
	    }

	    public static void main(String[] args) {
	        // Menjalankan GUI di thread Event Dispatch Thread
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new PendaftaranNasabahBank();
	            }
	        });
	    }
}


