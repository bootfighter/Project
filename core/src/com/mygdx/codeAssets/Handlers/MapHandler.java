package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.codeAssets.Objects.Tile;

public class MapHandler {
	
	GameMap currentMap;
	GameMap lastMap;
	
	EntityHandler entityHandler;
		
	public MapHandler() {
		entityHandler = new EntityHandler();
		currentMap = lastMap = new GameMap(500,500,1);
		testFill();
	}
	
	private void testFill(){
		
		currentMap.fillWithTile(new Tile(new Texture("Tiles/grass.png"), false));

		Tile dirt = new Tile(new Texture("Tiles/dirt.png"), true);

		//Walls preventing ppl from running out
		currentMap.fillWithTile(dirt, new Vector3(0, 0, 0), new Vector3(1, currentMap.getDimensionY() - 1, 0));
		currentMap.fillWithTile(dirt, new Vector3(0, currentMap.getDimensionY() - 1, 0), new Vector3(currentMap.getDimensionX(), currentMap.getDimensionY() , 0));
		currentMap.fillWithTile(dirt, new Vector3(currentMap.getDimensionX() - 1, 0, 0), new Vector3(currentMap.getDimensionX(), currentMap.getDimensionY() , 0));
		currentMap.fillWithTile(dirt, new Vector3(0, 0, 0), new Vector3(currentMap.getDimensionX() - 1, 1, 0));

		currentMap.fillWithTile(dirt, new Vector3(8, 8, 0), new Vector3(24, 24, 0));
		currentMap.fillWithTile(dirt, new Vector3(8, 24, 0), new Vector3(10, 34, 0));
		currentMap.fillWithTile(dirt, new Vector3(56, 56, 0), new Vector3(166, 60, 0));
		currentMap.fillWithTile(dirt, new Vector3(66, 40, 0), new Vector3(70, 60, 0));


		currentMap.fillWithTile(dirt, new Vector3(8, 40, 0), new Vector3(9, 60, 0));
		currentMap.fillWithTile(dirt, new Vector3(10, 40, 0), new Vector3(11, 60, 0));
		currentMap.fillWithTile(dirt, new Vector3(12, 40, 0), new Vector3(13, 60, 0));

		
	}
	
	
	public void update() {
		
		entityHandler.update(currentMap);
		
		//TODO:
		//loading of maps? or does the player decide what to load?
		
	}
	
	public Tile getTileFromPosition(Vector3 a_tilePosition) {
		return currentMap.getTileAtPosition(a_tilePosition);
	}
	
	public GameMap getCurrentMap() {
		return currentMap;
	}
	
	public void draw(SpriteBatch a_batch, float a_zoom, Vector3 a_playerposition){
		currentMap.draw(a_batch, a_zoom, a_playerposition);
		entityHandler.draw(a_batch);
	}

}
