import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

public class Bullet extends GameObject
{
    private int x;

    /**
     * Default constructor for objects of class Bullet
     */
    public Bullet(int x, int y, int degrees, ID id)
    {
        super(x,y,degrees,id);
    }

    public void tick(){
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x,y,radius,radius);
    
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
