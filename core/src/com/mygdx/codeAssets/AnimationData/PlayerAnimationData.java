package com.mygdx.codeAssets.AnimationData;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.codeAssets.Animation.AnimationState;
import com.mygdx.codeAssets.Animation.AnimationStateSet;
import com.mygdx.codeAssets.Objects.Vector2Scalbl;

public class PlayerAnimationData {

	public final static int walkingAnimationTime = 250;
	public final static int idleAnimationTime = 2000;
	public final static int numberOfSpriteParts = 10;
	public final static int numberOfAnimations = 2;
	
	public static void fillSpriteList(Sprite[] a_spriteList, String a_nameOfSprite){
		
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
			a_spriteList[indexOffset ] = new Sprite(spriteSheet, 24, 64 * i + 0, 40, 23);
			a_spriteList[indexOffset ].setOrigin(20, 12);
			//head
			a_spriteList[indexOffset + 1] = new Sprite(spriteSheet, 30, 64 * i + 23, 34, 41);
			a_spriteList[indexOffset + 1].setOrigin(17, 10);
			
			//LArm
			a_spriteList[indexOffset + 2] = new Sprite(spriteSheet, 0, 64 * i + 0, 12, 12);
			a_spriteList[indexOffset + 3] = new Sprite(spriteSheet, 0, 64 * i + 12, 12, 11);
			a_spriteList[indexOffset + 2].setOrigin(9, 9);
			a_spriteList[indexOffset + 3].setOrigin(6, 9);
	
			//RArm
			a_spriteList[indexOffset + 4] = new Sprite(spriteSheet, 12, 64 * i + 0, 12, 12);
			a_spriteList[indexOffset + 5] = new Sprite(spriteSheet, 12, 64 * i + 12, 12, 11);
			a_spriteList[indexOffset + 4].setOrigin(4, 9);
			a_spriteList[indexOffset + 5].setOrigin(6, 9);
			
			//LLeg
			a_spriteList[indexOffset + 6] = new Sprite(spriteSheet, 0, 64 * i + 23, 15, 12);
			a_spriteList[indexOffset + 7] = new Sprite(spriteSheet, 0, 64 * i + 35, 15, 10);
			a_spriteList[indexOffset + 6].setOrigin(8, 9);
			a_spriteList[indexOffset + 7].setOrigin(8, 8);
			
			//RLeg
			a_spriteList[indexOffset + 8] = new Sprite(spriteSheet, 15, 64 * i + 23, 15, 12);
			a_spriteList[indexOffset + 9] = new Sprite(spriteSheet, 15, 64 * i + 35, 15, 10);
			a_spriteList[indexOffset + 8].setOrigin(8, 9);
			a_spriteList[indexOffset + 9].setOrigin(8, 8);
			
			
			//EAST - WEST
			
			//body
			a_spriteList[indexOffset + 10] = new Sprite(spriteSheet, 64, 64 * i + 23, 24, 20);
			a_spriteList[indexOffset + 10].setOrigin(12, 12);
			//head
			a_spriteList[indexOffset + 11] = new Sprite(spriteSheet, 88, 64 * i + 23, 34, 41);
			a_spriteList[indexOffset + 11].setOrigin(17, 10);
			
			//LArm
			a_spriteList[indexOffset + 12] = new Sprite(spriteSheet, 64, 64 * i + 0, 12, 12);
			a_spriteList[indexOffset + 13] = new Sprite(spriteSheet, 64, 64 * i + 12, 12, 11);
			a_spriteList[indexOffset + 12].setOrigin(6, 9);
			a_spriteList[indexOffset + 13].setOrigin(6, 8);

			//RArm
			a_spriteList[indexOffset + 14] = new Sprite(spriteSheet, 76, 64 * i + 0, 12, 12);
			a_spriteList[indexOffset + 15] = new Sprite(spriteSheet, 76, 64 * i + 12, 12, 11);
			a_spriteList[indexOffset + 14].setOrigin(6, 9);
			a_spriteList[indexOffset + 15].setOrigin(6, 8);
			//LLeg
			a_spriteList[indexOffset + 16] = new Sprite(spriteSheet, 88, 64 * i + 0, 16, 12);
			a_spriteList[indexOffset + 17] = new Sprite(spriteSheet, 88, 64 * i + 12, 16, 10);
			a_spriteList[indexOffset + 16].setOrigin(8, 9);
			a_spriteList[indexOffset + 17].setOrigin(8, 7);
			
			//RLeg
			a_spriteList[indexOffset + 18] = new Sprite(spriteSheet, 104, 64 * i + 0, 16, 12);
			a_spriteList[indexOffset + 19] = new Sprite(spriteSheet, 104, 64 * i + 12, 16, 10);
			a_spriteList[indexOffset + 18].setOrigin(8, 9);
			a_spriteList[indexOffset + 19].setOrigin(8, 7);
		}				
	}
	
	public static void fillAnimationTimings(AnimationStateSet[][] a_animationStateSets)
	{
		
		
		int walkingTime = walkingAnimationTime;
		int idleTime = idleAnimationTime;
		
		
		for (int i = 0; i < numberOfAnimations; i++) {
			for (int j = 0; j < numberOfSpriteParts * 4; j++) {
				a_animationStateSets[i][j] = new AnimationStateSet(0);
			}
		}	
		//// »»»»»»»»»»»»»»»»»»»»»»»» WALKING ANIMATION ««««««««««««««««««««««««
		//NORTH
		//body
		a_animationStateSets[0][0].stateList = new AnimationState[3];
		a_animationStateSets[0][0].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][0].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.9f);
		a_animationStateSets[0][0].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);

		//head
		
		a_animationStateSets[0][1].stateList = new AnimationState[1];
		a_animationStateSets[0][1].stateList[0] = new AnimationState(0, 0, 1, 1);

		//LArm
		a_animationStateSets[0][2].stateList = new AnimationState[3];
		a_animationStateSets[0][2].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][2].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][2].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);
		
		a_animationStateSets[0][3].stateList = new AnimationState[3];
		a_animationStateSets[0][3].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][3].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][3].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);
		
		//RArm
		a_animationStateSets[0][4].stateList = new AnimationState[3];
		a_animationStateSets[0][4].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][4].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][4].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);
		
		a_animationStateSets[0][5].stateList = new AnimationState[3];
		a_animationStateSets[0][5].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][5].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][5].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);
		
		//LLeg
		a_animationStateSets[0][6].stateList = new AnimationState[3];
		a_animationStateSets[0][6].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][6].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][6].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);
		
		a_animationStateSets[0][7].stateList = new AnimationState[3];
		a_animationStateSets[0][7].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][7].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][7].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);
		
		//RLeg
		a_animationStateSets[0][8].stateList = new AnimationState[3];
		a_animationStateSets[0][8].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][8].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][8].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);
		
		a_animationStateSets[0][9].stateList = new AnimationState[3];
		a_animationStateSets[0][9].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][9].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][9].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);
		
		
		//EAST
		//body
		a_animationStateSets[0][10].stateList = new AnimationState[5];
		a_animationStateSets[0][10].stateList[0] = new AnimationState(0, 0, 1, 0.9f);
		a_animationStateSets[0][10].stateList[1] = new AnimationState(walkingTime / 4, 0, 1, 1);
		a_animationStateSets[0][10].stateList[2] = new AnimationState(walkingTime / 2, 0, 1, 0.9f);
		a_animationStateSets[0][10].stateList[3] = new AnimationState(3 * walkingTime / 4, 0, 1, 1);
		a_animationStateSets[0][10].stateList[4] = new AnimationState(walkingTime, 0, 1, 0.9f);
		//head

		//LArm
		a_animationStateSets[0][12].stateList = new AnimationState[3];
		a_animationStateSets[0][12].stateList[0] = new AnimationState(0, 15, 1, 1);
		a_animationStateSets[0][12].stateList[1] = new AnimationState(walkingTime / 2, -15, 1, 1);
		a_animationStateSets[0][12].stateList[2] = new AnimationState(walkingTime, 15, 1, 1);

		a_animationStateSets[0][13].stateList = new AnimationState[3];
		a_animationStateSets[0][13].stateList[0] = new AnimationState(0, 30, 1, 1);
		a_animationStateSets[0][13].stateList[1] = new AnimationState(walkingTime / 2, -30, 1, 1);
		a_animationStateSets[0][13].stateList[2] = new AnimationState(walkingTime, 30, 1, 1);

		//RArm
		a_animationStateSets[0][14].stateList = new AnimationState[3];
		a_animationStateSets[0][14].stateList[0] = new AnimationState(0, -15, 1, 1);
		a_animationStateSets[0][14].stateList[1] = new AnimationState(walkingTime / 2, 15, 1, 1);
		a_animationStateSets[0][14].stateList[2] = new AnimationState(walkingTime, -15, 1, 1);

		a_animationStateSets[0][15].stateList = new AnimationState[3];
		a_animationStateSets[0][15].stateList[0] = new AnimationState(0, -30, 1, 1);
		a_animationStateSets[0][15].stateList[1] = new AnimationState(walkingTime / 2, 30, 1, 1);
		a_animationStateSets[0][15].stateList[2] = new AnimationState(walkingTime, -30, 1, 1);

		//LLeg
		a_animationStateSets[0][16].stateList = new AnimationState[3];
		a_animationStateSets[0][16].stateList[0] = new AnimationState(0, -15, 1, 1);
		a_animationStateSets[0][16].stateList[1] = new AnimationState(walkingTime / 2, 15, 1, 1);
		a_animationStateSets[0][16].stateList[2] = new AnimationState(walkingTime, -15, 1, 1);

		a_animationStateSets[0][17].stateList = new AnimationState[3];
		a_animationStateSets[0][17].stateList[0] = new AnimationState(0, -30, 1, 1);
		a_animationStateSets[0][17].stateList[1] = new AnimationState(walkingTime / 2, 10, 1, 1);
		a_animationStateSets[0][17].stateList[2] = new AnimationState(walkingTime, -30, 1, 1);

		//RLeg
		a_animationStateSets[0][18].stateList = new AnimationState[3];
		a_animationStateSets[0][18].stateList[0] = new AnimationState(0, 15, 1, 1);
		a_animationStateSets[0][18].stateList[1] = new AnimationState(walkingTime / 2, -15, 1, 1);
		a_animationStateSets[0][18].stateList[2] = new AnimationState(walkingTime, 15, 1, 1);

		a_animationStateSets[0][19].stateList = new AnimationState[3];
		a_animationStateSets[0][19].stateList[0] = new AnimationState(0, 10, 1, 1);
		a_animationStateSets[0][19].stateList[1] = new AnimationState(walkingTime / 2, -30, 1, 1);
		a_animationStateSets[0][19].stateList[2] = new AnimationState(walkingTime, 10, 1, 1);
				
		
		
		//SOUTH
		//body
		a_animationStateSets[0][20].stateList = new AnimationState[3];
		a_animationStateSets[0][20].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][20].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.9f);
		a_animationStateSets[0][20].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);
		//head

		a_animationStateSets[0][21].stateList = new AnimationState[1];
		a_animationStateSets[0][21].stateList[0] = new AnimationState(0, 0, 1, 1);

		//LArm
		a_animationStateSets[0][22].stateList = new AnimationState[3];
		a_animationStateSets[0][22].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][22].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][22].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);

		a_animationStateSets[0][23].stateList = new AnimationState[3];
		a_animationStateSets[0][23].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][23].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][23].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);

		//RArm
		a_animationStateSets[0][24].stateList = new AnimationState[3];
		a_animationStateSets[0][24].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][24].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][24].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);

		a_animationStateSets[0][25].stateList = new AnimationState[3];
		a_animationStateSets[0][25].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][25].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][25].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);

		//LLeg
		a_animationStateSets[0][26].stateList = new AnimationState[3];
		a_animationStateSets[0][26].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][26].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][26].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);

		a_animationStateSets[0][27].stateList = new AnimationState[3];
		a_animationStateSets[0][27].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[0][27].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 0.5f);
		a_animationStateSets[0][27].stateList[2] = new AnimationState(walkingTime, 0, 1, 1);

		//RLeg
		a_animationStateSets[0][28].stateList = new AnimationState[3];
		a_animationStateSets[0][28].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][28].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][28].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);

		a_animationStateSets[0][29].stateList = new AnimationState[3];
		a_animationStateSets[0][29].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		a_animationStateSets[0][29].stateList[1] = new AnimationState(walkingTime / 2, 0, 1, 1);
		a_animationStateSets[0][29].stateList[2] = new AnimationState(walkingTime, 0, 1, 0.5f);

		//WEST
		//body
		a_animationStateSets[0][30].stateList = new AnimationState[5];
		a_animationStateSets[0][30].stateList[0] = new AnimationState(0, 0, 1, 0.9f);
		a_animationStateSets[0][30].stateList[1] = new AnimationState(walkingTime / 4, 0, 1, 1);
		a_animationStateSets[0][30].stateList[2] = new AnimationState(walkingTime / 2, 0, 1, 0.9f);
		a_animationStateSets[0][30].stateList[3] = new AnimationState(3 * walkingTime / 4, 0, 1, 1);
		a_animationStateSets[0][30].stateList[4] = new AnimationState(walkingTime, 0, 1, 0.9f);
		//head

		//LArm
		a_animationStateSets[0][32].stateList = new AnimationState[3];
		a_animationStateSets[0][32].stateList[0] = new AnimationState(0, 15, 1, 1);
		a_animationStateSets[0][32].stateList[1] = new AnimationState(walkingTime / 2, -15, 1, 1);
		a_animationStateSets[0][32].stateList[2] = new AnimationState(walkingTime, 15, 1, 1);

		a_animationStateSets[0][33].stateList = new AnimationState[3];
		a_animationStateSets[0][33].stateList[0] = new AnimationState(0, 30, 1, 1);
		a_animationStateSets[0][33].stateList[1] = new AnimationState(walkingTime / 2, -30, 1, 1);
		a_animationStateSets[0][33].stateList[2] = new AnimationState(walkingTime, 30, 1, 1);

		//RArm
		a_animationStateSets[0][34].stateList = new AnimationState[3];
		a_animationStateSets[0][34].stateList[0] = new AnimationState(0, -15, 1, 1);
		a_animationStateSets[0][34].stateList[1] = new AnimationState(walkingTime / 2, 15, 1, 1);
		a_animationStateSets[0][34].stateList[2] = new AnimationState(walkingTime, -15, 1, 1);

		a_animationStateSets[0][35].stateList = new AnimationState[3];
		a_animationStateSets[0][35].stateList[0] = new AnimationState(0, -30, 1, 1);
		a_animationStateSets[0][35].stateList[1] = new AnimationState(walkingTime / 2, 30, 1, 1);
		a_animationStateSets[0][35].stateList[2] = new AnimationState(walkingTime, -30, 1, 1);

		//LLeg
		a_animationStateSets[0][36].stateList = new AnimationState[3];
		a_animationStateSets[0][36].stateList[0] = new AnimationState(0, -15, 1, 1);
		a_animationStateSets[0][36].stateList[1] = new AnimationState(walkingTime / 2, 15, 1, 1);
		a_animationStateSets[0][36].stateList[2] = new AnimationState(walkingTime, -15, 1, 1);

		a_animationStateSets[0][37].stateList = new AnimationState[3];
		a_animationStateSets[0][37].stateList[0] = new AnimationState(0, -30, 1, 1);
		a_animationStateSets[0][37].stateList[1] = new AnimationState(walkingTime / 2, 10, 1, 1);
		a_animationStateSets[0][37].stateList[2] = new AnimationState(walkingTime, -30, 1, 1);

		//RLeg
		a_animationStateSets[0][38].stateList = new AnimationState[3];
		a_animationStateSets[0][38].stateList[0] = new AnimationState(0, 15, 1, 1);
		a_animationStateSets[0][38].stateList[1] = new AnimationState(walkingTime / 2, -15, 1, 1);
		a_animationStateSets[0][38].stateList[2] = new AnimationState(walkingTime, 15, 1, 1);

		a_animationStateSets[0][39].stateList = new AnimationState[3];
		a_animationStateSets[0][39].stateList[0] = new AnimationState(0, 10, 1, 1);
		a_animationStateSets[0][39].stateList[1] = new AnimationState(walkingTime / 2, -30, 1, 1);
		a_animationStateSets[0][39].stateList[2] = new AnimationState(walkingTime, 10, 1, 1);
		
		
		//// »»»»»»»»»»»»»»»»»»»»»»»» IDLE ANIMATION ««««««««««««««««««««««««

		//NORTH
		
		a_animationStateSets[1][0].stateList = new AnimationState[3];
		a_animationStateSets[1][0].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[1][0].stateList[1] = new AnimationState(idleTime / 2, 0, 1, 0.9f);
		a_animationStateSets[1][0].stateList[2] = new AnimationState(idleTime, 0, 1, 1);
		
		//EAST
		
		a_animationStateSets[1][10].stateList = new AnimationState[3];
		a_animationStateSets[1][10].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[1][10].stateList[1] = new AnimationState(idleTime / 2, 0, 1, 0.9f);
		a_animationStateSets[1][10].stateList[2] = new AnimationState(idleTime, 0, 1, 1);
		
		//SOUTH
		
		a_animationStateSets[1][20].stateList = new AnimationState[3];
		a_animationStateSets[1][20].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[1][20].stateList[1] = new AnimationState(idleTime / 2, 0, 1, 0.9f);
		a_animationStateSets[1][20].stateList[2] = new AnimationState(idleTime, 0, 1, 1);
		
		//WEST
		
		a_animationStateSets[1][30].stateList = new AnimationState[3];
		a_animationStateSets[1][30].stateList[0] = new AnimationState(0, 0, 1, 1);
		a_animationStateSets[1][30].stateList[1] = new AnimationState(idleTime / 2, 0, 1, 0.9f);
		a_animationStateSets[1][30].stateList[2] = new AnimationState(idleTime, 0, 1, 1);
		
	}
	
	public static void fillOffsetVectors(Vector2Scalbl[] a_offsetVectors){
		
		int indexOffset;

		for (int i = 0; i < 2; i++) {
			indexOffset = 2 * i * numberOfSpriteParts;
			//NORTH-SOUTH
			//body
			a_offsetVectors[indexOffset] = new Vector2Scalbl(18, 19);
			//head
			a_offsetVectors[indexOffset + 1] = new Vector2Scalbl(0, 9);
			//left arm
			a_offsetVectors[indexOffset + 2] = new Vector2Scalbl(-11, 4);
			a_offsetVectors[indexOffset + 3] = new Vector2Scalbl(-3, -6);

			//right arm
			a_offsetVectors[indexOffset + 4] = new Vector2Scalbl(12, 4);
			a_offsetVectors[indexOffset + 5] = new Vector2Scalbl(2, -6);

			//left leg
			a_offsetVectors[indexOffset + 6] = new Vector2Scalbl(-5, -8);
			a_offsetVectors[indexOffset + 7] = new Vector2Scalbl(0, -6);

			//right leg
			a_offsetVectors[indexOffset + 8] = new Vector2Scalbl(6, -8);
			a_offsetVectors[indexOffset + 9] = new Vector2Scalbl(0, -6);

			//EAST-WEST
			//body
			a_offsetVectors[indexOffset + 10] = new Vector2Scalbl(25, 20);
			//head
			a_offsetVectors[indexOffset + 11] = new Vector2Scalbl(0, 8); 
			//left arm
			a_offsetVectors[indexOffset + 12] = new Vector2Scalbl(0, 3); 
			a_offsetVectors[indexOffset + 13] = new Vector2Scalbl(0, -7);

			//right arm
			a_offsetVectors[indexOffset + 14] = new Vector2Scalbl(0, 3);
			a_offsetVectors[indexOffset + 15] = new Vector2Scalbl(0, -7);

			//left leg
			a_offsetVectors[indexOffset + 16] = new Vector2Scalbl(0, -9); 
			a_offsetVectors[indexOffset + 17] = new Vector2Scalbl(0, -7); 

			//right leg
			a_offsetVectors[indexOffset + 18] = new Vector2Scalbl(0, -9);
			a_offsetVectors[indexOffset + 19] = new Vector2Scalbl(0, -7);
		}
		
		//head offset in NORTHSOUTH
		a_offsetVectors[1].y++;
		a_offsetVectors[21].y--;
		//head offset in EASTWEST
		a_offsetVectors[11].x++;
		a_offsetVectors[31].x--;
	}
}
