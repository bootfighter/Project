package com.mygdx.codeAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Handlers.EventHandlers.IngameEventHandler;
import com.mygdx.codeAssets.Handlers.EventHandlers.MainMenuEventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandlers.IngameRenderHandler;
import com.mygdx.codeAssets.Handlers.RenderHandlers.MainMenuRenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandlers.IngameUIHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandlers.MainMenuUIHandler;
import com.mygdx.game.GameParameters.GameState;

public class GameStateMachine {

	SpriteBatch batch;
	
	private PlayerHandler currentPlayerHandler;
	private EventHandler currentEventHandler;
	private MapHandler currentMapHandler;
	private RenderHandler currentRenderHandler;
	private UserInterfaceHandler currentUserInterfaceHandler;
	
	private GameState currentGameState;
	
	public GameStateMachine(GameState a_currentGameState, SpriteBatch a_batch) {
		batch = a_batch;
		setCurrentGameState(a_currentGameState);
	}
	
	public GameState getCurrentGameState() {
		return currentGameState;
	}
	
	public void setCurrentGameState(GameState a_newGameState){
		if (a_newGameState == currentGameState)
			return;
		currentGameState = a_newGameState;
		updateHandlers();
		Gdx.input.setInputProcessor(currentEventHandler);
	}
	
	
	public void update(){
		
		switch (currentGameState) {
		case MAINMENU:
		

		case INGAME:
			currentPlayerHandler.update();
			currentMapHandler.update();
			
		default:
			currentRenderHandler.draw();			
			break;
		}
		
		
		
		Gdx.input.setInputProcessor(currentEventHandler);

	}
	
	
	private void updateHandlers(){
		
		
		
		switch (currentGameState) {
		case MAINMENU:
			currentUserInterfaceHandler = new MainMenuUIHandler();
			currentRenderHandler = new MainMenuRenderHandler(currentUserInterfaceHandler, batch);
			currentEventHandler = new MainMenuEventHandler(currentRenderHandler, currentUserInterfaceHandler);
			break;

		case INGAME:
			
			currentMapHandler = new MapHandler();
			currentPlayerHandler = new PlayerHandler(currentMapHandler);
			currentUserInterfaceHandler = new IngameUIHandler(currentPlayerHandler);
			currentRenderHandler = new IngameRenderHandler(currentMapHandler, currentPlayerHandler, currentUserInterfaceHandler, batch);
			currentEventHandler = new IngameEventHandler(currentMapHandler, currentPlayerHandler, currentRenderHandler, currentUserInterfaceHandler);
			
			
			break;

		default:
			break;
		}

	}
	
	public void resize(int width, int height) {
		currentRenderHandler.resize(width, height);
	}
}
