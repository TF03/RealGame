package com.eugene.game.ui;

import com.badlogic.gdx.InputProcessor;
import com.eugene.game.game.GameWorld;
import com.eugene.game.loader.ResourseLoader;
import com.eugene.game.objects.Fly;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputProcessor {

    private Fly fly;

    private List<PlayButton> menuButtons;
    private PlayButton playButton;

    private GameWorld world;
    private float scaleFactorX;
    private float scaleFactorY;

    public InputHandler(GameWorld world, float scaleFactorX, float scaleFactorY) {
        this.world = world;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

        fly = world.getFly();
        int midPointX = world.getMidPointX();
        int midPointY = world.getMidPointY();

        menuButtons = new ArrayList<PlayButton>();
        playButton = new PlayButton(midPointX - 14.5f, midPointY + 10, 29, 29,
                ResourseLoader.playButtonUp, ResourseLoader.playButtonDown);
        menuButtons.add(playButton);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if (world.isMenu()) {
            playButton.isTouchDown(screenX, screenY);
        } else if (world.isReady()) {
            world.start();
            fly.onClick();
        } else if (world.isRunning()) {
            fly.onClick();
        }

        if (world.isGameOver() || world.isHighScore()) {
            world.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if (world.isMenu()) {
            if (playButton.isTouchUp(screenX, screenY)) {
                world.ready();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }

    public List<PlayButton> getMenuButtons() {
        return menuButtons;
    }
}
