package com.roco.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.roco.gameobjects.Owner;
import com.roco.gameobjects.Square;
import com.roco.nbnhelpers.AssetLoader;

public class GameRenderer {
	private GameWorld world;
	private OrthographicCamera cam;
	
	private Stage uiStage;
	private SpriteBatch batch;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {
		//blank everything
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        batch.disableBlending();
                 
        //choose bigSquare selected;
        /*
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(world, y, width, height);
        shapeRenderer.end();
        */
        
        //draw squares
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
		
		//draw text
		switch (world.getCurrentState()) {
			case READY:
				break;
			case RESTART:
				break;
			case RUNNING:
				AssetLoader.font1.draw(batch, world.getCurrentPlayer().toString(), 50, Gdx.graphics.getHeight() - 150);
				if (world.getCurrentPlayer() == Owner.PLAYER1) {
					batch.draw(AssetLoader.block1, 60, Gdx.graphics.getHeight() - 130);
				} else if (world.getCurrentPlayer() == Owner.PLAYER2) {
					batch.draw(AssetLoader.block5, 80, Gdx.graphics.getHeight() - 130);
				}
				break;
			case WIN:
				AssetLoader.font1.draw(batch, "Player " + world.getCurrentPlayer().toString() + " wins!", 50, Gdx.graphics.getHeight() - 150);
				AssetLoader.font1.draw(batch, "Again?", 50, Gdx.graphics.getHeight() - 100);
				break;
			case TIE:
				AssetLoader.font1.draw(batch, "Tie!", 50, Gdx.graphics.getHeight() - 150);
				AssetLoader.font1.draw(batch, "Again?", 50, Gdx.graphics.getHeight() - 100);
				break;
			case LOSE:
				break;
			default:
				break;
		}
		//AssetLoader.font1.draw(batch, "OWNAGE", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		
		batch.end();
	}

}
