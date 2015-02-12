package com.mygdx.codeAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Handlers.EventHandlers.CreditsEventHandler;
import com.mygdx.codeAssets.Handlers.EventHandlers.IngameEventHandler;
import com.mygdx.codeAssets.Handlers.EventHandlers.MainMenuEventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandlers.IngameRenderHandler;
import com.mygdx.codeAssets.Handlers.RenderHandlers.MainMenuRenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandlers.CreditsUIHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandlers.IngameUIHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandlers.MainMenuUIHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;

public class GameStateMachine {

	SpriteBatch batch;
	
	private PlayerHandler currentPlayerHandler;
	private EventHandler currentEventHandler;
	private MapHandler currentMapHandler;
	private RenderHandler currentRenderHandler;
	private UserInterfaceHandler currentUserInterfaceHandler;
	
	private GameStateMutable currentGameState;
	private GameState prevGameState;
	
	public GameStateMachine(GameStateMutable a_currentGameState, SpriteBatch a_batch) {
		batch = a_batch;
		currentGameState = a_currentGameState;
		updateHandlers();
	}
	
	
	private void updateGameState(){
		if (prevGameState == currentGameState.gameState)
			return;
		updateHandlers();
				
		prevGameState = currentGameState.gameState;
	}
	
	public void update(){
		
		updateGameState();
		
		switch (currentGameState.gameState) {
		case MAINMENU:
			break;
		case INGAME:
			currentPlayerHandler.update();
			currentMapHandler.update();
			break;
		case CREDITS:
			break;
		default:
			break;
		}
		
		//always happens:
		currentUserInterfaceHandler.update(); 
		currentRenderHandler.draw();
		
	}	
	
	private void updateHandlers(){

		switch (currentGameState.gameState) {
		case MAINMENU:
			currentUserInterfaceHandler = new MainMenuUIHandler(currentGameState);
			currentRenderHandler = new MainMenuRenderHandler(currentUserInterfaceHandler, batch);
			currentEventHandler = new MainMenuEventHandler(currentRenderHandler, currentUserInterfaceHandler);
			break;

		case INGAME:
			currentMapHandler = new MapHandler();
			currentPlayerHandler = new PlayerHandler(currentMapHandler);
			currentUserInterfaceHandler = new IngameUIHandler(currentPlayerHandler, currentGameState);
			currentRenderHandler = new IngameRenderHandler(currentMapHandler, currentPlayerHandler, currentUserInterfaceHandler, batch);
			currentEventHandler = new IngameEventHandler(currentMapHandler, currentPlayerHandler, currentRenderHandler, currentUserInterfaceHandler);			
			break;

		case CREDITS:
			currentUserInterfaceHandler = new CreditsUIHandler(currentGameState);
			currentRenderHandler = new MainMenuRenderHandler(currentUserInterfaceHandler, batch);
			currentEventHandler = new CreditsEventHandler(currentRenderHandler, currentUserInterfaceHandler);
			break;
			
		default:
			return;
		}
		Gdx.input.setInputProcessor(currentEventHandler);
	}
	
	public void resize(int width, int height) {
		currentUserInterfaceHandler.resize(width, height);
		currentRenderHandler.resize(width, height);
	}
}
