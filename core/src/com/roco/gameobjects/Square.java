package com.roco.gameobjects;

public class Square {
	private boolean isSelectable;
	private Owner owner;
	private int[] position = new int[2];

	public Square(int x, int y) {
		isSelectable = true;
		owner = Owner.EMPTY;
		position[0] = x;
		position[1] = y;
		// TODO Auto-generated constructor stub
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

	public int getX() {
		return position[0];
	}
	
	public int getY() {
		return position[1];
	}
}
