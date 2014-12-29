package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.GameMap;
import com.mygdx.codeAssets.Tile;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	
	Texture img;
	
	GameMap testMap;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		testMap = new GameMap(10, 10, 2);
		
		testMap.fillWithTile(new Tile());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.6f, 0.7f, 1.f, 1.f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		
		batch.begin();
		
		
		
		
		//batch.draw(img, 0, 0);
		batch.end();
		
		
		
	}
}
