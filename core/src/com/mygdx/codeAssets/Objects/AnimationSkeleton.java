package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameParameters.Direction;

public class AnimationSkeleton {
	
	private Sprite spriteList[][];
	private int animationTimings[][];
	protected final int numberOfAnimations;
	private final int numberOfSpriteParts;
	protected int currentAnimation;
	private Vector2 originPosOffset;
	
	public AnimationSkeleton() {
		originPosOffset = new Vector2(8,30);
		numberOfSpriteParts = 14;
		numberOfAnimations = 1;
		currentAnimation = 0;
		spriteList = new Sprite[numberOfAnimations][numberOfSpriteParts * 4];
		animationTimings = new int[numberOfAnimations][numberOfSpriteParts];
	}
	
	public void fillSpriteList(String a_nameOfSprite, Direction a_direction, int a_animationNumber)
	{
		int indexOffset = 0;
		Texture spriteSheet = new Texture(a_nameOfSprite + ".png");
		if (a_direction == Direction.NORTH)
		
		
		if (a_direction == Direction.EAST)
			indexOffset = numberOfSpriteParts - 1;

		if (a_direction == Direction.SOUTH)
			indexOffset = 2 * numberOfSpriteParts - 1;

		
		if (a_direction == Direction.WEST)
			indexOffset = 3 * numberOfSpriteParts - 1;

		
		//head & body
		spriteList[a_animationNumber][indexOffset] = new Sprite(spriteSheet, 0, 0, 24, 28);
		spriteList[a_animationNumber][indexOffset + 1] = new Sprite(spriteSheet, 0, 28, 24, 36);
		//arms
		spriteList[a_animationNumber][indexOffset + 2] = new Sprite(spriteSheet, 24, 0, 16, 10);
		spriteList[a_animationNumber][indexOffset + 3] = new Sprite(spriteSheet, 24, 10, 16, 10);
		spriteList[a_animationNumber][indexOffset + 4] = new Sprite(spriteSheet, 40, 0, 14, 10);
		spriteList[a_animationNumber][indexOffset + 5] = new Sprite(spriteSheet, 40, 10, 14, 10);
		spriteList[a_animationNumber][indexOffset + 6] = new Sprite(spriteSheet, 54, 0, 10, 10);
		spriteList[a_animationNumber][indexOffset + 7] = new Sprite(spriteSheet, 54, 10, 10, 10);
		//legs
		spriteList[a_animationNumber][indexOffset + 8] = new Sprite(spriteSheet, 24, 20, 10, 16);
		spriteList[a_animationNumber][indexOffset + 9] = new Sprite(spriteSheet, 34, 20, 10, 16);
		spriteList[a_animationNumber][indexOffset + 10] = new Sprite(spriteSheet, 44, 20, 10, 14);
		spriteList[a_animationNumber][indexOffset + 11] = new Sprite(spriteSheet, 54, 20, 10, 14);
		spriteList[a_animationNumber][indexOffset + 12] = new Sprite(spriteSheet, 44, 34, 10, 9);
		spriteList[a_animationNumber][indexOffset + 13] = new Sprite(spriteSheet, 54, 34, 10, 9);
		
		
		spriteList[a_animationNumber][indexOffset].setCenter(12, 21);
		spriteList[a_animationNumber][indexOffset + 1].setCenter(12, 18);
		//arms
		spriteList[a_animationNumber][indexOffset + 2].setCenter(3, 5);
		spriteList[a_animationNumber][indexOffset + 3].setCenter(3, 5);
		spriteList[a_animationNumber][indexOffset + 4].setCenter(3, 5);
		spriteList[a_animationNumber][indexOffset + 5].setCenter(3, 5);
		spriteList[a_animationNumber][indexOffset + 6].setCenter(3, 5);
		spriteList[a_animationNumber][indexOffset + 7].setCenter(3, 5);
		//legs
		spriteList[a_animationNumber][indexOffset + 8].setCenter(5, 3);
		spriteList[a_animationNumber][indexOffset + 9].setCenter(5, 3);
		spriteList[a_animationNumber][indexOffset + 10].setCenter(5, 3);
		spriteList[a_animationNumber][indexOffset + 11].setCenter(5, 3);
		spriteList[a_animationNumber][indexOffset + 12].setCenter(5, 3);
		spriteList[a_animationNumber][indexOffset + 13].setCenter(5, 3);
	}
	
	
	
	
}
