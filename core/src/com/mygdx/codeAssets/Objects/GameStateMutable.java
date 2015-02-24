package com.mygdx.codeAssets.Objects;

public class GameStateMutable {

	public static enum GameState{
		MAINMENU,
		INGAMEMENU,
		INGAME, 
		INVENTORY, 
		NPCINTERACTION,
		CUTSCENE,
		CREDITS,
		EXIT
	}
	
	public GameState gameState;
	
	public GameStateMutable(GameState a_gameState) {
		gameState = a_gameState;
	}
}
