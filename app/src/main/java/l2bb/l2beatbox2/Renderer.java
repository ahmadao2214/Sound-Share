package l2bb.l2beatbox2;

import android.graphics.Canvas;
import android.graphics.Rect;

abstract public class Renderer {
    protected  float[] mPoints;

    public Renderer(){

    }
    /**
     * Implement this method to render the audio data onto the canvas
     * @param canvas - Canvas to draw on
     * @param data   - Data to render
     * @param rect   - Rect to render into
     */
    abstract public void onRender(Canvas canvas, AudioData data, Rect rect);
    final public void render(Canvas canvas, AudioData data, Rect rect){
        if(mPoints == null || mPoints.length < data.bytes.length * 4){
            mPoints = new float[data.bytes.length * 4];
        }
        onRender(canvas, data, rect);
    }
}
