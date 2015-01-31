package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.math.Vector2;

public class Vector2Scalbl extends Vector2{
	private static final long serialVersionUID = 1L;
	private Vector2 tmp;
	public float transformedX;
	public float transformedY;
	private float rotation;
	private float scaleX;
	private float scaleY;
	private float globalScaleX;
	private float globalScaleY;
	
	
	public Vector2Scalbl(int a_x, int a_y) {
		x = a_x;
		y = a_y;
		transformedX = a_x;
		transformedY = a_y;
		rotation = 0;
		scaleX = 1;
		scaleY = 1;
		globalScaleX = 1;
		globalScaleY = 1;
	}

	public void setGlobalScale(float a_globalScaleX, float a_globalScaleY) {
		globalScaleX = a_globalScaleX;
		globalScaleY = a_globalScaleY;
		updateTransformed();
	}
	
	public void setScaleFromBase(float a_scaleX, float a_scaleY)
	{
		scaleX = a_scaleX;
		scaleY = a_scaleY;
		updateTransformed();
	}
	
	public void setRotationOfBase(float a_angle){
		rotation = a_angle;
		updateTransformed();
	}
	private void updateTransformed(){
		tmp = new Vector2(x, y);
		tmp.x *= globalScaleX * scaleX;
		tmp.y *= globalScaleY * scaleY;
		tmp.rotate(rotation);
		transformedX = tmp.x;
		transformedY = tmp.y;
	}
}
