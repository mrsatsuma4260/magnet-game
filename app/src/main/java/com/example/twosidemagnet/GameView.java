package com.example.twosidemagnet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameView extends View {

    final long UPDATE_RATE = 100;

    final Bitmap background;

    final Context context;
    private Bird bird;
    private List<Wall> walls;

    private Rect sceneRect;

    private int width;
    private int height;

    public GameView(final Context context) {
        super(context);

        this.context = context;
        this.bird = new Bird();
        this.walls = new ArrayList<>();

        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        width = size.x;
        height = size.y;

        this.sceneRect = new Rect(0, 0, width, height);

        this.background = BitmapFactory.decodeResource(getResources(), R.drawable.space);

    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, sceneRect, null);
    }
}
