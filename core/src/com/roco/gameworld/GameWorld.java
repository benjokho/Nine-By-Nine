package com.roco.gameworld;

import nbnhelpers.AssetLoader;

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
	private Square[][] bigSquaresRep = new Square[3][3];
	private boolean[][] bigSquaresSettled = new boolean[3][3];
	private Owner currentPlayer = Owner.PLAYER1;
	private int[] bigSquareCoor = new int[2];
	private Owner currentLead;
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
				
				bigSquaresRep[tempBigSeparatorX][tempBigSeparatorY] = squares[tempBigSeparatorX * 3][tempBigSeparatorY * 3];
				bigSquaresSettled[tempBigSeparatorX][tempBigSeparatorY] = false;
			}
		}
		AssetLoader.partySector.setVolume(0.5f);
		AssetLoader.partySector.setLooping(true);
		AssetLoader.partySector.play();
	}

	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	public void update(Square square) {
		AssetLoader.click1.play();
		square.setOwner(currentPlayer);
		int tempX = square.getCoorX();
		int tempY = square.getCoorY();
		
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
			setCurrentLead(square.getOwner());
			double rand = Math.random();
			int temp = (int) Math.floor(rand * 2);
			
			switch(temp) {
				case 0:
					AssetLoader.objectiveAchieved.play();
					break;
				case 1:
					AssetLoader.powerUp.play();
					break;
				default:
					break;
			}
			bigSquaresSettled[bigSquareCoor[0]][bigSquareCoor[1]] = true;
			fillUpSquare(currentPlayer);
			if (gotThreeInARowBig(square)) {
				// win
				AssetLoader.objectiveAchieved.stop();
				AssetLoader.congratulations.stop();
				AssetLoader.powerUp.stop();
				AssetLoader.youWin.play();
			} else {
				if (noOneWon()) {
					// lose
					AssetLoader.objectiveAchieved.stop();
					AssetLoader.congratulations.stop();
					AssetLoader.powerUp.stop();
					AssetLoader.itsATie.play();
				}
			}
		} else {
			if (isFilledUp(bigSquareCoor)) {
				fillUpSquare(Owner.NEITHER);
				if (noOneWon()) {
					// lose
					AssetLoader.objectiveAchieved.stop();
					AssetLoader.congratulations.stop();
					AssetLoader.powerUp.stop();
					AssetLoader.itsATie.play();
				}
			}
		}
		int[] nextBigSquareCoor = new int[2];
		nextBigSquareCoor[0] = square.getCoorX() % 3;
		nextBigSquareCoor[1] = square.getCoorY() % 3;
		
		if (isFilledUp(nextBigSquareCoor)) {
			makeSelectable();// only Owner.EMPTY
		} else {
			makeSelectable();
			//XXX
			makeSelectable(nextBigSquareCoor);//thenext
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

	private boolean isFilledUp(int[] coor) {
		boolean filledUp = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				if (squares[(coor[0] * 3) + i][(coor[1] * 3) + j].getOwner() == Owner.EMPTY) {
					filledUp = false;
					break;
				}
			}
			if (!filledUp) {
				break;
			}
		}
		return filledUp;
	}

	private void makeSelectable() {
		//makes all Owner.EMPTY selectable
		for (int i = 0; i < SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < SQUARE_SIDE_COUNT; j++) {
				if (squares[i][j].getOwner() == Owner.EMPTY) {
					squares[i][j].setSelectable(true);
				} else {
					squares[i][j].setSelectable(false);
				}
			}
		}
	}
	
	private void makeSelectable(int[] coor) {
		//makes a certain square selectable
		for (int i = 0; i < SQUARE_SIDE_COUNT; i++) {
			for (int j = 0; j < SQUARE_SIDE_COUNT; j++) {	
				squares[i][j].setSelectable(false);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (squares[(coor[0] * 3) + i][(coor[1] * 3) + j].getOwner() == Owner.EMPTY) {
					squares[(coor[0] * 3) + i][(coor[1] * 3) + j].setSelectable(true);
				} else {
					squares[(coor[0] * 3) + i][(coor[1] * 3) + j].setSelectable(false);
				}
			}
		}
	}
	
	private boolean noOneWon() {
		boolean over = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				if (bigSquaresRep[i][j].getOwner() == Owner.EMPTY || !bigSquaresSettled[i][j]) {
					over = false;
					break;
				}
			}
			if (!over) {
				break;
			}
		}
		return over;
	}
	
	private void fillUpSquare(Owner newOwner) {
		for (int i = 0; i < 3; i ++) {
			for ( int j = 0; j < 3; j++) {
				squares[(bigSquareCoor[0] * 3) + i][(bigSquareCoor[1] * 3) + j].setOwner(newOwner);
			}
		}
	}
	private boolean gotThreeInARowBig(Square square) {
		Owner ownerToCheck = square.getOwner();
		boolean firstFlag, secondFlag, thirdFlag;
		
		//check row
		firstFlag = bigSquaresRep[0][bigSquareCoor[1]].getOwner() == bigSquaresRep[1][bigSquareCoor[1]].getOwner(); 
		secondFlag = bigSquaresRep[1][bigSquareCoor[1]].getOwner() == bigSquaresRep[2][bigSquareCoor[1]].getOwner();
		thirdFlag = bigSquaresSettled[0][bigSquareCoor[1]] && bigSquaresSettled[1][bigSquareCoor[1]] && bigSquaresSettled[2][bigSquareCoor[1]]; 
		if (firstFlag && secondFlag && thirdFlag) {
			return true;
		}
		//check col
		firstFlag = bigSquaresRep[bigSquareCoor[0]][0].getOwner() == bigSquaresRep[bigSquareCoor[0]][1].getOwner(); 
		secondFlag = bigSquaresRep[bigSquareCoor[0]][1].getOwner() == bigSquaresRep[bigSquareCoor[0]][2].getOwner();
		thirdFlag = bigSquaresSettled[bigSquareCoor[0]][0] && bigSquaresSettled[bigSquareCoor[0]][1] && bigSquaresSettled[bigSquareCoor[0]][2]; 
		if (firstFlag && secondFlag && thirdFlag) {
			return true;
		}
		
		//updiag
		firstFlag = bigSquaresRep[0][0].getOwner() == bigSquaresRep[1][1].getOwner(); 
		secondFlag = bigSquaresRep[1][1].getOwner() == bigSquaresRep[2][2].getOwner();
		thirdFlag = bigSquaresSettled[0][0] && bigSquaresSettled[1][1] && bigSquaresSettled[2][2]; 
		Gdx.app.log("flags for down diag", firstFlag + " " + secondFlag + " " + thirdFlag);
		if (firstFlag && secondFlag && thirdFlag) {
			return true;
		}	
			
		//downdiag
		firstFlag = bigSquaresRep[2][0].getOwner() == bigSquaresRep[1][1].getOwner(); 
		secondFlag = bigSquaresRep[1][1].getOwner() == bigSquaresRep[0][2].getOwner();
		thirdFlag = bigSquaresSettled[2][0] && bigSquaresSettled[1][1] && bigSquaresSettled[0][2]; 
		Gdx.app.log("flags for up diag", firstFlag + " " + secondFlag + " " + thirdFlag);
		Gdx.app.log("2,0 and 1,1", bigSquaresRep[2][0].getOwner() + " " + bigSquaresRep[1][1].getOwner());
		Gdx.app.log("1,1 and 0,2", bigSquaresRep[1][1].getOwner() + " " + bigSquaresRep[0][2].getOwner());
		if (firstFlag && secondFlag && thirdFlag) {
			return true;
		}	
		
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
			return true;
		}
		//check col
		firstFlag = squares[(bigSquareCoor[0] * 3)][tempY].getOwner() == squares[(bigSquareCoor[0] * 3) + 1][tempY].getOwner(); 
		secondFlag = squares[(bigSquareCoor[0] * 3)][tempY].getOwner() == squares[(bigSquareCoor[0] * 3) + 2][tempY].getOwner();
		if (firstFlag && secondFlag) {
			return true;
		}
		//check if on diag, then check diag
		
		firstFlag = squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3)].getOwner() == squares[(bigSquareCoor[0] * 3) + 2][(bigSquareCoor[1] * 3) + 2].getOwner(); 
		secondFlag = squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3)].getOwner() == squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner();
		thirdFlag = squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3)].getOwner() == square.getOwner();
		if (firstFlag && secondFlag && thirdFlag) {
			return true;
		}	
			
		firstFlag = squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner() == squares[(bigSquareCoor[0] * 3)][(bigSquareCoor[1] * 3) + 2].getOwner(); 
		secondFlag = squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner() == squares[(bigSquareCoor[0] * 3) + 2][(bigSquareCoor[1] * 3)].getOwner();
		thirdFlag = squares[(bigSquareCoor[0] * 3) + 1][(bigSquareCoor[1] * 3) + 1].getOwner() == square.getOwner();
		if (firstFlag && secondFlag && thirdFlag) {
			return true;
		}	
		
		return false;
	}

	public Square getSquare(int x, int y) {
		return squares[x][y];
	}

	public Owner getCurrentLead() {
		return currentLead;
	}

	public void setCurrentLead(Owner currentLead) {
		this.currentLead = currentLead;
	}

	public Square[][] getBigSquaresRep() {
		return bigSquaresRep;
	}

	public void setBigSquaresRep(Square[][] bigSquaresRep) {
		this.bigSquaresRep = bigSquaresRep;
	}

	public boolean[][] getBigSquaresSettled() {
		return bigSquaresSettled;
	}

	public void setBigSquaresSettled(boolean[][] bigSquaresSettled) {
		this.bigSquaresSettled = bigSquaresSettled;
	}
}
