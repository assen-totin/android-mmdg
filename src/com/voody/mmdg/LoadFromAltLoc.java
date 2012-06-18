package com.voody.mmdg;

//import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
//import android.os.Bundle;

public class LoadFromAltLoc extends Activity {
	//a handle to the application's resources
	private Resources resources;
	Context context;
	   
	public InputStream LoadFile(Context context, String fileName) throws IOException {
		// Get resources
		resources = context.getResources();
		
		// Create a InputStream to read the file into
		InputStream iS;

		// Get the resource id from the file name
		int rID = resources.getIdentifier("com.exercise.AndroidAudioPlayer:raw/"+fileName, null, null);

		// Get the file as a stream
		iS = resources.openRawResource(rID);

		/*
		//create a buffer that has the same size as the InputStream
		byte[] buffer = new byte[iS.available()];

		//read the file as a stream, into the buffer
		iS.read(buffer);

		//create a output stream to write the buffer into
		ByteArrayOutputStream oS = new ByteArrayOutputStream();

		//write this buffer to the output stream
		oS.write(buffer);

		//Close the Input and Output streams
		oS.close();
		iS.close();
		
		//return the output stream as a String
		return oS.toString();
		*/
		return iS;
	}

}
