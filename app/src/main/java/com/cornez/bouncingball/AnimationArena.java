package com.cornez.bouncingball;

import android.graphics.Canvas;

public class AnimationArena {
    private Ball mBall;
    private Bar mBar;

    public AnimationArena() {
        //INSTANTIATE THE BALL
        mBall = new Ball();
        mBar = new Bar();
    }

    public void update(int width, int height) {

        mBall.move(0, 0, width, height);
        mBar.update();
    }

    public void draw(Canvas canvas) {
        //WIPE THE CANVAS CLEAN
        canvas.drawRGB(156, 174, 216);

        //DRAW THE BALL
        mBall.draw(canvas);
        mBar.draw(canvas);
    }
}
