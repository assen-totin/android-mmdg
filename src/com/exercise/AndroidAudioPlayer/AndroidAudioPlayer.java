package com.exercise.AndroidAudioPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndroidAudioPlayer extends Activity {
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private final String MIDI_FILE_NAME = new String("waltz.mid");
	Button buttonDiceRoll;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonDiceRoll = (Button)findViewById(R.id.dice_roll);
        buttonDiceRoll.setOnClickListener(buttonDiceRollClickListener);   
    }

    Button.OnClickListener buttonDiceRollClickListener = new Button.OnClickListener(){
    	public void onClick(View v)  {    		
    		MidiJob tmp_obj = new MidiJob();
    		try {
				tmp_obj.allJobs(AndroidAudioPlayer.this, MIDI_FILE_NAME);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
   			
            Toast.makeText(AndroidAudioPlayer.this, R.string.dice_rolled, Toast.LENGTH_LONG).show();
                      
            mediaPlayer.reset();
            
            buttonDiceRoll.setEnabled(false);
            
            try {
            	FileInputStream fis = openFileInput(MIDI_FILE_NAME);
				mediaPlayer.setDataSource(fis.getFD());
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
            
            buttonDiceRoll.setEnabled(true);
    	}
    };

}

