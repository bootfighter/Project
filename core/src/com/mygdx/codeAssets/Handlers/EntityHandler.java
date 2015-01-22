package com.mygdx.codeAssets.Handlers;

import java.util.ArrayList;

import com.mygdx.codeAssets.Objects.Entity;
import com.mygdx.codeAssets.Objects.GameMap;

public class EntityHandler {

	
	ArrayList<Entity> entityList;
	
	
	public EntityHandler() {
		entityList = new ArrayList<Entity>();
	}
	
	public void update(GameMap a_map) {
		for (Entity entity : entityList) {
			entity.update(a_map);
			
		}
	}
	
	
	
	
}
