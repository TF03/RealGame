package com.eugene.game.objects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Web extends Moving {

    private Rectangle spider, webUp, webDown;

    public static final int GAP = 45;

    private Random r;
    private float groundY;

    public Web(float x, float y, int width, int height, float movSpeed, float groundY) {
        super(x, y, width, height, movSpeed);
        r = new Random();
        spider = new Rectangle();
        webUp = new Rectangle();
        webDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        webUp.set(position.x, position.y, width, height);
        webDown.set(position.x, position.y + height + GAP, width, groundY - (position.y + height + GAP));
        spider.set(position.x - (24 - width) / 2, position.y + height - 11, 24, 11);
    }

    @Override
    public void reset(float newX) {
        super.reset(newX);
        height = r.nextInt(90) + 15;
    }

    public boolean collides(Fly fly) {
        if (position.x < fly.getX() + fly.getWidth()) {
            return Intersector.overlaps(fly.getCircle(), spider)
                || Intersector.overlaps(fly.getCircle(), webUp)
                || Intersector.overlaps(fly.getCircle(), webDown);
        }
        return false;
    }
}
