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
		config.title = "Action RPG and Farming Simulator";
		
		
		//MSAA - Multi Sampling Anti Aliasing
		config.samples = 8;
		
		//no framelimiter
		config.foregroundFPS = 60;
		config.backgroundFPS = 20;

		// ------------------ //
				
		new LwjglApplication(new Game(), config);
	}
}
