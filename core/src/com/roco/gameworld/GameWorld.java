package com.roco.gameworld;

import com.roco.gameobjects.Square;

public class GameWorld {
	private final int BORDERX = 30;
	private final int BORDERY = 170;
	private final int SEPARATOR_SMALL = 10;
	private final int SEPARATOR_BIG = 15;
	private final int SQUARE_LENGTH = 30;
	protected int SQUARE_SIDE_COUNT = 9;
	private Square[][] squares;
	
	public GameWorld() {
		//generating squares
		
		
		squares = new Square[SQUARE_SIDE_COUNT][SQUARE_SIDE_COUNT];
		for (int i = 0; i < SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < SQUARE_SIDE_COUNT; j++) {
				int tempBigSeparatorX, tempBigSeparatorY, x, y;
				tempBigSeparatorX = Math.floorDiv(i, 3);
				tempBigSeparatorY = Math.floorDiv(j, 3);
				x = (SQUARE_LENGTH * i) + (tempBigSeparatorX * SEPARATOR_BIG) + ((i - tempBigSeparatorX) * SEPARATOR_SMALL) + BORDERX;
				y = (SQUARE_LENGTH * j)+ (tempBigSeparatorY * SEPARATOR_BIG) + ((j - tempBigSeparatorY) * SEPARATOR_SMALL) + BORDERY;
				squares[i][j] = new Square(x, y);
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
