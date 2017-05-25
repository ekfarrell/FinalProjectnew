import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.*;
/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends JFrame
{
    //Main Menu Frame
    JFrame frame;
    //buffered image
    BufferedImage i;
    //Graphics for buffered image
    Graphics g;
    //Graphics for frame
    Graphics g2;
    //input handler for main menu
    InputHandler handler;
    
    
    //instance variables
    //boolean that says whether the game is running or not
    boolean isRunning;
    //target fps
    final int FPS = 60;
    //Mennu height and width
    int menuHeight, menuWidth;
    //which selection the user is on
    int selection;
    //tells weather or not controls has been selected
    boolean controlsSelected;
    public static void main(String args[]){
        new MainMenu();
    }
    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu()
    {
        init();
    }
    
    void init(){
        //Menu Width
        menuWidth = 1200;
        //Menu height
        menuHeight = 900;
        //Frame
        frame = new JFrame("Main Menu");
        //sets the size of the frame to a new dimension with attributes height and width
        frame.setSize(new Dimension(menuWidth,menuHeight));
        //Setting frame,setLocationRelativeTo = null makes frame in the center of your screen
        frame.setLocationRelativeTo(null);
        //Makes it so when you close the window the program stops
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the frame so you can see it
        frame.setVisible(true);
        //Makes the new Buffered image
        i = new BufferedImage(menuWidth,menuHeight,BufferedImage.TYPE_INT_RGB);
        //Graphics for frame
        g = i.getGraphics();
        //Graphics for frame
        g2 = frame.getGraphics();
        //input handler for input
        handler = new InputHandler(frame);
        //boolean isRunning is set to truee by default
        isRunning = true;
        //selection by default is 0 whic is play
        selection = 0;
        //boolean controlsselected
        controlsSelected = false;
        //starts the game loop
        run();
    }
    
    void run(){
        while(isRunning){
            update();
            draw(g);
            //gets the current time
            long time = System.currentTimeMillis();
            
            //this makes it so it runs at 60 fps
            time = (1000/FPS) - (System.currentTimeMillis() - time);
            
            //makes sure the time is a valid time
            if(time > 0){
                try{
                    Thread.sleep(time);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                
            }
        }
    }
    
    void draw(Graphics g){
        //draws a black rectangle for the background
        g.setColor(Color.black);
        g.fillRect(0,0,1000,1000);
        if(controlsSelected == false){
            //Adds the text asteroids for the title
            g.setFont(new Font("TimesNewRoman", Font.PLAIN, 50));
            g.setColor(Color.white);
            g.drawString("Asteroids",500,100);
            g.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
            g.drawString("Hit Enter To Select An Option",500,145);
            g.setFont(new Font("TimesNewRoman", Font.PLAIN, 50));
        
            //Draws the text for the main meu optins
            if(selection == 0){
                g.setColor(Color.yellow);
            }
            else{
                g.setColor(Color.red);
            }
            g.drawString("Play",200,350);
            if(selection == 1){
                g.setColor(Color.yellow);
            }
            else{
                g.setColor(Color.red);
            }
            g.drawString("Controls",200,500);
            if(selection == 2){
            g.setColor(Color.yellow);
            }
            else{
            g.setColor(Color.red);
           }
           g.drawString("Exit",200,650);
           g2.drawImage(i,0,0,frame);
           }
        if(controlsSelected == true)
        {
            g.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
            g.setColor(Color.white);
            g.drawString("Hit Enter to go back to the main menu",500,145);
            g.drawString("Up arrow Key - Move Forward",500,185);
            g.drawString("Down arrow Key - Move Backward",500,225);
            g.drawString("Left arrow Key - Rotate Left",500,265);
            g.drawString("Right arrow Key - Rotate Right",500,305);
            g.drawString("Space Bar - Shoot",500,345);
            g2.drawImage(i,0,0,frame);
        }
    }
    
    void update(){
        if(handler.isKeyDown(KeyEvent.VK_UP)){
            selection--;
            if(selection > 2)
                selection = 2;
            if(selection < 0)
                selection = 0;
            try{
                Thread.sleep(100);}
            catch(InterruptedException e){}
        }
        if(handler.isKeyDown(KeyEvent.VK_DOWN)){
            selection++;
            if(selection > 2)
                selection = 2;
            if(selection < 0)
                selection = 0;
            try{
                Thread.sleep(100);}
            catch(InterruptedException e){}
        }
        if(handler.isKeyDown(KeyEvent.VK_ENTER)){
            if(controlsSelected == false){
                if(selection == 0){
                    frame.setVisible(false);
                    new Main();
                    isRunning = false;
                }
                if(selection == 1){
                    controlsSelected = true;
                    try{
                    Thread.sleep(100);}
                catch(InterruptedException e){}
                }
                if(selection == 2){
                    System.exit(-1);
                }
            }
            else if(controlsSelected == true){
                controlsSelected = false;
                try{
                    Thread.sleep(100);}
                catch(InterruptedException e){}
            }
        }
    }
}
