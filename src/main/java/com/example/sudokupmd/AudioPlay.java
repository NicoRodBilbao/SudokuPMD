package com.example.sudokupmd;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class AudioPlay {

    public static MediaPlayer mediaPlayer;
    public static void playAudio(Context c,int i){
        switch (i) {
            case 1:
                mediaPlayer = MediaPlayer.create(c,R.raw.music);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(c,R.raw.sad_trombone);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(c,R.raw.victory);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(c,R.raw.click);
                break;
        }
            mediaPlayer.start();
    }
    public static void stopAudio(){
        mediaPlayer.stop();
    }
}