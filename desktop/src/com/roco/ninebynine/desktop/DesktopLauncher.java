package com.roco.ninebynine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.roco.ninebynine.NineByNine;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Nine By Nine";
		config.width = 420;
		config.height = 700;
		new LwjglApplication(new NineByNine(), config);
	}
}
