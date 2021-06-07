package com.example.balls;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Balls {
    ArrayList<Integer> koord = new ArrayList<Integer>(4);
    private boolean[] track =  new boolean[4];
    private Coloring coloring;
    private Canvas c;

    Balls(Canvas canvas, Coloring col) {
        c = canvas;
        setKoord();
        setTrack();
        coloring = col;
    }

    public int rand(int limit) {
        Random r = new Random();
        int num = r.nextInt(limit);
        return num;
    }

    public void CnangeCircleInRect(Rect r) {

        for (int i=0; i<2; i++) {
            if (CircleCoordInRect(i, r.x, r.rectSize)) {
                changeMotionCircle(0);
                coloring.changeColor(1);
            }
        }

        for (int i=2; i<4; i++) {
            if (CircleCoordInRect(i, r.y, r.rectSize)) {
                changeMotionCircle(2);
                coloring.changeColor(2);
            }
        }
    }

    public boolean CircleCoordInRect(int i, int rectKoord, int rectSize){
        return koord.get(i)>rectKoord && koord.get(i)<rectKoord+(rectSize*2);
    }

    public void CnangeIfCircleInBorder(){

        for (int i=0; i<2; i++) {
            if (CircleCoordNotInBorder(i, c.getWidth())) {
                changeMotionCircle(i);
            }
        }

        for (int i=2; i<4; i++) {
            if (CircleCoordNotInBorder(i, c.getHeight())) {
                changeMotionCircle(i);
            }
        }
    }

    public boolean CircleCoordNotInBorder(int i, int border){
        return koord.get(i)<0 || koord.get(i)>border;
    }

    private void changeMotionCircle(int i){
        track[i] = !track[i];
    }

    public void koordRight(Rect r) {

            for (int i = 0; i < 2; i++) {
                while ( (CircleCoordNotInBorder(i, c.getWidth())) || (
                        CircleCoordInRect(i, r.x, r.rectSize)) )

                    koord.set(i, rand(c.getWidth()));
            }

            for (int i = 2; i < 4; i++) {
                while ( (CircleCoordNotInBorder(i, c.getHeight())) || (
                        CircleCoordInRect(i, r.y, r.rectSize)) )

                    koord.set(i, rand(c.getHeight()));
            }
    }

    public void setKoord() {

        int w = c.getWidth();
        int h = c.getHeight();

        for (int i=0; i<2;i++) {
            koord.add(rand(w));
        }

        for (int i=0; i<2;i++) {
            koord.add(rand(h));
        }

        Log.d("koord", "response: " +koord.size());

    }

    public void setTrack(){
        for (int i=0; i<3;i++) {
            if (rand(1) == 0) track[i]=true;
            else track[i]=false;
        }
    }

    public void drawCircles() {
        c.drawCircle(koord.get(0), koord.get(2), 50, coloring.colors[1]);
        c.drawCircle(koord.get(1), koord.get(3), 50, coloring.colors[2]);
    }

    public void CircleMoves(int i) {
        if (track[i]==true) {
            koord.set(i, koord.get(i)+1);
        } else {
            koord.set(i, koord.get(i)-1);
        }
    }

    public void CirclesMoves() {
        for (int i =0 ; i<koord.size()-2; i++){
            CircleMoves(i);
        }
    }

}
