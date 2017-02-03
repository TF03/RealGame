package com.eugene.game.game;

import com.eugene.game.objects.Fly;
import com.eugene.game.objects.MovHandler;

public class GameWorld {

    private Fly fly;
    private MovHandler movHandler;

    private int midPointY;
    private int midPointX;

    public GameWorld(int midPointY, int midPointX) {
        this.midPointY = midPointY;
        this.midPointX = midPointX;

        fly = new Fly(33, midPointY - 5, 17, 12);
        movHandler = new MovHandler(this, midPointY + 66);
    }

    public void update(float delta) {
        fly.update(delta);
        movHandler.update(delta);
    }

    public MovHandler getMovHandler() {
        return movHandler;
    }

    public Fly getFly() {
        return fly;
    }
}
