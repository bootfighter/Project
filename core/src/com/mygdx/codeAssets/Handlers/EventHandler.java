package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;


public class EventHandler implements InputProcessor {

	MapHandler mapHandler;
	PlayerHandler playerHandler;
	RenderHandler renderHandler;
	Vector2 playerDirection;
	Vector2 facingDirection;
	
	public EventHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler, RenderHandler a_renderHandler){
		mapHandler = a_mapHandler;
		playerHandler = a_playerHandler;
		renderHandler = a_renderHandler;
		playerDirection = new Vector2(a_playerHandler.player.getDirection());
		facingDirection = new Vector2(a_playerHandler.player.getFacingDirection());
	}
	
	@Override
	public boolean keyDown(int keycode) {
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
				playerHandler.player.sprinting = true;			
			break;
			
		case Keys.F1:
			renderHandler.isDebug = !renderHandler.isDebug; 
		default:
			break;
		}
		playerDirection.nor();
		playerHandler.player.setDirection(playerDirection);
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
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
			playerHandler.player.sprinting = false;			
		break;
		default:
			return false;
		}
		
		playerDirection.nor();
		playerHandler.player.setDirection(playerDirection);
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
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
		
		playerHandler.player.setFacingDirection(facingDirection);
				
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		renderHandler.zoom(amount);
		return false;
	}
		
}
