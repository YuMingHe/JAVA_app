package com.example.heyuming_10182267;

import java.util.ArrayList;
import java.util.List;

import com.example.heyuming_10182267.levelActivity.LetterAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class changeActivity extends Activity{
	
	private MyDatabaseHelper dbHelper;
	private EditText pwd_change,userchange;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change);
		dbHelper = new MyDatabaseHelper(this,"MyUser.db",null,2);
		pwd_change = (EditText)findViewById(R.id.pwd_change2);
		userchange = (EditText)findViewById(R.id.user_change);
		Button confirm_change = (Button) findViewById(R.id.confirm);

		confirm_change.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				String username_c = userchange.getText().toString();
				String pwd_c = pwd_change.getText().toString();
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("password",pwd_c);
				db.update("User", values, "name=?", new String[]{username_c});
			}
		});
	}
	
	
}

