package com.cornez.bouncingball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Ball {
    private final int RADIUS = 50;
    private final int REVERSE = -1;
    static int x, oldx;
    static int y, oldy;
    static int velX;
    static int velY;

    public Ball() {
        Random r=new Random();
        x = r.nextInt(200);
        y = r.nextInt(200);
        velX = 10+r.nextInt(10);
        velY = 10+r.nextInt(10);
    }

    public void move(int leftWall, int topWall,
                     int rightWall, int bottomWall) {
        //MOVE BALL
        oldx = x;
        oldy = y;
        x += velX;
        y += velY;

        //CHECK FOR COLLISIONS ALONG WALLS
        if (y > bottomWall - RADIUS) {
            y = bottomWall - RADIUS;
            velY *= REVERSE;
        } else if (y < topWall + RADIUS) {
            y = topWall + RADIUS;
            velY *= REVERSE;
        }

        if (x > rightWall - RADIUS) {
            x = rightWall - RADIUS;
            velX *= REVERSE;
        } else if (x < leftWall + RADIUS) {
            x = leftWall + RADIUS;
            velX *= REVERSE;
        }
    }

    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.rgb(211, 216, 156));
        canvas.drawCircle(x, y, RADIUS, paint);

    }
}
