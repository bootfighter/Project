package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.game.GameParameters.GameState;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	
	GameStateMachine gameStateMachine;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
				

		gameStateMachine = new GameStateMachine(GameState.INGAME, batch);
		
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
