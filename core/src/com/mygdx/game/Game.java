package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Scenes.MainMenuScene.MainMenuScene;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	
	GameStateMachine gameStateMachineS;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		gameStateMachineS = new GameStateMachine(batch);
		gameStateMachineS.setScene(new MainMenuScene(gameStateMachineS));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.6f, 0.7f, 1.f, 1.f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
		gameStateMachineS.update();
		gameStateMachineS.render();
	}
	
	@Override
	public void resize(int width, int height) {
		gameStateMachineS.resize(width, height);
	}
	
	@Override
	public void dispose() {
		gameStateMachineS.dispose();
		super.dispose();
	}
}
