import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.IOException;

class MP3Player implements AudioPlayer {
    private Player player;
    private Thread playerThread;
    private boolean isPlaying = false;
    private String filePath;
    private FileInputStream audioStream;

    public MP3Player(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        if (!isPlaying && filePath != null) {
            startPlaying();
        }
    }

    private void startPlaying() {
        try {
            audioStream = new FileInputStream(filePath);
            player = new Player(audioStream);
            playerThread = new Thread(this::playInBackground);
            playerThread.start();
            isPlaying = true;
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
            closeResources();
        }
    }

    private void playInBackground() {
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } finally {
            isPlaying = false;
            closeResources();
        }
    }

    @Override
    public void pause() {}

    @Override
    public void stop() {
        if (isPlaying) {
            player.close();
            isPlaying = false;
            filePath = null;
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (audioStream != null) {
                audioStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
