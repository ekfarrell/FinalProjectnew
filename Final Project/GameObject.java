import java.awt.Graphics;

public abstract class GameObject {
	
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected int degrees;
	protected int angularVelocity;
	protected int radius;
	protected int size;
	
	public GameObject(int x, int y, int degrees, ID id){
		this.x = x;
		this.y = y;
		this.degrees = degrees;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setId(ID id){
		this.id = id;
	}
	
	public ID getId(){
		return id;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public int getVelX(){
		return velX;
	}
	
	public int getVelY(){
		return velY;
	}
	
	public int getDegrees(){
		return degrees;
	}
	
	public void setDegrees(int degrees){
		this.degrees = degrees;
	}
	
	public int getAngularVelocity(){
		return angularVelocity;
	}
	
	public void setAngularVelocity(int angularVelocity){
		this.angularVelocity = angularVelocity;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
}
