package com.mygdx.codeAssets.AnimationData;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.codeAssets.Animation.AnimationBone;
import com.mygdx.codeAssets.Animation.AnimationState;
import com.mygdx.codeAssets.Animation.AnimationStateSet;
import com.mygdx.codeAssets.Objects.Vector2Scalbl;

public class PlayerAnimationData {

	public final static int walkingAnimationTime = 250;
	public final static int idleAnimationTime = 2000;
	public final static int numberOfAnimations = 2;
	private final static String texturePath = "Armors/TestArmor/TestArmor3.png";
	
	public static AnimationBone getAnimationStructureNorth(){
		Texture currentTexture = new Texture(texturePath);
		Sprite currentSprite;
		Vector2Scalbl offsetVector;
		AnimationStateSet[] currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		//body
		currentSprite = new Sprite(currentTexture, 24, 0, 40, 23);
		currentSprite.setOrigin(20, 4);
		offsetVector = new Vector2Scalbl(16, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.95f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(3);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[1].stateList[1] = new AnimationState(idleAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[1].stateList[2] = new AnimationState(idleAnimationTime, 0, 1, 1);
		
		AnimationBone body = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 1, 10);
		
		//head
		currentSprite = new Sprite(currentTexture, 30, 23, 34, 41);
		currentSprite.setOrigin(17, 10);
		offsetVector = new Vector2Scalbl(0, 18);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(1);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone head = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 2, 9);

		
		//LArm
		currentSprite = new Sprite(currentTexture, 0, 0, 12, 12);
		currentSprite.setOrigin(9, 9);
		offsetVector = new Vector2Scalbl(-10, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 3, 11);
		
		//LForearm
		currentSprite = new Sprite(currentTexture, 0, 12, 12, 11);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(-3, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 4, 12);
		
		
		//RArm
		currentSprite = new Sprite(currentTexture, 12, 0, 12, 12);
		currentSprite.setOrigin(4, 9);
		offsetVector = new Vector2Scalbl(11, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 5, 11);

		//RForearm
		currentSprite = new Sprite(currentTexture, 12, 12, 12, 11);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(2, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 6, 12);
		
		
		//LLeg
		currentSprite = new Sprite(currentTexture, 0, 23, 15, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(-5, 0);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 7, 11);
		
		//LFoot
		currentSprite = new Sprite(currentTexture, 0, 35, 15, 10);
		currentSprite.setOrigin(8, 8);
		offsetVector = new Vector2Scalbl(0, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 8, 12);
		

		//RLeg
		currentSprite = new Sprite(currentTexture,  15, 23, 15, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(6, 0);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 9, 13);

		//RFoot
		currentSprite = new Sprite(currentTexture, 15, 35, 15, 10);
		currentSprite.setOrigin(8, 8);
		offsetVector = new Vector2Scalbl(0, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 10, 14);
		
		
		//setting references
		LArm.addAnimationBoneChild(LForearm);
		RArm.addAnimationBoneChild(RForearm);
		LLeg.addAnimationBoneChild(LFoot);
		RLeg.addAnimationBoneChild(RFoot);
		

		body.addAnimationBoneChild(head);
		body.addAnimationBoneChild(LArm);
		body.addAnimationBoneChild(RArm);
		body.addAnimationBoneChild(LLeg);
		body.addAnimationBoneChild(RLeg);
		
		//returning head of structure
		return body;
	}
	
	public static AnimationBone getAnimationStructureSouth(){
		Texture currentTexture = new Texture(texturePath);
		Sprite currentSprite;
		Vector2Scalbl offsetVector;
		AnimationStateSet[] currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		//body
		currentSprite = new Sprite(currentTexture, 24, 64, 40, 23);
		currentSprite.setOrigin(20, 4);
		offsetVector = new Vector2Scalbl(16, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(3);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[1].stateList[1] = new AnimationState(idleAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[1].stateList[2] = new AnimationState(idleAnimationTime, 0, 1, 1);
		
		AnimationBone body = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 1, 10);
		
		//head
		currentSprite = new Sprite(currentTexture, 30, 87, 34, 41);
		currentSprite.setOrigin(17, 10);
		offsetVector = new Vector2Scalbl(0, 16);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(1);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone head = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 2, 9);

		
		//LArm
		currentSprite = new Sprite(currentTexture, 0, 64, 12, 12);
		currentSprite.setOrigin(9, 9);
		offsetVector = new Vector2Scalbl(-10, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 3, 11);
		
		//LForearm
		currentSprite = new Sprite(currentTexture, 0, 76, 12, 11);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(-3, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 4, 12);
		
		
		//RArm
		currentSprite = new Sprite(currentTexture, 12, 64, 12, 12);
		currentSprite.setOrigin(4, 9);
		offsetVector = new Vector2Scalbl(11, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 5, 11);

		//RForearm
		currentSprite = new Sprite(currentTexture, 12, 76, 12, 11);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(2, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 6, 12);
		
		
		//LLeg
		currentSprite = new Sprite(currentTexture, 0, 87, 15, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(-5, 0);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 7, 11);
		
		//LFoot
		currentSprite = new Sprite(currentTexture, 0, 99, 15, 10);
		currentSprite.setOrigin(8, 8);
		offsetVector = new Vector2Scalbl(0, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 8, 12);
		

		//RLeg
		currentSprite = new Sprite(currentTexture,  15, 87, 15, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(6, 0);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 9, 13);

		//RFoot
		currentSprite = new Sprite(currentTexture, 15, 99, 15, 10);
		currentSprite.setOrigin(8, 8);
		offsetVector = new Vector2Scalbl(0, -6);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 0.5f);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 0.5f);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 10, 14);
		
		
		//setting references
		LArm.addAnimationBoneChild(LForearm);
		RArm.addAnimationBoneChild(RForearm);
		LLeg.addAnimationBoneChild(LFoot);
		RLeg.addAnimationBoneChild(RFoot);
		

		body.addAnimationBoneChild(head);
		body.addAnimationBoneChild(LArm);
		body.addAnimationBoneChild(RArm);
		body.addAnimationBoneChild(LLeg);
		body.addAnimationBoneChild(RLeg);
		
		//returning head of structure
		return body;
	}
	
	public static AnimationBone getAnimationStructureEast(){
		Texture currentTexture = new Texture(texturePath);
		Sprite currentSprite;
		Vector2Scalbl offsetVector;
		AnimationStateSet[] currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		//body
		currentSprite = new Sprite(currentTexture, 64, 23, 24, 20);
		currentSprite.setOrigin(12, 3);
		offsetVector = new Vector2Scalbl(16, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[0].stateList[2] =  new AnimationState(walkingAnimationTime, 0, 1, 1);

		
		currentAnimationStateSets[1] = new AnimationStateSet(3);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[1].stateList[1] = new AnimationState(idleAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[1].stateList[2] = new AnimationState(idleAnimationTime, 0, 1, 1);
		
		AnimationBone body = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 1, 10);
		
		//head
		currentSprite = new Sprite(currentTexture, 88, 23, 34, 41);
		currentSprite.setOrigin(17, 10);
		offsetVector = new Vector2Scalbl(1, 17);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(1);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone head = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 2, 9);

		
		//LArm
		currentSprite = new Sprite(currentTexture, 64, 0, 12, 12);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(0, 11); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 15, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 3, 11);
		
		//LForearm
		currentSprite = new Sprite(currentTexture, 64, 12, 12, 11);
		currentSprite.setOrigin(6, 8);
		offsetVector = new Vector2Scalbl(0, -7);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 30, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 30, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 4, 12);
		
		
		//RArm
		currentSprite = new Sprite(currentTexture, 76, 0, 12, 12);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(0, 11);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, -15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -15, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 5, 6);

		//RForearm
		currentSprite = new Sprite(currentTexture, 76, 12, 12, 11);
		currentSprite.setOrigin(6, 8);
		offsetVector = new Vector2Scalbl(0, -7);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, -30, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -30, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 6, 7);
		
		
		//LLeg
		currentSprite = new Sprite(currentTexture,  88, 0, 16, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(0, 0); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, -15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -15, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 7, 13);
		
		//LFoot
		currentSprite = new Sprite(currentTexture, 88, 12, 16, 10);
		currentSprite.setOrigin(8, 7);
		offsetVector = new Vector2Scalbl(0, -7); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0,-30, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 10, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -30, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 8, 14);
		

		//RLeg
		currentSprite = new Sprite(currentTexture, 104, 0, 16, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(0, 0);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 15, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 9, 11);

		//RFoot
		currentSprite = new Sprite(currentTexture, 104, 12, 16, 10);;
		currentSprite.setOrigin(8, 7);
		offsetVector = new Vector2Scalbl(0, -7); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 10, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 10, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 10, 12);
		
		
		//setting references
		LArm.addAnimationBoneChild(LForearm);
		RArm.addAnimationBoneChild(RForearm);
		LLeg.addAnimationBoneChild(LFoot);
		RLeg.addAnimationBoneChild(RFoot);
		

		body.addAnimationBoneChild(head);
		body.addAnimationBoneChild(LArm);
		body.addAnimationBoneChild(RArm);
		body.addAnimationBoneChild(LLeg);
		body.addAnimationBoneChild(RLeg);
		
		//returning head of structure
		return body;
	}
	
	public static AnimationBone getAnimationStructureWest(){
		Texture currentTexture = new Texture(texturePath);
		Sprite currentSprite;
		Vector2Scalbl offsetVector;
		AnimationStateSet[] currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		//body
		currentSprite = new Sprite(currentTexture, 64, 87, 24, 20);
		currentSprite.setOrigin(12, 3);
		offsetVector = new Vector2Scalbl(16, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[0].stateList[2] =  new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(3);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[1].stateList[1] = new AnimationState(idleAnimationTime / 2, 0, 1, 0.9f);
		currentAnimationStateSets[1].stateList[2] = new AnimationState(idleAnimationTime, 0, 1, 1);
		
		AnimationBone body = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 1, 10);
		
		//head
		currentSprite = new Sprite(currentTexture, 88, 87, 34, 41);
		currentSprite.setOrigin(17, 10);
		offsetVector = new Vector2Scalbl(-1, 17);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(1);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone head = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 2, 9);

		
		//LArm
		currentSprite = new Sprite(currentTexture, 64, 64, 12, 12);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(0, 12); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 15, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 3, 6);
		
		//LForearm
		currentSprite = new Sprite(currentTexture, 64, 76, 12, 11);
		currentSprite.setOrigin(6, 8);
		offsetVector = new Vector2Scalbl(0, -7);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 30, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 30, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 4, 7);
		
		
		//RArm
		currentSprite = new Sprite(currentTexture, 76, 64, 12, 12);
		currentSprite.setOrigin(6, 9);
		offsetVector = new Vector2Scalbl(0, 12);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, -15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -15, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RArm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 5, 11);

		//RForearm
		currentSprite = new Sprite(currentTexture, 76, 76, 12, 11);
		currentSprite.setOrigin(6, 8);
		offsetVector = new Vector2Scalbl(0, -7);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, -30, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -30, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RForearm =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 6, 12);
		
		
		//LLeg
		currentSprite = new Sprite(currentTexture,  88, 64, 16, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(0, 0); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, -15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -15, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);
		
		AnimationBone LLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 7, 13);
		
		//LFoot
		currentSprite = new Sprite(currentTexture, 88, 76, 16, 10);
		currentSprite.setOrigin(8, 7);
		offsetVector = new Vector2Scalbl(0, -7); 
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0,-30, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 10, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, -30, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone LFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 8, 14);
		

		//RLeg
		currentSprite = new Sprite(currentTexture, 104, 64, 16, 12);
		currentSprite.setOrigin(8, 9);
		offsetVector = new Vector2Scalbl(0, 0);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 15, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -15, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 15, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RLeg =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 9, 11);

		//RFoot
		currentSprite = new Sprite(currentTexture, 104, 76, 16, 10);;
		currentSprite.setOrigin(8, 7);
		offsetVector = new Vector2Scalbl(0, -7);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 10, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, -30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 10, 1, 1);

		currentAnimationStateSets[1] = new AnimationStateSet(0);

		AnimationBone RFoot =  new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 10, 12);
		
		
		//setting references
		LArm.addAnimationBoneChild(LForearm);
		RArm.addAnimationBoneChild(RForearm);
		LLeg.addAnimationBoneChild(LFoot);
		RLeg.addAnimationBoneChild(RFoot);
		

		body.addAnimationBoneChild(head);
		body.addAnimationBoneChild(LArm);
		body.addAnimationBoneChild(RArm);
		body.addAnimationBoneChild(LLeg);
		body.addAnimationBoneChild(RLeg);
		
		//returning head of structure
		return body;
	}
	
}
