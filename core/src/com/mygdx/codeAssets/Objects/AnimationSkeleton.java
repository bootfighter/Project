package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameParameters.Direction;




public class AnimationSkeleton {
	
	class Vector2Scalbl extends Vector2{
		private static final long serialVersionUID = 1L;
		public float transformedX;
		public float transformedY;
		
		public Vector2Scalbl(int a_x, int a_y) {
			this.x = a_x;
			this.y = a_y;
			this.transformedX = a_x;
			this.transformedY = a_y;
		}

		public void setScaleFromBase(float a_scaleX, float a_scaleY)
		{
			transformedX = this.x * a_scaleX;
			transformedY = this.y * a_scaleY;
		}
		
		public void setRotationOfBase(float a_angle){
			Vector2 tmp = new Vector2(this.x, this.y);
			tmp.rotate(a_angle);
			transformedX = tmp.x;
			transformedY = tmp.y;
		}
	}
	
	private Sprite spriteList[];
	private AnimationStateSet animationStateSets[][];
	protected final int numberOfAnimations;
	private final int numberOfSpriteParts;
	private int deltaAnimationTime;
	private int currentAnimation;
	private Direction currentDirection;
	private boolean isAnimationRunning;
	private Vector2Scalbl[] offsetVectors;
	
	public AnimationSkeleton(Vector2 a_position) {
		
		numberOfSpriteParts = 10;
		numberOfAnimations = 1;
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
	
	public void fillSpriteList(String a_nameOfSprite)
	{
		int indexOffset = 0;
		Texture spriteSheet;
		try {
			spriteSheet = new Texture(a_nameOfSprite + ".png");
		} catch (Exception e) {
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			indexOffset = 2 * i * numberOfSpriteParts;
			//NORTH - SOUTH
			//body
			spriteList[indexOffset ] = new Sprite(spriteSheet, 24, 64 * i + 0, 40, 23);
			spriteList[indexOffset ].setOrigin(20, 12);
			//head
			spriteList[indexOffset + 1] = new Sprite(spriteSheet, 30, 64 * i + 23, 34, 41);
			spriteList[indexOffset + 1].setOrigin(17, 10);
			
			//LArm
			spriteList[indexOffset + 2] = new Sprite(spriteSheet, 0, 64 * i + 0, 12, 12);
			spriteList[indexOffset + 3] = new Sprite(spriteSheet, 0, 64 * i + 12, 12, 11);
			spriteList[indexOffset + 2].setOrigin(9, 9);
			spriteList[indexOffset + 3].setOrigin(6, 9);
	
			//RArm
			spriteList[indexOffset + 4] = new Sprite(spriteSheet, 12, 64 * i + 0, 12, 12);
			spriteList[indexOffset + 5] = new Sprite(spriteSheet, 12, 64 * i + 12, 12, 11);
			spriteList[indexOffset + 4].setOrigin(4, 9);
			spriteList[indexOffset + 5].setOrigin(6, 9);
			
			//LLeg
			spriteList[indexOffset + 6] = new Sprite(spriteSheet, 0, 64 * i + 23, 15, 12);
			spriteList[indexOffset + 7] = new Sprite(spriteSheet, 0, 64 * i + 35, 15, 10);
			spriteList[indexOffset + 6].setOrigin(8, 9);
			spriteList[indexOffset + 7].setOrigin(8, 8);
			
			//RLeg
			spriteList[indexOffset + 8] = new Sprite(spriteSheet, 15, 64 * i + 23, 15, 12);
			spriteList[indexOffset + 9] = new Sprite(spriteSheet, 15, 64 * i + 35, 15, 10);
			spriteList[indexOffset + 8].setOrigin(8, 9);
			spriteList[indexOffset + 9].setOrigin(8, 8);
			
			
			//EAST - WEST
			
			//body
			spriteList[indexOffset + 10] = new Sprite(spriteSheet, 64, 64 * i + 23, 24, 20);
			spriteList[indexOffset + 10].setOrigin(12, 12);
			//head
			spriteList[indexOffset + 11] = new Sprite(spriteSheet, 88, 64 * i + 23, 34, 41);
			spriteList[indexOffset + 11].setOrigin(17, 10);
			
			//LArm
			spriteList[indexOffset + 12] = new Sprite(spriteSheet, 64, 64 * i + 0, 12, 12);
			spriteList[indexOffset + 13] = new Sprite(spriteSheet, 64, 64 * i + 12, 12, 11);
			spriteList[indexOffset + 12].setOrigin(6, 9);
			spriteList[indexOffset + 13].setOrigin(6, 8);

			//RArm
			spriteList[indexOffset + 14] = new Sprite(spriteSheet, 76, 64 * i + 0, 12, 12);
			spriteList[indexOffset + 15] = new Sprite(spriteSheet, 76, 64 * i + 12, 12, 11);
			spriteList[indexOffset + 14].setOrigin(6, 9);
			spriteList[indexOffset + 15].setOrigin(6, 8);
			//LLeg
			spriteList[indexOffset + 16] = new Sprite(spriteSheet, 88, 64 * i + 0, 16, 12);
			spriteList[indexOffset + 17] = new Sprite(spriteSheet, 88, 64 * i + 12, 16, 10);
			spriteList[indexOffset + 16].setOrigin(8, 9);
			spriteList[indexOffset + 17].setOrigin(8, 7);
			
			//RLeg
			spriteList[indexOffset + 18] = new Sprite(spriteSheet, 104, 64 * i + 0, 16, 12);
			spriteList[indexOffset + 19] = new Sprite(spriteSheet, 104, 64 * i + 12, 16, 10);
			spriteList[indexOffset + 18].setOrigin(8, 9);
			spriteList[indexOffset + 19].setOrigin(8, 7);
			
		}				
	}
	
	public void fillAnimationTimings(){
		
		int animTime = 100;
		
		
		for (int i = 0; i < numberOfAnimations; i++) {
			for (int j = 0; j < numberOfSpriteParts * 4; j++) {
				animationStateSets[i][j] = new AnimationStateSet();
			}
		}		
		//north
		//body
		animationStateSets[0][0].stateList = new AnimationState[1];
		animationStateSets[0][0].stateList[0] = new AnimationState(0, 0, 1, 1);
		//head
		
		animationStateSets[0][1].stateList = new AnimationState[1];
		animationStateSets[0][1].stateList[0] = new AnimationState(0, 0, 1, 1);

		//LArm
		animationStateSets[0][2].stateList = new AnimationState[3];
		animationStateSets[0][2].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		animationStateSets[0][2].stateList[1] = new AnimationState(animTime, 0, 1, 1);
		animationStateSets[0][2].stateList[2] = new AnimationState(animTime * 2, 0, 1, 0.5f);
		
		animationStateSets[0][3].stateList = new AnimationState[3];
		animationStateSets[0][3].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		animationStateSets[0][3].stateList[1] = new AnimationState(animTime, 0, 1, 1);
		animationStateSets[0][3].stateList[2] = new AnimationState(animTime * 2, 0, 1, 0.5f);
		
		//RArm
		animationStateSets[0][4].stateList = new AnimationState[3];
		animationStateSets[0][4].stateList[0] = new AnimationState(0, 0, 1, 1);
		animationStateSets[0][4].stateList[1] = new AnimationState(animTime, 0, 1, 0.5f);
		animationStateSets[0][4].stateList[2] = new AnimationState(animTime * 2, 0, 1, 1);
		
		animationStateSets[0][5].stateList = new AnimationState[3];
		animationStateSets[0][5].stateList[0] = new AnimationState(0, 0, 1, 1);
		animationStateSets[0][5].stateList[1] = new AnimationState(animTime, 0, 1, 0.5f);
		animationStateSets[0][5].stateList[2] = new AnimationState(animTime * 2, 0, 1, 1);
		
		//LLeg
		animationStateSets[0][6].stateList = new AnimationState[3];
		animationStateSets[0][6].stateList[0] = new AnimationState(0, 0, 1, 1);
		animationStateSets[0][6].stateList[1] = new AnimationState(animTime, 0, 1, 0.5f);
		animationStateSets[0][6].stateList[2] = new AnimationState(animTime * 2, 0, 1, 1);
		
		animationStateSets[0][7].stateList = new AnimationState[3];
		animationStateSets[0][7].stateList[0] = new AnimationState(0, 0, 1, 1);
		animationStateSets[0][7].stateList[1] = new AnimationState(animTime, 0, 1, 0.5f);
		animationStateSets[0][7].stateList[2] = new AnimationState(animTime * 2, 0, 1, 1);
		
		//RLeg
		animationStateSets[0][8].stateList = new AnimationState[3];
		animationStateSets[0][8].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		animationStateSets[0][8].stateList[1] = new AnimationState(animTime, 0, 1, 1);
		animationStateSets[0][8].stateList[2] = new AnimationState(animTime * 2, 0, 1, 0.5f);
		
		animationStateSets[0][9].stateList = new AnimationState[3];
		animationStateSets[0][9].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		animationStateSets[0][9].stateList[1] = new AnimationState(animTime, 0, 1, 1);
		animationStateSets[0][9].stateList[2] = new AnimationState(animTime * 2, 0, 1, 0.5f);

	}
	
	public void setOffsetVectors()
	{
		int indexOffset;
		
		for (int i = 0; i < 2; i++) {
			indexOffset = 2 * i * numberOfSpriteParts;
			//NORTH-SOUTH
			//body
			offsetVectors[indexOffset] = new Vector2Scalbl(18, 19);
			//head
			offsetVectors[indexOffset + 1] = new Vector2Scalbl(0, 9);
			//left arm
			offsetVectors[indexOffset + 2] = new Vector2Scalbl(-11, 4);
			offsetVectors[indexOffset + 3] = new Vector2Scalbl(-3, -6);
			
			//right arm
			offsetVectors[indexOffset + 4] = new Vector2Scalbl(12, 4);
			offsetVectors[indexOffset + 5] = new Vector2Scalbl(2, -6);

			//left leg
			offsetVectors[indexOffset + 6] = new Vector2Scalbl(-5, -8);
			offsetVectors[indexOffset + 7] = new Vector2Scalbl(0, -6);
			
			//right leg
			offsetVectors[indexOffset + 8] = new Vector2Scalbl(6, -8);
			offsetVectors[indexOffset + 9] = new Vector2Scalbl(0, -6);
			
			//EAST-WEST
			//body
			offsetVectors[indexOffset + 10] = new Vector2Scalbl(18, 20);
			//head
			offsetVectors[indexOffset + 11] = new Vector2Scalbl(0, 8); 
			//left arm
			offsetVectors[indexOffset + 12] = new Vector2Scalbl(0, 3); 
			offsetVectors[indexOffset + 13] = new Vector2Scalbl(0, -7);
			
			//right arm
			offsetVectors[indexOffset + 14] = new Vector2Scalbl(0, 3);
			offsetVectors[indexOffset + 15] = new Vector2Scalbl(0, -7);

			//left leg
			offsetVectors[indexOffset + 16] = new Vector2Scalbl(0, -9); 
			offsetVectors[indexOffset + 17] = new Vector2Scalbl(0, -7); 
			
			//right leg
			offsetVectors[indexOffset + 18] = new Vector2Scalbl(0, -9);
			offsetVectors[indexOffset + 19] = new Vector2Scalbl(0, -7);
		}
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
	
	
	
	
	public void setPosition(Vector2 a_position){
		
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
		
	
	
	public void update(Direction a_direction)
	{
		if (!isAnimationRunning)
			return;
		
		int offsetIndex = getOffsetIndex(a_direction);
		deltaAnimationTime += (int)(Gdx.graphics.getDeltaTime() * 1000);
		
		for (int i = 0; i < numberOfSpriteParts; i++) {
			updateSpritePartPosition(offsetIndex + i, deltaAnimationTime);
		}
	}
	
	public void startAnimation(int a_animationNumber, Direction a_direction){
		deltaAnimationTime = 0;
		currentAnimation = a_animationNumber;
		currentDirection = a_direction;
		isAnimationRunning = true;
	}
	
	public void stopAnimation(){
		isAnimationRunning = false;
	}
	
	private void updateSpritePartPosition(int a_index, int a_deltaAnimationTime){

		if (a_index < 0) {
			return;
		}
		
		int numberOfAnimStates = animationStateSets[currentAnimation][a_index].stateList.length;
		if (numberOfAnimStates < 2) // no calculation for onyl one entry in the list
			return;
		int currentState = 1;
		float percentOfState = 0; //times hundred. faster calc
		float newRotValue = 0f;
		float newScaleX = 0f;
		float newScaleY = 0f;
		
		a_deltaAnimationTime = a_deltaAnimationTime % animationStateSets[currentAnimation][a_index].stateList[numberOfAnimStates - 1].millisecondsFromStart;
		
		//finding of current state
		for (int i = 0; i < numberOfAnimStates - 1; i++) {	
			if(a_deltaAnimationTime > animationStateSets[currentAnimation][a_index].stateList[i].millisecondsFromStart && 
					a_deltaAnimationTime < animationStateSets[currentAnimation][a_index].stateList[i+1].millisecondsFromStart){
				currentState = i + 1;
				break;
			}
		}
		
		a_deltaAnimationTime -= animationStateSets[currentAnimation][a_index].stateList[currentState - 1].millisecondsFromStart;
		
		
		percentOfState = (int)(animationStateSets[currentAnimation][a_index].stateList[currentState].millisecondsFromStart -
							animationStateSets[currentAnimation][a_index].stateList[currentState - 1].millisecondsFromStart) / 100;
		percentOfState = (float)a_deltaAnimationTime / percentOfState / 100;
		
		
		
		newRotValue = (animationStateSets[currentAnimation][a_index].stateList[currentState].rotation - 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].rotation) * percentOfState;
		
		
		setBoneRotation(newRotValue, a_index);
		
		
		newScaleX = (float)(animationStateSets[currentAnimation][a_index].stateList[currentState].scaleX - 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleX) * percentOfState;
		newScaleY = (float)(animationStateSets[currentAnimation][a_index].stateList[currentState].scaleY - 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleY) * percentOfState;
		
		
		setBoneScale(animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleX + newScaleX, 
				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleY + newScaleY, a_index);
//		spriteList[a_index].setScale(animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleX + newScaleX, 
//				animationStateSets[currentAnimation][a_index].stateList[currentState - 1].scaleY + newScaleY);
	

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
