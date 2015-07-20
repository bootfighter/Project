package com.mygdx.codeAssets.Particles;

import java.util.ArrayList;
import java.util.Random;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class ParticleEmitter {

	protected int particlePerSecond;
	protected int particleID;
	
	
	protected ArrayList<Particle> particlePool;
	
	protected Vector3 position;
	protected Vector3 randPosition;
	protected Vector3 velocity;
	protected Vector3 randVelocity;
	protected Vector3 force;
	protected Vector3 randForce;
	
	protected float angle;
	protected float randAngle;
	
	protected float angularVelocity;
	protected float randAngularVelocity;
	
	protected float angularForce;
	protected float randAngularForce;
	
	protected float lifeTime;
	protected float randLifeTime;
	
	protected float alpha;
	protected float alphaFading;
	
	protected boolean isEmitting;
	
	protected Random random;
	
	private float currentTime;
	private float timeStep;
	
	// DELETE THIS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	private Texture tmpTexture;
	
	
	public ParticleEmitter() {
		
		tmpTexture = new Texture("Particles/Dust.png");
		
		particlePerSecond = 0;
		particleID = 0;
		
		particlePool = new ArrayList<Particle>();

				
		position = new Vector3(0, 0, 0);
		randPosition = new Vector3(0, 0, 0);
		velocity = new Vector3(0, 0, 0);
		randVelocity =  new Vector3(0, 0, 0);
		force = new Vector3(0, 0, 0);
		randForce = new Vector3(0, 0, 0);
		
		angle = 0;
		randAngle = 0;
		
		angularVelocity = 0;
		randAngularVelocity = 0;
		
		angularForce = 0;
		randAngularForce = 0;
		
		lifeTime = 0;
		randLifeTime = 0;
		
		alpha = 1;
		alphaFading = 0;
		
		isEmitting = false;
		
		random = new Random();
		
		currentTime = 0;
		timeStep = 0;
	}
	
	
	public abstract void startEmitting();
	
	public abstract void endEmitting();
	
	public void draw(SpriteBatch a_batch){
		
		a_batch.begin();
		
		for (Particle particle : particlePool) {
			if (particle.getLifeTime() > 0) {
				a_batch.draw(tmpTexture, particle.getPosition().x, particle.getPosition().y);
			}
		}
		
		
		a_batch.end();
	}
	
	private void addParticleToPool(){
		
		Vector3 finalPosition = new Vector3(position);
		Vector3 finalVelocity = new Vector3(velocity);
		Vector3 finalForce = new Vector3(force);
		float finalAngle = angle;
		float finalAngularVelocity = angularVelocity;
		float finalAngularForce = angularForce;
		float finalLifeTime = lifeTime;
		

		finalPosition.x += getRandomBlurDelta(randPosition.x);
		finalPosition.y += getRandomBlurDelta(randPosition.y);
		finalPosition.z += getRandomBlurDelta(randPosition.z);
		
		finalVelocity.x += getRandomBlurDelta(randVelocity.x);
		finalVelocity.y += getRandomBlurDelta(randVelocity.y);
		finalVelocity.z += getRandomBlurDelta(randVelocity.z);
		

		finalForce.x += getRandomBlurDelta(randForce.x);
		finalForce.y += getRandomBlurDelta(randForce.y);
		finalForce.z += getRandomBlurDelta(randForce.z);
		
		finalAngle += getRandomBlurDelta(randAngle);
		finalAngularVelocity += getRandomBlurDelta(randAngularVelocity);
		finalAngularForce += getRandomBlurDelta(randAngularForce);
		finalLifeTime += getRandomBlurDelta(randLifeTime);

		
		for (Particle particle : particlePool) {
			if (particle.getLifeTime() <= 0f) //if particle is dead
			{
				particle.set(particleID, finalPosition, finalVelocity, finalForce, finalAngle, finalAngularVelocity,
						finalAngularForce, finalLifeTime, alpha, alphaFading);
				return; //new particla is added
			}
		}
		
		particlePool.add(new Particle(particleID, finalPosition, finalVelocity, finalForce, finalAngle, finalAngularVelocity,
						finalAngularForce, finalLifeTime, alpha, alphaFading));
	}
	
	public void update(){
		
		if (particlePerSecond <= 0) return;
		timeStep = (1f / (float)particlePerSecond);
		
		currentTime += Gdx.graphics.getDeltaTime();
		
		while(currentTime > timeStep){
			currentTime -= timeStep;
			if (isEmitting) {
				addParticleToPool();
				System.out.println(particlePool.size());
			}
		}
		
		
		for (Particle particle : particlePool) {
			particle.update();
		}		
	}
	
	public void setPosition(Vector3 a_position){
		position.set(a_position);
	}
	
	private float getRandomBlurDelta(float a_deltaValue){
		
		if (a_deltaValue == 0) {
			return 0;
		}
		
		float bluredValue = a_deltaValue;

		if (bluredValue < 0) {
			bluredValue = Math.abs(bluredValue);
		}
		
		//nextFloat retuns [0..1] gets mutiplied by the blurvalue and the shifted down by half
		//of the value
		return (random.nextFloat() * bluredValue) - (bluredValue / 2);
	}
	
}
