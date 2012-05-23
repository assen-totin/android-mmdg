package com.exercise.AndroidAudioPlayer;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.MidiEvent;
//import com.leff.midi.event.NoteOff;
//import com.leff.midi.event.NoteOn;
//import com.leff.midi.event.meta.Tempo;
//import com.leff.midi.event.meta.TimeSignature;

public class MidiJob {

	static String m1[] = {"m0", "m0", "m96", "m32", "m69", "m4m0", "m148", "m104", "m152", "m119", "m98", "m3", "m54"};
	static String m2[] = {"m0", "m0", "m22", "m6", "m95", "m17", "m74", "m157", "m6m0", "m84", "m142", "m87", "m130"};
	static String m3[] = {"m0", "m0", "m141", "m128", "m158", "m113", "m163", "m27", "m171", "m114", "m42", "m165", "m10"};
	static String m4[] = {"m0", "m0", "m41", "m63", "m13", "m85", "m45", "m167", "m53", "m5m0", "m156", "m61", "m103"};
	static String m5[] = {"m0", "m0", "m105", "m146", "m153", "m161", "m8m0", "m154", "m99", "m14m0", "m75", "m135", "m28"};
	static String m6[] = {"m0", "m0", "m122", "m46", "m55", "m2", "m97", "m68", "m133", "m86", "m129", "m47", "m106"};
	static String m7[] = {"m0", "m0", "m11", "m134", "m11m0", "m159", "m36", "m118", "m21", "m169", "m62", "m147", "m106"};
	static String m8[] = {"m0", "m0", "m3m0", "m81", "m24", "m10m0", "m107", "m91", "m127", "m94", "m123", "m33", "m5"};
	static String m9[] = {"m0", "m0", "m7m0", "m117", "m66", "m9m0", "m25", "m138", "m16", "m12m0", "m65", "m102", "m35"};
	static String m10[] = {"m0", "m0", "m121", "m39", "m139", "m176", "m143", "m71", "m155", "m88", "m77", "m4", "m20"};
	static String m11[] = {"m0", "m0", "m26", "m126", "m15", "m7", "m64", "m15m0", "m57", "m48", "m19", "m31", "m108"};
	static String m12[] = {"m0", "m0", "m9", "m56", "m132", "m34", "m125", "m29", "m175", "m166", "m82", "m164", "m92"};
	static String m13[] = {"m0", "m0", "m112", "m174", "m73", "m67", "m76", "m101", "m43", "m51", "m137", "m144", "m12"};
	static String m14[] = {"m0", "m0", "m49", "m18", "m58", "m16m0", "m136", "m162", "m168", "m115", "m38", "m59", "m124"};
	static String m15[] = {"m0", "m0", "m109", "m116", "m145", "m52", "m1", "m23", "m89", "m72", "m149", "m173", "m44"};
	static String m16[] = {"m0", "m0", "m14", "m83", "m79", "m17m0", "m93", "m151", "m172", "m111", "m8", "m78", "m131"};

	static String t1[] = {"t0", "t72", "t56", "t75", "t4t0", "t83", "t18"};
	static String t2[] = {"t0", "t6", "t82", "t39", "t73", "t3", "t45"};
	static String t3[] = {"t0", "t59", "t42", "t54", "t16", "t28", "t62"};
	static String t4[] = {"t0", "t25", "t74", "t1", "t68", "t53", "t38"};
	static String t5[] = {"t0", "t81", "t14", "t65", "t29", "t37", "t5"};
	static String t6[] = {"t0", "t41", "t7", "t43", "t55", "t17", "t28"};
	static String t7[] = {"t0", "t89", "t26", "t15", "t2", "t44", "t52"};
	static String t8[] = {"t0", "t13", "t71", "t8t0", "t61", "t7t0", "t94"};
	static String t9[] = {"t0", "t36", "t76", "t9", "t22", "t63", "t11"};
	static String t10[] = {"t0", "t5", "t2t0", "t34", "t67", "t85", "t92"};
	static String t11[] = {"t0", "t46", "t64", "t93", "t49", "t32", "t24"};
	static String t12[] = {"t0", "t79", "t84", "t48", "t77", "t96", "t86"};
	static String t13[] = {"t0", "t3t0", "t8", "t69", "t57", "t12", "t51"};
	static String t14[] = {"t0", "t95", "t35", "t58", "t87", "t23", "t60"};
	static String t15[] = {"t0", "t19", "t47", "t9t0", "t33", "t5t0", "t78"};
	static String t16[] = {"t0", "t66", "t88", "t21", "t1t0", "t91", "t31"};
	
	/**
	 * @param args
	 */
	public void allJobs(String waltz) {
		Random myRandom = new Random();
		String m[];
		String t[];
		MidiFile mf;
		MidiTrack T;

		// 1. Create some MidiTracks
		//MidiTrack tempoTrack = new MidiTrack();
		MidiTrack noteTrack = new MidiTrack();
		
		// 2. Add events to the tracks. 
		// Track 0 is typically the tempo map
		//TimeSignature ts = new TimeSignature();
		//ts.setTimeSignature(4, 4, TimeSignature.DEFAULT_METER, TimeSignature.DEFAULT_DIVISION);
		
		//Tempo t = new Tempo();
		//t.setBpm(120);
		
		//tempoTrack.insertEvent(ts);
		//tempoTrack.insertEvent(t);
		
		for (int i=0; i< 17; i++) {
			int dice1 = myRandom.nextInt(5) + 1;
			int dice2 = myRandom.nextInt(5) + 1;
			int dice_sum = dice1 + dice2;
			
			if (i == 1) {m = m1;}
			else if (i == 2) {m = m2;}
			else if (i == 3) {m = m3;}
			else if (i == 4) {m = m4;}
			else if (i == 5) {m = m5;}
			else if (i == 6) {m = m6;}
			else if (i == 7) {m = m7;}
			else if (i == 8) {m = m8;}
			else if (i == 9) {m = m9;}
			else if (i == 10) {m = m10;}
			else if (i == 11) {m = m11;}
			else if (i == 12) {m = m12;}
			else if (i == 13) {m = m13;}
			else if (i == 14) {m = m14;}
			else if (i == 15) {m = m15;}
			else {m = m16;}
			
			// 3. Track 1 will contain all the notes from the merged files
			try {
				LoadFromAltLoc tmp_obj = new LoadFromAltLoc();
				mf = new MidiFile(tmp_obj.LoadFile(m[dice_sum]));
			}
			catch(IOException e) {
				System.err.println("Error parsing MIDI file:");
				e.printStackTrace();
				return;
			} 
			
			T = mf.getTracks().get(0);
			Iterator<MidiEvent> it = T.getEvents().iterator();
			while(it.hasNext()) {
				MidiEvent E = it.next();		
				noteTrack.insertEvent(E);
			}
		}
		
		for (int i=0; i<17; i++) {
			int dice1 = myRandom.nextInt(5) + 1;
						
			if (i == 1) {t = t1;}
			else if (i == 2) {t = t2;}
			else if (i == 3) {t = t3;}
			else if (i == 4) {t = t4;}
			else if (i == 5) {t = t5;}
			else if (i == 6) {t = t6;}
			else if (i == 7) {t = t7;}
			else if (i == 8) {t = t8;}
			else if (i == 9) {t = t9;}
			else if (i == 10) {t = t10;}
			else if (i == 11) {t = t11;}
			else if (i == 12) {t = t12;}
			else if (i == 13) {t = t13;}
			else if (i == 14) {t = t14;}
			else if (i == 15) {t = t15;}
			else {t = t16;}
			
			// 3. Track 1 will contain all the notes from the merged file			
			try {
				LoadFromAltLoc tmp_obj = new LoadFromAltLoc();
				mf = new MidiFile(tmp_obj.LoadFile(t[dice1]));
			}
			catch(IOException e) {
				System.err.println("Error parsing MIDI file:");
				e.printStackTrace();
				return;
			} 
			
			T = mf.getTracks().get(0);
			Iterator<MidiEvent> it = T.getEvents().iterator();
			while(it.hasNext()) {
				MidiEvent E = it.next();		
				noteTrack.insertEvent(E);
			}
		}		
		
		// 4. Create a MidiFile with the tracks we created
		ArrayList<MidiTrack> out_tracks = new ArrayList<MidiTrack>();
		//out_tracks.add(tempoTrack);
		out_tracks.add(noteTrack);
		
		MidiFile out_file = new MidiFile(MidiFile.DEFAULT_RESOLUTION, out_tracks);
		// This should be default for single track:
		//out_file.setType(0);
		
		// 5. Write the MIDI data to a file
		File output = new File(waltz);
		try {
			out_file.writeToFile(output);
		} 
		catch(IOException e) {
			System.err.println(e);
		}

	}

}
