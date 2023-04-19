package com.example.heyuming_10182267;

import android.os.Bundle;
import android.app.Activity;
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

public class MyDatabaseHelper extends SQLiteOpenHelper{
	public static final String CREATE_USER = "create table User("+"id interger,"+"name text,"+"password text,"+"age interger)";
	private Context myContext;
	
	public MyDatabaseHelper(Context context,String name,CursorFactory factory,int version){
		super(context, name, factory, version);
		myContext = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_USER);
		Toast.makeText(myContext, "Create succeeded",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
	    db.execSQL("drop table if exists User");
		onCreate(db);
	}
	
}
