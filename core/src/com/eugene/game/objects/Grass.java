package com.eugene.game.objects;

public class Grass extends Moving {

    public Grass(float x, float y, int width, int height, float movSpeed) {
        super(x, y, width, height, movSpeed);
    }

    public void onRestart(float tailX, int movSpeed) {
        position.x = tailX;
        velocity.y = movSpeed;
    }
}
