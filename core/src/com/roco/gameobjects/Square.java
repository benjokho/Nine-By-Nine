package com.roco.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Square {
	private boolean isSelectable;
	private Owner owner;
	private Vector2 position;//like actual position not coor
	private final int SQUARE_SIZE = 30;
	private int[] coor = new int[2]; //smallSquareCoor
	public Square(int x, int y, int i, int j) {
		isSelectable = true;
		owner = Owner.EMPTY;
		position = new Vector2(x, y);
		coor[0] = i;
		coor[1] = j;
		// TODO Auto-generated constructor stub
	}

	public void onClick() {
		
    }
	
	public boolean isSelectable() {
		return isSelectable;
	}

	public void setSelectable(boolean isSelectable) {
		this.isSelectable = isSelectable;
	}

	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public float getX() {
		//like actual x, where it is on screenx
		return position.x;
	}
	
	public float getY() {
		//like actual y, where it is on screeny
		return position.y;
	}
	
	public int getSquareSize() {
		return SQUARE_SIZE;
	}

	public int getCoorX() {
		return coor[0];
	}
	
	public int getCoorY() {
		return coor[1];
	}
}
