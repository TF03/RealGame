package com.eugene.game.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourseLoader {

    private static TextureAtlas atlas;
    public static Sprite logo, flyAndSpiders, background, grass, fly1, fly2, fly3,
            spider, webUp,webDown, playButtonUp, playButtonDown, ready, retry, gameOver,
            highScore, scoreboard, starOn, starOff;
    public static Animation flyAnimation;
    public static Sound dead, flap, coin, fall;
    public static Music fly;
    public static BitmapFont font, shadow, whiteFont;

    public static void load(){

        atlas = new TextureAtlas(Gdx.files.internal("texture/texture.pack"), true);

        logo = new Sprite(atlas.findRegion("logo"));
        logo.flip(false, true);
        playButtonUp = new Sprite(atlas.findRegion("buttonOff"));
        playButtonDown = new Sprite(atlas.findRegion("buttonOn"));
        ready = new Sprite(atlas.findRegion("tapToFly"));
        retry = new Sprite(atlas.findRegion("retry"));
        gameOver = new Sprite(atlas.findRegion("gameOver"));
        scoreboard = new Sprite(atlas.findRegion("wood"));
        starOn = new Sprite(atlas.findRegion("starOn"));
        starOff = new Sprite(atlas.findRegion("starOff"));
        highScore = new Sprite(atlas.findRegion("highScore"));
        flyAndSpiders = new Sprite(atlas.findRegion("flyAndSpyders"));
        background = new Sprite(atlas.findRegion("background"));
        grass = new Sprite(atlas.findRegion("grass"));
        fly1 = new Sprite(atlas.findRegion("fly1"));
        fly2 = new Sprite(atlas.findRegion("fly2"));
        fly3 = new Sprite(atlas.findRegion("fly3"));
        spider = new Sprite(atlas.findRegion("spider"));
        webUp = new Sprite(atlas.findRegion("webUp"));
        webDown = new Sprite(atlas.findRegion("webDown"));

        TextureRegion[] fly = {fly1, fly2, fly3};
        flyAnimation = new Animation(0.06f, fly);
        flyAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        dead = Gdx.audio.newSound(Gdx.files.internal("sounds/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("sounds/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("sounds/coin.wav"));
        fall = Gdx.audio.newSound(Gdx.files.internal("sounds/fall.wav"));
        ResourseLoader.fly = Gdx.audio.newMusic(Gdx.files.internal("sounds/fly.mp3"));

        font = new BitmapFont(Gdx.files.internal("fonts/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        whiteFont = new BitmapFont(Gdx.files.internal("fonts/whitetext.fnt"));
        whiteFont.getData().setScale(.1f, -.1f);
        shadow = new BitmapFont(Gdx.files.internal("fonts/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);

    }
    public static void dispose(){
        atlas.dispose();

        dead.dispose();
        flap.dispose();
        coin.dispose();
        fly.dispose();

        font.dispose();
        shadow.dispose();
    }

}
