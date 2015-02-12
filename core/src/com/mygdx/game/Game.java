package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Objects.GameStateMutable;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	
	GameStateMachine gameStateMachine;

	GameStateMutable gameState;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameState = new GameStateMutable(GameState.MAINMENU);
		
		gameStateMachine = new GameStateMachine(gameState, batch);
	}

	
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0.6f, 0.7f, 1.f, 1.f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
		gameStateMachine.update();
	}
	
	@Override
	public void resize(int width, int height) {
		gameStateMachine.resize(width, height);
	}
}
