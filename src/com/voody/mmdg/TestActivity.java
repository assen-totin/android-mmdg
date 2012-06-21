package com.voody.mmdg;

import android.app.Activity;

import android.os.Bundle;

public class TestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main1);
        
        System.err.println("TEST Going to sleep...");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.err.println("TEST After being asleep...");
        
        //sheet.callOnDraw();
        //sheet.keepRunning();
        
        //layout.removeView(sheet);
        //layout.requestLayout();
        
        finish();
    }

    
    
}