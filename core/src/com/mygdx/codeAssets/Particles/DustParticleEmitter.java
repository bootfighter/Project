package com.mygdx.codeAssets.Particles;

public class DustParticleEmitter extends ParticleEmitter{

	public DustParticleEmitter() {
		super();
		particlePerSecond = 60;
		
		velocity.x = 0;
		velocity.y = 5;
		randPosition.y = 0f;
		randVelocity.x = 0f;
		randVelocity.y = 9f;
		//force.y = -0.01f;
		
		angle = 0;
		randAngle = 10;
		
		lifeTime = 1f;
		randLifeTime = 0.4f;
		
		alpha = 1;
		alphaFading = 1f;
		
		
	}


	@Override
	public void startEmitting() {
		isEmitting = true;
	}

	@Override
	public void endEmitting() {
		isEmitting = false;
	}	
	
}
