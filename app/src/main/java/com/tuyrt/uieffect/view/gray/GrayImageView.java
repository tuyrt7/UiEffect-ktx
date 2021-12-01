package com.tuyrt.uieffect.view.gray;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;

public class GrayImageView extends androidx.appcompat.widget.AppCompatImageView {

    private Paint mPaint = new Paint();

    public GrayImageView(Context context) {
        super(context);
    }

    public GrayImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        mPaint.setColorFilter(new ColorMatrixColorFilter(cm));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(null, mPaint, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        canvas.restore();
    }
}
