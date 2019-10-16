package com.erkuai.workview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2019/10/16.
 */

public class WorkView2 extends View {

    //直线
    private Paint linePaint;
    private int lineColor;
    private float lineWidth;

    //始末坐标
    private float startX;
    private float startY;
    private float endX;
    private float endY;

    //A点坐标
    private float aX;
    private float aY;
    private Bitmap bitmapA;

    //B点坐标
    private float bX;
    private float bY;
    private Bitmap bitmapB;

    //小车
    private float carX;
    private float carY;
    private Bitmap bitmapCar;

    //虚线
    private Paint imaginaryPaint;
    private int imaginaryColor;
    private float imaginaryWidth;

    //虚线间隔
    private float interval;

    //绿地
    private Paint greenbeltPaint;
    private int greenbeltColor;


    public WorkView2(Context context) {
        this(context, null);
    }

    public WorkView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WorkView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.WorkView);
        lineColor = array.getColor(R.styleable.WorkView_lineColor, Color.RED);
        lineWidth = array.getFloat(R.styleable.WorkView_lineWidth, Utils.dp2px(2));
        imaginaryColor = array.getColor(R.styleable.WorkView_imaginaryColor, Color.RED);
        imaginaryWidth = array.getFloat(R.styleable.WorkView_imaginaryWidth, Utils.dp2px(2));
        greenbeltColor = array.getColor(R.styleable.WorkView_greenbeltColor, Color.GREEN);
        interval = array.getFloat(R.styleable.WorkView_interval, Utils.dp2px(100));
        array.recycle();

        //直线
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(lineWidth);

        //虚线
        imaginaryPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        imaginaryPaint.setColor(imaginaryColor);
        imaginaryPaint.setStrokeWidth(imaginaryWidth);
        imaginaryPaint.setPathEffect(new DashPathEffect(new float[]{20f, 10f}, 0));

        //绿地
        greenbeltPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        greenbeltPaint.setColor(greenbeltColor);

        //A点、B点、小车
        bitmapA = BitmapFactory.decodeResource(getResources(), R.drawable.icon_a);
        bitmapB = BitmapFactory.decodeResource(getResources(), R.drawable.icon_b);
        bitmapCar = BitmapFactory.decodeResource(getResources(), R.drawable.icon_car);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        startX = getWidth() / 2;
        startY = getHeight();
        endX = getWidth() / 2;
        endY = 0;

        aX = getWidth() / 2;
        aY = getHeight() - 200;

        bX = getWidth() / 2;
        bY = 200;

        carX = aX;
        carY = aY;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

     //   canvas.drawLine(startX, startY, endX, endY, linePaint);
        //左边
      //  canvas.drawLine(startX - interval, startY, endX - interval, endY, imaginaryPaint);
        //右边
      //  canvas.drawLine(startX + interval, startY, endX + interval, endY, imaginaryPaint);

      //  canvas.drawBitmap(bitmapA, aX - bitmapA.getWidth() / 2, aY - bitmapA.getHeight() / 2, linePaint);
      //  canvas.drawBitmap(bitmapB, bX - bitmapB.getWidth() / 2, bY - bitmapB.getHeight() / 2, linePaint);
        canvas.drawBitmap(bitmapCar, carX - bitmapCar.getWidth() / 2, carY - bitmapCar.getHeight() / 2, linePaint);

        //绿色区域
       // canvas.drawRect(startX - interval, carY + bitmapCar.getHeight() / 2, startX + interval, startY, greenbeltPaint);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (bitmapA != null) {
            bitmapA.recycle();
        }
        if (bitmapB != null) {
            bitmapB.recycle();
        }
        if (bitmapCar != null) {
            bitmapCar.recycle();
        }
    }

    public void setCarX(float carX) {
        this.carX = carX;
        postInvalidate();
    }

    public void setCarY(float carY) {
        this.carY = carY;
        postInvalidate();
    }

    public float getCarX() {
        return carX;
    }

    public float getCarY() {
        return carY;
    }

    public Bitmap getBitmapCar() {
        return bitmapCar;
    }
}
