import org.apache.hc.client5.http.async.methods.*;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.Timeout;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame {

    public static void main(String[] args) {
        final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                .setSoTimeout(Timeout.ofSeconds(5))
                .build();

        final CloseableHttpAsyncClient client = HttpAsyncClients.custom()
                .setIOReactorConfig(ioReactorConfig)
                .build();

        client.start();

        final HttpHost target = new HttpHost("672fbf9066e42ceaf15e9a9b.mockapi.io");
        final String requestUri = "/api/contacts";

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh HTTP Client di Swing");
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            JLabel statusLabel = new JLabel("Tekan tombol untuk mulai mengunduh data", JLabel.CENTER);
            JButton startButton = new JButton("Mulai");
            JProgressBar progressBar = new JProgressBar(0, 100);
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);

            JPanel panel = new JPanel();
            panel.add(startButton);
            panel.add(progressBar);
            panel.setLayout(new FlowLayout());
            frame.add(panel, BorderLayout.SOUTH);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    // Add functionality if needed
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    client.close(CloseMode.GRACEFUL);
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    // Add functionality if needed
                }

                @Override
                public void windowIconified(WindowEvent e) {
                    // Add functionality if needed
                }

                @Override
                public void windowDeiconified(WindowEvent e) {
                    // Add functionality if needed
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    // Add functionality if needed
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                    // Add functionality if needed
                }
            });

            final SimpleHttpRequest request = SimpleRequestBuilder.get()
                    .setHttpHost(target)
                    .setPath(requestUri)
                    .build();

            startButton.addActionListener(e -> {
                progressBar.setIndeterminate(true);
                startButton.setEnabled(false);
                statusLabel.setText("Proses berjalan...");
                textArea.setText("");

                client.execute(
                        SimpleRequestProducer.create(request),
                        SimpleResponseConsumer.create(),
                        new FutureCallback<>() {
                            @Override
                            public void completed(final SimpleHttpResponse response) {
                                try {
                                    System.out.println(request + "->" + new StatusLine(response));
                                    System.out.println(response.getBodyText());

                                    JSONParser parser = new JSONParser();
                                    try {
                                        JSONArray contacts = (JSONArray) parser.parse(response.getBodyText());
                                        contacts.forEach(obj -> {
                                            JSONObject contact = (JSONObject) obj;
                                            textArea.append(contact + "\n");
                                        });
                                    } catch (ParseException ex) {
                                        throw new RuntimeException(ex);
                                    }

                                    progressBar.setIndeterminate(false);
                                    startButton.setEnabled(true);
                                    statusLabel.setText("Proses selesai");

                                } catch (Exception ex) {
                                    failed(ex);
                                }
                            }

                            @Override
                            public void failed(final Exception ex) {
                                statusLabel.setText("Proses gagal: " + ex.getMessage());
                                progressBar.setIndeterminate(false);
                                startButton.setEnabled(true);
                            }

                            @Override
                            public void cancelled() {
                                statusLabel.setText("Proses dibatalkan");
                                progressBar.setIndeterminate(false);
                                startButton.setEnabled(true);
                            }
                        });
            });

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
