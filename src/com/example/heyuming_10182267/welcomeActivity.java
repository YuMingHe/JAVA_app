package com.example.heyuming_10182267;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class welcomeActivity extends Activity{
	
	Button log,load;
	private ProgressBar progressbar_2;
	private MyDatabaseHelper dbHelper;
	@Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		dbHelper = new MyDatabaseHelper(this,"MyUser.db",null,2);
		log = (Button) this.findViewById(R.id.button01);
		load = (Button) this.findViewById(R.id.button_load);
		progressbar_2 = (ProgressBar)this.findViewById(R.id.progress_bar01);
		log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				int progress = progressbar_2.getProgress();
				progressbar_2.setProgress(progress+100);
				if(progress==100){
				Intent intent = new Intent();
                    intent.setClass(welcomeActivity.this, logActivity.class);
					startActivity(intent);
					Toast.makeText(welcomeActivity.this, "welcome",
		    		        Toast.LENGTH_SHORT).show();
				}
			}
		});
        load.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", "heyuming");
				values.put("password", 10182267);
				values.put("age",21);
				db.insert("User", null, values);
				values.clear();
				values.put("name", "jinwenjing");
				values.put("password", 10182181);
				values.put("age",21);
				db.insert("User", null, values);
			}
		});
	}
	
}