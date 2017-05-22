
import java.applet.Applet;
import java.applet.AudioClip;
/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound
{
    public static final AudioClip SOUND1 = Applet.newAudioClip(Sound.class.getResource("SoundEffects//LaserGun.wav"));
    public static final AudioClip SOUND2 = Applet.newAudioClip(Sound.class.getResource("SoundEffects//ShipExplodes.wav"));
    public static final AudioClip SOUND3 = Applet.newAudioClip(Sound.class.getResource("SoundEffects//Startup.wav"));
    public static final AudioClip SOUND4 = Applet.newAudioClip(Sound.class.getResource("SoundEffects//ShipExplodes.wav"));
    public static final AudioClip SOUND5 = Applet.newAudioClip(Sound.class.getResource("SoundEffects//AstroidSplits.wav"));
}
