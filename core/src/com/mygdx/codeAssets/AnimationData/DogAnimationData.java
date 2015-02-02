package com.mygdx.codeAssets.AnimationData;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.codeAssets.Animation.AnimationBone;
import com.mygdx.codeAssets.Animation.AnimationState;
import com.mygdx.codeAssets.Animation.AnimationStateSet;
import com.mygdx.codeAssets.Objects.Vector2Scalbl;

public class DogAnimationData {
	public final static int walkingAnimationTime = 1250;
	public final static int idleAnimationTime = 2000;
	public final static int numberOfAnimations = 2;
	
	
	public static AnimationBone getAnimationStructurN(){
		// »» NORTH ««
		//body
		Texture currentTexture = new Texture("Animals/dog.png");
		Sprite currentSprite;
		Vector2Scalbl offsetVector;
		AnimationStateSet[] currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		//body
		currentSprite = new Sprite(currentTexture, 0, 5, 8, 11);
		currentSprite.setOrigin(4, 6);
		offsetVector = new Vector2Scalbl(4, 6);
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone body = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 1, 10);
		
		//head
		currentSprite = new Sprite(currentTexture, 8, 4, 8, 12);
		currentSprite.setOrigin(4, 3);
		offsetVector = new Vector2Scalbl(0, 2);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 30, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);

		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone head = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 2, 9);
		
		//rearLLeg
		currentSprite = new Sprite(currentTexture, 0, 0, 4, 5);
		currentSprite.setOrigin(2, 4);
		offsetVector = new Vector2Scalbl(-2, -4);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone rearLLeg = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 3, 11);
		
		//rearLFoot
		currentSprite = new Sprite(currentTexture, 8, 0, 4, 4);
		currentSprite.setOrigin(2, 3);
		offsetVector = new Vector2Scalbl(0, -2);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone rearLFoot = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 4, 12);
		
		//rearRLeg
		currentSprite = new Sprite(currentTexture, 4, 0, 4, 5);
		currentSprite.setOrigin(2, 4);
		offsetVector = new Vector2Scalbl(2, -4);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone rearRLeg = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 5, 11);
		
		//rearRFoot
		currentSprite = new Sprite(currentTexture, 12, 0, 4, 4);
		currentSprite.setOrigin(2, 3);
		offsetVector = new Vector2Scalbl(0, -2);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];
		
		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone rearRFoot = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 6, 12);
		
		//tailOne
		currentSprite = new Sprite(currentTexture, 16, 0, 3, 4);
		currentSprite.setOrigin(2, 3);
		offsetVector = new Vector2Scalbl(0, -4);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone tailOne = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 7, 9);

		//tailTwo
		currentSprite = new Sprite(currentTexture, 16, 4, 3, 4);
		currentSprite.setOrigin(2, 3);
		offsetVector = new Vector2Scalbl(1, -2);
		currentAnimationStateSets = new AnimationStateSet[numberOfAnimations];

		currentAnimationStateSets[0] = new AnimationStateSet(3);
		currentAnimationStateSets[0].stateList[0] = new AnimationState(0, 0, 1, 1);
		currentAnimationStateSets[0].stateList[1] = new AnimationState(walkingAnimationTime / 2, 0, 1, 1);
		currentAnimationStateSets[0].stateList[2] = new AnimationState(walkingAnimationTime, 0, 1, 1);
		
		currentAnimationStateSets[1] = new AnimationStateSet(1);
		currentAnimationStateSets[1].stateList[0] = new AnimationState(0, 0, 1, 1);
		
		AnimationBone tailTwo = new AnimationBone(currentSprite, offsetVector, currentAnimationStateSets, 8, 9);
		
		
		body.addAnimationBoneChild(head);

		body.addAnimationBoneChild(rearLLeg);
		body.addAnimationBoneChild(rearRLeg);
		body.addAnimationBoneChild(tailOne);
		
		rearLLeg.addAnimationBoneChild(rearLFoot);
		rearRLeg.addAnimationBoneChild(rearRFoot);
		tailOne.addAnimationBoneChild(tailTwo);

		
		return body;
	}

}
