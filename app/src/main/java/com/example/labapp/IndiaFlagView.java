package com.example.labapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class IndiaFlagView extends View {
    Paint paint;
    public IndiaFlagView(Context context) {
        super(context);
        init();
    }
    public void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.parseColor("#ff671f"));
        canvas.drawRect(300f,300f,1200f,500f, paint);
        paint.setColor(Color.parseColor("white"));
        canvas.drawRect(300f,500f,1200f,700f, paint);
        paint.setColor(Color.parseColor("green"));
        canvas.drawRect(300f,700f, 1200f, 900f, paint);

        paint.setColor(Color.parseColor("blue"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        canvas.drawCircle(750f, 600f, 100f, paint);
        for(int i=0; i<24; i++) {
            canvas.drawLine(750, 500, 750, 700, paint);
            canvas.rotate((float)15, 750,600);
        }

    }
}
