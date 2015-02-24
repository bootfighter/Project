package com.mygdx.codeAssets.Scenes.CreditsScene;

import com.badlogic.gdx.Gdx;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Scenes.SceneAbstract;
import com.mygdx.codeAssets.Scenes.MainMenuScene.MainMenuRenderHandler;
import com.mygdx.codeAssets.Scenes.MainMenuScene.MainMenuScene;

public class CreditsScene extends SceneAbstract{

	public CreditsScene(GameStateMachine a_gameStateMachine) {
		super(a_gameStateMachine);
		
		currentUIHandler = new CreditsUIHandler(this);
		currentRenderHandler = new MainMenuRenderHandler(currentUIHandler, gameStateMachine.getBatch(), this);
		currentEventHandler = new CreditsEventHandler(currentRenderHandler, currentUIHandler, this);
		Gdx.input.setInputProcessor(currentEventHandler);

	}

	@Override
	public void setNewState(GameState a_gameState) {
		switch (a_gameState) {
		case MAINMENU:
			gameStateMachine.setScene(new MainMenuScene(gameStateMachine));
			break;
		default:
			break;
		}
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
