package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.AnimationData.PlayerWalking;
import com.mygdx.game.GameParameters.Direction;




public class AnimationSkeleton {
		
	private Sprite spriteList[];
	private AnimationStateSet animationStateSets[][];
	protected final int numberOfAnimations;
	private final int numberOfSpriteParts;
	private final static int walkingAnimationTime = 1500;
	private int deltaAnimationTime;
	private int currentAnimation;
	private Direction currentDirection;
	private boolean isAnimationRunning;
	private Vector2Scalbl[] offsetVectors;
	
		
	public AnimationSkeleton(Vector2 a_position) {
		
		numberOfSpriteParts = PlayerWalking.numberOfSpriteParts;
		numberOfAnimations = PlayerWalking.numberOfAnimations;
		currentAnimation = 0;
		currentDirection = Direction.NORTH;
		deltaAnimationTime = 0;
		isAnimationRunning = false;
		
		spriteList = new Sprite[numberOfSpriteParts * 4];
		animationStateSets = new AnimationStateSet[numberOfAnimations][numberOfSpriteParts * 4];
		offsetVectors = new Vector2Scalbl[numberOfSpriteParts * 4];

		
		fillSpriteList("Armors/DebugArmor/DebugArmor");
		fillAnimationTimings();
		setOffsetVectors();			
		setPosition(a_position);
	}
	
	private void fillSpriteList(String a_nameOfSprite){
		
		PlayerWalking.fillSpriteList(spriteList, a_nameOfSprite);

	}
	
	private void fillAnimationTimings(){
		
		PlayerWalking.fillAnimationTimings(animationStateSets);
	
	}
	
	private void setOffsetVectors(){
		
		PlayerWalking.fillOffsetVectors(offsetVectors);
		
	}
		
	private int getOffsetIndex(Direction a_direction)
	{		
		if (a_direction == Direction.EAST)
			return (numberOfSpriteParts );

		if (a_direction == Direction.SOUTH)
			return (2 * numberOfSpriteParts);
		
		if (a_direction == Direction.WEST)
			return (3 * numberOfSpriteParts);
		return 0;
	}
	
	private void setPosition(Vector2 a_position){
		
		int offsetIndex = getOffsetIndex(currentDirection);
		
		//body
		spriteList[offsetIndex].setPosition(a_position.x + offsetVectors[offsetIndex].transformedX - 11, a_position.y + offsetVectors[offsetIndex].transformedY- 7);
		
		//head
		spriteList[offsetIndex + 1].setPosition(spriteList[offsetIndex].getX() + spriteList[offsetIndex].getOriginX() + 
				offsetVectors[offsetIndex + 1].transformedX - spriteList[offsetIndex + 1].getOriginX(),
				spriteList[offsetIndex].getY() + spriteList[offsetIndex].getOriginY() + 
				offsetVectors[offsetIndex + 1].transformedY - spriteList[offsetIndex + 1].getOriginY());
		
		//4 times - each for every limb
		for (int i = 0; i < 4; i++) {
			
			spriteList[offsetIndex + 2 + 2*i].setPosition(
					spriteList[offsetIndex].getX() + spriteList[offsetIndex].getOriginX() + 
					offsetVectors[offsetIndex + 2 + 2*i].transformedX - spriteList[offsetIndex + 2 + 2*i].getOriginX(),
					spriteList[offsetIndex].getY() + spriteList[offsetIndex].getOriginY() + 
					offsetVectors[offsetIndex + 2 + 2*i].transformedY - spriteList[offsetIndex + 2 + 2*i].getOriginY());
			
			spriteList[offsetIndex + 3 + 2*i].setPosition(
					spriteList[offsetIndex + 2 + 2*i].getX() + spriteList[offsetIndex + 2 + 2*i].getOriginX() + 
					offsetVectors[offsetIndex + 3 + 2*i].transformedX - spriteList[offsetIndex + 3 + 2*i].getOriginX(),
					spriteList[offsetIndex + 2 + 2*i].getY() + spriteList[offsetIndex + 2 + 2*i].getOriginY() + 
					offsetVectors[offsetIndex + 3 + 2*i].transformedY - spriteList[offsetIndex + 3 + 2*i].getOriginY());

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
	
	
	public void update(Direction a_direction, Vector2 a_position)
	{
		setPosition(a_position);
		currentDirection = a_direction;
		setPosition(a_position);

		
		if (!isAnimationRunning)
			return;
		
		int offsetIndex = getOffsetIndex(currentDirection);
		deltaAnimationTime += (int)(Gdx.graphics.getDeltaTime() * 1000);
		
		for (int i = 0; i < numberOfSpriteParts; i++) {
			updateSpritePartTransformation(offsetIndex + i);
		}
	}
	
	
	private void updateSpritePartTransformation(int a_index){
		
		int numberOfAnimStates = animationStateSets[currentAnimation][a_index].stateList.length;
		if (numberOfAnimStates == 0)
			return;
		int currentState = 1;
		int currentDeltaTime = 0;
		float percentOfState = 0;
		float newRotValue = 0f;
		float newScaleX = 1f;
		float newScaleY = 1f;
		
		
		//if no 
		if (numberOfAnimStates == 1){
			setBoneRotation(animationStateSets[currentAnimation][a_index].stateList[0].rotation, a_index);	
			setBoneScale(animationStateSets[currentAnimation][a_index].stateList[0].scaleX, 
					animationStateSets[currentAnimation][a_index].stateList[0].scaleY, a_index);
			return;
		}	
		
		if (currentAnimation == 0 && deltaAnimationTime > walkingAnimationTime) {
			deltaAnimationTime -= walkingAnimationTime;
		}
		
		currentDeltaTime = deltaAnimationTime % animationStateSets[currentAnimation][a_index].stateList[numberOfAnimStates - 1].millisecondsFromStart;
		
		
		
		//finding of current state
		for (int i = 0; i < numberOfAnimStates - 1; i++) {	
			if(currentDeltaTime > animationStateSets[currentAnimation][a_index].stateList[i].millisecondsFromStart && 
					currentDeltaTime <= animationStateSets[currentAnimation][a_index].stateList[i+1].millisecondsFromStart){
				currentState = i + 1;
				break;
			}
		}
		
		
		//finds current time within the current state by subtracting the value of the last state
		currentDeltaTime -= animationStateSets[currentAnimation][a_index].stateList[currentState - 1].millisecondsFromStart;
		

		//calulating percent of how far the time is into the current state
		percentOfState = (float)(animationStateSets[currentAnimation][a_index].stateList[currentState].millisecondsFromStart -
							animationStateSets[currentAnimation][a_index].stateList[currentState - 1].millisecondsFromStart) / 100;
		percentOfState = (float)currentDeltaTime / percentOfState / 100;
		
		
		
		newRotValue = (animationStateSets[currentAnimation][a_index].stateList[currentState].rotation - 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].rotation) * percentOfState;
		
		
		setBoneRotation(animationStateSets[currentAnimation][a_index].stateList[currentState - 1].rotation + newRotValue, a_index);
		
		
		newScaleX = (float)(animationStateSets[currentAnimation][a_index].stateList[currentState].scaleX - 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleX) * percentOfState;
		newScaleY = (float)(animationStateSets[currentAnimation][a_index].stateList[currentState].scaleY - 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleY) * percentOfState;
				
		setBoneScale(animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleX + newScaleX, 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleY + newScaleY, a_index);
	}
	
	
	private void setBoneScale(float a_scaleX, float a_scaleY, int a_boneIndex) {
		
		spriteList[a_boneIndex].setScale(a_scaleX, a_scaleY);
		
		if ((a_boneIndex % numberOfSpriteParts) == 0) {
			offsetVectors[a_boneIndex + 1].setScaleFromBase(a_scaleX, a_scaleY);//head
			offsetVectors[a_boneIndex + 2].setScaleFromBase(a_scaleX, a_scaleY); //LArm
			offsetVectors[a_boneIndex + 4].setScaleFromBase(a_scaleX, a_scaleY); //RArm
			offsetVectors[a_boneIndex + 6].setScaleFromBase(a_scaleX, a_scaleY); //LLeg
			offsetVectors[a_boneIndex + 8].setScaleFromBase(a_scaleX, a_scaleY); //RLeg
		}
		else //if upper limb, lower limb part's offsetvector gets rotated 
			if (a_boneIndex % numberOfSpriteParts == 2 || a_boneIndex  % numberOfSpriteParts == 4 || 
				a_boneIndex % numberOfSpriteParts == 6 || a_boneIndex  % numberOfSpriteParts == 8) {
				offsetVectors[a_boneIndex + 1].setScaleFromBase(a_scaleX, a_scaleY);
			}
		
		
		
	}
	

	private void setBoneRotation(float a_rotation, int a_boneIndex) {

		spriteList[a_boneIndex].setRotation(a_rotation);

		//if body
		if ((a_boneIndex % numberOfSpriteParts) == 0) {
			offsetVectors[a_boneIndex + 1].setRotationOfBase(a_rotation); //head
			offsetVectors[a_boneIndex + 2].setRotationOfBase(a_rotation); //LArm
			offsetVectors[a_boneIndex + 4].setRotationOfBase(a_rotation); //RArm
			offsetVectors[a_boneIndex + 6].setRotationOfBase(a_rotation); //LLeg
			offsetVectors[a_boneIndex + 8].setRotationOfBase(a_rotation); //RLeg
		}
		else //if upper limb, lower limb part's offsetvector gets rotated 
			if (a_boneIndex % numberOfSpriteParts == 2 || a_boneIndex  % numberOfSpriteParts == 4 || 
				a_boneIndex % numberOfSpriteParts == 6 || a_boneIndex  % numberOfSpriteParts == 8) {
				offsetVectors[a_boneIndex + 1].setRotationOfBase(a_rotation);
			}
	}

	
	public void draw(SpriteBatch a_batch){
	
		int indexOffset = getOffsetIndex(currentDirection);
				
		a_batch.begin();
		
		for (int i = indexOffset + numberOfSpriteParts; i > indexOffset; i--) {
			spriteList[i - 1].draw(a_batch);
		}
		a_batch.end();
	}	
	
}
