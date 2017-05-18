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
        
    }

}
