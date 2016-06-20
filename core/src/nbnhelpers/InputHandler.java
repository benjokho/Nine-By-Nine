package nbnhelpers;

import com.badlogic.gdx.InputProcessor;
import com.roco.gameobjects.Square;
import com.roco.gameworld.GameWorld;

public class InputHandler implements InputProcessor{
	private GameWorld world;

	public InputHandler(GameWorld world) {
		super();
		this.world = world;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		//check if a square is clicked
		//SQUARE_SIZE_COUNT
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				//check if a square is clicked
				Square tempSquare = world.getSquare(i, j);
				/*
				if () {
					return true;
				}*/
			}
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
