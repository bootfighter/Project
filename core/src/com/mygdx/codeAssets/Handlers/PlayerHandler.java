package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class PlayerHandler {
	

	Vector3 position;
	Vector2 facingDirection;
	Vector2 direction;
	private int walkSpeed;
	private int sprintSpeed;
	boolean walking;
	boolean sprinting;
	Texture texture;
	
	public PlayerHandler() {
		position = Vector3.Zero;
		facingDirection = Vector2.Zero;
		direction = Vector2.Zero;
		walkSpeed = 100;
		sprintSpeed = 200;
		walking = true;
		sprinting = false;
		texture = new Texture("player.png");
	}
	

	
	public void update()
	{
		if (walking) {
			position.x += direction.x * walkSpeed * Gdx.graphics.getDeltaTime();
			position.y += direction.y * walkSpeed * Gdx.graphics.getDeltaTime();
		}else if (sprinting) {
			position.x += direction.x * sprintSpeed * Gdx.graphics.getDeltaTime();
			position.y += direction.y * sprintSpeed * Gdx.graphics.getDeltaTime();
		}
	}
	
	public void draw(SpriteBatch a_batch) {
		
		a_batch.begin();
		
		a_batch.draw(texture, position.x, position.y);
		
		
		a_batch.end();
	}
}
