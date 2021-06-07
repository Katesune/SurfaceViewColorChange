package com.example.balls;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class Coloring {
    private int[] pallette = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA, Color.BLACK, Color.YELLOW, Color.LTGRAY};
    Paint[] colors = new Paint[3];

    Coloring() {
        for (int i = 0; i < 3; i++) {
            colors[i] = getColor();
        }
    }

    private int rand(int limit) {
        Random r = new Random();
        int num = r.nextInt(limit);
        return num;
    }

    private Paint getColor(){
        Paint p = new Paint();
        p.setColor(pallette[rand(pallette.length)]);
        return p;
    }

    public void changeColor(int i){
        Paint p = new Paint();
        p.setColor(pallette[rand(pallette.length)]);
        colors[i]=p;
    }

}
