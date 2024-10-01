import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class WAVPlayer implements AudioPlayer {
    private Clip audioClip;
    private boolean isPlaying = false;

    public WAVPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        loadAudio(filePath);
    }

    // Геттер для isPlaying
    public boolean isPlaying() {
        return isPlaying;
    }

    // Приватний метод для завантаження аудіо
    private void loadAudio(String filePath)
            throws UnsupportedAudioFileException,
                   IOException,
                   LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
        audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);
    }

    @Override
    public void play() {
        if (!isPlaying) {
            audioClip.start();
            isPlaying = true;
        }
    }

    @Override
    public void pause() {
        if (isPlaying) {
            audioClip.stop();
            isPlaying = false;
        }
    }

    @Override
    public void stop() {
        if (isPlaying) {
            audioClip.stop(); // Зупиняємо відтворення
            close();
            audioClip.setFramePosition(0);  // Повертаємося на початок
            isPlaying = false;
        }
    }

    // Метод для звільнення ресурсів (важливо для управління пам'яттю)
    public void close() {
        if (audioClip != null) {
            audioClip.close();
        }
    }
}
