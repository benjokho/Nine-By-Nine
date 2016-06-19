package com.roco.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.roco.gameobjects.Owner;
import com.roco.gameobjects.Square;

public class GameRenderer {
	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
		// TODO Auto-generated method stub
		for (int i = 0; i < world.SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < world.SQUARE_SIDE_COUNT; j++) {
				//draw square
				if (world.getSquare(i, j).isSelectable()) {
					//XXX draw selected box shit
				}
				switch (world.getSquare(i, j).getOwner()) {
					//XXX draw corresponding square
					case EMPTY:
						break;
					case NEITHER:
						break;
					case PLAYER1:
						break;
					case PLAYER2:
						break;
					default:
						break;
				}	
				
			}
			
		}
	}

}
