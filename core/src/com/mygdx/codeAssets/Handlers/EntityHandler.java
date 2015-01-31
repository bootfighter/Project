package com.mygdx.codeAssets.Handlers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	
	public void draw(SpriteBatch a_batch) {
		for (Entity entity : entityList) {
			entity.draw(a_batch);
		}
	}
	
	public void addEntity(Entity a_entity){
		if (a_entity != null)
			entityList.add(a_entity);
	}
	
	
}
