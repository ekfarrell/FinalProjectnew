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
        SoundforGame soundmaker = new SoundforGame();

        

        while(choice != 0){
            System.out.println("enter in a number between 1-9.(0 to exit)");
            choice = keyboard.nextInt();
            
            if(choice == 1){
                soundmaker.playlaser();
            }
            else if(choice == 2){
                soundmaker.playshipdeath();
            }
            else if(choice == 3){
                soundmaker.playstartup();
            }
            else if(choice == 4){
                soundmaker.playsplit();
            }
        }
        System.out.println("Program ends");
    }
}
