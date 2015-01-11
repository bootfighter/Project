package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.codeAssets.Objects.Tile;

public class MapHandler {
	
	GameMap currentMap;
	GameMap lastMap;
		
	public MapHandler() {
		currentMap = lastMap = new GameMap(30,30,1);
		currentMap.fillWithTile(new Tile(new Texture("missingtxt.png"), false));
		
//		currentMap.setTileAtPosition(new Tile(new Texture("dirt.png"),true), 3, 3, 0);
		currentMap.fillWithTile(new Tile(new Texture("dirt.png"),true), new Vector3(4, 4, 0), new Vector3(8, 8, 0));

		currentMap.fillWithTile(new Tile(new Texture("dirt.png"),true), new Vector3(9, 4, 0), new Vector3(11, 10, 0));
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
