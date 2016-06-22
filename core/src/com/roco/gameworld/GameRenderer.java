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
        /*
        if (world.getCurrentLead() == Owner.PLAYER1) {
        	Gdx.gl.glClearColor(0, 1, 0, 1);
        	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        } else if (world.getCurrentLead() == Owner.PLAYER2) {
        	Gdx.gl.glClearColor(0, 0, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
        */
        
		for (int i = 0; i < world.SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < world.SQUARE_SIDE_COUNT; j++) {
				//draw square
				Square tempSquare = world.getSquare(i, j);
				if (tempSquare.isSelectable()) {
					batch.draw(AssetLoader.blockSelector, tempSquare.getX() - 2, tempSquare.getY() - 2);
				}
				switch (tempSquare.getOwner()) {
					//XXX draw corresponding square
					case EMPTY:
						batch.draw(AssetLoader.block8, tempSquare.getX(), tempSquare.getY());
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
		
		//draw settled big squares
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (world.getBigSquaresSettled()[i][j]) {
					switch (world.getBigSquaresRep()[i][j].getOwner()) {
					case PLAYER1:
						batch.draw(AssetLoader.bigBlock1, world.getBigSquaresRep()[i][j].getX(), world.getBigSquaresRep()[i][j].getY());
						break;
					case PLAYER2:
						batch.draw(AssetLoader.bigBlock5, world.getBigSquaresRep()[i][j].getX(), world.getBigSquaresRep()[i][j].getY());
						break;
					default:
						break;
					}
				}
			}
		}
		
		batch.end();
	}

}
