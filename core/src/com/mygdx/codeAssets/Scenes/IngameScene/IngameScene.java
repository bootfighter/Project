package com.mygdx.codeAssets.Scenes.IngameScene;

import com.badlogic.gdx.Gdx;
import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Scenes.IngameSceneAbstract;
import com.mygdx.codeAssets.Scenes.IngameMenuScene.IngameMenuScene;
import com.mygdx.codeAssets.Scenes.MainMenuScene.MainMenuScene;

public class IngameScene extends IngameSceneAbstract{

	public IngameScene(GameStateMachine a_gameStateMachine) {
		super(a_gameStateMachine);
		
		currentMapHandler = new MapHandler();
		currentPlayerHandler = new PlayerHandler(currentMapHandler, this);
		currentUIHandler = new IngameUIHandler(currentPlayerHandler, this);
		currentRenderHandler = new IngameRenderHandler(currentMapHandler, currentPlayerHandler, currentUIHandler, gameStateMachine.getBatch() ,this);
		currentEventHandler = new IngameEventHandler(currentMapHandler, currentPlayerHandler, currentRenderHandler, currentUIHandler, this);
		
		Gdx.input.setInputProcessor(currentEventHandler);
	}
	
	
	
	public IngameScene(GameStateMachine a_gameStateMachine, MapHandler a_mapHandler, PlayerHandler a_playerHandler, RenderHandler a_renderHandler) {
		super(a_gameStateMachine);
		
		currentMapHandler = a_mapHandler;
		currentPlayerHandler = a_playerHandler;
		currentUIHandler = new IngameUIHandler(currentPlayerHandler, this);
		a_renderHandler.setUIHandler(currentUIHandler);
		currentRenderHandler = a_renderHandler;
		currentEventHandler = new IngameEventHandler(currentMapHandler, currentPlayerHandler, currentRenderHandler, currentUIHandler, this);
		
		Gdx.input.setInputProcessor(currentEventHandler);
	}	
	
	@Override
	public void setNewState(GameState a_gameState) {
	
		switch (a_gameState) {
		case INGAMEMENU:
			
			gameStateMachine.setScene(new IngameMenuScene(gameStateMachine, currentPlayerHandler, currentMapHandler, currentRenderHandler));
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
		currentMapHandler.update();
		currentPlayerHandler.update();
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
