package l2bb.l2beatbox2;

/**
 * Created by OZ on 12/28/2015.
 */

// Data class to explicitly indicate that these bytes are raw audio data
public class AudioData {
    public byte[] bytes;

    public AudioData(byte[] bytes) { this.bytes = bytes;}
}
