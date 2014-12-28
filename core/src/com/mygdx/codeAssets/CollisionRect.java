package com.mygdx.codeAssets;

public class CollisionRect {
	float X_point_1;
	float Y_point_1;
	
	float X_point_2;
	float Y_point_2;
	
	public CollisionRect(float X_1, float Y_1, float X_2, float Y_2) {
		X_point_1 = X_1;
		Y_point_1 = Y_1;
		
		X_point_2 = X_2;
		Y_point_2 = Y_2;
	}
	
	public float getX_point_1() {
		return X_point_1;
	}
	public float getY_point_1() {
		return Y_point_1;
	}
	public float getX_point_2() {
		return X_point_2;
	}
	public float getY_point_2() {
		return Y_point_2;
	}
}
