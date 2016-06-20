package com.roco.gameworld;

import com.badlogic.gdx.Gdx;
import com.roco.gameobjects.Owner;
import com.roco.gameobjects.Square;

public class GameWorld {
	private final int BORDERX = 30;
	private final int BORDERY = 170;
	private final int SEPARATOR_SMALL = 10;
	private final int SEPARATOR_BIG = 15;
	private final int SQUARE_LENGTH = 30;
	protected int SQUARE_SIDE_COUNT = 9;
	private Square[][] squares;
	private Square[][] bigSquares;
	private Owner currentPlayer = Owner.PLAYER1;
	private int[] bigSquareCoor = new int[2];
	
	public GameWorld() {
		// generating squares

		squares = new Square[SQUARE_SIDE_COUNT][SQUARE_SIDE_COUNT];
		for (int i = 0; i < SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < SQUARE_SIDE_COUNT; j++) {
				int tempBigSeparatorX, tempBigSeparatorY, x, y;
				tempBigSeparatorX = Math.floorDiv(i, 3);
				tempBigSeparatorY = Math.floorDiv(j, 3);
				x = (SQUARE_LENGTH * i) + (tempBigSeparatorX * SEPARATOR_BIG)
						+ ((i - tempBigSeparatorX) * SEPARATOR_SMALL) + BORDERX;
				y = (SQUARE_LENGTH * j) + (tempBigSeparatorY * SEPARATOR_BIG)
						+ ((j - tempBigSeparatorY) * SEPARATOR_SMALL) + BORDERY;
				squares[i][j] = new Square(x, y, i, j);
			}
		}

		bigSquares = new Square[3][3];

		bigSquares[0][0] = squares[0][0];
		bigSquares[1][0] = squares[3][0];
		bigSquares[2][0] = squares[6][0];

		bigSquares[0][1] = squares[0][3];
		bigSquares[1][1] = squares[3][3];
		bigSquares[2][1] = squares[6][3];

		bigSquares[0][2] = squares[0][6];
		bigSquares[1][2] = squares[3][6];
		bigSquares[2][2] = squares[6][6];
	}

	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	public void update(Square square) {
		// TODO Auto-generated method stub
		// change square color
		square.setOwner(currentPlayer);
		int tempX = square.getCoorX();
		int tempY = square.getCoorY();
		Gdx.app.log("x and y", tempX + " " + tempY);
		if (tempX < 3) {
			bigSquareCoor[0] = 0;
		} else if (tempX < 6) {
			bigSquareCoor[0] = 1;
		} else {
			bigSquareCoor[0] = 2;
		}
		if (tempY < 3) {
			bigSquareCoor[1] = 0;
		} else if (tempY < 6) {
			bigSquareCoor[1] = 1;
		} else {
			bigSquareCoor[1] = 2;
		}
		
		if (gotThreeInARowSmall(square)) {
			for (int i = 0; i < 3; i ++) {
				for ( int j = 0; j < 3; j++) {
					squares[(bigSquareCoor[0] * 3) + i][(bigSquareCoor[1] * 3) + j].setOwner(currentPlayer);
					Gdx.app.log("bigSquareCoor", ((bigSquareCoor[0] * 3) + i) + " " + ((bigSquareCoor[1] * 3) + j));
				}
			}
			if (gotThreeInARowBig(square)) {
				// win
			} else {
				if (true /* all squares are Owner.NEITHER */) {
					// lose
				}
			}
		} else {
			// check if 3x3 is full
			if (true /* 3x3 full */) {
				// change all squares to Owner.NEITHER Color
				if (true /* all squares are Owner.NEITHER */) {
					// lose
				}
			}
		}

		if (true /* next 3x3 square is full */) {
			// make all Owner.EMPTY squares selectable
		} else {
			// make only that 3x3 square selectable
		}

		switch (this.currentPlayer) {
		case PLAYER1:
			currentPlayer = Owner.PLAYER2;
			break;
		case PLAYER2:
			currentPlayer = Owner.PLAYER1;
			break;
		default:
			break;
		}
	}

	private boolean gotThreeInARowBig(Square square) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean gotThreeInARowSmall(Square square) {
		int tempX = square.getCoorX();
		int tempY = square.getCoorY();//smallSquareCoor
		boolean firstFlag, secondFlag, thirdFlag;
		//check row
		firstFlag = squares[tempX][(bigSquareCoor[1] * 3)].getOwner() == squares[tempX][(bigSquareCoor[1] * 3) + 1].getOwner(); 
		secondFlag = squares[tempX][(bigSquareCoor[1] * 3)].getOwner() == squares[tempX][(bigSquareCoor[1] * 3) + 2].getOwner();
		if (firstFlag && secondFlag) {
			Gdx.app.log("true", "row");
			return true;
		}
		//check col
		firstFlag = squares[(bigSquareCoor[0] * 3)][tempY].getOwner() == squares[(bigSquareCoor[0] * 3) + 1][tempY].getOwner(); 
		secondFlag = squares[(bigSquareCoor[0] * 3)][tempY].getOwner() == squares[(bigSquareCoor[0] * 3) + 2][tempY].getOwner();
		if (firstFlag && secondFlag) {
			Gdx.app.log("true", "col");
			return true;
		}
		//check if on diag, then check diag
		if (tempX == tempY) {
			firstFlag = squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3)].getOwner() == squares[(bigSquareCoor[0] * 3) + 2][(bigSquareCoor[1] * 3) + 2].getOwner(); 
			secondFlag = squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3)].getOwner() == squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner();
			thirdFlag = squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3)].getOwner() == square.getOwner();
			if (firstFlag && secondFlag && thirdFlag) {
				Gdx.app.log("true", "dia");
				return true;
			}	
			
			firstFlag = squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner() == squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[0] * 3) + 2].getOwner(); 
			secondFlag = squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner() == squares[(bigSquareCoor[0] * 3) + 2][(bigSquareCoor[1] * 3)].getOwner();
			thirdFlag = squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner() == square.getOwner();
			if (firstFlag && secondFlag && thirdFlag) {
				Gdx.app.log("true", "row");
				return true;
			}	
		}
		return false;
	}

	public Square getSquare(int x, int y) {
		return squares[x][y];
	}
}
