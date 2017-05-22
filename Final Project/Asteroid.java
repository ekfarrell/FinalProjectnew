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
    private int radius;
    private int size;
    /**
     * Default constructor for objects of class Asteroid
     */
    public Asteroid(int x, int y, int degrees, int size, ID id)
    {
       super(x,y,degrees,id);
       this.size = 3;
       //Bases the radius off of the size of the asteroid which is between 1 and 3
       if (size == 3){
           radius = 50;
       }
       else if (size == 2){
           radius = 30;
       }
       else if (size == 1){
           radius = 15;
       }
       else{
           radius = 50;
       }
    }
    
    public void tick(){
        //indexs the x, based on the direction it is going
        x += Math.cos(Math.toRadians((degrees-130)*-1)) *  6 +
        Math.sin(Math.toRadians((degrees-130)*-1)) * 6;
        
        //indexs the y, based on the direction it is going
        y -= -Math.cos(Math.toRadians((degrees-130)*-1)) * 6 +
        Math.sin(Math.toRadians((degrees-130)*-1)) * 6;
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillOval(x,y,radius,radius);
    }
    
    public LinkedList<Asteroid> destroy(){
        LinkedList<Asteroid> astrolist = new LinkedList<Asteroid>();
        astrolist.add(new Asteroid(this.x-20,this.y,degrees+45,this.size-1,ID.Asteroid));
        astrolist.add(new Asteroid(this.x-20,this.y,degrees-45,this.size-1,ID.Asteroid));
        return astrolist;
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
