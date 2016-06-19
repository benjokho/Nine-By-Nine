package com.roco.gameworld;

import com.roco.gameobjects.Square;

public class GameWorld {
	protected int SQUARE_SIDE_COUNT = 9;
	private Square[][] squares;
	
	public GameWorld() {
		squares = new Square[SQUARE_SIDE_COUNT][SQUARE_SIDE_COUNT];
		for (int i = 0; i < SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < SQUARE_SIDE_COUNT; j++) {
				squares[i][j] = new Square(i, j);
			}
		}
	}

	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	public Square getSquare(int x, int y) {
		return squares[x][y];
	}
}
