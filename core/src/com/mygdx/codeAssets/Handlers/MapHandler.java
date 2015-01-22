package com.mygdx.codeAssets.Handlers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.CollisionRect;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.codeAssets.Objects.Tile;

public class MapHandler {
	
	GameMap currentMap;
	GameMap lastMap;
		
	public MapHandler() {
		currentMap = lastMap = new GameMap(50,50,1);
		
		currentMap.fillWithTile(new Tile(new Texture("grass.png"), false));
		
		Tile dirt = new Tile(new Texture("dirt.png"), true);
		
		
		currentMap.fillWithTile(dirt, new Vector3(0, 0, 0), new Vector3(1, currentMap.getDimensionY() - 1, 0));
		currentMap.fillWithTile(dirt, new Vector3(0, currentMap.getDimensionY() - 1, 0), new Vector3(currentMap.getDimensionX(), currentMap.getDimensionY() , 0));
		currentMap.fillWithTile(dirt, new Vector3(currentMap.getDimensionX() - 1, 0, 0), new Vector3(currentMap.getDimensionX(), currentMap.getDimensionY() , 0));
		currentMap.fillWithTile(dirt, new Vector3(0, 0, 0), new Vector3(currentMap.getDimensionX() - 1, 1, 0));
		
		currentMap.fillWithTile(dirt, new Vector3(8, 8, 0), new Vector3(24, 24, 0));
		
		ArrayList<CollisionRect> tempList = new ArrayList<CollisionRect>();
		tempList.add(new CollisionRect(new Vector2(4, 0), new Vector2(8, 16)));
		
	}
	
	
	public void update() {
		
		//TODO:
		//loading of maps? or does the player decide what to load?
		
	}
	
	public Tile getTileFromPosition(Vector3 a_tilePosition) {
		return currentMap.getTileAtPosition(a_tilePosition);
	}
	
	public GameMap getCurrentMap() {
		return currentMap;
	}

}
