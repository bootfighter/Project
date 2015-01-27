package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.Weapon;
import com.mygdx.codeAssets.Objects.Entities.Player;
import com.mygdx.codeAssets.Objects.Weapons.Daggers.SapphireDagger;

public class PlayerHandler {
	


	private MapHandler mapHandler;
	Player player;
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

		a_batch.begin();
		
		//TODO: Multi equipment animation and rendering
		//		Jedes item hat eine texture die an einer position zeichnet wird
		//		die position werden mit animation verändert. keine ahnung was hier noch kommt ^^ vllt ein skript?
//		a_batch.draw(player.getTexture(), player.position.x, player.position.y);
		
		
		weapon.getTexture().setPosition(player.position.x, player.position.y);
		weapon.getTexture().draw(a_batch);
		
		a_batch.end();
	}
}
