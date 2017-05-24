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
public class Main {
    
    //sets the fps
    int fps = 60;
    //sets the width and height of the frame
    int gameWidth = 1200, gameHeight = 900;
    
    //Objects
    JFrame frame;
    InputHandler handler;
    
    LinkedList<GameObject> objects = new LinkedList<GameObject>();
    
    //graphics for the page and graphics for the bufered image
    Graphics g2;
    Graphics g;
    //prevents the flickering
    BufferedImage i;
    
    //position of the shape
    //radius/length of shape
    int shapeLength = 50;
    int degrees = 0;
    //player inital x and y
    int x = 500;
    int y = 500;
    //the player
    Player player1;
    //random for asteroid size and xy cordinates
    Random r = new Random();
    //asteroid variables
    int astroX;
    int astroY;
    int astroDegree;
    int side;
    int astrocount = 0;
    
    int firingrate;
    
    Image gameEnd;
    
    boolean isRunning = true;
    boolean isGameOver= false;
    
    //Main method runs the constructor
    public static void main(String[] args) {
        new Main();
    }
    /**
     * Main method for the constructor which runs the run method to start the game
     */
    public Main() {
        //startup sound here
        run();
        //cleanup
        System.exit(-1);
    }
    
    void init(){
       firingrate = 0;
        player1 = new Player(x,y,degrees,ID.Player);
        objects.add(player1);
        //initializes the frame
        //The string inside is the name of the frame
        frame = new JFrame("Game");
        //sets the size of the frame to a new dimension with attributes height and width
        frame.setSize(new Dimension(gameWidth,gameHeight));
        //Setting frame,setLocationRelativeTo = null makes frame in the center of your screen
        frame.setLocationRelativeTo(null);
        //Makes it so when you close the window the program stops
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //turns on anti aliasing
        
        //sets the frame so you can see it
        frame.setVisible(true);
        
        //Objects
        handler = new InputHandler(frame);
        
        //Graphics stuff
        //Makes a new BufferedImage to draw on so everything can go on the frame at once
        //prevents flickering
        i = new BufferedImage(gameWidth,gameHeight,BufferedImage.TYPE_INT_RGB);
        //sets g to be the graphics of the buffered image
        g = i.getGraphics();
        //sets g2 to be the graphics of the frame
        g2 = frame.getGraphics();
        
         Toolkit t=Toolkit.getDefaultToolkit();  
         gameEnd=t.getImage("FinalProjectNew\\GameOver.png");  
       
    }
    /**
     * Runs the program in a continuous loop by running init and then using a while ture loop
     */
    void run(){
        init();
       
        
        //Main menu
        
        
        
        //Make the game run until the window is closed
        while(isRunning){
            //gets the current time
            long time = System.currentTimeMillis();
            
            //makes it so it keeps executing update draw, update draw,...
            update();
            draw();
            
            //this makes it so it runs at 60 fps
            time = (1000/fps) - (System.currentTimeMillis() - time);
            
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
    
    
    /**
     * Changes the coordinates of the shape based on input
     */
    void update(){
        //allows control of the firing rate
        firingrate++;
        if (firingrate == 60){
               firingrate = 0;
            }
       
        //if the up arrow key is down
        if(handler.isKeyDown(KeyEvent.VK_UP))
        { 
         player1.setX(player1.getX() + (int)(Math.cos(Math.toRadians((player1.getDegrees()-130)*-1)) *  5 + (Math.sin(Math.toRadians((player1.getDegrees()-130)*-1)) * 5)));
         player1.setY(player1.getY() - (int)(-Math.cos(Math.toRadians((player1.getDegrees()-130)*-1)) * 5 + Math.sin(Math.toRadians((player1.getDegrees()-130)*-1)) * 5));
         // x += Math.cos(Math.toRadians((degrees-120)*-1)) *  5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
         //y -= -Math.cos(Math.toRadians((degrees-120)*-1)) * 5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
          
          if(player1.getX()<15)
                player1.setX(15);
          if(player1.getX()>gameWidth)
                player1.setX(gameWidth);
          if(player1.getY()<30)
                player1.setY(30);
          if(player1.getY()>gameWidth)
                player1.setY(gameHeight);        
        }
        //If the down arrow key is down
        if(handler.isKeyDown(KeyEvent.VK_DOWN))
        {
            player1.setX(player1.getX() - (int)(Math.cos(Math.toRadians((player1.getDegrees()-130)*-1)) *  5 + (Math.sin(Math.toRadians((player1.getDegrees()-130)*-1)) * 5)));
            player1.setY(player1.getY() + (int)(-Math.cos(Math.toRadians((player1.getDegrees()-130)*-1)) * 5 + Math.sin(Math.toRadians((player1.getDegrees()-130)*-1)) * 5));
          // x -= Math.cos(Math.toRadians((degrees-120)*-1)) *  5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
          // y += -Math.cos(Math.toRadians((degrees-120)*-1)) * 5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
          if(player1.getX()<15)
                player1.setX(15);
          if(player1.getX()>gameWidth)
                player1.setX(gameWidth);
          if(player1.getY()<30)
                player1.setY(30);
          if(player1.getY()>gameWidth)
                player1.setY(gameHeight);
        }
        
        if(handler.isKeyDown(KeyEvent.VK_SPACE)){
           if(firingrate%6 == 0 || firingrate%6 == 3){
               objects.add(new Bullet(player1.getX(),player1.getY(),player1.getDegrees(),ID.Bullet));
           }
           
           // Sound.SOUND1.play();
        }
        
         //if the left arrow key is down
        if(handler.isKeyDown(KeyEvent.VK_LEFT))
        {
            degrees-=5;
            player1.setAngularVelocity(-5);
        }
        //if the right arrow key is pressed
        if(handler.isKeyDown(KeyEvent.VK_RIGHT))
        {
            degrees+=5;
            player1.setAngularVelocity(5);
        }
        
        
        //Moves the ship to where you click
        /*if(handler.isMouseDown(1)){
            x = handler.getEvent(1).getX() - shapeLength/2;
            y = handler.getEvent(1).getY() - shapeLength/2;
        }*/
        //If the escape key is pressed it exits the game
        if(handler.isKeyDown(KeyEvent.VK_ESCAPE))
        {
            System.exit(-1);
        }
        
    }
    /**
     * Draws the shapes onto the image
     */
    void draw(){ 
       g.setColor(Color.black);
       g.fillRect(0, 0, gameWidth, gameHeight);
      
        //Asteroid newAstro = new Asteroid(astroX,astroY,astroDegree,3,ID.Asteroid);
        
       //objects.add(new Player(x,y,degrees,ID.Player));
       //objects.add(new Asteroid(x2,y2,degrees,size2,ID.Player));
       
       for (int i = 0; i < objects.size(); i++){
           objects.get(i).tick();
           objects.get(i).render(g);
           if (objects.get(i).getId() == ID.Player){
               objects.get(i).setAngularVelocity(0);
            }
           if(objects.get(i).getX()<-51){
               if(objects.get(i).getId() == ID.Asteroid)
                    astrocount--;
               objects.remove(i);
               i--;
               continue;
            }
           if(objects.get(i).getX()>1251){
               if(objects.get(i).getId() == ID.Asteroid)
                    astrocount--;
               objects.remove(i);
               i--;
               continue;
            }
           if(objects.get(i).getY()<-51){
            if(objects.get(i).getId() == ID.Asteroid)
                astrocount--;
            objects.remove(i);
            i--;
            continue;
            }     
           if(objects.get(i).getY()>951){
               if(objects.get(i).getId() == ID.Asteroid)
                    astrocount--;
               objects.remove(i);
               i--; 
               continue;
           }
           if (astrocount < 10){
                side = r.nextInt(4)+1;;
                //asteroids spawning from top
                if(side == 1){
                    astroX = r.nextInt(1200);
                    astroY = -50;
                    astroDegree = r.nextInt(90)+135;
                }
                //asteroids spawning from bottom
                if(side == 2){
                    astroX = r.nextInt(1200);
                    astroY = 950;
                    astroDegree = r.nextInt(90)-45;
                }
                //asteroids spawning from left
                if(side == 3){
                    astroX = -50;
                    astroY = r.nextInt(900);
                    astroDegree = r.nextInt(90)+90;
                }
                //asteroids spawning from right
                if(side == 4){
                    astroX = 1250;
                    astroY = r.nextInt(900);
                    astroDegree = r.nextInt(90)-90;
                }
                objects.add(new Asteroid(astroX,astroY,astroDegree,3,ID.Asteroid));
                astrocount++;
            }
            //ends the game if an asteroid hit the player
           if(objects.get(i).getId() == ID.Asteroid)
           {
               if (player1.hitReg(objects.get(i)))
               { 
                   isGameOver = true;
               }
           }
           //should breakup asteroid when they are hit by bullets
           /*for (int j = 0; j<objects.size();j++){
               if(objects.get(j).getId() == ID.Asteroid)
               {
                   if(objects.get(j).getX()+objects.get(j).getRadius() > objects.get(i).getX() && objects.get(j).getX() - objects.get(j).getRadius() < objects.get(i).getX())
                   {
                       if(objects.get(j).getY()+objects.get(j).getRadius() < objects.get(i).getY() &&
                          objects.get(j).getY() - objects.get(j).getRadius() > objects.get(i).getY())
                       {
                           if(objects.get(j).getSize()-1 != 0){
                               objects.add(new Asteroid(objects.get(j).getX()-30,objects.get(j).getY(),degrees+45,objects.get(j).getSize()-1,ID.Asteroid));
                               objects.add(new Asteroid(objects.get(j).getX()+30,objects.get(j).getY(),degrees-45,objects.get(j).getSize()-1,ID.Asteroid));
                               objects.remove(j);
                           }
                           else{
                               objects.remove(j);
                           }
                      }
                   }
               }
           }*/
           
           if(objects.get(i).getId() == ID.Asteroid){
               for (int j = 0; j< objects.size();j++)
               {
                   if (objects.get(j).getId() == ID.Bullet)
                   {
                       if(objects.get(i).getX()+objects.get(i).getRadius() > objects.get(j).getX() &&
                          objects.get(i).getX() - objects.get(i).getRadius() < objects.get(j).getX())
                       {
                           if(objects.get(i).getY()+objects.get(i).getRadius() > objects.get(j).getY() &&
                              objects.get(i).getY() - objects.get(i).getRadius() < objects.get(j).getY())
                          {
                              if(objects.get(j).getSize()== 0){
                                  objects.remove(i);
                                  astrocount--;
                                  i--;
                                }
                              else{
                                  objects.add(new Asteroid(objects.get(i).getX(),objects.get(j).getY(),degrees+45,objects.get(i).getSize()-1,ID.Asteroid));
                                  objects.add(new Asteroid(objects.get(i).getX(),objects.get(j).getY(),degrees-45,objects.get(i).getSize()-1,ID.Asteroid));
                                  objects.remove(i);
                                  astrocount ++;
                                  i--;
                              }
                          }
                      }
                   }
               }
           }
        }
       if(isGameOver)
       {
           objects.clear();
           g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
           g.setColor(Color.red);
           g.drawString("Game Over!", 500,450);
       }
        //draws the buffered image onto the frame
        g2.drawImage(i/* this is the image that get's drawn*/, 0, 0, frame);
        
    
    }
}
