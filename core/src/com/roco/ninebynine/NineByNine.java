package com.roco.ninebynine;

import nbnhelpers.AssetLoader;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.roco.screens.GameScreen;

public class NineByNine extends Game {
	
	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		AssetLoader.dispose();
	}
}
