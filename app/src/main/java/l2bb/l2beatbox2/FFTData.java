package l2bb.l2beatbox2;

/**
 * Created by OZ on 12/28/2015.
 */

// Data class to explicitly indicate that these bytes are the FFT of audio data
public class FFTData {
    public byte[] bytes;

    public FFTData(byte[] bytes){ this.bytes = bytes;  }
}
