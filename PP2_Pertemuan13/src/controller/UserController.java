package controller;

import model.*;
import view.UserPdf;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
        this.view.addUpdateListener(new UpdateUserListener());
        this.view.addDeleteListener(new DeleteUserListener());
        this.view.addStartTaskListener(new StartTaskListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                // Start background task
                new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        view.updateProgress(0);
                        // Simulate adding user
                        User user = new User();
                        user.setName(name);
                        user.setEmail(email);
                        mapper.insertUser(user);

                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50);
                            publish(i); // Update progress
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        view.updateProgress(chunks.get(chunks.size() - 1)); // Update progress bar
                    }

                    @Override
                    protected void done() {
                        view.resetProgress();
                        JOptionPane.showMessageDialog(view, "User added successfully!");
                    }
                }.execute();
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Simulating long process
            new SwingWorker<Void, Integer>() {
                @Override
                protected Void doInBackground() throws Exception {
                    List<User> users = mapper.getAllUsers();
                    Object[][] userArray = new Object[users.size()][3];
                    for (int i = 0; i < users.size(); i++) {
                        User user = users.get(i);
                        userArray[i][0] = i + 1;
                        userArray[i][1] = user.getName();
                        userArray[i][2] = user.getEmail();
                    }
                    // Simulate a delay while refreshing
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50);
                        publish(i);
                    }
                    view.setUserList(userArray);
                    return null;
                }

                @Override
                protected void process(List<Integer> chunks) {
                    view.updateProgress(chunks.get(chunks.size() - 1)); // Update progress bar
                }

                @Override
                protected void done() {
                    view.resetProgress();
                }
            }.execute();
        }
    }

    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<User> users = mapper.getAllUsers();
                if (users.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "No users to export.");
                    return;
                }
                pdf.exportPdf(users);
                JOptionPane.showMessageDialog(view, "PDF successfully generated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error generating PDF: " + ex.getMessage());
            }
        }
    }

    class UpdateUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getSelectedRow();
            if (selectedRow != -1) {
                String name = view.getNameInput();
                String email = view.getEmailInput();
                if (!name.isEmpty() && !email.isEmpty()) {
                    // Start background task for update
                    new SwingWorker<Void, Integer>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            User user = new User();
                            user.setEmail(email);
                            user.setName(name);
                            mapper.updateUser(user);

                            for (int i = 0; i <= 100; i++) {
                                Thread.sleep(50);
                                publish(i); // Update progress
                            }
                            return null;
                        }

                        @Override
                        protected void process(List<Integer> chunks) {
                            view.updateProgress(chunks.get(chunks.size() - 1));
                        }

                        @Override
                        protected void done() {
                            view.resetProgress();
                            JOptionPane.showMessageDialog(view, "User updated successfully!");
                        }
                    }.execute();
                } else {
                    JOptionPane.showMessageDialog(view, "Please fill in all fields.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to update.");
            }
        }
    }

    class DeleteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getSelectedRow();
            if (selectedRow != -1) {
                String email = (String) view.userTable.getValueAt(selectedRow, 2);
                // Start background task for delete
                new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        mapper.deleteUser(email);

                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50);
                            publish(i); // Update progress
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        view.updateProgress(chunks.get(chunks.size() - 1));
                    }

                    @Override
                    protected void done() {
                        view.resetProgress();
                        JOptionPane.showMessageDialog(view, "User deleted successfully!");
                    }
                }.execute();
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to delete.");
            }
        }
    }
    
    // ActionListener untuk tombol Mulai
    class StartTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Menonaktifkan tombol Mulai dan menunjukkan status
            view.updateProgress(0);
            view.statusLabel.setText("Proses berjalan...");

            // Menjalankan tugas berat dalam SwingWorker
            new SwingWorker<Void, Integer>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Simulasi tugas berat
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50); // Simulasi delay
                        publish(i); // Memperbarui progress
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<Integer> chunks) {
                    // Memperbarui progress bar
                    int latestProgress = chunks.get(chunks.size() - 1);
                    view.updateProgress(latestProgress);
                }

                @Override
                protected void done() {
                    // Setelah tugas selesai, reset progress bar dan beri pesan selesai
                    view.resetProgress();
                    JOptionPane.showMessageDialog(view, "Proses selesai!");
                }
            }.execute();
        }
    }
}
