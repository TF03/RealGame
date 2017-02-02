package com.eugene.game;

import com.badlogic.gdx.Game;
import com.eugene.game.loader.ResourseLoader;
import com.eugene.game.screens.SplashScreen;

public class RealGame extends Game {

	@Override
	public void create () {
		ResourseLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		ResourseLoader.dispose();
	}
}
