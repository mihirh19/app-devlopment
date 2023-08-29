package com.example.labapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawingView  extends View {
    Paint paint;
    public DrawingView(Context context) {
        super(context);
        init();
    }

    public void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("red"));
        canvas.drawCircle(300,300,150,paint);
        paint.setColor(Color.parseColor("blue"));
        canvas.drawRect(150f,450f,450f,1500f, paint);
        paint.setColor(Color.parseColor("yellow"));
        canvas.drawRect(450f,750f,750f,1500f,paint);
        paint.setColor(Color.parseColor("green"));
        canvas.drawRect(750f,1050f,1050f,1500f, paint);




    }
}
