import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler {
    //Makes the input handler
    public static InputHandler handler; 
    //boolean array for every key on keyboard
    boolean[] keys = new boolean[256];
    //boolean array for the muse buttons
    boolean[] mouse = new boolean[4];
    //mouse event array
    MouseEvent[] mEvent = new MouseEvent[4];
    
    /**
     * Constructor that sets up methods and runs them
     * @param Takes a component such as frame
     */
    public InputHandler(Component c) {
        //makes a key listener and the methods
        c.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                //if the key is released sets it's position in the boolean array to false
                keys[e.getKeyCode()] = false;
                
            }
            public void keyPressed(KeyEvent e) {
                //if key is pressed it sets it's position in the boolean array to true
                keys[e.getKeyCode()] = true;
                
            }
        });
        c.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                //sets the position in mouse array to false if mouse button is released
                mouse[e.getButton()] = false;
                //puts the mouse event in the array to record data
                mEvent[e.getButton()] = e;
            }
            /**
             * Sets the position in mouse to true if the mouse button is pressed
             */
            public void mousePressed(MouseEvent e) {
                //sets the mouse array position to true when the button is pressed
                mouse[e.getButton()] = true;
                //gets the mouse event and puts it into the array for more info
                mEvent[e.getButton()] = e;
                
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
        });
        
        //sets the handler to this
        handler = this;
    }
    /**
     * 
     * @param keyCode
     * @return the boolean at the position of the key that is pressed if the key is valid or false if invalid key
     */
    public boolean isKeyDown(int keyCode){
        //Checks to see if it is a valid keyCode
        if(keyCode > 0 && keyCode < keys.length){
            return keys[keyCode];
        }
        return false;
    }
    /**
     * 
     * @    param button
     * @return the boolean at the mouse array position or false if invalid input
     */
    public boolean isMouseDown(int button){
        if(button > 0 && button <= 3){
            return mouse[button];
        }
        
        return false;
    }
    //returns the mouse event when the mouse button is pressed
    /**
     * 
     * @param event
     * @return correct mouse event or null if nothing
     */
    public MouseEvent getEvent(int event){
        if(event > 0 && event <= 3){
        return mEvent[event];
    }
        return null;
    }
}
