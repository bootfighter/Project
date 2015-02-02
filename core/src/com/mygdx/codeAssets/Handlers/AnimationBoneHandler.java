package com.mygdx.codeAssets.Handlers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Animation.AnimationBone;
import com.mygdx.codeAssets.AnimationData.DogAnimationData;
import com.mygdx.game.GameParameters.Direction;

public class AnimationBoneHandler {

	private float deltaAnimationTime;
	private int currentAnimation;
	private int currentAnimationTimeInverval;
	private Direction currentDirection;
	private boolean isAnimationRunning;
	private AnimationBone animationBoneHeadNorth;
	private AnimationBone animationBoneHeadEast;
	private AnimationBone animationBoneHeadSouth;
	private AnimationBone animationBoneHeadWest;
	private ArrayList<AnimationBone> drawOrderList;

	
	public AnimationBoneHandler(String a_entityName) {
		deltaAnimationTime = 0;
		currentAnimation = 0;
		currentDirection = Direction.NORTH;
		currentAnimationTimeInverval = 0;
		isAnimationRunning = false;
		getAnimationBoneHead(a_entityName);
		
		drawOrderList = new ArrayList<AnimationBone>();
		animationBoneHeadNorth.getDrawOrderList(drawOrderList);
		
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
//		animationBoneHeadEast.setGlobalScale(a_globalScaleX, a_globalScaleY);
//		animationBoneHeadSouth.setGlobalScale(a_globalScaleX, a_globalScaleY);
//		animationBoneHeadWest.setGlobalScale(a_globalScaleX, a_globalScaleY);
	}
	
	public void update(Vector2 a_position, Direction a_currentDirection) {
		
		
		if (!isAnimationRunning)
			return;
		
		currentDirection = a_currentDirection;
		
		//adding time since last frame in milliseconds
		deltaAnimationTime += Gdx.graphics.getDeltaTime() * 1000;
		
		//shaves off currentAnimation time if more than 
		if (deltaAnimationTime > currentAnimationTimeInverval && currentAnimationTimeInverval > 0) {
			deltaAnimationTime = deltaAnimationTime % currentAnimationTimeInverval;
		}
		
		switch (currentDirection) {
		case NORTH:
			animationBoneHeadNorth.update(a_position, (int)deltaAnimationTime, currentAnimation);
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
		setAnimationTimeInverval();
	}
	
	public void changeAnimation(int a_animationNumber){
		if (a_animationNumber == currentAnimation) 
			return;
		deltaAnimationTime = 0;
		currentAnimation = a_animationNumber;		
		setAnimationTimeInverval();
	}
	
	public void stopAnimation(){
		isAnimationRunning = false;
		animationBoneHeadNorth.reset();
		animationBoneHeadEast.reset();
		animationBoneHeadSouth.reset();
		animationBoneHeadWest.reset();
	}
	
	private void setAnimationTimeInverval(){
		switch (currentDirection) {
		case NORTH:
			currentAnimationTimeInverval = animationBoneHeadNorth.getAnimationTime(currentAnimation);
			break;
		case EAST:
			currentAnimationTimeInverval = animationBoneHeadEast.getAnimationTime(currentAnimation);
			break;
		case SOUTH:
			currentAnimationTimeInverval = animationBoneHeadSouth.getAnimationTime(currentAnimation);
			break;
		case WEST:
			currentAnimationTimeInverval = animationBoneHeadWest.getAnimationTime(currentAnimation);
			break;
		default:
			currentAnimationTimeInverval = -1;
			break;
		}
	}
	
	public void draw(SpriteBatch a_batch){
		
		for (AnimationBone animationBone : drawOrderList) {
			animationBone.draw(a_batch);
		}
	}
	
}
