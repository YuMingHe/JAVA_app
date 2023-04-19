package com.example.heyuming_10182267;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
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

public class SQLActivity extends Activity{
	
	private MyDatabaseHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql);
		dbHelper = new MyDatabaseHelper(this,"MyUser.db",null,2);
		Button create_db = (Button) findViewById(R.id.c_db);
		Button addData = (Button) findViewById(R.id.add_data);
		create_db.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				try{
					dbHelper.getWritableDatabase();
				}catch(Exception e){
					Toast.makeText(SQLActivity.this, "error info:"+e.getMessage(),Toast.LENGTH_SHORT).show();
				}
			}
		});
//		addData.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View b) {
//				
//				SQLiteDatabase db = dbHelper.getWritableDatabase();
//				ContentValues values = new ContentValues();
//				values.put("name", "heyuming");
//				values.put("password", 10182267);
//				values.put("age",21);
//				db.insert("User", null, values);
//				values.clear();
//				values.put("name", "jinwenjing");
//				values.put("password", 10182181);
//				values.put("age",21);
//				db.insert("User", null, values);
//			}
//		});
	}
	
	
}
