package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Handlers.*;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera orthoCamera;
	
	PlayerHandler playerHandler;
	MapHandler mapHandler;
	EventHandler eventHandler;
	RenderHandler renderHandler;
	
	
	
	Texture img;
	Texture dirtTexture;
//	GameMap testMap;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
				
		playerHandler = new PlayerHandler();
		mapHandler = new MapHandler(playerHandler);
		renderHandler = new RenderHandler(mapHandler, playerHandler, batch);
		eventHandler = new EventHandler(mapHandler, playerHandler, renderHandler);
		
		Gdx.input.setInputProcessor(eventHandler);
		
		//textures
		img = new Texture("badlogic.jpg");
		dirtTexture = new Texture("dirt.png");
	}

	
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0.6f, 0.7f, 1.f, 1.f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderHandler.draw();
		mapHandler.update();
		playerHandler.update();
	
	}
}
