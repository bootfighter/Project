package com.mygdx.codeAssets.Scenes;

import com.mygdx.codeAssets.GameStateMachine;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;

public abstract class IngameSceneAbstract extends SceneAbstract {

	protected MapHandler currentMapHandler;
	protected PlayerHandler currentPlayerHandler;
	
	public IngameSceneAbstract(GameStateMachine a_gameStateMachine) {
		super(a_gameStateMachine);
	}
	
	public void setMapHandler(MapHandler a_mapHandler){
		currentMapHandler = a_mapHandler;
	}
	public void setPlayerHandler(PlayerHandler a_playerHandler) {
		currentPlayerHandler = a_playerHandler;
	}

}
