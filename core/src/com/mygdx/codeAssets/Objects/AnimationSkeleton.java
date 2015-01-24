package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameParameters.Direction;

public class AnimationSkeleton {
	
	private Sprite spriteList[][];
	private int animationTimings[][];
	protected final int numberOfAnimations;
	private final int numberOfSpriteParts;
	protected int currentAnimation;
	private Vector2[][] offsetVectors;
	
	public AnimationSkeleton() {
		
		numberOfSpriteParts = 14;
		numberOfAnimations = 1;
		currentAnimation = 0;
		
		offsetVectors = new Vector2[numberOfAnimations][numberOfSpriteParts * 4];
		spriteList = new Sprite[numberOfAnimations][numberOfSpriteParts * 4];
		animationTimings = new int[numberOfAnimations][numberOfSpriteParts * 4];
		
		
		fillSpriteList("Armors/KnightArmor/KnightArmor_S", Direction.NORTH, 0);
		fillAnimationTimings(Direction.NORTH, 0);
		setOffsetVectors(Direction.NORTH, 0);		
		
		rotateBone(-45, 2, Direction.NORTH, 0);
		rotateBone(-45, 3, Direction.NORTH, 0);
		rotateBone(-45, 4, Direction.NORTH, 0);

		rotateBone(45, 5, Direction.NORTH, 0);
		rotateBone(45, 6, Direction.NORTH, 0);
		rotateBone(45, 7, Direction.NORTH, 0);


		
	}
	
	public void fillSpriteList(String a_nameOfSprite, Direction a_direction, int a_animationNumber)
	{
		int offsetIndex = getOffsetIndex(a_direction);
		Texture spriteSheet = new Texture(a_nameOfSprite + ".png");
		
		//body 
		spriteList[a_animationNumber][offsetIndex] = new Sprite(spriteSheet, 0, 28, 24, 36);
		spriteList[a_animationNumber][offsetIndex].setOrigin(12, 18);

		//head
		spriteList[a_animationNumber][offsetIndex + 1] = new Sprite(spriteSheet, 0, 0, 24, 28);
		spriteList[a_animationNumber][offsetIndex + 1].setOrigin(12, 9);

		//arms
		//left
		spriteList[a_animationNumber][offsetIndex + 2] = new Sprite(spriteSheet, 24, 0, 16, 10);
		spriteList[a_animationNumber][offsetIndex + 2].setOrigin(3, 5);
		
		spriteList[a_animationNumber][offsetIndex + 3] = new Sprite(spriteSheet, 40, 0, 14, 10);
		spriteList[a_animationNumber][offsetIndex + 3].setOrigin(3, 5);
		
		
		spriteList[a_animationNumber][offsetIndex + 4] = new Sprite(spriteSheet, 54, 0, 10, 10);
		spriteList[a_animationNumber][offsetIndex + 4].setOrigin(3, 5);
		
		//right
		spriteList[a_animationNumber][offsetIndex + 5] = new Sprite(spriteSheet, 24, 10, 16, 10);
		spriteList[a_animationNumber][offsetIndex + 5].rotate(180);
		spriteList[a_animationNumber][offsetIndex + 5].flip(false, true);
		spriteList[a_animationNumber][offsetIndex + 5].setOrigin(3, 5);

		spriteList[a_animationNumber][offsetIndex + 6] = new Sprite(spriteSheet, 40, 10, 14, 10);
		spriteList[a_animationNumber][offsetIndex + 6].rotate(180);		
		spriteList[a_animationNumber][offsetIndex + 6].flip(false, true);
		spriteList[a_animationNumber][offsetIndex + 6].setOrigin(3, 5);

		spriteList[a_animationNumber][offsetIndex + 7] = new Sprite(spriteSheet, 54, 10, 10, 10);
		spriteList[a_animationNumber][offsetIndex + 7].rotate(180);
		spriteList[a_animationNumber][offsetIndex + 7].flip(false, true);
		spriteList[a_animationNumber][offsetIndex + 7].setOrigin(3, 5);

		//legs
		//left
		spriteList[a_animationNumber][offsetIndex + 8] = new Sprite(spriteSheet, 24, 20, 10, 16);
		spriteList[a_animationNumber][offsetIndex + 8].setOrigin(5, 13);

		spriteList[a_animationNumber][offsetIndex + 9] = new Sprite(spriteSheet, 44, 20, 10, 14);
		spriteList[a_animationNumber][offsetIndex + 9].setOrigin(5, 11);
		
		spriteList[a_animationNumber][offsetIndex + 10] = new Sprite(spriteSheet, 44, 34, 10, 9);
		spriteList[a_animationNumber][offsetIndex + 10].setOrigin(5, 6);
		
		//right
		spriteList[a_animationNumber][offsetIndex + 11] = new Sprite(spriteSheet, 34, 20, 10, 16);
		spriteList[a_animationNumber][offsetIndex + 11].setOrigin(5, 13);
		
		spriteList[a_animationNumber][offsetIndex + 12] = new Sprite(spriteSheet, 54, 20, 10, 14);
		spriteList[a_animationNumber][offsetIndex + 12].setOrigin(5, 11);

		spriteList[a_animationNumber][offsetIndex + 13] = new Sprite(spriteSheet, 54, 34, 10, 9);
		spriteList[a_animationNumber][offsetIndex + 13].setOrigin(5, 6);
		
		
	}
	
	public void fillAnimationTimings(Direction a_direction, int a_animationNumber){
		
		int offsetIndex = getOffsetIndex(a_direction);
		
		for (int i = 0; i < numberOfSpriteParts; i++) {
			animationTimings[a_animationNumber][offsetIndex + i] = 100;
		}
	}
	
	public void setOffsetVectors(Direction a_direction, int a_animationNumber)
	{
		int offsetIndex = getOffsetIndex(a_direction);
		
		//everything in hero perspectiv looking towards player
		//body
		offsetVectors[a_animationNumber][offsetIndex] = new Vector2(12, 18);
		//head
		offsetVectors[a_animationNumber][offsetIndex + 1] = new Vector2(0, 12);
		//left arm
		offsetVectors[a_animationNumber][offsetIndex + 2] = new Vector2(8, 6);
		offsetVectors[a_animationNumber][offsetIndex + 3] = new Vector2(12, 0);
		offsetVectors[a_animationNumber][offsetIndex + 4] = new Vector2(10, 0);
		
		//right arm
		offsetVectors[a_animationNumber][offsetIndex + 5] = new Vector2(-8, 6);
		offsetVectors[a_animationNumber][offsetIndex + 6] = new Vector2(-12, 0);
		offsetVectors[a_animationNumber][offsetIndex + 7] = new Vector2(-10, 0);

		//left leg
		offsetVectors[a_animationNumber][offsetIndex + 8] = new Vector2(5, -10);
		offsetVectors[a_animationNumber][offsetIndex + 9] = new Vector2(0, -12);
		offsetVectors[a_animationNumber][offsetIndex + 10] = new Vector2(0, -10);
		
		//right leg
		offsetVectors[a_animationNumber][offsetIndex + 11] = new Vector2(-4, -10);
		offsetVectors[a_animationNumber][offsetIndex + 12] = new Vector2(0, -12);
		offsetVectors[a_animationNumber][offsetIndex + 13] = new Vector2(0, -10);
		
	}
	
	private int getOffsetIndex(Direction a_direction)
	{		
		if (a_direction == Direction.EAST)
			return (numberOfSpriteParts - 1);

		if (a_direction == Direction.SOUTH)
			return (2 * numberOfSpriteParts - 1);
		
		if (a_direction == Direction.WEST)
			return (3 * numberOfSpriteParts - 1);
		return 0;
	}
	
	public void setPosition(Vector2 a_position, Direction a_direction, int a_animationNumber){
		
		int offsetIndex = getOffsetIndex(a_direction);
		
		//body
		spriteList[a_animationNumber][offsetIndex].setPosition(a_position.x - 4, a_position.y);
		
		
		//head
		spriteList[a_animationNumber][offsetIndex + 1].setPosition(spriteList[a_animationNumber][offsetIndex].getX() + spriteList[a_animationNumber][offsetIndex].getOriginX() + 
				offsetVectors[a_animationNumber][offsetIndex + 1].x - spriteList[a_animationNumber][offsetIndex + 1].getOriginX(),
				spriteList[a_animationNumber][offsetIndex].getY() + spriteList[a_animationNumber][offsetIndex].getOriginY() + 
				offsetVectors[a_animationNumber][offsetIndex + 1].y - spriteList[a_animationNumber][offsetIndex + 1].getOriginY());
		
		
		//4 times - each for every gliedmasse
		for (int i = 0; i < 4; i++) {
			spriteList[a_animationNumber][offsetIndex + 2 + 3*i].setPosition(
					spriteList[a_animationNumber][offsetIndex].getX() + spriteList[a_animationNumber][offsetIndex].getOriginX() + 
					offsetVectors[a_animationNumber][offsetIndex + 2 + 3*i].x - spriteList[a_animationNumber][offsetIndex + 2 + 3*i].getOriginX(),
					spriteList[a_animationNumber][offsetIndex].getY() + spriteList[a_animationNumber][offsetIndex].getOriginY() + 
					offsetVectors[a_animationNumber][offsetIndex + 2 + 3*i].y - spriteList[a_animationNumber][offsetIndex + 2 + 3*i].getOriginY());
			
			spriteList[a_animationNumber][offsetIndex + 3 + 3*i].setPosition(
					spriteList[a_animationNumber][offsetIndex + 2 + 3*i].getX() + spriteList[a_animationNumber][offsetIndex + 2 + 3*i].getOriginX() + 
					offsetVectors[a_animationNumber][offsetIndex + 3 + 3*i].x - spriteList[a_animationNumber][offsetIndex + 3 + 3*i].getOriginX(),
					spriteList[a_animationNumber][offsetIndex + 2 + 3*i].getY() + spriteList[a_animationNumber][offsetIndex + 2 + 3*i].getOriginY()  + 
					offsetVectors[a_animationNumber][offsetIndex + 3 + 3*i].y - spriteList[a_animationNumber][offsetIndex + 3 + 3*i].getOriginY());

			spriteList[a_animationNumber][offsetIndex + 4 + 3*i].setPosition(
					spriteList[a_animationNumber][offsetIndex + 3 + 3*i].getX() + spriteList[a_animationNumber][offsetIndex + 3 + 3*i].getOriginX() + 
					offsetVectors[a_animationNumber][offsetIndex + 4 + 3*i].x - spriteList[a_animationNumber][offsetIndex + 4 + 3*i].getOriginX(),
					spriteList[a_animationNumber][offsetIndex + 3 + 3*i].getY() + spriteList[a_animationNumber][offsetIndex + 3 + 3*i].getOriginY()  + 
					offsetVectors[a_animationNumber][offsetIndex + 4 + 3*i].y - spriteList[a_animationNumber][offsetIndex + 4 + 3*i].getOriginY());
		}	
	}
	
	private void rotateBone(float a_rotation, int a_boneIndex, Direction a_direction, int a_animationNumber) {
		int offsetIndex = getOffsetIndex(a_direction);
		
		spriteList[a_animationNumber][offsetIndex + a_boneIndex].rotate(a_rotation);
		
		//if body
		if (a_boneIndex == 0) {
			offsetVectors[a_animationNumber][offsetIndex + a_boneIndex + 1].rotate(a_rotation); //head
			offsetVectors[a_animationNumber][offsetIndex + a_boneIndex + 2].rotate(a_rotation); //LArm
			offsetVectors[a_animationNumber][offsetIndex + a_boneIndex + 5].rotate(a_rotation); //RArm
			offsetVectors[a_animationNumber][offsetIndex + a_boneIndex + 8].rotate(a_rotation); //LLeg
			offsetVectors[a_animationNumber][offsetIndex + a_boneIndex + 11].rotate(a_rotation); //RLeg
		}else //if not the hands/feet  
			if (!(a_boneIndex == 4 || a_boneIndex == 7 || a_boneIndex == 10 || a_boneIndex == 13)) {
			offsetVectors[a_animationNumber][offsetIndex + a_boneIndex + 1].rotate(a_rotation);
		}
	}
	
	
 	public void testDraw(SpriteBatch a_batch, Direction a_direction, int a_animationNumber){
	
 		setPosition(new Vector2(64, 64), a_direction, a_animationNumber);
		a_batch.begin();
		
		for (int i = numberOfSpriteParts; i > 0; i--) {
			spriteList[a_animationNumber][i - 1].draw(a_batch);
		}
		a_batch.end();
	}
	
	
}
