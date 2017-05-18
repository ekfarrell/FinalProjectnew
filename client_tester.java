import java.util.*;
import java.applet.*;
import java.net.*;
/**
Matthew Kunzer
Audioplayer tester code
 */
public class client_tester
{
    public static void main(String args[]){
        int choice = 10;
        Scanner keyboard = new Scanner(System.in);
        while(choice != 0){
            System.out.println("enter in a number between 1-9.(0 to exit)");
            choice = keyboard.nextInt();
            
            if(choice == 1){
                Sound.SOUND1.play();
            }
            else if(choice == 2){
                Sound.SOUND2.play();
            }
            else if(choice == 3){
                Sound.SOUND3.play();
            }
            else if(choice == 4){
                Sound.SOUND4.play();
            }
            else if(choice ==5){
                Sound.SOUND5.play();
            }
        }
        System.out.println("Program ends");
    }
}
