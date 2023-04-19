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
import android.text.Editable;
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

public class addActivity extends Activity{
	
	private MyDatabaseHelper dbHelper;
	private EditText pwd_add,useradd,age;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adduser);
		dbHelper = new MyDatabaseHelper(this,"MyUser.db",null,2);
		pwd_add = (EditText)findViewById(R.id.pwd_add2);
		useradd = (EditText)findViewById(R.id.user_add);
		age = (EditText)findViewById(R.id.age_add);
		Button confirm_add = (Button) findViewById(R.id.confirm_add);

		confirm_add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				String username_a = useradd.getText().toString();
				String pwd_a = pwd_add.getText().toString();
				String age_a = age.getText().toString();
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", username_a);
				values.put("password", pwd_a);
				values.put("age",age_a);
				db.insert("User", null, values);
			}
		});
	}
	
	
}

