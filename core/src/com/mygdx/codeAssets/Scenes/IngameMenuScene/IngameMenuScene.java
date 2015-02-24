package com.mygdx.codeAssets.Scenes.IngameMenuScene;

import com.badlogic.gdx.Gdx;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Scenes.IngameSceneAbstract;
import com.mygdx.codeAssets.Scenes.IngameScene.IngameScene;
import com.mygdx.codeAssets.Scenes.MainMenuScene.MainMenuScene;

public class IngameMenuScene extends IngameSceneAbstract {


	public IngameMenuScene(GameStateMachine a_gameStateMachine, PlayerHandler a_playerHandler, MapHandler a_mapHandler, RenderHandler a_renderHandler){
		super(a_gameStateMachine);
		
		currentUIHandler = new IngameMenuUIHandler(this);
		currentMapHandler = a_mapHandler;
		currentPlayerHandler = a_playerHandler;
		a_renderHandler.setUIHandler(currentUIHandler);
		currentRenderHandler = a_renderHandler;
		currentEventHandler = new IngameMenuEventHandler(currentRenderHandler, currentUIHandler, this);
		Gdx.input.setInputProcessor(currentEventHandler);

	}
	
	@Override
	public void setNewState(GameState a_gameState) {
		switch (a_gameState) {
		case INGAME:
			gameStateMachine.setScene(new IngameScene(gameStateMachine, currentMapHandler, currentPlayerHandler, currentRenderHandler));
			break;
			
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
		// TODO Auto-generated method stub
		
	}

	
	
}
