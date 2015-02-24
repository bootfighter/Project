package com.mygdx.codeAssets.Scenes.MainMenuScene;

import com.badlogic.gdx.Gdx;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Scenes.SceneAbstract;
import com.mygdx.codeAssets.Scenes.CreditsScene.CreditsScene;
import com.mygdx.codeAssets.Scenes.IngameScene.IngameScene;

public class MainMenuScene extends SceneAbstract{

	public MainMenuScene( GameStateMachine a_gameStateMachine) {
		super(a_gameStateMachine);
		currentUIHandler = new MainMenuUIHandler(this);
		currentRenderHandler = new MainMenuRenderHandler(currentUIHandler, gameStateMachine.getBatch(), this);
		currentEventHandler = new MainMenuEventHandler(currentRenderHandler, currentUIHandler, this);
		Gdx.input.setInputProcessor(currentEventHandler);

	}

	
	@Override
	public void setNewState(GameState a_gameState) {
		switch (a_gameState) {
		case INGAME:
			gameStateMachine.setScene(new IngameScene(gameStateMachine));			
			break;
		
		case CREDITS:
			gameStateMachine.setScene(new CreditsScene(gameStateMachine));
			break;
		case EXIT:
			gameStateMachine.dispose();
			break;
		default:
			break;
		}
	}
	
	public void setNewState(GameState a_gameState, String a_info){
		
		//TODO: load game with the given information
		
	}
	
	
	@Override
	public void update() {
		currentUIHandler.update();
	}

	@Override
	public void render() {
		currentRenderHandler.draw();
	}

	@Override
	public void resize(int width, int height) {
		currentRenderHandler.resize(width, height);
	}

	@Override
	public void dispose() {
		
	}

}
