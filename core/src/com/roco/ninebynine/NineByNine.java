package com.roco.ninebynine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.roco.nbnhelpers.AssetLoader;
import com.roco.screens.GameScreen;
import com.roco.screens.MenuScreen;

public class NineByNine extends Game {
	
	@Override
	public void create (){
		AssetLoader.load();
		AssetLoader.partySector.setVolume(0.5f);
		AssetLoader.partySector.setLooping(true);
		AssetLoader.partySector.play();
		//setScreen(new GameScreen());
		setScreen(new MenuScreen(this));
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		AssetLoader.dispose();
	}
}
