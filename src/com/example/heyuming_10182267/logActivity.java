package com.example.heyuming_10182267;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.AttributeSet;
import android.util.Log;
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

public class logActivity extends Activity{
	EditText name, pwd;
	Button btnlogin,select_p,button_c,button_a;
	ImageView img;
	private ProgressBar progressbar_001;
	private MyDatabaseHelper dbHelper;
	@Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log);
		dbHelper = new MyDatabaseHelper(this,"MyUser.db",null,2);
		name = (EditText) this.findViewById(R.id.user);
		pwd  = (EditText) this.findViewById(R.id.pwd);
		btnlogin = (Button) this.findViewById(R.id.button02);
		select_p = (Button) this.findViewById(R.id.button04);
		progressbar_001 = (ProgressBar)findViewById(R.id.progress_bar001);
		img = (ImageView)findViewById(R.id.image_view02);
		button_c = (Button) this.findViewById(R.id.button_change);
		button_a = (Button) this.findViewById(R.id.button_log);
		int data = getIntent().getIntExtra("detail_img",0);
		img.setImageResource(data);
		btnlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				Cursor cursor = db.query("User", null, null, null, null, null, null);
				int flag=0;
				if(cursor.moveToFirst()){
					do{
						String uesrname = cursor.getString(cursor.getColumnIndex("name"));
						String password = cursor.getString(cursor.getColumnIndex("password")).toString();
						int age = cursor.getInt(cursor.getColumnIndex("age"));
						String uesrname1 = name.getText().toString();
						String password1 = pwd.getText().toString();
						if(uesrname1.equals(uesrname) && password1.equals(password)){
							Intent intent = new Intent();
		                    intent.setClass(logActivity.this, welcomeActivity1.class);
		                    //intent.putExtra(name:"data", 1);
							startActivity(intent);
							Toast.makeText(logActivity.this, "welcome", 
				    		        Toast.LENGTH_SHORT).show();
							flag=1;
							
						}
					}while(cursor.moveToNext());
						if(flag==0){
					    int progress1 = progressbar_001.getProgress();
						progressbar_001.setProgress(progress1+100);
						AlertDialog.Builder alertdialog = new AlertDialog.Builder(logActivity.this);
				        alertdialog.setTitle("用户名或密码错误");
				        alertdialog.setMessage("请重新修改");
				        alertdialog.setCancelable(false);
				        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								
							}
						});
						alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								
							}
						});
						alertdialog.show();}
					
				}
			}
			
			
		});
		
		select_p.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(logActivity.this, levelActivity.class);
				startActivity(intent);
			}
		});
        button_c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(logActivity.this, changeActivity.class);
				startActivity(intent);
			}
		});
        button_a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(logActivity.this, addActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
}