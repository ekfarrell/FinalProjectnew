import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
public class Player extends GameObject{

    Random r = new Random();
    int[] xArray;
    int[] yArray;
    int velX;
    int velY;
    private InputHandler handler;
    boolean isShooting;
    

    public Player(int x, int y, int degrees, ID id) {
        super(x,y,degrees,id);
        
    }//end of default constructor
    
    public void tick(){
        //indexs the degrees by the angular velocity
        degrees +=  angularVelocity;
        //index the x
        //x+= Math.cos(Math.toRadians((degrees-120)*-1)) * velY +
        //Math.sin(Math.toRadians((degrees-120)*-1)) * velX;
        
        //y-= -Math.cos(Math.toRadians((degrees-120)*-1)) * velY +
       // Math.sin(Math.toRadians((degrees-120)*-1)) * velX;
    }//end of tick method
    
    public void render(Graphics g){
        xArray = new int[] {x,x+15,x,x-15,x};
        yArray = new int[] {y-15,y+10,y,y+10,y-15};
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.red);
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(degrees),x,y);
        //draw shape/image (will be rotated)
        g.fillPolygon(xArray, yArray,5);
        g2d.setTransform(old);
        
    }//end of render method
    
    /*public boolean shoot(){
        isShooting = true;
        return isShooting;
    }*/
}//end of player class
