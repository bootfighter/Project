package com.mygdx.codeAssets.Animation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Objects.Vector2Scalbl;

public class AnimationBone {
	
	Sprite sprite;
	Vector2Scalbl offsetVector;
	private AnimationStateSet animationStateSet;
	private ArrayList<AnimationBone> animationBoneChilds;
	private float globalScaleX;
	private float globalScaleY;
	public final int drawDepth;
	public int uniqueId;
	
	
	public AnimationBone(Sprite a_sprite, Vector2Scalbl a_offsetVetor, AnimationStateSet a_animationStateSet, int a_uniqueId, int a_drawDepth) {
		sprite = a_sprite;
		offsetVector = a_offsetVetor;
		animationStateSet = a_animationStateSet;
		animationBoneChilds = new ArrayList<AnimationBone>();		
		globalScaleX = 1;
		globalScaleY = 1;
		uniqueId = a_uniqueId;
		drawDepth = a_drawDepth;
	}
	
	public void setOrigin(Vector2 a_origin){
		sprite.setOrigin(a_origin.x, a_origin.y);
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
	
	public void setGlobalScale(float a_globalScaleX, float a_globalScaleY) {
		globalScaleX = a_globalScaleX;
		globalScaleY = a_globalScaleY;
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.setGlobalScale(a_globalScaleX, a_globalScaleY);
		}
		
	}
	
	private void scale(float a_scaleX, float a_scaleY){
		offsetVector.setScaleFromBase(a_scaleX, a_scaleY);
		sprite.setScale(globalScaleX * a_scaleX, globalScaleY * a_scaleY);
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.scale(a_scaleX, a_scaleY);
		}
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
		//less important sprites get drawn in the background (temporary)
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.draw(a_batch);
		}
		
		a_batch.begin();
		
		sprite.draw(a_batch);
		
		a_batch.end();
	}
	
	public void update(Vector2 a_position, int a_currentTime){
		
		updateSpriteTransform(a_currentTime);
		//TODO REDO THE POSITIONING!
		sprite.setPosition(a_position.x + offsetVector.transformedX, a_position.y + offsetVector.transformedY);
		
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.update(new Vector2(sprite.getX() + offsetVector.transformedX, sprite.getY() + offsetVector.transformedY), a_currentTime);
		}
	}
	
	private void updateSpriteTransform(int a_currentTime){
		
		
		int currentState = 0;
		float percentWithinState = 0;
		
		
		for (int i = 0; i < animationStateSet.stateList.length - 1; i++) {	
			if(a_currentTime > animationStateSet.stateList[i].millisecondsFromStart && 
					a_currentTime <= animationStateSet.stateList[i+1].millisecondsFromStart){
				currentState = i + 1;
				break;
			}
		}
		if (currentState == 0)
			return;
		
		a_currentTime -= animationStateSet.stateList[currentState - 1].millisecondsFromStart;
		
		percentWithinState = animationStateSet.getDeltaMilliseconds(currentState) / 100; //one percent of the state
		percentWithinState = a_currentTime / percentWithinState; //time within current state divided by one percent of the state's time 
		
		
		rotate(animationStateSet.stateList[currentState - 1].rotation - (animationStateSet.getDeltaRotation(currentState) * percentWithinState));
		scale(animationStateSet.stateList[currentState - 1].scaleX - (animationStateSet.getDeltaScaleX(currentState) * percentWithinState), 
				animationStateSet.stateList[currentState - 1].scaleY - (animationStateSet.getDeltaScaleY(currentState) * percentWithinState));
		
	}
	
	public void reset(){
		offsetVector.setRotationOfBase(0);
		offsetVector.setScaleFromBase(1, 1);
		for (AnimationBone animationBone : animationBoneChilds) {
			animationBone.reset();
		}
	}
}
