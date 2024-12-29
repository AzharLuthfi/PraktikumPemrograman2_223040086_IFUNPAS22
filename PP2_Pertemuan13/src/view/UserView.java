package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class UserView extends JFrame {
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JButton btnAdd = new JButton("Add User");
    private JButton btnRefresh = new JButton("Refresh");
    private JButton btnExport = new JButton("Export");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnDelete = new JButton("Delete");
    private JButton startButton;
    public JLabel statusLabel;
    private JProgressBar progressBar; 
    public JTable userTable;
    private DefaultTableModel tableModel;

    public UserView() {
        setTitle("User Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnExport);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        panel.add(buttonPanel);
        
        // Inisialisasi komponen UI
        startButton = new JButton("Mulai");
        statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat");
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
    
        // Setup JTable and its model
        tableModel = new DefaultTableModel(new Object[] {"No", "Name", "Email"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(userTable);

        
        add(panel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);
    }

    public String getNameInput() {
        return txtName.getText();
    }

    public String getEmailInput() {
        return txtEmail.getText();
    }

    public void setUserList(Object[][] users) {
        tableModel.setRowCount(0);  // Clear existing rows
        for (Object[] user : users) {
            tableModel.addRow(user);
        }
    }

    public int getSelectedRow() {
        return userTable.getSelectedRow();
    }

    public void addAddUserListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addRefreshListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }

    public void addExportListener(ActionListener listener) {
        btnExport.addActionListener(listener);
    }

    public void addUpdateListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    // Update progress bar during task
    public void updateProgress(int value) {
        progressBar.setValue(value);
    }
    
    public void addStartTaskListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    // Reset progress bar after task completion
    public void resetProgress() {
        progressBar.setValue(0);
    }
}
