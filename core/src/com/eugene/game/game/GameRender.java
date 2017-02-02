package com.eugene.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.eugene.game.loader.ResourseLoader;
import com.eugene.game.objects.Fly;

public class GameRender {

    private int midPointY;
    private int midPointX;

    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;
    private Fly fly;

    public static Sprite background, grass, flyMid, spider, webUp, webDown, ready,
            flyLogo, gameOver, highScore, scoreboard, starOn, starOff, retry;
    public static Animation flyAnimation;
    public static Music music;

    public GameRender(GameWorld world, int gameHeight, int midPointY, int midPointX) {
        this.world = world;
        this.midPointY = midPointY;
        this.midPointX = midPointX;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, gameHeight);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        initGameObjects();
        initAssets();
    }

    public void render(float delta, float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(186 / 255.0f, 224 / 255.0f, 213 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        shapeRenderer.setColor(167 / 255.0f, 211 / 255.0f, 152 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        shapeRenderer.setColor(75 / 255.0f, 136 / 255.0f, 178 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 53);

        shapeRenderer.end();

        batch.begin();
        batch.disableBlending();

        batch.draw(background, 0, midPointY + 23, 136, 43);

        batch.enableBlending();

        drawFly(runTime);

        batch.end();
    }

    private void initAssets() {
        background = ResourseLoader.background;
        grass = ResourseLoader.grass;
        flyAnimation = ResourseLoader.flyAnimation;
        flyMid = ResourseLoader.fly2;
        spider = ResourseLoader.spider;
        webUp = ResourseLoader.webUp;
        webDown = ResourseLoader.webDown;
        ready = ResourseLoader.ready;
        flyLogo = ResourseLoader.flyAndSpiders;
        gameOver = ResourseLoader.gameOver;
        highScore = ResourseLoader.highScore;
        scoreboard = ResourseLoader.scoreboard;
        retry = ResourseLoader.retry;
        starOff = ResourseLoader.starOff;
        starOn = ResourseLoader.starOn;
        music = ResourseLoader.fly;
    }

    private void initGameObjects() {
        fly = world.getFly();
    }

    private void drawFly(float runTime) {

        if (fly.notFlap()) {
            batch.draw(flyMid, fly.getX(), fly.getY(), fly.getWidth() / 2.0f, fly.getHeight() / 2.0f,
                    fly.getWidth(), fly.getHeight(), 1, 1, fly.getRotation());
        } else {
            batch.draw((TextureRegion) flyAnimation.getKeyFrame(runTime),
                    fly.getX(), fly.getY(), fly.getWidth() / 2.0f, fly.getHeight() / 2.0f,
                    fly.getWidth(), fly.getHeight(), 1, 1, fly.getRotation());
        }

    }
}
