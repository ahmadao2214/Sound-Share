package l2bb.l2beatbox2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by OZ on 12/28/2015.
 */
public class LineRenderer extends Renderer {
    private Paint mPaint;

    public LineRenderer(Paint paint){
        super();
        mPaint = paint;
    }

    @Override
    public void onRender(Canvas canvas, AudioData data, Rect rect){
        // Calculate points for line
        for(int i = 0; i < data.bytes.length - 1; i++){
            mPoints[i * 4] = rect.width() * i / (data.bytes.length - 1);
            mPoints[i * 4 + 1] = rect.height() / 2 + ((byte) (data.bytes[i] + 128)) * (rect.height() /3) / 128;
            mPoints[i * 4 + 2] = rect.width() * (i + 1) / (data.bytes.length - 1);
            mPoints[i * 4 + 3] = rect.height() / 2 + ((byte) (data.bytes[i+1] + 128)) * (rect.height() / 3 ) /128;
        }
        canvas.drawLines(mPoints, mPaint);
    }
}
