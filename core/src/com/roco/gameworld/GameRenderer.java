package com.roco.gameworld;

import nbnhelpers.AssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.roco.gameobjects.Owner;
import com.roco.gameobjects.Square;

public class GameRenderer {
	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batch;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        batch.disableBlending();
		for (int i = 0; i < world.SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < world.SQUARE_SIDE_COUNT; j++) {
				//draw square
				Square tempSquare = world.getSquare(i, j);
				if (tempSquare.isSelectable()) {
					//XXX draw selected box shit
				}
				switch (tempSquare.getOwner()) {
					//XXX draw corresponding square
					case EMPTY:
						batch.draw(AssetLoader.block7, tempSquare.getX(), tempSquare.getY());
						break;
					case NEITHER:
						batch.draw(AssetLoader.block3, tempSquare.getX(), tempSquare.getY());
						break;
					case PLAYER1:
						batch.draw(AssetLoader.block1, tempSquare.getX(), tempSquare.getY());
						break;
					case PLAYER2:
						batch.draw(AssetLoader.block5, tempSquare.getX(), tempSquare.getY());
						break;
					case PLAYER1CAPTURED:
						batch.draw(AssetLoader.block2, tempSquare.getX(), tempSquare.getY());
						break;
					case PLAYER2CAPTURED:
						batch.draw(AssetLoader.block4, tempSquare.getX(), tempSquare.getY());
						break;
					default:
						batch.draw(AssetLoader.block6, tempSquare.getX(), tempSquare.getY());
						break;
				}
				
			}
			
		}
		batch.end();
	}

}
