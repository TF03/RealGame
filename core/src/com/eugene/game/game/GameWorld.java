package com.eugene.game.game;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.eugene.game.loader.ResourseLoader;
import com.eugene.game.objects.Fly;
import com.eugene.game.objects.MovHandler;

public class GameWorld {

    private Fly fly;
    private MovHandler movHandler;
    private Rectangle ground;

    private int midPointY;
    private int midPointX;

    private GameRender renderer;

    public GameWorld(int midPointY, int midPointX) {
        this.midPointY = midPointY;
        this.midPointX = midPointX;

        fly = new Fly(33, midPointY - 5, 17, 12);
        movHandler = new MovHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 137, 11);
    }

    public void update(float delta) {
        fly.update(delta);
        movHandler.update(delta);

        if (movHandler.collides(fly) && fly.isAlive()) {
            movHandler.stop();
            fly.die();
            fly.cling();
            ResourseLoader.fall.play();
            renderer.prepareTransition(255, 255, 255, 0.3f);
        }
        if (Intersector.overlaps(fly.getCircle(), ground)) {
            if (fly.isAlive()) {
                ResourseLoader.dead.play();
                fly.die();
                renderer.prepareTransition(255, 255, 255, 0.3f);
            }
            movHandler.stop();
            fly.cling();
        }
    }

    public MovHandler getMovHandler() {
        return movHandler;
    }

    public Fly getFly() {
        return fly;
    }

    public void setRenderer(GameRender renderer) {
        this.renderer = renderer;
    }
}
