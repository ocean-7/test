package com.example.testbc;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textview1;
	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview1=(TextView) findViewById(R.id.textview1);
		button1=(Button) findViewById(R.id.button1);
		
		IntentFilter intentFilter=new IntentFilter(MyService.ACTION_NAME);
		 LocalBroadcastManager.getInstance(this).registerReceiver(br, intentFilter);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Log.v("test", "testonClick");
				Intent mServiceIntent = new Intent(MainActivity.this, MyService.class);
				startService(mServiceIntent);
				
				Intent it=new Intent(MainActivity.this, Act2.class);
				startActivity(it);
				finish();
			}
		});
		
	}

	BroadcastReceiver br=new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.v("test", "testonReceive_main");
			textview1.setText(intent.getStringExtra("txt"));
		}
	};
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
