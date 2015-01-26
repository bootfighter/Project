package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameParameters.Direction;

public class AnimationSkeleton {
	
	private Sprite spriteList[];
	private int animationTimings[][];
	protected final int numberOfAnimations;
	private final int numberOfSpriteParts;
	protected int currentAnimation;
	private Vector2[] offsetVectors;
	
	public AnimationSkeleton() {
		
		numberOfSpriteParts = 10;
		numberOfAnimations = 1;
		currentAnimation = 0;
		
		spriteList = new Sprite[numberOfSpriteParts * 4];
		animationTimings = new int[numberOfAnimations][numberOfSpriteParts * 4];
		offsetVectors = new Vector2[numberOfSpriteParts * 4];

		
		fillSpriteList("Armors/DebugArmor/DebugArmor");
		fillAnimationTimings(Direction.NORTH, 0);
		setOffsetVectors();			
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
	
	public void fillAnimationTimings(Direction a_direction, int a_animationNumber){
		
		int offsetIndex = getOffsetIndex(a_direction);
		
		for (int i = 0; i < numberOfSpriteParts * 4; i++) {
			animationTimings[a_animationNumber][offsetIndex + i] = 100;
		}
	}
	
	public void setOffsetVectors()
	{
		int indexOffset;
		
		for (int i = 0; i < 2; i++) {
			indexOffset = 2 * i * numberOfSpriteParts;
			//NORTH-SOUTH
			//body
			offsetVectors[indexOffset] = new Vector2(18, 19);
			//head
			offsetVectors[indexOffset + 1] = new Vector2(0, 9);
			//left arm
			offsetVectors[indexOffset + 2] = new Vector2(-11, 4);
			offsetVectors[indexOffset + 3] = new Vector2(-3, -6);
			
			//right arm
			offsetVectors[indexOffset + 4] = new Vector2(12, 4);
			offsetVectors[indexOffset + 5] = new Vector2(2, -6);

			//left leg
			offsetVectors[indexOffset + 6] = new Vector2(-5, -8);
			offsetVectors[indexOffset + 7] = new Vector2(0, -6);
			
			//right leg
			offsetVectors[indexOffset + 8] = new Vector2(6, -8);
			offsetVectors[indexOffset + 9] = new Vector2(0, -6);
			
			//EAST-WEST
			//body
			offsetVectors[indexOffset + 10] = new Vector2(18, 20);
			//head
			offsetVectors[indexOffset + 11] = new Vector2(0, 8); 
			//left arm
			offsetVectors[indexOffset + 12] = new Vector2(0, 3); 
			offsetVectors[indexOffset + 13] = new Vector2(0, -7);
			
			//right arm
			offsetVectors[indexOffset + 14] = new Vector2(0, 3);
			offsetVectors[indexOffset + 15] = new Vector2(0, -7);

			//left leg
			offsetVectors[indexOffset + 16] = new Vector2(0, -9); 
			offsetVectors[indexOffset + 17] = new Vector2(0, -7); 
			
			//right leg
			offsetVectors[indexOffset + 18] = new Vector2(0, -9);
			offsetVectors[indexOffset + 19] = new Vector2(0, -7);
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
	
	
	
	
	public void setPosition(Vector2 a_position, Direction a_direction){
		
		int offsetIndex = getOffsetIndex(a_direction);
		
		//body
		spriteList[offsetIndex].setPosition(a_position.x + offsetVectors[offsetIndex].x - 11, a_position.y + offsetVectors[offsetIndex].y- 7);
		
		//head
		spriteList[offsetIndex + 1].setPosition(spriteList[offsetIndex].getX() + spriteList[offsetIndex].getOriginX() + 
				offsetVectors[offsetIndex + 1].x - spriteList[offsetIndex + 1].getOriginX(),
				spriteList[offsetIndex].getY() + spriteList[offsetIndex].getOriginY() + 
				offsetVectors[offsetIndex + 1].y - spriteList[offsetIndex + 1].getOriginY());
		
		//4 times - each for every limb
		for (int i = 0; i < 4; i++) {
			
			spriteList[offsetIndex + 2 + 2*i].setPosition(
					spriteList[offsetIndex].getX() + spriteList[offsetIndex].getOriginX() + 
					offsetVectors[offsetIndex + 2 + 2*i].x - spriteList[offsetIndex + 2 + 2*i].getOriginX(),
					spriteList[offsetIndex].getY() + spriteList[offsetIndex].getOriginY() + 
					offsetVectors[offsetIndex + 2 + 2*i].y - spriteList[offsetIndex + 2 + 2*i].getOriginY());
			
			spriteList[offsetIndex + 3 + 2*i].setPosition(
					spriteList[offsetIndex + 2 + 2*i].getX() + spriteList[offsetIndex + 2 + 2*i].getOriginX() + 
					offsetVectors[offsetIndex + 3 + 2*i].x - spriteList[offsetIndex + 3 + 2*i].getOriginX(),
					spriteList[offsetIndex + 2 + 2*i].getY() + spriteList[offsetIndex + 2 + 2*i].getOriginY() + 
					offsetVectors[offsetIndex + 3 + 2*i].y - spriteList[offsetIndex + 3 + 2*i].getOriginY());

		}	
	}
	
	
	
	private void rotateBone(float a_rotation, int a_boneIndex, Direction a_direction) {
		
		
		int offsetIndex = getOffsetIndex(a_direction);
		
		spriteList[offsetIndex + a_boneIndex].rotate(a_rotation);
		
		//if body
		if (a_boneIndex == 0) {
			offsetVectors[offsetIndex + a_boneIndex + 1].rotate(a_rotation); //head
			offsetVectors[offsetIndex + a_boneIndex + 2].rotate(a_rotation); //LArm
			offsetVectors[offsetIndex + a_boneIndex + 4].rotate(a_rotation); //RArm
			offsetVectors[offsetIndex + a_boneIndex + 6].rotate(a_rotation); //LLeg
			offsetVectors[offsetIndex + a_boneIndex + 8].rotate(a_rotation); //RLeg
		}
		else //if not the hands/feet  
			if (a_boneIndex == 2 || a_boneIndex == 4 || a_boneIndex == 6 || a_boneIndex == 8) {
			offsetVectors[offsetIndex + a_boneIndex + 1].rotate(a_rotation);
		}
	}
	
	
	
	
 	public void testDraw(SpriteBatch a_batch, Direction a_direction, int a_animationNumber){
	
 		setPosition(new Vector2(64, 64), a_direction);
 		setPosition(new Vector2(100, 64), Direction.EAST);
 		setPosition(new Vector2(150, 64), Direction.SOUTH);
 		setPosition(new Vector2(200, 64), Direction.WEST);

 		
 		
		a_batch.begin();
		
		for (int i = numberOfSpriteParts * 4; i > 0; i--) {
			
			spriteList[i - 1].draw(a_batch);
		}
		a_batch.end();
	}
	
	
}
