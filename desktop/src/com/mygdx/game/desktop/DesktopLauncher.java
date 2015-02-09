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
		
		//title
		config.title = "Action RPG Farming Simulator";
		
		
		//MSAA - Multi Sampling Anti Aliasing
		config.samples = 16;
		
		//framelimiter
		config.vSyncEnabled = false;
		config.foregroundFPS = 100;
		config.backgroundFPS = 300;

		// ------------------ //
				
		new LwjglApplication(new Game(), config);
	}
}
