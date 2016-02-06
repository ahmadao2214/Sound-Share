package l2bb.l2beatbox2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.PorterDuff.Mode;
import android.graphics.Matrix;
import java.util.HashSet;
import java.util.Set;

/**
 * A class that draws visualizations of data received from a
 * {@link Visualizer.OnDataCaptureListener#onWaveFormDataCapture }
 */
public class VisualizerView extends View {
    Bitmap mCanvasBitmap;
    Canvas mCanvas;
    private byte[] mBytes;
    private Rect mRect = new Rect();
    private Visualizer mVisualizer;
    private Set<Renderer> mRenderers;

    public VisualizerView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs);
        init();
    }
    public VisualizerView(Context context, AttributeSet attrs){ this(context, attrs, 0); }
    public VisualizerView(Context context){ this(context, null, 0);}
    private void init(){
        mBytes = null;
        mRenderers = new HashSet<Renderer>();
    }

    /**
     * Links visualizer to player
     * @param player - MediaPlayer instance to link to
     */
    public void link(MediaPlayer player){
        if (player == null){
            throw new NullPointerException("Cannot link to null MediaPlayer");
        }

        // Create the Visualizer object and attach it to our media player.
        mVisualizer = new Visualizer(player.getAudioSessionId());
        mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);

        // Pass through Visualizer data to VisualizerView
        Visualizer.OnDataCaptureListener captureListener = new Visualizer.OnDataCaptureListener() {
            @Override
            public void onWaveFormDataCapture(Visualizer visualizer, byte[] bytes, int samplingRate) {
                updateVisualizer(bytes);
            }

            @Override
            public void onFftDataCapture(Visualizer visualizer, byte[] bytes, int samplingRate) {
                //updateVisualizerFFT(bytes);
            }
        };

        mVisualizer.setDataCaptureListener(captureListener, Visualizer.getMaxCaptureRate() / 2, true, true);
        // Enabled Visualizer and disable when stream use is done
        mVisualizer.setEnabled(true);
    }

    public void addRenderer(Renderer renderer){
        if(renderer != null){
            mRenderers.add(renderer);
        }
    }

    /**
     * Pass data to visualizer. Typically this will be obtained from the
     * Android Visualizer.OnDataCaptureListener call back. See
     * {@link Visualizer.OnDataCaptureListener#onWaveFormDataCapture }
     * @param bytes
     */
    public void updateVisualizer(byte[] bytes){
        mBytes= bytes;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        // Create canvas when ready to draw
        mRect.set(0, 0, getWidth(), getHeight());

        if(mCanvasBitmap == null){
            mCanvasBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        }
        if(mCanvas == null){
            mCanvas = new Canvas(mCanvasBitmap);
        }
        mCanvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);

        if(mBytes != null){
            // Render all audio renderers
            AudioData audioData = new AudioData(mBytes);
            for(Renderer r : mRenderers){
                r.render(mCanvas, audioData, mRect);
            }
        }
        canvas.drawBitmap(mCanvasBitmap, new Matrix(), null);
    }
}
