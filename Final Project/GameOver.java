import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class GameOver extends JPanel{
    
   public void paint(Graphics g) {
        Image img = createImage();
        g.drawImage(img, 20,20,this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new GameOver());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.setVisible(true);
    }
    
    private Image createImage(){
        BufferedImage bufferedImage = new BufferedImage(1200,900,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.setColor(Color.red);
        g.drawString("Game Over!", 500,450);
    
        return bufferedImage;
    }
}