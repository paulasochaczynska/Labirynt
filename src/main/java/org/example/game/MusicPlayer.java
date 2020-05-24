package org.example.game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MusicPlayer {

    private String musicPath;
    private Clip clip;
    private long time = 0;

    public MusicPlayer(String musicPath) {
        this.musicPath = musicPath;
    }

    public void start() {
        File file = new File(musicPath);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setMicrosecondPosition(time);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (clip == null) {
            return;
        }
        time = clip.getMicrosecondPosition();
        clip.stop();
    }
}
