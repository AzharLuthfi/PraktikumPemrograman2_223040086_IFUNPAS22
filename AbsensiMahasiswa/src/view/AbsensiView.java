package view;

import model.Absensi;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import dao.AbsensiMapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AbsensiView extends JFrame {
    private JTextField tfNama, tfKelas;
    private JSpinner spinnerTanggal; // Spinner untuk tanggal
    private JComboBox<String> cbStatus; // ComboBox untuk status kehadiran
    private JTable table;
    private DefaultTableModel tableModel;

    private SqlSessionFactory sqlSessionFactory;

    public AbsensiView() {
        setTitle("Aplikasi Absensi Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load MyBatis Configuration
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Panel Input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Form Input"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNama = new JLabel("Nama Mahasiswa:");
        tfNama = new JTextField(20);
        JLabel lblKelas = new JLabel("Kelas:");
        tfKelas = new JTextField(20);

        JLabel lblTanggal = new JLabel("Tanggal:");
        spinnerTanggal = new JSpinner(new SpinnerDateModel()); // Spinner untuk tanggal
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggal, "yyyy-MM-dd");
        spinnerTanggal.setEditor(dateEditor);

        JLabel lblStatus = new JLabel("Status Kehadiran:");
        cbStatus = new JComboBox<>(new String[]{"Hadir", "Tidak Hadir"}); // ComboBox untuk status

        // Add Components to Input Panel
        gbc.gridx = 0; gbc.gridy = 0; inputPanel.add(lblNama, gbc);
        gbc.gridx = 1; gbc.gridy = 0; inputPanel.add(tfNama, gbc);

        gbc.gridx = 0; gbc.gridy = 1; inputPanel.add(lblKelas, gbc);
        gbc.gridx = 1; gbc.gridy = 1; inputPanel.add(tfKelas, gbc);

        gbc.gridx = 0; gbc.gridy = 2; inputPanel.add(lblTanggal, gbc);
        gbc.gridx = 1; gbc.gridy = 2; inputPanel.add(spinnerTanggal, gbc);

        gbc.gridx = 0; gbc.gridy = 3; inputPanel.add(lblStatus, gbc);
        gbc.gridx = 1; gbc.gridy = 3; inputPanel.add(cbStatus, gbc);

        // Panel Tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Tambah");
        JButton btnUpdate = new JButton("Ubah");
        JButton btnDelete = new JButton("Hapus");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        // Panel Tabel
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "Kelas", "Tanggal", "Status"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Add Panels to Main Panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(tableScrollPane, BorderLayout.SOUTH);

        // Add Main Panel to Frame
        add(mainPanel);

        // Load Data
        loadData();

        // Event Listeners
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahData();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ubahData();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusData();
            }
        });
    }

    private void loadData() {
        tableModel.setRowCount(0);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AbsensiMapper mapper = session.getMapper(AbsensiMapper.class);
            List<Absensi> data = mapper.ambilSemuaAbsensi();
            for (Absensi absensi : data) {
                tableModel.addRow(new Object[]{
                        absensi.getIdMahasiswa(),
                        absensi.getNamaMahasiswa(),
                        absensi.getKelas(),
                        absensi.getTanggalAbsen(),
                        absensi.getStatusKehadiran()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tambahData() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AbsensiMapper mapper = session.getMapper(AbsensiMapper.class);
            Absensi absensi = new Absensi();
            absensi.setNamaMahasiswa(tfNama.getText());
            absensi.setKelas(tfKelas.getText());

            // Format tanggal ke 'yyyy-MM-dd'
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            absensi.setTanggalAbsen(dateFormat.format((Date) spinnerTanggal.getValue()));

            absensi.setStatusKehadiran(cbStatus.getSelectedItem().toString());
            mapper.tambahAbsensi(absensi);
            session.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data!");
        }
    }

    private void ubahData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah!");
            return;
        }

        try (SqlSession session = sqlSessionFactory.openSession()) {
            AbsensiMapper mapper = session.getMapper(AbsensiMapper.class);
            Absensi absensi = new Absensi();
            absensi.setIdMahasiswa((int) table.getValueAt(selectedRow, 0));
            absensi.setNamaMahasiswa(tfNama.getText());
            absensi.setKelas(tfKelas.getText());

            // Format tanggal ke 'yyyy-MM-dd'
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            absensi.setTanggalAbsen(dateFormat.format((Date) spinnerTanggal.getValue()));

            absensi.setStatusKehadiran(cbStatus.getSelectedItem().toString());
            mapper.updateAbsensi(absensi);
            session.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah!");
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengubah data!");
        }
    }

    private void hapusData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            AbsensiMapper mapper = session.getMapper(AbsensiMapper.class);
            int idMahasiswa = (int) table.getValueAt(selectedRow, 0);
            mapper.hapusAbsensi(idMahasiswa);
            session.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menghapus data!");
        }
    }
}
