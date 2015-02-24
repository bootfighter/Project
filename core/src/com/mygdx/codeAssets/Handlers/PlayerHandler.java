package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.Weapon;
import com.mygdx.codeAssets.Objects.Entities.Player;
import com.mygdx.codeAssets.Objects.Weapons.Daggers.SapphireDagger;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class PlayerHandler {
	


	private MapHandler mapHandler;
	public Player player;
	Weapon weapon;
	Vector2 facingDirection;
	Vector2 playerDirection;
	
	public PlayerHandler(MapHandler a_mapHandler, SceneAbstract a_Scene) {
		mapHandler = a_mapHandler;
		player = new Player();
		player.position = new Vector3(30, 30, 0);
		facingDirection = new Vector2(0,0);
		playerDirection = new Vector2(0,0);
		
		weapon  = new SapphireDagger();
	}
	
	
	public boolean keyDown(int keycode){
		switch (keycode) {

		case Keys.W:
			if (Gdx.input.isKeyPressed(Keys.S))
				playerDirection.y = 0;
			else
				playerDirection.y = 1;
			break;
		case Keys.S:	
			if (Gdx.input.isKeyPressed(Keys.W))
				playerDirection.y = 0;
			else
				playerDirection.y = -1;
			break;
		case Keys.D:
			if (Gdx.input.isKeyPressed(Keys.A))
				playerDirection.x = 0;
			else
				playerDirection.x = 1;
			break;
		case Keys.A:
			if (Gdx.input.isKeyPressed(Keys.D))
				playerDirection.x = 0;
			else
				playerDirection.x = -1;
			break;
		case Keys.SHIFT_LEFT:
			player.sprinting = true;			
			break;


		default:
			return false;
		}
		playerDirection.nor();
		player.setDirection(playerDirection);
		return true;
	}
	
	public boolean keyUp(int keycode){
		switch (keycode) {
		case Keys.W:
			if (Gdx.input.isKeyPressed(Keys.S)){
				playerDirection.y = -1;
				break;
			}
			playerDirection.y = 0;
			break;
		case Keys.S:
			if (Gdx.input.isKeyPressed(Keys.W)){
				playerDirection.y = 1;
				break;
			}
			playerDirection.y = 0;
			break;
		case Keys.D:
			if (Gdx.input.isKeyPressed(Keys.A)){
				playerDirection.x = -1;
				break;
			}
			playerDirection.x = 0;
			break;
		case Keys.A:
			if (Gdx.input.isKeyPressed(Keys.D)){
				playerDirection.x = 1;
				break;
			}
			playerDirection.x = 0;
			break;
		case Keys.SHIFT_LEFT:
			player.sprinting = false;			
			break;
		default:
			return false;
		}

		playerDirection.nor();
		player.setDirection(playerDirection);
		
		return true;
	}
	
	public boolean mouseMoved(int screenX, int screenY){
		
		facingDirection.x = (Gdx.graphics.getWidth() / 2) - screenX;
		facingDirection.y = (Gdx.graphics.getHeight() / 2) - screenY;
		
		facingDirection.nor();
		
		
		if (facingDirection.x <= -0.5f)
			facingDirection.x = 1f;
		else if (facingDirection.x >= 0.5f)
			facingDirection.x = -1f;
		else
			facingDirection.x = 0f;
		
		
		if (facingDirection.y <= -0.5f)
			facingDirection.y = -1f;
		else if (facingDirection.y >= 0.5f)
			facingDirection.y = 1f;
		else
			facingDirection.y = 0f;
		
		player.setFacingDirection(facingDirection);
		
		return true;
	}
	
	public void update()
	{
		
		player.update(mapHandler.getCurrentMap());
		
	}
	
	public void draw(SpriteBatch a_batch) {
				
		player.draw(a_batch);

	}
}
