package com.mygdx.codeAssets;

import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.game.GameParameters.Gamestate;

public class GameStateMachine {

	PlayerHandler currentPlayerHandler;
	EventHandler currentEventHandler;
	MapHandler currentMapHandler;
	RenderHandler currentRenderHandler;
	
	
	public GameStateMachine(Gamestate a_currentGameState) {
		
	}
	
	
}
