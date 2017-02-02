package com.eugene.game.game;

import com.eugene.game.objects.Fly;

public class GameWorld {

    private Fly fly;

    private int midPointY;
    private int midPointX;

    public Fly getFly() {
        return fly;
    }

    public GameWorld(int midPointY, int midPointX) {
        this.midPointY = midPointY;
        this.midPointX = midPointX;

        fly = new Fly(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        fly.update(delta);
    }
}
