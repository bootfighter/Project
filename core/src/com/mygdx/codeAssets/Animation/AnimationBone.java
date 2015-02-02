package com.mygdx.codeAssets.Animation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Objects.Vector2Scalbl;

public class AnimationBone {
	
	Sprite sprite;
	Vector2Scalbl offsetVector;
	private AnimationStateSet[] animationStateSets;
	private ArrayList<AnimationBone> animationBoneChilds;
	private float globalScaleX;
	private float globalScaleY;
	private int currentAnimation;
	public final int drawDepth;
	public int uniqueId;
	
	
	public AnimationBone(Sprite a_sprite, Vector2Scalbl a_offsetVetor, AnimationStateSet[] a_animationStateSet, int a_uniqueId, int a_drawDepth) {
		sprite = a_sprite;
		offsetVector = a_offsetVetor;
		animationStateSets = a_animationStateSet;
		animationBoneChilds = new ArrayList<AnimationBone>();		
		globalScaleX = 1;
		globalScaleY = 1;
		currentAnimation = 0;
		uniqueId = a_uniqueId;
		drawDepth = a_drawDepth;
	}
		
	public void addAnimationBoneChild(AnimationBone a_child){
		animationBoneChilds.add(a_child);	
	}
	
	private void rotate(float a_angle){	
		sprite.setRotation(a_angle);
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.rotateOffsetVector(a_angle);
		}
	}
	
	private void rotateOffsetVector(float a_angle){
		offsetVector.setRotationOfBase(a_angle);
	}
	
	private void scale(float a_scaleX, float a_scaleY){
		
		sprite.setScale(globalScaleX * a_scaleX, globalScaleY * a_scaleY);
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.scaleOffsetVector(a_scaleX, a_scaleY);
		}
	}
	
	private void scaleOffsetVector(float a_scaleX, float a_scaleY){
		offsetVector.setScaleFromBase(a_scaleX, a_scaleY);
	}
	
	public AnimationBone getChild(int a_uniqueID){
		if (uniqueId == a_uniqueID) {
			return this;
		} 
		for (AnimationBone animationBone : animationBoneChilds) {
			return animationBone.getChild(a_uniqueID);
		}
		return null;
	}

	public void draw(SpriteBatch a_batch){
		
		a_batch.begin();
		
		sprite.draw(a_batch);
		
		a_batch.end();
		
	}
	
	public void update(Vector2 a_position, int a_currentTime, int a_animationNumber){
		
		currentAnimation = a_animationNumber;
		
		updateSpriteTransform(a_currentTime);
		
		sprite.setPosition(a_position.x + offsetVector.transformedX - sprite.getOriginX(),
							a_position.y + offsetVector.transformedY - sprite.getOriginY());
		
		
				
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.update(new Vector2(sprite.getX() + sprite.getOriginX(), sprite.getY() + sprite.getOriginY()),
					a_currentTime, a_animationNumber);
		}
	}
	
	private void updateSpriteTransform(int a_currentTime){
		
		int currentState = 0;
		float percentWithinState = 0;
		
		if (animationStateSets[currentAnimation].stateListLength < 1)
			return;
			
		if (animationStateSets[currentAnimation].stateListLength == 1) {
			rotate(animationStateSets[currentAnimation].stateList[0].rotation);
			scale(animationStateSets[currentAnimation].stateList[0].scaleX, animationStateSets[currentAnimation].stateList[0].scaleY);
			return;
		}
		
		for (int i = 0; i < animationStateSets[currentAnimation].stateListLength - 1; i++) {	
			if(a_currentTime > animationStateSets[currentAnimation].stateList[i].millisecondsFromStart && 
					a_currentTime <= animationStateSets[currentAnimation].stateList[i+1].millisecondsFromStart){
				currentState = i + 1;
				break;
			}
		}
		if (currentState == 0)
			return;
		
		a_currentTime -= animationStateSets[currentAnimation].stateList[currentState - 1].millisecondsFromStart;
		
		percentWithinState = (float)animationStateSets[currentAnimation].getDeltaMilliseconds(currentState) / 100; //one percent of the state

		percentWithinState = (float)(a_currentTime / percentWithinState / 100); //time within current state divided by one percent of the state's time 
		
		
		rotate(animationStateSets[currentAnimation].stateList[currentState - 1].rotation + 
				(animationStateSets[currentAnimation].getDeltaRotation(currentState) * percentWithinState));
		
		scale(animationStateSets[currentAnimation].stateList[currentState - 1].scaleX + 
				(animationStateSets[currentAnimation].getDeltaScaleX(currentState) * percentWithinState), 
				animationStateSets[currentAnimation].stateList[currentState - 1].scaleY + 
				(animationStateSets[currentAnimation].getDeltaScaleY(currentState) * percentWithinState));
		
	}
	
	public void reset(){
		offsetVector.setRotationOfBase(0);
		offsetVector.setScaleFromBase(1, 1);
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.reset();
		}
	}
	
	public int getAnimationTime(int a_animationNumber){
		return animationStateSets[a_animationNumber].getAnimationTime();
	}
	
	public void setGlobalScale(float a_globalScaleX, float a_globalScaleY) {
		globalScaleX = a_globalScaleX;
		globalScaleY = a_globalScaleY;
		offsetVector.setGlobalScale(a_globalScaleX, a_globalScaleY);
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.setGlobalScale(a_globalScaleX, a_globalScaleY);
		}
		
	}
	
	public void getDrawOrderList(ArrayList<AnimationBone> a_drawOrderList){
		
		//finding right place in drawOrderlist. lower numbers (less depth) go to the left, higher numbers to the right
		if (a_drawOrderList.size() > 1) {
			
			for (int i = 0; i < a_drawOrderList.size() - 1; i++) {
				
				if (drawDepth <= a_drawOrderList.get(i).drawDepth && drawDepth >= a_drawOrderList.get(i + 1).drawDepth ) {
					a_drawOrderList.add(i + 1, this);
					break;
				}
			}
			
			if (drawDepth > a_drawOrderList.get(0).drawDepth) {
				a_drawOrderList.add(0, this);
			}
			if (drawDepth < a_drawOrderList.get(a_drawOrderList.size() - 1).drawDepth ) {
				a_drawOrderList.add(this);
			}
			
			
		}else if (a_drawOrderList.size() == 0){ //no item in list
			a_drawOrderList.add(this);
		}else if (a_drawOrderList.size() == 1) { // one item in list, "this" could be only be bigger or smaller than the one existing element 
			if (drawDepth <= a_drawOrderList.get(0).drawDepth) 
				a_drawOrderList.add(this);
			else 
				a_drawOrderList.add(0, this);
		}

		
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.getDrawOrderList(a_drawOrderList);
		}
	}
	
}
