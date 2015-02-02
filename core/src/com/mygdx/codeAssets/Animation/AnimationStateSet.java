package com.mygdx.codeAssets.Animation;

public class AnimationStateSet {
		public AnimationState[] stateList;
		public final int stateListLength;

		public AnimationStateSet(int a_numberOfAnimationStates) {
			stateList = new AnimationState[a_numberOfAnimationStates];
			stateListLength = a_numberOfAnimationStates;
		}
		
		public int getAnimationTime(){
			return stateList[stateListLength - 1].millisecondsFromStart;
		}
		
		public int getDeltaMilliseconds(int a_index){
			if(!isInBounds(a_index))
				return -1;
			return stateList[a_index].millisecondsFromStart - stateList[a_index - 1].millisecondsFromStart;
		}
		
		public float getDeltaRotation(int a_index){
			if(!isInBounds(a_index))
				return -1;
			return stateList[a_index].rotation - stateList[a_index - 1].rotation;
		}
		
		public float getDeltaScaleX(int a_index){
			if(!isInBounds(a_index))
				return -1;
			return stateList[a_index].scaleX - stateList[a_index - 1].scaleX;
		}
		
		public float getDeltaScaleY(int a_index){
			if(!isInBounds(a_index))
				return -1;
			return stateList[a_index].scaleY - stateList[a_index - 1].scaleY;
		}
		
		private boolean isInBounds(int a_index){
			if (a_index < 1 || a_index >= stateListLength) {
				return false;
			}			
			return true;
		}
}
