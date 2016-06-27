package com.roco.gameobjects;

public enum Owner {
	PLAYER1("1"),
	PLAYER2("2"),
	NEITHER("neither"),
	EMPTY("none");
	
	private final String name;
	private Owner (final String name) { this.name = name;}
	public String toString() {
		return name;
	}
};
