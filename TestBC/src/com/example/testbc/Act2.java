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

public class Act2 extends Activity {

	TextView textview1;
	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		textview1=(TextView) findViewById(R.id.textview1);
		
		textview1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it=new Intent(Act2.this, MainActivity.class);
				startActivity(it);
				finish();
			}
		});
		
		
		IntentFilter intentFilter=new IntentFilter(MyService.ACTION_NAME);
		 LocalBroadcastManager.getInstance(this).registerReceiver(br, intentFilter);
		
		
	}

	BroadcastReceiver br=new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.v("test", "testonReceive_act2");
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
