/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.jenismember;

/**
 *
 * @author LENOVO
 */
import java.util.*;
import javax.swing.*;
import dao.JenisMemberDao;
import model.JenisMember;
public class JenisMemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;
    public JenisMemberFrame(JenisMemberDao jenisMemberDao){
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15,40,350,10);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,60,350,30);
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15,100,100,40);
       
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,150,350,200);
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);
        buttonSimpan.addActionListener(actionListener);
        this.add(buttonSimpan);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        this.setSize(400,500);
        this.setLayout(null);
    }
    public String getNama(){
        return textFieldNama.getText();
    }
    
    public void addJenisMember(JenisMember jenisMember){
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}