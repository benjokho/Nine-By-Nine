package com.roco.screens;

import nbnhelpers.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.roco.gameworld.GameRenderer;
import com.roco.gameworld.GameWorld;

public class GameScreen implements Screen {
	float screenWidth, screenHeight;   
    float gameWidth, gameHeight;
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime = 0;
	
	public GameScreen() {
		float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();      
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
		world = new GameWorld();
		renderer = new GameRenderer(world);
		
		Gdx.input.setInputProcessor(new InputHandler(world));
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
