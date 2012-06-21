package com.voody.mmdg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.voody.midisheet.SheetMusicEntryPoint;

public class AndroidAudioPlayer extends Activity {
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private final String MIDI_FILE_NAME = new String("waltz.mid");
	Button buttonDiceRoll;
	Bundle sendBundle = new Bundle();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
               
        buttonDiceRoll = (Button)findViewById(R.id.dice_roll);
        buttonDiceRoll.setOnClickListener(buttonDiceRollClickListener);
    }
        
    Button.OnClickListener buttonDiceRollClickListener = new Button.OnClickListener(){
       	public void onClick(View view)  {
        	MidiJob tmp_obj = new MidiJob();
        	byte[] data = null;
        	try {
        		data = tmp_obj.allJobs(AndroidAudioPlayer.this, MIDI_FILE_NAME);
			} catch (FileNotFoundException e1) {
        		e1.printStackTrace();
        	} catch (IOException e1) {
        		e1.printStackTrace();
        	}
                     
        	mediaPlayer.reset();
           
        	buttonDiceRoll.setEnabled(false);
           
        	mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {           
        		public void onCompletion(MediaPlayer mediaPlayer) {
        			buttonDiceRoll.setEnabled(true);
        		}           
        	});
                                  
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
	        	            
	        sendBundle.putByteArray("data", data);
	        Intent intent = new Intent(view.getContext(), SheetMusicEntryPoint.class);
	        intent.putExtras(sendBundle);
	        startActivity(intent);
       	}
    };
}

