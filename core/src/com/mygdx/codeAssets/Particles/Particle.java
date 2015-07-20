package com.mygdx.codeAssets.Particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.FileManagement.TextureManager;

public class Particle {
	
	private int particleID;
	private Vector3 position;
	private Vector3 velocity;
	private Vector3 force;
	
	private float angle; //angle in degrees
	private float angularVelocity; //addative to angle
	private float angularForce; //slows or accelerates angularVelocity
	
	private float lifeTime; //if zero -> particle dead | in seconds
	private float alpha; //transparency, 0 = invisible, 1 = visible
	private float alphaFading; //rate at which alpha is fading per second [0..1]
	
	private float deltaTime;
	
	public Particle(int a_particleID, Vector3 a_position, Vector3 a_velocity, Vector3 a_force, 
			 float a_angle, float a_angularVelocity, float a_angularForce, float a_lifeTime, float a_alpha, float a_alphaFading)
	{
		particleID = a_particleID;

		position = new Vector3(a_position);
		velocity = new Vector3(a_velocity);
		force = new Vector3(a_force);
		
		angle = a_angle;
		angularVelocity = a_angularVelocity;
		angularForce = a_angularForce;
		
		lifeTime = a_lifeTime;
		alpha = a_alpha;
		alphaFading = a_alphaFading;
		
		deltaTime = 0;
	}
	
	public Particle(int a_particleID, Vector3 a_position, Vector3 a_velocity, Vector3 a_force, 
			float a_lifeTime, float a_alpha, float a_alphaFading)
	{
		this(a_particleID, a_position, a_velocity, a_force, 0f, 0f, 0f, a_lifeTime, a_alpha, a_alphaFading);
	}
		
	
	public void update()
	{
		//new position
		deltaTime = Gdx.graphics.getDeltaTime();
		
		velocity.x += force.x * deltaTime;
		velocity.y += force.y * deltaTime;
		velocity.z += force.z * deltaTime;
		
		position.x += velocity.x * deltaTime;
		position.y += velocity.y * deltaTime;
		position.z += velocity.z * deltaTime;
	
		
		//updating angle
		angularVelocity += angularForce * deltaTime;
		angle += angularVelocity * deltaTime;
		
		
		//updating alpha
		alpha -= alphaFading * deltaTime;
		
		
		//updating lifetime
		if (lifeTime > 0) {
			lifeTime -= Gdx.graphics.getDeltaTime();			
		}
		else {
			lifeTime = 0;
		}
	}
	
	public float getLifeTime() {
		return lifeTime;
	}
	public int getParticleID() {
		return particleID;
	}
	public TextureRegion getTexture(){
		return TextureManager.getParticle(particleID);
	}
	public Vector3 getPosition() {
		return position;
	}
	public float getAngle() {
		return angle;
	}
	
	
	public void set(Particle a_particle){
		particleID = a_particle.particleID;

		position.set(a_particle.position);
		velocity.set(a_particle.velocity);
		force.set(a_particle.force);
		
		angle = a_particle.angle;
		angularVelocity = a_particle.angularVelocity;
		angularForce = a_particle.angularForce;
		
		lifeTime = a_particle.lifeTime;
		alpha = a_particle.alpha;
		alphaFading = a_particle.alphaFading;
	}
	
	public void set(int a_particleID, Vector3 a_position, Vector3 a_velocity, Vector3 a_force, 
			 float a_angle, float a_angularVelocity, float a_angularForce, float a_lifeTime, float a_alpha, float a_alphaFading ){
		particleID = a_particleID;

		position.set(a_position);
		velocity.set(a_velocity);
		force.set(a_force);
		
		angle = a_angle;
		angularVelocity = a_angularVelocity;
		angularForce = a_angularForce;
		
		lifeTime = a_lifeTime;
		alpha = a_alpha;
		alphaFading = a_alphaFading;
	}
	
	public void setLifeTime(float lifeTime) {
		this.lifeTime = lifeTime;
	}
	public void setForce(Vector3 force) {
		this.force = force;
	}
	public void setVelocity(Vector3 velocity) {
		this.velocity = velocity;
	}
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
	public void setPosition(Vector3 position) {
		this.position = position;
	}
	public void setParticleID(int particleID) {
		this.particleID = particleID;
	}
		
	
}
