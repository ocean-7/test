package com.example.testbc;

import java.io.File;
import java.util.ArrayList;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyService extends IntentService {

	public MyService() {
		super("MyService");
	}

	public MyService(String name) {
		super(name);
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}


	public static  String ACTION_NAME = "dobell.missan.uploadlater";
	Intent mIntent = new Intent(ACTION_NAME);

	@Override
	protected void onHandleIntent(Intent intent) {

		Log.v("test", "testonHandleIntent_start");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.v("test", "testonHandleIntent_send");
		mIntent.putExtra("txt", "GOGOGOGO");
		LocalBroadcastManager.getInstance(this).sendBroadcast(mIntent);
	}

}
