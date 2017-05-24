import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends GameObject
{
    /**
     * Default constructor for objects of class Asteroid
     */
    public Asteroid(int x, int y, int degrees, int size, ID id)
    {
       super(x,y,degrees,id);
       this.setSize(size);
       //Bases the radius off of the size of the asteroid which is between 1 and 3
       if (this.getSize() == 3){
           this.setRadius(50);
       }
       else if (this.getSize() == 2){
            this.setRadius(30);
       }
       else if (this.getSize() == 1){
            this.setRadius(15);
       }
       else{
            this.setRadius(0);
       }
    }
    
    public void tick(){
        //indexs the x, based on the direction it is going
        x += Math.cos(Math.toRadians((degrees-130)*-1)) *  4 +
        Math.sin(Math.toRadians((degrees-130)*-1)) * 4;
        
        //indexs the y, based on the direction it is going
        y -= -Math.cos(Math.toRadians((degrees-130)*-1)) * 4 +
        Math.sin(Math.toRadians((degrees-130)*-1)) * 4;
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillOval(x,y,this.getRadius(),this.getRadius());
    }
    
     public boolean hitReg(LinkedList<GameObject> objects){
        int distance;
        for(int object = 1;object <= objects.size(); object++){
            if(objects.get(object).getId() == ID.Asteroid){
                distance = (int)Math.sqrt(Math.pow((x-objects.get(object).getX()),2)+Math.pow(y-objects.get(object).getY(),2));
                if(distance < objects.get(object).getRadius()){
                  return true;  
                }
            }
        }
        return false; 
    }
}
