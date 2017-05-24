
import java.applet.Applet;
import java.applet.AudioClip;
/**
Matthew Kunzer & Ethan Farrell
SoundforGame
Plays the sound for the game.
 */
public final class SoundforGame
{
    private static final AudioClip SOUND1 = Applet.newAudioClip(SoundforGame.class.getResource("SoundEffects//LaserGun(Edited).wav"));
    private static final AudioClip SOUND2 = Applet.newAudioClip(SoundforGame.class.getResource("SoundEffects//ShipExplodes(Edited).wav"));
    private static final AudioClip SOUND3 = Applet.newAudioClip(SoundforGame.class.getResource("SoundEffects//Startup(Edited).wav"));
    private static final AudioClip SOUND4 = Applet.newAudioClip(SoundforGame.class.getResource("SoundEffects//AstroidSplits(Edited).wav"));
    public SoundforGame(){
        
    }
    
    public void playlaser(){
      SOUND1.play();
    }
    
    public void playshipdeath(){
      SOUND2.play();
     }
    
    public void playstartup(){
      SOUND3.play();
    }
    
    public void playsplit(){
      SOUND4.play();
    }
    
}
