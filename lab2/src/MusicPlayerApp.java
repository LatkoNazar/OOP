import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.io.File;
import javazoom.jl.decoder.JavaLayerException;
import javax.swing.border.EmptyBorder;
import java. awt. event. ActionListener;

public class MusicPlayerApp extends JFrame {
    private AudioPlayer player;
    private JLabel songNameLabel;
    private JLabel label;
    private JButton stopButton;
    private JButton pauseButton;
    private JButton playButton;

    public MusicPlayerApp() {
        setTitle("Music Player");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        songNameLabel = new JLabel("");
        songNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(songNameLabel, BorderLayout.NORTH);

        label = new JLabel("Drag the WAV or MP3 file here", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        playButton = createButton("Play", Color.GREEN, e -> {
            if (player != null) {
                player.play();
                label.setText("Playing.");
            }
        });
        buttonPanel.add(playButton);
        add(buttonPanel, BorderLayout.SOUTH);

        stopButton = createButton("Stop", Color.RED, (e) -> {
                    if (player != null) {
                        player.stop();
                        label.setText("Drag the WAV, MP3 or FLAC file here");
                        songNameLabel.setText("");
                    }
        });
        buttonPanel.add(stopButton);

        pauseButton = createButton("Pause", Color.ORANGE, e -> {
            if (player != null) {
                player.pause();
                label.setText("Paused.");
            }
        });

        new DropTarget(label, new DropTargetListener() {
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {}

            @Override
            public void dragOver(DropTargetDragEvent dtde) {}

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {}

            @Override
            public void dragExit(DropTargetEvent dte) {}

            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    Transferable transferable = dtde.getTransferable();
                    DataFlavor[] flavors = transferable.getTransferDataFlavors();
                    for (DataFlavor flavor : flavors) {
                        if (flavor.isFlavorJavaFileListType()) {
                            java.util.List<File> files = (java.util.List<File>) transferable.getTransferData(flavor);
                            File file = files.get(0);
                            String filePath = file.getAbsolutePath();
                            if (filePath.endsWith(".wav") || filePath.endsWith(".mp3") || filePath.endsWith(".flac")) {
                                if (player != null) {
                                    player.stop();
                                }
                                if (filePath.endsWith(".wav")) {
                                    player = new WAVPlayer(filePath);
                                    buttonPanel.add(pauseButton);
                                    buttonPanel.add(stopButton);
                                } if (filePath.endsWith(".mp3")) {
                                    player = new MP3Player(filePath);
                                    buttonPanel.remove(pauseButton);
                                    buttonPanel.add(stopButton);
                                } if (filePath.endsWith(".flac")) {
                                    player = new FLACPlayer(filePath);
                                    buttonPanel.add(pauseButton);
                                    buttonPanel.add(stopButton);
                                }
                                player.play();
                                songNameLabel.setText("Playing now: " + file.getName());
                                songNameLabel.setBorder(new EmptyBorder(10, 10, 0, 0));
                            } else {
                                label.setText("File is not a .wav or .mp3 file.");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    label.setText("Error!");
                }
            }
        });
    }

    private JButton createButton(String text, Color color, ActionListener action) {
        JButton new_button = new JButton(text);
        new_button.addActionListener(action);
        new_button.setPreferredSize(new Dimension(100, 50));
        new_button.setBackground(color);
        new_button.setForeground(Color.WHITE);
        new_button.setBorderPainted(false);
        new_button.setFocusPainted(false);
        return new_button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicPlayerApp playerApp = new MusicPlayerApp();
            playerApp.setVisible(true);
        });
    }
}
