package com.mygdx.codeAssets.Scenes;

import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;

public abstract class SceneAbstract {

	protected UserInterfaceHandler currentUIHandler;
	protected RenderHandler currentRenderHandler;
	protected EventHandler currentEventHandler;
	protected GameStateMachine gameStateMachine;
	
	public SceneAbstract(GameStateMachine a_gameStateMachine) {
		gameStateMachine = a_gameStateMachine;
	}
	
	public void setUIHandler(UserInterfaceHandler a_uiHandler){
		currentUIHandler = a_uiHandler;
	
	}
	public void setEventHandler(EventHandler a_eventHandler){
		currentEventHandler = a_eventHandler;
	
	}
	public void setRenderHandler(RenderHandler a_renderHandler){
		currentRenderHandler = a_renderHandler;
	}
	
	public abstract void setNewState(GameState a_gameState);
	
	public abstract void update();
	
	public abstract void render();
	
	public abstract void resize(int width, int height);
	
	public abstract void dispose();
	
}
