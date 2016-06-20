package com.roco.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Square {
	private boolean isSelectable;
	private Owner owner;
	private Vector2 position;
	private final int SQUARE_SIZE = 30;
	
	public Square(int x, int y) {
		isSelectable = true;
		owner = Owner.EMPTY;
		position = new Vector2(x, y);
		
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
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public int getSquareSize() {
		return SQUARE_SIZE;
	}
}
