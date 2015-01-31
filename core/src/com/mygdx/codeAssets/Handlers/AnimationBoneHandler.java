package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Animation.AnimationBone;
import com.mygdx.codeAssets.AnimationData.DogAnimationData;
import com.mygdx.game.GameParameters.Direction;

public class AnimationBoneHandler {

	private float deltaAnimationTime;
	private int currentAnimation;
	private Direction currentDirection;
	private boolean isAnimationRunning;
	private AnimationBone animationBoneHeadNorth;
	private AnimationBone animationBoneHeadEast;
	private AnimationBone animationBoneHeadSouth;
	private AnimationBone animationBoneHeadWest;

	
	public AnimationBoneHandler(String a_entityName) {
		deltaAnimationTime = 0;
		currentAnimation = 0;
		currentDirection = Direction.NORTH;
		isAnimationRunning = false;
		getAnimationBoneHead(a_entityName);
	}
	
	private void getAnimationBoneHead(String a_entityName)
	{
		if (a_entityName.equals("Player"))
			return;
		if (a_entityName.equals("Dog"))
			animationBoneHeadNorth = DogAnimationData.getAnimationStructurN();
		return;
	}
	
	public void setGlobalScale(float a_globalScaleX, float a_globalScaleY){
		animationBoneHeadNorth.setGlobalScale(a_globalScaleX, a_globalScaleY);
		animationBoneHeadEast.setGlobalScale(a_globalScaleX, a_globalScaleY);
		animationBoneHeadSouth.setGlobalScale(a_globalScaleX, a_globalScaleY);
		animationBoneHeadWest.setGlobalScale(a_globalScaleX, a_globalScaleY);
	}
	
	public void update(Vector2 a_position, Direction a_currentDirection) {
		
		
		if (!isAnimationRunning)
			return;
		
		currentDirection = a_currentDirection;
		
		deltaAnimationTime += Gdx.graphics.getDeltaTime() * 1000;
		
		switch (currentDirection) {
		case NORTH:
			animationBoneHeadNorth.update(a_position, (int)deltaAnimationTime);
			break;
		case EAST:
			//TODO
			break;
		case SOUTH:
			//TODO
			break;
		case WEST:
			//TODO
			break;
		default:
			break;
		}
	}
	
	public void startAnimation(int a_animationNumber, Direction a_direction){
		deltaAnimationTime = 0;
		currentAnimation = a_animationNumber;
		currentDirection = a_direction;
		isAnimationRunning = true;
	}
	
	public void changeAnimation(int a_animationNumber){
		if (a_animationNumber == currentAnimation) 
			return;
		deltaAnimationTime = 0;
		currentAnimation = a_animationNumber;		
	}
	
	public void stopAnimation(){
		isAnimationRunning = false;
	}
	
	public void draw(SpriteBatch a_batch){
		animationBoneHeadNorth.draw(a_batch);
	}
	
}
