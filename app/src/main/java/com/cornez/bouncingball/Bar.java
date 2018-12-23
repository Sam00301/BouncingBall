package com.cornez.bouncingball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bar {
    int bar_x;
    int bar_y;
    boolean hit;
    private Paint paint = new Paint();

    Bar() {
        bar_x = 600;
        bar_y = 1000;
        hit = false;
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
    }


    void update() {
        if (MyActivity.move) {
            bar_x = MyActivity.x;
            bar_y = MyActivity.y - 200;
        }

        if (Math.abs(Ball.x - bar_x) <= 200 && Math.abs(Ball.y - bar_y) <= 70) {
            hit = true;
        }

        if (hit) {
            if (200 - Math.abs(Ball.x - bar_x) > 70 - Math.abs(Ball.y - bar_y)) {
                Ball.velY *= -1;
                hit = false;
            } else {
                Ball.velX *= -1;
                hit = false;
            }
        }
    }

    void draw(Canvas canvas) {
        canvas.drawRect(bar_x - 150, bar_y - 20, bar_x + 150, bar_y + 20, paint);
    }
}
