package com.example.balls;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Rect {
    int x, y;
    final int rectSize = 150;
    Paint color;
    private Canvas c;

    public void RectStart(Canvas canvas, Coloring coloring){
        color = coloring.colors[0];
        c = canvas;
    }

    public void RectInBorders(){

        if (x < 0) x = 0;
        if (x + rectSize > c.getWidth()) x = c.getWidth()-(rectSize*2);

        if (y < 0) y = 0;
        if (y + rectSize > c.getHeight()) y = c.getHeight()-(rectSize*2);

    }

    public void drawRect(){
        int w = c.getWidth()/2;
        int h = c.getHeight()/2;

        x = w - rectSize;
        y = h - rectSize;

        c.drawRect(x, y, w + rectSize, h + rectSize, color);
    }

    public Canvas getCanvas(){return c;}

}
