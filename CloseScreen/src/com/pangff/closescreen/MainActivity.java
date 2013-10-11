package com.pangff.closescreen;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Menu;
import android.view.WindowManager;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_main);
		
		closeScreen();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				openScreen();
			}
		}, 5000);
		
		
	}
	
	private void openScreen(){
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				WindowManager.LayoutParams params = getWindow().getAttributes();
				params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
				params.screenBrightness = 255;
				getWindow().setAttributes(params);
				closeScreen();
			}
		}, 5000);
	}
	
	private void closeScreen(){
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				WindowManager.LayoutParams params = getWindow().getAttributes();
				params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
				params.screenBrightness = 1f/255f;
				getWindow().setAttributes(params);
				openScreen();
			}
		}, 5000);
	}
}



