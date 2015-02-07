package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.Weapon;
import com.mygdx.codeAssets.Objects.Entities.Player;
import com.mygdx.codeAssets.Objects.Weapons.Daggers.SapphireDagger;

public class PlayerHandler {
	


	private MapHandler mapHandler;
	public Player player;
	Weapon weapon;
	
	
	public PlayerHandler(MapHandler a_mapHandler) {
		mapHandler = a_mapHandler;
		player = new Player();
		player.position = new Vector3(30, 30, 0);
		
		
		
		weapon  = new SapphireDagger();
	}
	
	
	public void update()
	{
		
		player.update(mapHandler.getCurrentMap());
		
	}
	
	public void draw(SpriteBatch a_batch) {
				
		player.draw(a_batch);

	}
}
