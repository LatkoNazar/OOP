import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.*;
import org.kc7bfi.jflac.FLACDecoder;
import org.kc7bfi.jflac.frame.Frame;
import org.kc7bfi.jflac.metadata.StreamInfo;
import org.kc7bfi.jflac.util.ByteData;

class FLACPlayer implements AudioPlayer {
    private String filePath;
    private boolean isPlaying = false;

    public FLACPlayer(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        isPlaying = true;
    }

    @Override
    public void pause() {
        isPlaying = false;
    }

    @Override
    public void stop() {
        isPlaying = false;
    }
}
