package com.mygdx.codeAssets.Objects.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.AnimationBoneHandler;
import com.mygdx.codeAssets.Objects.Entity;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.game.GameParameters.Direction;

public class Dog extends Entity{
	
	AnimationBoneHandler animBoneHandler;
	
	public Dog() {
		super();
		animBoneHandler = new AnimationBoneHandler("Dog");
		
		position.x = 70;
		position.y = 30;
		
		animBoneHandler.startAnimation(0, Direction.NORTH);
	}
	
	
	@Override
	public void update(GameMap a_map) {
		
		animBoneHandler.update(new Vector2(position.x, position.y), Direction.NORTH);
		
	}
	
	@Override
	public void draw(SpriteBatch a_batch) {
		animBoneHandler.draw(a_batch);
	}
	
}
