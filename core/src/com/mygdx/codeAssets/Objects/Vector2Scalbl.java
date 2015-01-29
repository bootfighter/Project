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
	
	
	public Vector2Scalbl(int a_x, int a_y) {
		x = a_x;
		y = a_y;
		transformedX = a_x;
		transformedY = a_y;
		rotation = 0;
		scaleX = 1;
		scaleY = 1;
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
		tmp.x *= scaleX;
		tmp.y *= scaleY;
		tmp.rotate(rotation);
		transformedX = tmp.x;
		transformedY = tmp.y;
	}
}
