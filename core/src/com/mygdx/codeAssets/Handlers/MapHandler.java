package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.codeAssets.Objects.Tile;

public class MapHandler {
	
	GameMap currentMap;
	GameMap lastMap;
	PlayerHandler playerHandler;
		
	public MapHandler(PlayerHandler a_playerHandler) {
		currentMap = lastMap = new GameMap(10,10,3);
		playerHandler = a_playerHandler;
		currentMap.fillWithTile(new Tile());
	}
	
	
	public void update() {
		
		
		
	}
	
	public Tile getTileFromPosition(Vector3 a_tilePosition) {
		return currentMap.getTileAtPosition(a_tilePosition);
	}
	
	public GameMap getCurrentMap() {
		return currentMap;
	}

}
