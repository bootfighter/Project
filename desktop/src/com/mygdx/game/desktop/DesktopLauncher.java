package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			
		// -- Config Changes-- //
		
		config.width = 1280;
		config.height = 720;
		
		
		//no framelimiter
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;

		// ------------------ //
				
		new LwjglApplication(new Game(), config);
	}
}
