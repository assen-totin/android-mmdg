package com.exercise.AndroidAudioPlayer;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndroidAudioPlayer extends Activity {
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private static final String MIDI_FILE_NAME = new String("/sdcard/waltz.mid");
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonDiceRoll = (Button)findViewById(R.id.dice_roll);
        buttonDiceRoll.setOnClickListener(buttonDiceRollClickListener);   
    }

    Button.OnClickListener buttonDiceRollClickListener = new Button.OnClickListener(){
    	public void onClick(View v) {
    		
    		MidiJob tmp_obj = new MidiJob();
    		tmp_obj.allJobs(MIDI_FILE_NAME);
   			
            Toast.makeText(AndroidAudioPlayer.this, R.string.dice_rolled, Toast.LENGTH_LONG).show();
                      
            mediaPlayer.reset();
            
            try {
				mediaPlayer.setDataSource(MIDI_FILE_NAME);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
            try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
            mediaPlayer.start();
    	}
    };

}

