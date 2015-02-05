package com.mygdx.codeAssets.Handlers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Animation.AnimationBone;
import com.mygdx.game.GameParameters.Direction;

public class AnimationBoneHandler {

	private float deltaAnimationTime;
	private int currentAnimation;
	private int currentAnimationTimeInverval;
	private Direction currentDirection;
	private boolean isAnimationRunning;
	
	private AnimationBone currentBoneHead;
	private AnimationBone animationBoneHeadNorth;
	private AnimationBone animationBoneHeadEast;
	private AnimationBone animationBoneHeadSouth;
	private AnimationBone animationBoneHeadWest;
	private ArrayList<AnimationBone> currentDrawOrderList;
	private ArrayList<AnimationBone> drawOrderListNorth;
	private ArrayList<AnimationBone> drawOrderListEast;
	private ArrayList<AnimationBone> drawOrderListSouth;
	private ArrayList<AnimationBone> drawOrderListWest;


	
	public AnimationBoneHandler(AnimationBone a_headNorth,  AnimationBone a_headEast, AnimationBone a_headSouth,  AnimationBone a_headWest) {
		deltaAnimationTime = 0;
		currentAnimation = 0;
		currentDirection = Direction.NORTH;
		currentAnimationTimeInverval = 0;
		isAnimationRunning = false;
		
		animationBoneHeadNorth = a_headNorth;
		animationBoneHeadEast = a_headEast;
		animationBoneHeadSouth = a_headSouth;
		animationBoneHeadWest = a_headWest;
		
		currentDrawOrderList = new ArrayList<AnimationBone>();
		drawOrderListNorth = new ArrayList<AnimationBone>();
		drawOrderListEast = new ArrayList<AnimationBone>();
		drawOrderListSouth = new ArrayList<AnimationBone>();
		drawOrderListWest = new ArrayList<AnimationBone>();
		
		animationBoneHeadNorth.getDrawOrderList(drawOrderListNorth);
		animationBoneHeadEast.getDrawOrderList(drawOrderListEast);
		animationBoneHeadSouth.getDrawOrderList(drawOrderListSouth);
		animationBoneHeadWest.getDrawOrderList(drawOrderListWest);
		
		currentDrawOrderList = drawOrderListNorth;
		currentBoneHead = animationBoneHeadNorth;
		
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
		
		//adding time since last frame in milliseconds
		deltaAnimationTime += Gdx.graphics.getDeltaTime() * 1000;
		
		//shaves off currentAnimation time if more than 
		if (deltaAnimationTime > currentAnimationTimeInverval && currentAnimationTimeInverval > 0) {
			deltaAnimationTime = deltaAnimationTime % currentAnimationTimeInverval;
		}
		
		switch (currentDirection) {
		case NORTH:
			currentBoneHead = animationBoneHeadNorth;
			currentDrawOrderList = drawOrderListNorth;
			break;
		case EAST:
			currentBoneHead = animationBoneHeadEast;
			currentDrawOrderList = drawOrderListEast;
			break;
		case SOUTH:
			currentBoneHead = animationBoneHeadSouth;
			currentDrawOrderList = drawOrderListSouth;
			break;
		case WEST:
			currentBoneHead = animationBoneHeadWest;
			currentDrawOrderList = drawOrderListWest;
			break;
		default:
			break;
		}
		
		currentBoneHead.update(a_position, (int)deltaAnimationTime, currentAnimation);
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
	
	public void reset(){
		animationBoneHeadNorth.reset();
		animationBoneHeadEast.reset();
		animationBoneHeadSouth.reset();
		animationBoneHeadWest.reset();		
	}
	
	private void setAnimationTimeInverval(){
		currentAnimationTimeInverval = currentBoneHead.getAnimationTime(currentAnimation);
	}
	
	public void draw(SpriteBatch a_batch){
		
		for (AnimationBone animationBone : currentDrawOrderList) {
			animationBone.draw(a_batch);
		}
	}
	
}
